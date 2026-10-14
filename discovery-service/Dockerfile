FROM eclipse-temurin:21-jre-alpine
LABEL authors="hassaneelhariti"

WORKDIR "/app"
COPY /target/discovery-service-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8761
ENTRYPOINT ["java", "-jar","discovery-service-0.0.1-SNAPSHOT.jar"]