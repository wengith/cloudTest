# 1. 微服务网关简介
API 网关（API Gateway）主要负责服务请求路由
、组合及协议转换。
百度百科对于API网关的介绍：
> API网关是一个服务器，是系统的唯一入口。从面向对象设计的角度看，它与外观模式类似。API网关封装了系统内部架构，为每个客户端提供一个定制的API。它可能还具有其它职责，如身份验证、监控、负载均衡、缓存、请求分片与管理、静态响应处理。
> API网关方式的核心要点是，所有的客户端和消费端都通过统一的网关接入微服务，在网关层处理所有的非业务功能。通常，网关也是提供REST/HTTP的访问API。服务端通过API-GW注册和管理服务。

# 2.  技术选型
- SpringCloud-Zuul :社区活跃,基于 SrpingCloud 完整生态, 是构建微服务体系前置网关服务的最佳选型.

- Kong : 基于OpenResty的 API 网关服务和网关服务管理层.

- 自建网关服务: nginx+lua+OpenResty

### 网关的设计要素
#### 系统级别
- 高可用性
- 均衡负载: 容错,防止雪崩.
- 并发控制 : 错峰流控
- 动态路由制定和修改
#### 应用级别
- 监控统计
- 版本控制
- 认证 鉴权
- 数据安全: 防篡改,参数脱敏…
- 协议转换: 如 HTTP => RPC协议。
# 3. Spring Cloud Zuul
### 简介
基于Netflix Zuul组件开发，兼容Spring Cloud体系，官方文档描述如下：
> - front door. API Gateway.Zuul is a JVM based router and server side load balancer by Netflix.（所有请求的入口）
> - As an edge service application, Zuul is built to enable dynamic routing, monitoring, resiliency and security. （作为边界应用服务，zuul能实现动态路由、监控、弹性与安全性。）

### 3.1 Zuul能做什么
- Authentication 认证
- Insights 洞察力
- Stress Testing 压力测试
- Canary Testing 金丝雀测试
- Dynamic Routing 动态路由
- Service Migration 服务迁移
- Load Shedding 减载
- Security 安全
- Static Response handling 静态响应处理
- Active/Active traffic management 流量控制
### 3.2 Zuul请求响应过程
![image](http://git.jsptz.com/cloud/pictures/raw/master/arch6/zuul.png)

### 3.3 认证鉴权流程
![image](http://git.jsptz.com/cloud/pictures/raw/master/arch6/zuul-%E5%AE%8C%E6%95%B4%E6%9E%B6%E6%9E%84.png)

- JWT（Json Web Token）携带用户的userCode和comCode信息，并存储在Redis集群中，用户的权限信息也通过redis进行缓存
- Redis内缓存的数据Key值使用“userCode:key“，保证共享的数据不重复。
- 微服务实际使用过程中userCode是从JWT中获取，JWT会在微服务间进行传递
- 对于外部调用接口，需要根据提供的用户名密码调用网关服务的JWT生成接口，获得JWT信息，并在接口实际调用时携带该JWT信息。

### 3.4 限流策略
常见的限流算法有：令牌桶、漏桶。 计数器也可以进行粗暴限流实现。
#### 3.4.1 令牌桶
大小固定的令牌桶可自行以恒定的速率源源不断地产生令牌。如果令牌不被消耗，或者被消耗的速度小于产生的速度，令牌就会不断地增多，直到把桶填满。后面再产生的令牌就会从桶中溢出。最后桶中可以保存的最大令牌数永远不会超过桶的大小
![image](http://git.jsptz.com/cloud/pictures/raw/master/arch6/%E4%BB%A4%E7%89%8C%E6%A1%B6.jpg)
流程：
> 1. 所有的流量在放行之前需要获取一定量的 token；
> 2. 所有的 token 存放在一个 bucket（桶）当中，每 1/r 秒，都会往这个 bucket 当中加入一个 token；
> 3. bucket 有最大容量（capacity or limit），在 bucket 中的 token 数量等于最大容量，而且没有 token 消耗时，新的额外的 token 会被抛弃。


这种实现方法有几个优势：
> 1. 避免了给每一个 Bucket 设置一个定时器这种笨办法，
> 2. 数据结构需要的内存量很小，只需要储存 Bucket 中剩余的 Token 量以及上次补充 Token 的时间戳就可以了；
> 3. 只有在用户访问的时候，才会计算 Token 补充量，对于系统的计算资源占用量也较小。
#### 3.4.2 漏桶
漏桶算法强制一个常量的输出速率而不管输入数据流的突发性
![image](http://git.jsptz.com/cloud/pictures/raw/master/arch6/%E6%BC%8F%E6%A1%B6.png)
流程：

到达的数据包（网络层的PDU）被放置在底部具有漏孔的桶中（数据包缓存）；
漏桶最多可以排队b个字节，漏桶的这个尺寸受限于有效的系统内存。如果数据包到达的时候漏桶已经满了，那么数据包应被丢弃；
数据包从漏桶中漏出，以常量速率（r字节/秒）注入网络，因此平滑了突发流量。
#### 3.4.3 我们的策略
> **Redis+lua**

分布式限流最关键的是要将限流服务做成原子化，而解决方案可以使使用redis+lua或者技术进行实现，通过这两种技术可以实现的高并发和高性能。

其中核心部分access方法通过lua脚本实现时间窗内某个接口的请求数限流，实现了该功能后可以改造为限流总并发/请求数和限制总资源数。Lua本身就是一种编程语言，也可以使用它实现复杂的令牌桶或漏桶算法。

```
local key = KEYS[1] --限流KEY（一秒一个）
local limit = tonumber(ARGV[1])        --限流大小
local current = tonumber(redis.call('get', key) or "0")
if current + 1 > limit then --如果超出限流大小
    redis.call("INCRBY", key,"1") -- 如果不需要统计真是访问量可以不加这行
    return 0
else  --请求数+1，并设置2秒过期
    redis.call("INCRBY", key,"1")
    if tonumber(ARGV[2]) > -1 then
        redis.call("expire", key,tonumber(ARGV[2])) --时间窗口最大时间后销毁键
    end
    return 1
end

```
因此目前提供的zuul是对微服务级别的限流。
### 3.5 网关配置
#### 3.5.1 转发配置
1. 静态路由

```
zuul:
  routes:
    myroute1:
      path: /mypath/**
      url: http://localhost:8080	(注意这里url要http://开头)
```
2. 动态路由

```
zuul:
  routes:
    myroutes1:
      path: /mypath/**
      serviceId: myserverId
```
#### 3.5.2 转发规则
**stripPrefix=true**，转发会过滤掉前缀。

**path: /myusers/****
，默认时转发到服务的请求是/**

如果**stripPrefix=false**，转发的请求是
/myusers/**

**zuul.prefix=/api**	
会对所有的path增加一个/api前缀

#### 3.5.3 匹配顺序
path:/myusers/**

path:/**

如果是在application.yml中配置的，那么会优先匹配/myusers/**
但如果是applicaiton.properties配置的，那么可能导致/myusers/**
被/**
覆盖

ignored-Services: ‘*‘	对于自动发现的services,除了route中明确指定的，其他都会被忽略

#### 3.5.4 请求头过滤
route.sensitiveHeaders:Cookie,Set-Cookie,Authorization	

默认就有这三个请求头，意思是不向下游转发请求这几个头
zuul.ignoredHeaders 是一个全局设置，而route.sensitiveHeaders是局部设置

#### 3.5.5 超时配置
```
hystrix:
  command:  
    default: 
      execution:  
        isolation:  
          thread.timeoutInMilliseconds: 10000 #熔断设定
ribbon: 
  ConnectTimeout: 3000 #表示路由转发请求的时候，创建请求连接的超时时间
  ReadTimeout: 5000 #用来设置路由转发请求的超时时间，它的超时是对请求建立连接之后的处理时间
```
######两种路由配置对应不一样的超时配置
1.ribbon.ReadTimeout，ribbon.SocketTimeout这两个就是ribbon超时时间设置。
2.zuul.host.connect-timeout-millis， zuul.host.socket-timeout-millis这两个配置，这两个和上面的ribbon都是配超时的。
>区别在于，如果路由方式是serviceId的方式，那么ribbon的生效，如果是url的方式，则zuul.host开头的生效
>使用url的方式将没有线程隔离和断路器的保护，并且也不会具备负载均衡的能力。所以不建议使用url的方式

######几种超时情况
1.hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds:该参数用来设置API网关中路由转发请求的执行时间，执行超过配置值之后Hystrix会将执行命令标记为TIMEOUT并抛出异常。

2.ribbon.ReadTimeout:配置值小于hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds配置值时，路由请求出现超时，会自动进行路由重试，如果依旧失败出现重试失败；
ribbon.ReadTimeout:配置值大于hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds配置值时，路由请求出现超时，返回TIMEOUT的错误信息。

3.ConnectTimeout和ribbon.ReadTimeout相似，唯一的区别就在于它的超时是对请求建立连接之后的处理时间，也具有重试机制。
>zuul.retryable=false和zuul.routes.<route>.retryable=false可以关闭重试机制
#### 3.5.5 数据库动态路由加载
zuul_gateway表结构

id | path | service_id  |url|retryable|enabled|strip_prefix|api_name
---|---|---|---|---|---|---|---
主键|匹配地址|微服务id|转发地址，默认空|是否重试|是否启用|是否过滤前缀|接口名称

#### 3.5.6 限流表结构
zuul_rate_limit表

Id | Method | Type | Limits | Time_Unit | Name
---|---|---|---|---|---
主键|冗余字段|1限流2配额|限制次数|秒，单位时间|名称

zuul_client_relation表

Id | Client_Id | Api_Define_Id | Rate_Limit_Id | Time_Limit_Id
---|---|---|---|---
主键|用户代码|zuul_gateway主键|限流方案Id|限额方案ID



