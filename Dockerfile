# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files
COPY build/libs/nba-back.jar .

# Expose the port that your application will run on (if needed)
EXPOSE 8080

# Set the entry point with the necessary Java options
ENTRYPOINT ["java", "-jar", "nba-back.jar"]