set MAVEN_OPTS=-Xms64m -Xmx512m 
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dapollo.meta=http://apollo.dev.jsptz.com"