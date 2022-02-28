FROM openjdk:17-jdk-alpine
EXPOSE 8001
COPY target/config-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "config-service-0.0.1-SNAPSHOT.jar"]