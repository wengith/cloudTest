# Web类型转Web+DB类型

## 单体应用样本程序
业务系统开发框架单体应用样本程序如下：
* mono-echo-server ：Web应用，Git地址：http://git.jsptz.com/jsptz/framework-poc/src/master/monolith/mono-echo-server
* mono-robot-server ：Web+DB应用，robot主子表操作，Git地址：http://git.jsptz.com/jsptz/framework-poc/src/master/monolith/mono-robot-server

本例将从mono-echo-server转为mono-robot-server。

## Web类型转为Web+DB类型
Web类型转为Web+DB类型:
### pom.xml引入依赖包 
dependencies节增加
```
    <!-- +DB类型 -->
    <dependency>
        <groupId>ins.framework</groupId>
        <artifactId>ins-framework-mybatis</artifactId>
        <version>${ins-framework-mybatis.version}</version>
    </dependency>
    <!-- 代码生成工具 -->
    <dependency>
        <groupId>ins.framework</groupId>
        <artifactId>ins-framework-mybatis-generator</artifactId>
        <version>${ins-framework-mybatis-generator.version}</version>
        <scope>test</scope>
    </dependency>
    <!-- 数据库驱动 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
``` 
### 增加代码生成相关代码
在/src/test/java下增加类codegen.CodeGenerator,示例代码如下： 
```
package codegen;

import java.util.ArrayList;
import java.util.List;

import ins.framework.mybatis.generator.GenConfig;
import ins.framework.mybatis.generator.GenParam;
import ins.framework.mybatis.generator.GenType;
import ins.framework.mybatis.generator.Generator;

public class CodeGenerator {

	public static void main(String[] args) {
		List<GenParam> paramList = new ArrayList<GenParam>();
		/**
		 * 请保持生成参数的完整，不要注释
		 */
		paramList.add(new GenParam("robot", new String[] { "demo_robot_main", "demo_robot_job" }));
		GenConfig gc = new GenConfig();
		gc.setBasePackage("ins.platform");
		// 设置要忽略的表名前缀，默认空
		gc.setIgnoreTablePrefixs(new String[] { "prpl", "pprd" });
		// 设置PO是否保留前缀(设置忽略表名前缀时)，默认true
		gc.setKeepPrefixForPO(false);
		// 设置取操作时间函数，默认空
		gc.setOperateTimeForHisFunc("");
		// 设置是否默认开启二级缓存（影响base中的MapperXML），默认false
		gc.setDefaultCache(false);
		// mysql 数据库相关配置
		// 设置基本保存目录（Java源代码根目录） 
		gc.setSaveDir("src/main/java"); 
		gc.setDbDriverName("com.mysql.jdbc.Driver");
		gc.setDbUser("root");
		gc.setDbSchema("platform_devdb");
		gc.setDbPassword("admin");
		gc.setDbUrl("jdbc:mysql://localhost:3306/platform_devdb?characterEncoding=utf8&autoReconnect=true");
		// 支持生成的文件类型:生成PO、BASE_MAPPER_XML（自动覆盖）、Dao、VO、MapperXML（不覆盖）
		gc.setGenTypes(
				new GenType[] { GenType.VO, GenType.PO, GenType.DAO, GenType.BASE_MAPPER_XML, GenType.MAPPER_XML });

		Generator generator = new Generator();
		generator.setGenConfig(gc);
		generator.setParamList(paramList);
		generator.generate();
	}
}

```
执行CodeGenerator，生成相关代码
### 配置文件增加数据库相关配置
修改application.xml（实际使用apollo），增加如下内容
```
spring:
  datasource: #数据源配置
    url: jdbc:mysql://localhost:3306/platform_devdb?useUnicode=true&amp;characterEncoding=utf-8
    username: root
    password: admin
    dbcp2:
      max-idle: 10
      max-wait-millis: 10000
      min-idle: 5
      initial-size: 5
      validation-query: SELECT 1
      test-on-borrow: false
      test-while-idle: true
      time-between-eviction-runs-millis: 18800
      
mybatis: #MyBatis配置
  mapperLocations: classpath*:mapper/**/*Dao.xml
  executor-type: REUSE         
``` 
### Application 添加@Mapper扫描
默认情况下，将自动扫描Appliation所在包及子包下的所有带@Mapper注解的接口。如果需要扫描其它包下的@Mapper接口，需要特别值得，示例如下：
```
package ins.platform.demo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan; 
@ComponentScan(basePackages = { "ins.framework", "ins.platform" })
@MapperScan(annotationClass=Mapper.class, basePackages= { "ins" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

### 编写相关数据库操作代码
(略)