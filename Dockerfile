# Multi-stage build for production
FROM maven:3.9.4-openjdk-21-slim AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Production stage
FROM openjdk:21-jre-slim

# Set working directory
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/HR_EmployeeManagement-*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]