# Spring Cloud Gateway

> Finchley.SR1

Spirng Cloud Gateway项目提供API网关功能，它基于Spring生态系统建设，包括Spring 5，Spring Boot 2 和 Reactor项目。Spirng Cloud Gateway目标是提供一个简单高效的方法来实现API的路由，综合关注安全、监控/度量和弹性等。

## 如何集成Spring Cloud Gateway
在项目中包含如下starter集成Spring Cloud Gateway

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```
查看 [Spring Cloud 项目](https://projects.spring.io/spring-cloud/)获取在当前Spring Cloud版本下构建系统的详细信息。  
如果你包含了这个Starter，但是由于某些原因不想启用gateway的话，可以设置
`spring.cloud.gateway.enabled=false`  

> **重要提醒**   
> Spring Cloud Gateway 需要SpringBoot和Spring Webflux提供的Netty运行时，它无法在传统的Servlet中容器中工作或者构建成war包。

## 术语
- Route:Route是gateway的基本构件。它由ID，目标URL，Predicate集合和Filter集合构成。如果Predicate为真则匹配路由。
- Predicate:这是一个Java 8函数谓词。输入类型是`Spring Framework ServerWebExchange`。它允许开发人员对HTTP请求中的任何内容进行匹配，例如头信息和参数信息。
- Filter:这些是与特定工厂一起构建的实例`Spring Framework GatewayFilter`。在这里，可以在发送下游请求之前或之后修改requests和responses。

## 工作原理

![gateway工作原理](https://raw.githubusercontent.com/spring-cloud/spring-cloud-gateway/master/docs/src/main/asciidoc/images/spring_cloud_gateway_diagram.png)

客户端请求Spring Cloud Gateway，如果Gateway Handler Mapping判定请求和Route匹配，它将被发送到Gateway Web Handler。此处理程序通过特定于请求的过滤器链发送请求。过滤器被虚线分隔的原因是过滤器可以在代理请求发送之前或之后执行逻辑。在所有“pre”过滤器逻辑执行后，发出代理请求。在代理请求完成后，将执行“post”过滤器逻辑。

> 路由定义URI未定义端口号时将使用默认的HTTP和HTTPS端口80或443。

## Route Predicate Factory
Spring Cloud Gateway路由匹配作为Spring WebFlux `HandlerMapping`基础设施的一部分。Spring Cloud Gateway包括许多内置Route Predicate Factory。所有这些谓词都匹配HTTP请求的不同属性。多个Route Predicate Factory可以通过逻辑`and`方式进行组合。

### After Route Predicate Factory
这个After Route Predicate Factory接受一个参数，即日期时间。这个谓词匹配当前日期时间之后发生的请求。   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: http://example.org
        predicates:
        - After=2017-01-20T17:42:47.789-07:00[America/Denver]
```
这个路由匹配2017-01-20T17:42:47.789-07:00[America/Denver]之后的任意请求
> 译者注:这里日期为java.time.ZonedDateTime.parse(dateString)能解析的日期

### Before Route Predicate Factory
这个Before Route Predicate Factory接受一个参数，即日期时间。这个谓词匹配当前日期时间之前发生的请求。   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: before_route
        uri: http://example.org
        predicates:
        - Before=2017-01-20T17:42:47.789-07:00[America/Denver]
```

这个路由匹配2017-01-20T17:42:47.789-07:00[America/Denver]之前的任意请求
> 译者注:这里日期为java.time.ZonedDateTime.parse(dateString)能解析的日期

### Between Route Predicate Factory
这个Between Route Predicate Factory接受两个参数，即日期时间1和日期时间2。这个谓词匹配当前日期时间在日期时间1和日期时间2之间的请求。日期时间2必须在日期时间1之后   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: between_route
        uri: http://example.org
        predicates:
        - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
```

这个路由匹配2017-01-20T17:42:47.789-07:00[America/Denver]之后，2017-01-21T17:42:47.789-07:00[America/Denver]之前的任意请求。通常对维护窗口时间段比较有用。
> 译者注:这里日期为java.time.ZonedDateTime.parse(dateString)能解析的日期

### Cookie Route Predicate Factory

这个Cookie Route Predicate Factory接受两个参数，即Cookie名和一个正则表达式。这个谓词匹配具有给定Cookie名且其值匹配正则表达式的请求   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: cookie_route
        uri: http://example.org
        predicates:
        - Cookie=chocolate, ch.p
```
这个路由匹配请求的cookie名为`chocolate`，且值与`ch.p`正则表达式匹配的请求。

### Header Route Predicate Factory

这个Header Route Predicate Factory接受两个参数，即Header名和一个正则表达式。这个谓词匹配具有给定Header名且其值匹配正则表达式的请求   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: header_route
        uri: http://example.org
        predicates:
        - Header=X-Request-Id, \d+
```
这个路由匹配请求的Header名为`X-Request-Id`，且值与`\d+`正则表达式匹配的请求。

### Host Route Predicate Factory

这个Host Route Predicate Factory接受一个参数，即主机名表达式。这个表达式是用`.`分隔的Ant风格的表达式。这个谓词匹配具有匹配名为`Host`的Header的请求。
   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://example.org
        predicates:
        - Host=**.somehost.org
```
这个路由匹配请求的Header中包含名为`Host`，且值为`www.somehost.org`或 `beta.somehost.org`的请求。

### Method Route Predicate Factory

这个Host Route Predicate Factory接受一个参数，即HTTP Method类型   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: method_route
        uri: http://example.org
        predicates:
        - Method=GET
```
这个路由匹配请求类型为`GET`的请求。

### Path Route Predicate Factory

这个Path Route Predicate Factory接受一个参数，一个Spring的`PathMatcher`表达式   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://example.org
        predicates:
        - Path=/foo/{segment}
```
这个路由将匹配这样的请求，如 `/foo/1` 或者 `/foo/bar`。  

这个谓词将URI模板变量(如上面示例中定义的`segment`)提取为map的name和value，并将其放入`ServerWebExchange.getAttributes()`中，使用`PathRoutePredicate.URL_PREDICATE_VARS_ATTR`作为其key。然后这些值可供[GatewayFilter](https://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/spring-cloud.html#gateway-route-filters)工厂使用。

### Query Route Predicate Factory

这个Query Route Predicate Factory接受两个参数，一个必须的`param`和一个可选的`regexp`。   

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: http://example.org
        predicates:
        - Query=baz
```
这个路由将匹配包含 `baz` 参数的请求。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: http://example.org
        predicates:
        - Query=foo, ba.
```
这个路由将匹配包含`baz`参数且其值匹配`ba.`表达式(如`bar`、`baz`)的请求。

### RemoteAddr Route Predicate Factory

这个RemoteAddr Route Predicate Factory接受CIDR-notation（IPv4或者IPv6）列表作为参数(最少1条)，例如`192.168.0.1/16`(这里`192.168.0.1`是一个IP 地址，`16`是子网掩码)   
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: remoteaddr_route
        uri: http://example.org
        predicates:
        - RemoteAddr=192.168.1.1/24
```
这个路由将匹配这样的远程地址符合要求的请求，如 `192.168.1.10`。  

#### 修改远程地址解析的方式
默认情况下RemoteAddr Route Predicate Factory使用传入请求中获取到的remote address。如果Spring Cloud网关位于代理层后面，这可能与实际客户端IP地址不匹配。  

你可以通过设置自定义`RemoteAddressResolver`来定制解析远程地址的方式。Spring Cloud Gateway提供了一个非默认远程地址解析器，它基于名为[X-Forwarded-For](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-For) 的Header进行解析，`XForwardedRemoteAddressResolver`。  

`XForwardedRemoteAddressResolver` 有两个静态构造函数方法，采用不同的安全方法:   

`XForwardedRemoteAddressResolver::trustAll`返回一个`RemoteAddressResolver`，它总是取名为`X-Forwarded-For`的Header信息中找到的第一个IP地址。这种方法很容易被欺骗，因为恶意客户端可以为`X-Forwarded-For`设置一个初始值——解析器会接受这个初始值。  

`XForwardedRemoteAddressResolver::maxTrustedIndex`是一个与部署架构中Spring Cloud Gateway之前运行的可信基础设施数量相关的索引。如果Spring Cloud Gateway只能通过HAProxy访问，那么应该使用1的值。如果在访问Spring Cloud Gateway之前需要两跳可信基础设施，那么应该使用值2。   

给定以下Header值:  
```
X-Forwarded-For: 0.0.0.1, 0.0.0.2, 0.0.0.3
```
`maxTrustedIndex`获取到的remote addressesd的值将如下表所示:    

maxTrustedIndex|result
--- | ---
[`Integer.MIN_VALUE`,0]|(非法,初始化期间抛出异常 `IllegalArgumentException`)
1|0.0.0.3
2|0.0.0.2
3|0.0.0.1
[4, `Integer.MAX_VALUE`]|0.0.0.1

使用Java方式配置:  
GatewayConfig.java 示例代码如下：  
```
RemoteAddressResolver resolver = XForwardedRemoteAddressResolver
    .maxTrustedIndex(1);

...

.route("direct-route",
    r -> r.remoteAddr("10.1.1.1", "10.10.1.1/24")
        .uri("https://downstream1")
.route("proxied-route",
    r -> r.remoteAddr(resolver,  "10.10.1.1", "10.10.1.1/24")
        .uri("https://downstream2")
)
```

## GatewayFilter Factory
Route filter允许以某种方式修改传入HTTP请求或传出HTTP响应。Route filter作用于特定的Route。Spring Cloud Gateway包括许多内置的GatewayFilter Factory。  
关于如何使用以下任何过滤器的更详细示例，请参阅[单元测试](https://github.com/spring-cloud/spring-cloud-gateway/tree/master/spring-cloud-gateway-core/src/test/java/org/springframework/cloud/gateway/filter/factory)。

### AddRequestHeader GatewayFilter Factory
AddRequestHeader GatewayFilter Factory需要1个名字和1个值作为参数  
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: http://example.org
        filters:
        - AddRequestHeader=X-Request-Foo, Bar
```
这将向下游的所有匹配请求添加Header信息`X-Request-Foo:Bar`。

### AddRequestParameter GatewayFilter Factory
AddRequestParameter GatewayFilter Factory需要1个name和1个value作为参数  
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_parameter_route
        uri: http://example.org
        filters:
        - AddRequestParameter=foo, bar
```
这将向下游的所有匹配请求添加参数信息`foo=bar`。

### AddResponseHeader GatewayFilter Factory
AddResponseHeader GatewayFilter Factory需要1个name和1个value作为参数  
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: http://example.org
        filters:
        - AddResponseHeader=X-Response-Foo, Bar
```
这将向下游的所有匹配响应添加Header信息`X-Response-Foo:Bar`。

### Hystrix GatewayFilter Factory
[Hystrix](https://github.com/Netflix/Hystrix)是Netflix的一个库，实现了[断路器模式](https://martinfowler.com/bliki/CircuitBreaker.html)。Hystrix网关过滤器允许你将断路器引入网关路由，保护你的服务免受级联故障的影响，并允许你在发生下游故障时提供备用响应。  

要在项目中启用Hystrix网关过滤器，请添加对[Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/)的`spring-cloud-starter-netflix-hystrix`的依赖。

AddResponseHeader GatewayFilter Factory需要1个`name`参数，对应`HystrixCommand` 的名字
application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: hystrix_route
        uri: http://example.org
        filters:
        - Hystrix=myCommandName
```
这将剩余的过滤器用命令名`myCommandName`包装在`HystrixCommand`中。

Hystrix过滤器还可以接受一个可选的`fallbackUri`参数。目前，只支持`forward:`形式的uri。如果发生回退，请求将被转发到由URI匹配的Controller。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: hystrix_route
        uri: lb://backing-service:8088
        predicates:
        - Path=/consumingserviceendpoint
        filters:
        - name: Hystrix
          args:
            name: fallbackcmd
            fallbackUri: forward:/incaseoffailureusethis
        - RewritePath=/consumingserviceendpoint, /backingserviceendpoint
```
这将在调用Hystrix回退时转发到`/incaseoffailureusethis`这个URI。注意，这个示例还通过目标URI上的`lb`前缀演示了(可选的)Spring Cloud Netflix Ribbon负载平衡。

Hystrix设置(例如超时)可以设置为全局默认值级别，也可以设置为路由级别。使用在[Hystrix wiki](https://github.com/Netflix/Hystrix/wiki/Configuration)上介绍的属性进行配置。

要为上面的示例路由设置5秒超时，将使用以下配置:

application.yml中示例如下：
```
hystrix.command.fallbackcmd.execution.isolation.thread.timeoutInMilliseconds:5000
```

### PrefixPath GatewayFilter Factory
PrefixPath网关过滤器接受一个`prefix`参数。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: prefixpath_route
        uri: http://example.org
        filters:
        - PrefixPath=/mypath
```
这将为所有匹配请求的路径加上`/mypath`前缀。因此，对`/hello`的请求将被发送到`/mypath/hello`。		

### PreserveHostHeader GatewayFilter Factory
PreserveHostHeader网关过滤器没有参数。此过滤器设置请求属性，路由过滤器将检查该请求属性，以确定是否应该发送原始主机header，而不是http客户端确定的主机header。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: preserve_host_route
        uri: http://example.org
        filters:
        - PreserveHostHeader
```
这将为所有匹配请求保留原始主机Header信息。

### RequestRateLimiter GatewayFilter Factory
RequestRateLimiter GatewayFilter Factory使用`RateLimiter`实现来确定当前请求是否允许继续进行。如果不是，则返回`HTTP 429 - Too Many Requests`(默认情况下)。

此过滤器接受一个可选的`keyResolver`参数和特定于速率限制器的参数(参见下面)。

`keyResolver`是实现`KeyResolver`接口的bean。在配置中，使用SpEL通过名称引用bean。`#{@myKeyResolver}`是一个引用名为`myKeyResolver`的bean的SpEL表达式。

KeyResolver.java示例如下：

```
public interface KeyResolver {
	Mono<String> resolve(ServerWebExchange exchange); 
} 

```

`KeyResolver`接口允许可插入策略派生用于限制请求的键。在未来的里程碑中，将会有一些`KeyResolver`的实现。

`KeyResolver`的默认实现是`PrincipalNameKeyResolver`，它从`ServerWebExchange`中检索`Principal`并调用`Principal. getname()`。

> RequestRateLimiter不能通过“shortcut”方式进行配置。下面的示例无效

application.properties 示例如下：
```
#INVALID SHORTCUT CONFIGURATION
spring.cloud.gateway.routes[0].filters[0]=RequestRateLimiter=2, 2, #{@userkeyresolver}
```

#### Redis RateLimiter

redis的实现基于 [Stripe](https://stripe.com/blog/rate-limiters) 公司完成的工作。它需要使用`spring-boot-starter-data-redis-reactive`这个Spring Boot starter。

使用的算法是令牌桶算法[Token Bucket Algorithm](https://en.wikipedia.org/wiki/Token_bucket)。

`redis-rate-limiter.replenishRate`是你希望允许用户每秒执行多少请求，而不需要丢弃任何请求。这是令牌桶被填充的速率。

`redis-rate-limiter.burstCapacity`是允许用户在一秒钟内完成的最大请求数量。这是令牌桶可以容纳的令牌数量。将此值设置为0将阻塞所有请求。

通过在`replenishRate`和`burstCapacity`上设置相同的值来实现稳定的速度。可以通过设置比`replenishRate`更高的`burstCapacity`来允许临时爆发。在这种情况下，速率限制器需要在突发事件之间允许一段时间(根据`replenishRate`)，连续的两次突发事件将导致被丢弃的请求(`HTTP 429 - Too Many Requests`)。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: requestratelimiter_route
        uri: http://example.org
        filters:
        - name: RequestRateLimiter
          args:
            redis-rate-limiter.replenishRate: 10
            redis-rate-limiter.burstCapacity: 20
```
Config.java示例如下：
```
@Bean
KeyResolver userKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
}
```
这里定义了每个用户的请求速率限制为10。允许有20个突发请求，但是下一秒只有10个请求可用。`KeyResolver`是一个获取用户请求参数的简单程序(注意:不建议在生产环境中使用)。

速率限制器也可以定义为实现`RateLimiter`接口的bean。在配置中，使用SpEL通过名称引用bean。`#{@myRateLimiter}`是引用名为`myRateLimiter`的bean的SpEL表达式。			

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: requestratelimiter_route
        uri: http://example.org
        filters:
        - name: RequestRateLimiter
          args:
            rate-limiter: "#{@myRateLimiter}"
            key-resolver: "#{@userKeyResolver}"
```

### RedirectTo GatewayFilter Factory
RedirectTo GatewayFilter Factory需要1个`status`和1个`url`作为参数。status应该是300系列的重定向http代码，比如301。url应该是一个有效的url。这将是名为`Location`的Header的值。  

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: prefixpath_route
        uri: http://example.org
        filters:
        - RedirectTo=302, http://acme.org
```
这将发送一个`Location:http://acme.org`的302状态码，以执行重定向。

### RemoveNonProxyHeaders GatewayFilter Factory
RemoveNonProxyHeaders GatewayFilter Factory移除转发请求中的header。删除的默认标头列表来自IETF。

默认要删除的Header如下：   
- Connection
- Keep-Alive
- Proxy-Authenticate
- Proxy-Authorization
- TE
- Trailer
- Transfer-Encoding
- Upgrade

要改变这一点，设置属性`spring.com cloud.gateway.filter.remove-non-proxy-headers`来标识要删除的header名称列表。


### RemoveRequestHeader GatewayFilter Factory
RemoveRequestHeader GatewayFilter Factory需要1个`name`参数。它是要删除的header的名字。  

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: removerequestheader_route
        uri: http://example.org
        filters:
        - RemoveRequestHeader=X-Request-Foo
```
这将在请求发送到下游之前删除名为`X-Request-Foo`的Header。

### RemoveResponseHeader GatewayFilter Factory
RemoveResponseHeader GatewayFilter Factory需要1个`name`参数。它是要删除的参数的名字。  

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: removeresponseheader_route
        uri: http://example.org
        filters:
        - RemoveResponseHeader=X-Response-Foo
```
这将在响应返回gateway客户端前删除名为`X-Request-Foo`的Header。

### RewritePath GatewayFilter Factory
RewritePath GatewayFilter Factory需要1个`regexp`参数和1个`replacement`参数。它使用Java正则表达式以一种灵活的方式重写请求路径。  

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: rewritepath_route
        uri: http://example.org
        predicates:
        - Path=/foo/**
        filters:
        - RewritePath=/foo/(?<segment>.*), /$\{segment}
```
对于`/foo/bar`的请求路径，这将在发出下游请求之前将路径设置为`/bar`。注意`$\`，由于YAML规范，它被`$`替换了。

### SaveSession GatewayFilter Factory
SaveSession GatewayFilter Factory强制执行一个WebSession::save操作，然后将调用转发到下游。这在使用类似Spring Session这样带有延迟数据存储的东西时特别有用，并且需要确保在进行转发调用之前保存了会话状态。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: save_session
        uri: http://example.org
        predicates:
        - Path=/foo/**
        filters:
        - SaveSession
```
如果你正在将[Spring Security](https://projects.spring.io/spring-security/)与Spring Session集成，并且希望确保安全细节已转发到远程进程，那么这是非常关键的。


### SecureHeaders GatewayFilter Factory
SecureHeaders网关过滤器在这篇[博客文章](https://blog.appcanary.com/2017/http-security-headers.html)中添加了很多Header。

添加了以下Header(带有默认值):
- `X-Xss-Protection:1; mode=block`
- `Strict-Transport-Security:max-age=631138519`
- `X-Frame-Options:DENY`
- `X-Content-Type-Options:nosniff`
- `Referrer-Policy:no-referrer`
- `Content-Security-Policy:default-src 'self' https:; font-src 'self' https: data:; img-src 'self' https: data:; object-src 'none'; script-src https:; style-src 'self' https: 'unsafe-inline'`
- `X-Download-Options:noopen`
- `X-Permitted-Cross-Domain-Policies:none`

要改变默认值，请在`spring.cloud.gateway.filter.secure-headers`命名空间中设置适当的属性。 可改变的属性：
- `xss-protection-header`
- `strict-transport-security`
- `frame-options`
- `content-type-options`
- `referrer-policy`
- `content-security-policy`
- `download-options`
- `permitted-cross-domain-policies`

### SetPath GatewayFilter Factory
SetPath GatewayFilter Factory接受一个路径`template`参数。它提供了一种通过允许路径的模板段来操作请求路径的简单方法。这将使用Spring框架中的uri模板。允许多个匹配段。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: setpath_route
        uri: http://example.org
        predicates:
        - Path=/foo/{segment}
        filters:
        - SetPath=/{segment}
```
对于`/foo/bar`的请求路径，这将在发出下游请求之前将路径设置为`/bar`。

### SetResponseHeader GatewayFilter Factory
SetResponseHeader GatewayFilter Factory接受一个`name`参数和一个`value`参数。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: setresponseheader_route
        uri: http://example.org
        filters:
        - SetResponseHeader=X-Response-Foo, Bar
```
这个网关过滤器用给定的Header替换所有的Header，而不是添加(是删除所有其他header么?)。因此，如果下游服务器响应`X-Response-Foo:1234`，这将被替换为`X-Response-Foo:Bar`，这是网关客户机将接收到的。

### SetStatus GatewayFilter Factory
SetStatus GatewayFilter Factory接受一个`status`参数。它必须是后一个合法的Spring `HttpStatus`。它可能是整数值`404`或者枚举`NOT_FOUND`的字符串表示形式

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: setstatusstring_route
        uri: http://example.org
        filters:
        - SetStatus=BAD_REQUEST
      - id: setstatusint_route
        uri: http://example.org
        filters:
        - SetStatus=401
```
无论哪种情况，响应的HTTP状态都将设置为401。


### StripPrefix GatewayFilter Factory
StripPrefix GatewayFilter Factory接受一个`parts`参数。`parts`参数指示在将请求发送到下游之前从请求中删除的路径中的部件数量。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: nameRoot
        uri: http://nameservice
        predicates:
        - Path=/name/**
        filters:
        - StripPrefix=2
```
当通过网关发出请求时，`/name/bar/foo`向`nameservice`发出的请求将类似于`http://nameservice/foo`。


### Retry  GatewayFilter Factory
Retry GatewayFilter Factory接受`retries`、`statuses`、`methods`和`series`参数。
- `retries` : 应该尝试的重试次数
- `statuses`:应该重试的HTTP状态代码，使用`org.springframework.http.HttpStatus`表示
- `methods`:应该重试的HTTP方法，使用`org.springframework.http.HttpMethod`表示
- `series`:要重试的状态代码系列，使用`org.springframework.http.HttpStatus.Series`表示

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: retry_test
        uri: http://localhost:8080/flakey
        predicates:
        - Host=*.retry.com
        filters:
        - name: Retry
          args:
            retries: 3
            statuses: BAD_GATEWAY
```
> 目前，使用`forward `协议的URI不支持使用retry过滤器。

## GlobalFilter
`GlobalFilter`接口具有与`GatewayFilter`相同的签名。这些是特殊的过滤器，有条件地应用于所有路由。(这个接口和用法在将来的里程碑中可能会改变)。

### Combined Global Filter and GatewayFilter Ordering
当传入请求(并匹配路由)时， Filtering Web Handler将向过滤器链添加`GlobalFilter`的所有实例和`GatewayFilter`的所有特定路由实例。这个组合过滤器链是按`org.springframework.core.Ordered`接口排序的，具体排序可以通过实现`getOrder()`方法或使用`@Order`注解来实现。

由于Spring Cloud Gateway区分了过滤器逻辑执行的“pre”和“post”阶段(参见:How It Works)，优先级最高的过滤器将是“pre”阶段的第一个和“post”阶段的最后一个。

> 译者注: 数字越小优先级越高（数字区间在最小整数和最大整数之间）

ExampleConfiguration.java示例代码如下：
```
@Bean
@Order(-1)
public GlobalFilter a() {
    return (exchange, chain) -> {
        log.info("first pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("third post filter");
        }));
    };
}

@Bean
@Order(0)
public GlobalFilter b() {
    return (exchange, chain) -> {
        log.info("second pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("second post filter");
        }));
    };
}

@Bean
@Order(1)
public GlobalFilter c() {
    return (exchange, chain) -> {
        log.info("third pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("first post filter");
        }));
    };
}
```

### Forward Routing Filter
`ForwardRoutingFilter`在exchange属性`ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR`中查找URI。如果url有`forward`(例如forward:///localendpoint)，它将使用Spring `DispatcherHandler`处理请求。请求URL的路径部分将被转发URL中的路径覆盖。未修改的原始url被附加到`ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR`列表中。

### LoadBalancerClient Filter
`LoadBalancerClientFilter`在exchange属性`ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR`中查找URI。
如果url有`lb`(例如lb://myservice)，它将使用Spring Cloud `LoadBalancerClient`将名称(上一个示例中的myservice)解析为实际的主机和端口，并替换相同属性中的URI。未修改的原始url被附加到`ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR`列表中。过滤器还将在`ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR`属性中检查它是否等于`lb`，然后应用相同的规则。

application.yml中示例如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: myRoute
        uri: lb://service
        predicates:
        - Path=/service/**
```

### Netty Routing Filter

如果url位于`ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR`的属性中且是以`http`或`https`开头，则运行Netty Routing Filter。它使用Netty `HttpClient`发出下游代理请求。响应放在`ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR`属性中供以后的过滤器使用。(有一个实验性的`WebClientHttpRoutingFilter`，它执行相同的功能，但不需要netty)

### Netty Write Response Filter
如果在`ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR`属性中有一个Netty `HttpClientResponse` ，则运行`NettyWriteResponseFilter`。它在所有其他过滤器完成后运行，并将代理响应写回网关客户端响应。(有一个实验性的`WebClientWriteResponseFilter`，它执行相同的功能，但不需要netty)

### RouteToRequestUrl Filter
如果在`ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR`属性中有一个 `Route`对象 ，则运行`RouteToRequestUrlFilter`。它根据请求URI创建一个新的URI，但是使用`Route`对象的URI属性进行更新。新URI放在`ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR`属性中。

如果URI有一个scheme前缀，比如`lb:ws://serviceid`，则将`lb`从URI中剥离，并放在`ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR`中用于之后在过滤器链中使用。

### Websocket Routing Filter
如果URL位于`ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR`属性中且有一个`ws`或`wss`前缀，则运行Websocket Routing Filter。 它使用Spring Web Socket基础结构将Websocket请求转发到下游。

Websockets可以通过在URI前面加上`lb`来实现负载平衡，比如`lb:ws://serviceid`。

> 如果使用SockJS作为常规http的fallback，应该配置一个常规http路由以及Websocket路由。

application.yml中示例如下：

```
spring:
  cloud:
    gateway:
      routes:
      # SockJS route
      - id: websocket_sockjs_route
        uri: http://localhost:3001
        predicates:
        - Path=/websocket/info/**
      # Normwal Websocket route
      - id: websocket_route
        uri: ws://localhost:3001
        predicates:
        - Path=/websocket/**
```

### Gateway Metrics Filter
如果需要启用Gateway Metrics需要在项目依赖中添加`spring-boot-starter-actuator`。然后，默认情况下，如果属性`spring.cloud.gateway.metrics.enabled`没有设置为`false`，则Gateway Metrics Filter会一直运行。 这个过滤器添加了一个名为“gateway.requests”的计时器度量，带有以下标签: 
-`routeId`: route id
-`routeUri`: API将要路由到的URI
-`outcome`: 按照[HttpStatus.Series](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.Series.html)分类的结果
-`status`: 返回给客户端的请求的Http Status 

然后可以从`/actuator/metrics/gateway.requests`中提取这些指标。并容易地与Prometheus联系起来，创建一个[Grafana仪表板](https://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/gateway-grafana-dashboard.json)。

> 为了启用Prometheus端点，需要在项目中添加`micrometer-registry-prometheus`依赖项。 

### Making An Exchange As Routed
在网关路由了`ServerWebExchange`之后，它将通过向exchange添加`gatewayAlreadyRouted`属性来将exchange标记为已路由(routed)。一旦一个请求被标记为已路由，其他路由过滤器将不会再路由该请求，本质上就是跳过过滤器。有一些方便的方法可用于将交换标记为已路由或检查交换是否已经路由。

- `ServerWebExchangeUtils.isAlreadyRouted`接受一个`ServerWebExchange`对象，检查它是否标记为“已路由”
- `ServerWebExchangeUtils.setAlreadyRouted`接受一个`ServerWebExchange`对象，并将其标记为“已路由”

## TLS/SSL
Gateway可以通过常规的Spring server 配置方式监听https请求，示例如下：

application.yml
```
server:
  ssl:
    enabled: true
    key-alias: scg
    key-store-password: scg1234
    key-store: classpath:scg-keystore.p12
    key-store-type: PKCS12
```
Gateway路由可以路由到http和https后端。如果路由到https后端，那么网关可以配置为信任所有下游证书:

application.yml
```
spring:
  cloud:
    gateway:
      httpclient:
        ssl:
          useInsecureTrustManager: true
```

使用不安全的信任管理器不适合生产环境。对于生产部署，网关可以配置信任一组已知的证书，配置示例如下:

application.yml. 
```
spring:
  cloud:
    gateway:
      httpclient:
        ssl:
          trustedX509Certificates:
          - cert1.pem
          - cert2.pem
```

## Configuration
Spring Cloud Gateway的配置由一序列 `RouteDefinitionLocator`来驱动。

RouteDefinitionLocator.java. 示例代码如下：
```
public interface RouteDefinitionLocator {
	Flux<RouteDefinition> getRouteDefinitions();
}
```
默认情况下，一个`PropertiesRouteDefinitionLocator`使用Spring Boot的`@ConfigurationProperties`机制加载属性。

上面的配置示例都使用了使用位置参数而不是命名参数的快捷符号。以下两个例子是相同的:

application.yml示例代码如下：
```
spring:
  cloud:
    gateway:
      routes:
      - id: setstatus_route
        uri: http://example.org
        filters:
        - name: SetStatus
          args:
            status: 401
      - id: setstatusshortcut_route
        uri: http://example.org
        filters:
        - SetStatus=401
```
对于网关的某些用法，使用属性方式是足够的，但是一些生产用例将从外部源(如数据库)的加载配置中获益。未来的里程碑版本将拥有基于Spring数据存储库的`RouteDefinitionLocator`实现，例如:Redis、MongoDB和Cassandra。

### Fluent Java Routes API
为了在Java中实现简单的配置，`RouteLocatorBuilder` bean中定义了一个fluent风格的API。

GatewaySampleApplication.java示例代码如下
```
// static imports from GatewayFilters and RoutePredicates
@Bean
public RouteLocator customRouteLocator(RouteLocatorBuilder builder, ThrottleGatewayFilterFactory throttle) {
    return builder.routes()
            .route(r -> r.host("**.abc.org").and().path("/image/png")
                .filters(f ->
                        f.addResponseHeader("X-TestHeader", "foobar"))
                .uri("http://httpbin.org:80")
            )
            .route(r -> r.path("/image/webp")
                .filters(f ->
                        f.addResponseHeader("X-AnotherHeader", "baz"))
                .uri("http://httpbin.org:80")
            )
            .route(r -> r.order(-1)
                .host("**.throttle.org").and().path("/get")
                .filters(f -> f.filter(throttle.apply(1,
                        1,
                        10,
                        TimeUnit.SECONDS)))
                .uri("http://httpbin.org:80")
            )
            .build();
}
```
这种样式还允许使用更多定制谓词断言。由`RouteDefinitionLocator` bean定义的谓词使用逻辑`and`组合。通过使用fluent Java API，您可以在`Predicate`类上使用`and()`、`or()`和`negate()`操作符。


### DiscoveryClient Route Definition Locator
网关可以配置为基于使用DiscoveryClient兼容服务注册中心注册的服务创建路由。

要实现这一点，设置`spring.cloud.gateway.discovery.locator.enabled=true`，并确保`DiscoveryClient`实现在类路径中是启用的(比如Netflix Eureka、Consul或Zookeeper)。

## CORS Configuration
Gateway可以配置为控制CORS行为。全局CORS配置是一个URL表达式的Map，参见：[Spring Framework `CorsConfiguration`](https://docs.spring.io/spring/docs/5.0.x/javadoc-api/org/springframework/web/cors/CorsConfiguration.html)。

application.yml. 
```
spring:
  cloud:
    gateway:
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins: "docs.spring.io"
            allowedMethods:
            - GET
```
在上面的例子中，CORS请求将被允许来自于docs.spring.io的所有GET方式的请求。
## Actuator API
官方整理中: 在端点`/gateway`

## Developer Guide
官方整理中: 编写自定义集成的概述

### Writing Custom Route Predicate Factories
官方整理中: 编写自定义路由断言工厂

### Writing Custom GatewayFilter Factories
为了编写`GatewayFilter`，您需要实现`GatewayFilterFactory`。有一个抽象类叫做`AbstractGatewayFilterFactory`，您可以对它进行扩展。

PreGatewayFilterFactory.java示例代码如下
```
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {
	public PreGatewayFilterFactory() {
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		// grab configuration from Config object
		return (exchange, chain) -> {
	           //If you want to build a "pre" filter you need to manipulate the
	           //request before calling change.filter
	           ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
	           //use builder to manipulate the request
	           return chain.filter(exchange.mutate().request(request).build());
		};
	}
	public static class Config {
	       //Put the configuration properties for your filter here
	}
}
```

PostGatewayFilterFactory.java示例代码如下

```
public class PostGatewayFilterFactory extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config> {
	public PostGatewayFilterFactory() {
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		// grab configuration from Config object
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				ServerHttpReponse response = exchange.getResponse();
				//Manipulate the response in some way
			}));
		};
	}
	public static class Config {
	       //Put the configuration properties for your filter here
	}
}
```
### Writing Custom Global Filters
官方整理中:  编写Custom Global Filters

### Writing Custom Route Locators and Writers
官方整理中: 编写自定义Route Locators 和 Writers

## Building a Simple Gateway Using Spring MVC or Webflux
Spring Cloud Gateway提供了一个名为`ProxyExchange`的工具对象，可以在常规Spring web处理程序中使用它作为方法参数。它通过镜像HTTP谓词的方法支持基本的下游HTTP交换。通过MVC，它还支持通过`forward()`方法转发到本地处理程序。要使用`ProxyExchange`，只需在类路径中包含正确的模块(`spring-cloud-gateway-mvc` 或 `spring-cloud-gateway-webflux`)。

MVC示例(将请求代理到下游的远程服务器上进行“/test”):
```
@RestController
@SpringBootApplication
public class GatewaySampleApplication {

	@Value("${remote.home}")
	private URI home;

	@GetMapping("/test")
	public ResponseEntity<?> proxy(ProxyExchange<byte[]> proxy) throws Exception {
		return proxy.uri(home.toString() + "/image/png").get();
	}

}
```

Webflux也是一样:
```
@RestController
@SpringBootApplication
public class GatewaySampleApplication {

	@Value("${remote.home}")
	private URI home;

	@GetMapping("/test")
	public Mono<ResponseEntity<?>> proxy(ProxyExchange<byte[]> proxy) throws Exception {
		return proxy.uri(home.toString() + "/image/png").get();
	}
}
```
`ProxyExchange`上有一些方便的方法，可以让处理程序方法发现并增强传入请求的URI路径。例如，您可能希望提取路径的尾部元素，以便将它们传递到下游:
```
@GetMapping("/proxy/path/**")
public ResponseEntity<?> proxyPath(ProxyExchange<byte[]> proxy) throws Exception {
  String path = proxy.path("/proxy/path/");
  return proxy.uri(home.toString() + "/foos/" + path).get();
}
```  

Spring MVC或Webflux的所有特性都可以用在网关处理器方法上。因此，您可以注入请求头和查询参数，例如，您可以使用映射注释中的声明约束传入的请求。有关这些特性的详细信息，请参阅Spring MVC中的`@RequestMapping`文档。

可以使用`ProxyExchange`上的`header()`方法将header添加到下游响应中。

您还可以通过添加一个mapper到`get()` 等方法来操作响应header(以及response中您喜欢的任何其他内容)。mapper是一个获取传入`ResponseEntity`并将其转换为传出`ResponseEntity`的函数。

"敏感"header (默认情况下是“cookie”和“authorization”) 和“proxy”header (`x-forwarded-*`)不会被传递到下游。
