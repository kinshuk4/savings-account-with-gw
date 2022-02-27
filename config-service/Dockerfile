FROM maven:3.8.4-openjdk-11-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn -Dmaven.test.skip=true package

FROM openjdk:11-jre
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/config-service-1.0.0.jar /app/

ENTRYPOINT ["java", "-jar", "config-service-1.0.0.jar"]
