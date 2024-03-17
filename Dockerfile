FROM openjdk:17-slim AS builder
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

COPY tennis-player-application tennis-player-application
COPY tennis-player-domain tennis-player-domain
COPY tennis-player-infrastructure tennis-player-infrastructure

COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

FROM openjdk:17-slim
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar tennis_players.jar

COPY src/main/resources/players.json .

ENTRYPOINT ["java", "-jar", "tennis_players.jar"]
