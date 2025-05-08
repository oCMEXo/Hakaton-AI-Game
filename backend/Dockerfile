FROM gradle:jdk23-alpine AS builder
WORKDIR /build
COPY --chown=gradle:gradle . ./
RUN gradle build

FROM eclipse-temurin:23-jdk
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder /build/${JAR_FILE} app.jar
COPY --from=builder /build/.env .env
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
