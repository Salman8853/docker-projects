
# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy
LABEL maintainer="codeadiction"
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

#COPY target/docker-demo.jar /app/docker-demo.jar
CMD ["./mvnw", "spring-boot:run"]
#ENTRYPOINT ["java", "-jar", "/app/docker-demo.jar"]

