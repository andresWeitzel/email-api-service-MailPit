### Configuration and Execution (Docker Compose)
* If any of the following steps don't work, watch this [x](x)
* Repository Clone
```git
git clone https://github.com/andresWeitzel/email-api-service-MailPit
cd email-api-service-MailPit
```
<br>

#### Docker Compose Setup for Development


> 🟡 **Note**: Upon first use, you must compile the project at least once for Maven to download all dependencies.

* Before building the Docker image, you need to generate the JAR file of the project. Run the following command from the root directory of the project:
```git
./mvnw clean package -DskipTests
or
mvn clean package -DskipTests (If you have Maven installed globally)
```
* This will create a .jar file inside the target/ directory, with a next name:
```git
target/email-api-mailpit-0.0.1-SNAPSHOT.jar
```
* This file will be used by Docker to build the application image.
* Before building and running the containers, make sure you have Docker running (for Windows, use [Docker Desktop]([https://nodejs.org/en/download](https://www.docker.com/products/docker-desktop/)))
* Once installed, make sure Docker is running
```git
docker --version
```
* Once Docker is running, you can build and deploy the containers with docker compose (This command is only needed once to build).
* The container for Mailpit and Postgres will be created. 
```git
docker-compose up --build
```
* After creating the containers with Docker Compose, each time we are going to start the containers we will use the following command, otherwise we will run it from Docker Desktop. Start the environment in development mode. Every time you want to run the app in development, you won't need to compile the jar. Simply run the following command:
```git
docker-compose up
```
* Finally, run the app in development mode with maven.
```git
./mvnw spring-boot:run
or
mvn spring-boot:run (If you have Maven installed globally)
```
* Or from sts right click on the project -> Run As-> Spring boot app
* We now have the services available for development and testing.
  


<br>

#### Docker Compose Setup for Production

* Pending

  <br>

### Testing
* The MailPit web interface will be available at `http://localhost:8025`, where you can view sent emails.
* You can test the API using Postman or swagger or any HTTP client by sending request to `http://localhost:8080/api/v1/users` with the following JSON body.
* The Swagger UI web interface will be available at `http://localhost:8080/swagger-ui/index.html`, where you can test all endpoints.

