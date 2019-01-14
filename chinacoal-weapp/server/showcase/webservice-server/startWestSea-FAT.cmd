set MAVEN_OPTS=-Xms64m -Xmx128m 
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dapollo.meta=http://10.10.2.244:8080"