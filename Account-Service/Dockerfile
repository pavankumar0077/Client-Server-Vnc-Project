# Stage 1: Build the Spring Boot application
FROM maven:3.8.4 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files for dependencies resolution
COPY pom.xml .

# Copy the source code
COPY src src

# Build the application with Maven
RUN mvn clean package

# Stage 2: Create the final Docker image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/Account-Service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 9901

# Define the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
