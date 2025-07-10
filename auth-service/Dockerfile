# Author: Srinivas Velishetti
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/auth-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
