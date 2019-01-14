# FAQ
## selectPage无法获取count值
Application.java中的包扫描一定要包含ins.framework，否则无法加载分页插件，就会出现无法获取count等问题。Application中示例代码如下：
```
@SpringBootApplication(scanBasePackages = { "ins.framework","ins.platform" })
```
## 如何加载非Application子包下的MyBatisDAO
包含两个package的示例如下：
```
@MapperScan(annotationClass=org.apache.ibatis.annotations.Mapper.class, basePackages= { "ins" ,"flex"})
```
## 使用360双核浏览器时，通过单点登录跳转后第1次使用会失效
原因是360双核浏览器从跳转页(cas-portal)到系统页(xxx)时进行了自动内核切换，导致存储在localStorage中的token无法传递

## 异常信息取不到国际化的文本
如果使用apollo，需要在bootstrap.yml中添加
```
spring:
  messages:
    basename: i18n/exception   
```
此时才能正确取到值，且使用的是apollo中的配置


## 如何通过系统参数自定义日志文件根路径

检查logback-spring.xml文件中的内容，如果如下所示
```
    <property name="LOG_HOME" value="logs/${springAppName}" />
```
则需要修改为
```
    <property name="LOG_HOME" value="${LOG_ROOT:-logs}/${springAppName}" />
```
即使用变量LOG_ROOT,且其值默认为logs。

启动时使用 
```java -DLOG_ROOT=/home/cloud/logs XXX```
 的方式设定LOG_ROOT的值就可以自定义日志文件的根路径了。

## RestTemplate写法导致内存无法GC问题
错误代码
```
    		String url = "http://"+ConsultConstant.ACT_SERVER_NAME+"/runtime/tasks/"+taskid;
    		restTemplate.postForEntity(url, request, Object.class);
```
正确代码
```
	//类常量
	private static fianl String TASKS_URL = "http://"+ConsultConstant.ACT_SERVER_NAME+"/runtime/tasks/${taskId}"; 
		...         		
		restTemplate.postForEntity(TASKS_URL, request, Object.class,taskId);
```
原因：
		以url为key进行测量，url巨多则占用内存巨多，且无法gc，表现为存在大量MBean实例