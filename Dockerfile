# Stage 1: Build the application using Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Find the real executable jar (ignoring the plain one) and rename it to a clean name
RUN cp target/$(ls target | grep -v "plain" | grep ".jar") /app/final-app.jar

# Stage 2: Run the application using Java 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Explicitly copy the exact file without any wildcards
COPY --from=build /app/final-app.jar ./app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]