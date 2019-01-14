# Maven模块转换为单独项目

为统一版本期间，POC为一个多模块项目，如果希望只要其中一个模块，可以将该模块转换为独立项目。
; 本例将从mono-echo-server模块转为单独项目。均为操作pom.xml文件

## 转换步骤

### 更改parent项目
```
	<parent>
		<groupId>ins.platform</groupId>
		<artifactId>ins-platform-parent</artifactId>
		<version>6.1.1-SNAPSHOT</version>
		<relativePath>../../.</relativePath>
	</parent>
```
变更为
 ```
	<parent>
		<groupId>ins.framework</groupId>
		<artifactId>ins-framework-parent</artifactId>
		<version>6.1.1-SNAPSHOT</version>
	</parent>
```

### 添加属性

 ```
	<properties> 
		<ins-framework.version>${project.parent.version}</ins-framework.version>
	</properties>
 ```

### 添加仓库
 ```
	<!-- 设定除中央仓库(repo1.maven.org/maven2/)外的其他仓库,按设定顺序进行查找. -->
	<repositories>
		<!-- 如有Nexus私服, 取消注释并指向正确的服务器地址. -->
		<repository>
			<id>jsptz-nexus</id>
			<name>Team 
				Nexus Repository</name>
			<url>http://repo.jsptz.com/nexus/content/groups/public</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>
	<!-- 设定使用Release插件发布的仓库服务器 如有Nexus私服, 取消注释并指向正确的服务器地址. -->
	<distributionManagement>
		<repository>
			<id>jsptz-nexus</id>
			<name>Team Nexus Release Repository</name>
			<url>http://repo.jsptz.com/nexus/content/repositories/releases</url>
		</repository>
		<snapshotRepository>
			<id>jsptz-nexus-snapshot</id>
			<name>Team Nexus Snapshot Repository</name>
			<url>http://repo.jsptz.com/nexus/content/repositories/snapshots</url>
			<uniqueVersion>false</uniqueVersion>
		</snapshotRepository>
	</distributionManagement>
 ```

### 从parent项目中把本模块删除