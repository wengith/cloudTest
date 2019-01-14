# 微服务应用
业务系统开发框架样本程序分为两类：
* 单体应用：单实例即可运行
* 微服务应用：需要依赖consul-server（可选）、gateway-server、rabbitmq（可选）等基础微服务和软件，通过gateway-server提供诸多企业级特性，内置分布式缓存+分布式Session。

所有业务系统开发框架样本程序均要求具有Redis（单节点或集群即可）。

## 微服务应用的分类
根据是否使用数据库，Arch6微服务应用分为2类：
* Web应用：依赖ins-framework-web 
* Web+DB应用:依赖ins-framework-web和ins-framework-mybatis

## 微服务应用样本程序

业务系统开发框架微服务应用样本程序如下：
* echo-server ：Web应用，支持Swagger、AppLog、TraceLog，Git地址：http://git.jsptz.com/jsptz/framework-poc/src/master/server/echo-server
* misc-server ：Web+DB应用，支持Swagger、AppLog、TraceLog，Git地址：为：http://git.jsptz.com/jsptz/framework-poc/src/master/server/misc-server

## 微服务应用转为单体应用
业务系统开发框架微服务应用转为单体应用:
### pom.xml移除依赖包
移除ins-framework-cloud相关包：
* ins-framework-cloud 
* ins-framework-rabbitmq

### 应用修改
* 在Application.java中去掉EnableDiscoveryClient或@EnableEurekaClient注解
* 其他编译错误修正 

