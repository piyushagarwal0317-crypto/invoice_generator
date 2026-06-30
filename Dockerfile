# Stage 1: Build the application using Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Delete the plain jar entirely so only the main executable is left
RUN rm target/*-plain.jar || true

# Stage 2: Run the application using Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Safely copy the one remaining correct jar file
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]