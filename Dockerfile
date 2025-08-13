# Use official lightweight OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper & project files
COPY . .

# Build the application without running tests
RUN ./mvnw -DskipTests package

# Expose the port Render will use
EXPOSE 8080

# Run the built JAR file
CMD ["java", "-jar", "target/expensetracker-0.0.1-SNAPSHOT.jar"]
