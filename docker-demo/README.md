### This Repository Explain, How to connect Spring boot container with Mysql Container Using  DOCKER CLI
---

> [!NOTE]
Follow the below step by step procedure to run your Spring boot Container With Mysql database container

### Step 1: Create a docker network
Syntax to create  network in docker <br>
`docker create network <namtwork-name>`<br>

Example

```
docker network create my-network
```

### Step 2:  Run mysql image with docker network
>[!IMPORTANT]
>This image will be pulled form docker hub public repository and then run by the below docker run command
```
docker run --name  mysql-container -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=docker-db --network my-network mysql:8.3.0

```

### Step 3: Change in Spring boot application.properties/application.yml file
  In your Spring Boot application's application.properties or application.yml file, configure the MySQL database connection properties. Use the MySQL container's hostname (mysql-container) or IP address within the Docker network
```
server.port=8082
#spring.datasource.url=jdbc:mysql://localhost:3306/docker-db?useSSL=false
# To connect with Mysql database, Pass mysql container name inplace of localhost
spring.datasource.url=jdbc:mysql://mysql-container:3306/docker-db?createDatabaseIfNotExists=true&autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=123456

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
### Step 4: Build the image image
**To build the docker image of Spring Boot app** <br>
``` 
docker build -t docker-demo:latest .
```
### To Run the Spring boot app in the same network in which you run the mysql database container
Syntex for  running the Spring boot app <br>
`docker run -d -p 8080:8082 --network <docker-network-name> <image-name-with-tag>`<br>

Example <br>
```
docker run -d -p 8080:8082 --network my-network docker-demo:latest
```
>[!NOTE]
>If you want to inspect/check both containers are connected togather in the same network
` Syntex:
    docker inspect <docker-resource-name>
`
**Example** <br>
```
    $docker inspect my-network
```

If you want to show the application log of Spring boot app <br>
```
docker logs <Springboot app container Id>
```
>[!NOTE]
>To get the container Id
>Run the command `docker ps` this command will print all the running conatiners detail. If you are interested to know about stooped conatiners the hit this one `docker ps -a`

### Check the Mysql conatiner Database
To  check the database of mysql use the command <br>
```
  docker exec -it <conainer-ID> bash
 ```

This command will open the Shall of your mysql database container in which mysql database is running....<br>
**To connect mysql database use the below command**
```
 mysql -u root -p
```
>[!IMPORTANT]
>Get **database password** from your **application.properties** file <br>
>Check out the database `use <your-app-db-name>` command. and  `show tables` for show the tables in db.<br>
>To fetch records `Select * from <db-name>`

<br>


THANK YOU & HAPPU LEARNING  🥰 ❤️






