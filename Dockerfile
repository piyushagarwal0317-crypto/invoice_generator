
# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
# Smartly find the real jar (ignoring the 'plain' one) and rename it to app.jar
RUN find target -maxdepth 1 -name "*.jar" -not -name "*plain.jar" -exec cp {} /app/app.jar \;

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk
WORKDIR /app
# Copy the single, correctly named app.jar from Stage 1
COPY --from=build /app/app.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]