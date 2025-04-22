#defines a multi-stage build for a Java Spring Boot application using Maven and OpenJDK, optimized for smaller image size and faster builds.
# Use Maven image to build the app
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
#Copies pom.xml and src directory into the container.
#Maven uses pom.xml to know which dependencies and plugins are needed.
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK image to run the app
FROM openjdk:17-jdk-alpine
WORKDIR /app
# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar calc-githubactions.jar

# Expose port 8085 for Spring Boot
EXPOSE 8085

# Start the app with the jar file
ENTRYPOINT ["java", "-jar", "calc-githubactions.jar"]
