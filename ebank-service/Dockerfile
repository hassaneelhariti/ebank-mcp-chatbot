FROM eclipse-temurin:17-jre
LABEL authors="hassaneelhariti"
WORKDIR "/app"
COPY target/ebank-service-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8081
ENTRYPOINT ["java", "-jar","ebank-service-0.0.1-SNAPSHOT.jar"]