# Step 1: Use an official OpenJDK image as a base image
FROM openjdk:17-jdk

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file from the local machine to the container
COPY build/libs/airport-0.0.1-SNAPSHOT.jar /app/airport-0.0.1-SNAPSHOT.jar

# Step 4: Expose the port that your app runs on (optional, for web apps)
EXPOSE 8080

# Step 5: Define the entry point for running the application
ENTRYPOINT ["java", "-jar", "/app/airport-0.0.1-SNAPSHOT.jar"]
