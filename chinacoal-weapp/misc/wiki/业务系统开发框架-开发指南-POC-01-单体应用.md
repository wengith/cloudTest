# 单体应用
业务系统开发框架样本程序分为两类：
* 单体应用：单实例即可运行
* 微服务应用：需要依赖consul-server（可选）、gateway-server、rabbitmq（可选）等基础微服务和软件，通过gateway-server提供诸多企业级特性，内置分布式缓存+分布式Session。

所有业务系统开发框架样本程序均要求具有Redis（单节点或集群即可）。

## 单体应用的分类
根据是否使用数据库，业务系统开发框架单体应用分为2类：
* Web应用：依赖ins-framework-web 
* Web+DB应用:依赖ins-framework-web和ins-framework-mybatis

## 单体应用样本程序
业务系统开发框架单体应用样本程序如下：
* mono-echo-server ：Web应用，Git地址：http://git.jsptz.com/jsptz/framework-poc/src/master/monolith/mono-echo-server
* mono-robot-server ：Web+DB应用，robot主子表操作，Git地址：http://git.jsptz.com/jsptz/framework-poc/src/master/monolith/mono-robot-server

所有应用均支持Swagger、AppLog、TraceLog
## 单体应用转为微服务应用
业务系统开发框架单体应用转为微服务应用:
### pom.xml引入依赖包
如果使用全微服务特性(consul-server、rabbitmq)，直接引用
```
    <dependency>
        <groupId>ins.framework</groupId>
        <artifactId>ins-framework-cloud</artifactId>
        <version>${ins-framework-cloud.version}</version>
    </dependency>
```
也可以根据需要进行排除
```
    <dependency>
        <groupId>ins.framework</groupId>
        <artifactId>ins-framework-cloud</artifactId>
        <version>${ins-framework-cloud.version}</version>
        <exclusions>                 
            <!-- 不使用rabbitmq，将失去日志跟踪等功能 -->
            <exclusion>
                <groupId>ins.framework</groupId>
                <artifactId>ins-framework-rabbitmq</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
``` 
### 应用修改
如果使用consul-server，在Application.java中添加EnableDiscoveryClient、EnableFeignClients注解，如下所示：
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = { "ins.framework", "ins.platform" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

```