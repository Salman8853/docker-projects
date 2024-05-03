# Use the official OpenJDK 17 image from Docker Hub
FROM openjdk:17
# Set working directory inside the container
WORKDIR /myapp
# Copy the compiled Java application JAR file into the container
COPY ./target/docker-shall-app.jar /myapp

# Copy the entrypoint script
COPY entrypoint.sh /myapp/entrypoint.sh

# Make the entrypoint script executable
RUN chmod +x /myapp/entrypoint.sh

# Set the entrypoint
ENTRYPOINT ["/myapp/entrypoint.sh"]
# Expose the port the Spring Boot application will run on
EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "docker-shall-app.jar"]