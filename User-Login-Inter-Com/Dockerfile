# Use a lightweight base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Set a volume for temporary storage (if needed)
VOLUME /tmp

# Expose the port your Spring Boot application uses (change if needed)
EXPOSE 9902

# Define an argument for the JAR file
ARG JAR_FILE=target/User-Login-0.0.1-SNAPSHOT.jar

# Copy the JAR file into the container as "app.jar"
ADD ${JAR_FILE} app.jar

# Specify the entry point for running the application
ENTRYPOINT ["java", "-jar", "/app.jar"]