FROM eclipse-temurin:21-jre
LABEL authors="hassaneelhariti"
WORKDIR /app
COPY /target/gateway-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 9999
ENTRYPOINT ["java", "-jar","gateway-service-0.0.1-SNAPSHOT.jar"]