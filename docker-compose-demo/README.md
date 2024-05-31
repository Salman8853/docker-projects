### How to Create a Spring boot application with mysql DB using Docker Compose
---
Hi, 
 This is a sample application to walk through you to run and communicate spring boot container with mysql container via docker compose.
I'll explain you each and every thinkg step by step, So let's get started. <br>
## Step 1:  Create a spring boot application with docker file
```
# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy
LABEL maintainer="codeadiction"
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
```
## Step 2: Create a docker compose file
> [!NOTE]
> This docker compose file container all the informantion about to create a mysql DB conatainer and  Spring boot container
> And how to both connected with each in same network with
```
version: '1.0'
services:
# MySQL Database Service
  mysql: # ServiceName which you want to give.
    image: mysql:latest
    container_name: mysql-container
    ports:
      - 3308:3306
    environment:
      MYSQL_ROOT_PASSWORD: Khanms8853@@
      MYSQL_DATABASE: docker-db
    healthcheck:
        test: [ "CMD","mysqladmin","ping","-h","localhost","-u","root","-pKhanms8853@@"]
        interval: 10s
        timeout: 5s
        retries: 3
    networks:
      - docker-nw
  # Spring Boot Application
  spring-app:
    #image: docker-compose-demo
    build:
      context: .
      dockerfile: Dockerfile
    container_name: spring-container
    depends_on:
      mysql:
        condition: service_healthy
    ports:
      - "8080:8080"
    environment:
      SPRING_CONFIG_LOCATION: classpath:/application.properties
    networks:
      - docker-nw
    image: puddu6264/docker-compose-demo:latest  # Set your desired image name

networks:
    docker-nw: #Name of your docker network you want to give
      driver: bridge
```

## Step 3 Change the application.properties file 
In the application.properties file, we should change change the datasouce url host, localhost to database service name
```
server.port=8080
#spring.datasource.url=jdbc:mysql://<db-service-name>:3306/docker-db?autoReconnect=true&useSSL=false
spring.datasource.url=jdbc:mysql://mysql:3306/docker-db?createDatabaseIfNotExists=true&autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=<root-user-name>
spring.datasource.password=<mmysql-db-passwd>

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
## Step 4:  Run the Docker compose 
To run the docker compose using the command 
```
docker compose up
```
To run the docker compose in detach mode use flag -d
```docker-compose up -d ```
## --build Build images before starting containers
```docker-compose up --build```

## Step 3: Stop the Docker compose
To Stop and kill the containers
```
docker compose down
```

# Some Important docker-compose commands List
- ``` docker-compose up ```
* ``` docker-compose up -d ``` run docker compose in detach mode. 
+ ``` docker-compose up --build ``` Build images before starting containers.
+ ```docker-compose down``` Stops and removes containers, networks, volumes, and images.
+ ```docker-compose stop``` Stops running containers without removing them.
+ ``` docker-compose start``` Starts existing stopped containers.
+ ``` docker-compose restart ``` docker-compose restart.
+  ```docker-compose ps ``` Lists containers.
+  Executes a command in a running container.
   ```
   docker-compose exec <service_name> <command>
   ```
   Example
    ```
     docker-compose exec web bash
    ```
+ Scales a service to a specified number of instances.
  ```
  docker-compose up --scale <service_name>=<number_of_instances>
  ```
    Example
         ```
          docker-compose up --scale spring-app=3
         ```

Thank you




