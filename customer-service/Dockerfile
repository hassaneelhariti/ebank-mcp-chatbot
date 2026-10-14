FROM eclipse-temurin:21-jre-alpine
LABEL authors="hassaneelhariti"
WORKDIR "/app"
COPY /target/customer-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
ENTRYPOINT ["java", "-jar","customer-service-0.0.1-SNAPSHOT.jar"]