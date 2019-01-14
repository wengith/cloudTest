set MAVEN_OPTS=-Xms64m -Xmx512m 
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dapollo.meta=http://10.10.2.243:8080"