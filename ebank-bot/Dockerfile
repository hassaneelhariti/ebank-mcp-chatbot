FROM eclipse-temurin:21-jre
LABEL authors="hassaneelhariti"
WORKDIR /app
COPY /target/ebank-bot-0.0.1-SNAPSHOT.jar /app
EXPOSE 8083
ENTRYPOINT ["java", "-jar","ebank-bot-0.0.1-SNAPSHOT.jar"]