FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/backend-1.0-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]