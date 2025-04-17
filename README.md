### Configuration and Execution (Docker Compose)
* If any of the following steps don't work, watch this [video](https://www.youtube.com/watch?v=QMlpFdOQHfI)
* Repository Clone
```git
git clone https://github.com/andresWeitzel/email-api-service-MailPit
cd email-api-service-MailPit
```
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
* Once Docker is running, you can build and deploy the containers with docker compose.

  <br>

#### Docker Compose Setup for Development

During development, [`docker-compose.override.yml`](./docker-compose.override.yml) is used, which builds the source code and runs the app with `spring-boot:run`, allowing hot swaps without having to rebuild the container.

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
* Start the environment in development mode. Every time you want to run the app in development, you won't need to compile the jar. Simply run the following command:
```git
docker-compose up
```

<br>

#### Docker Compose Setup for Production

* `docker-compose.yml` is ready for production. It uses a Dockerfile that builds the image with the compiled JAR.

* Compile the jar
```git
./mvnw clean package -DskipTests
or
mvn clean package -DskipTests (If you have Maven installed globally)
```
* Start the environment in production mode
```git
docker-compose -f docker-compose.yml up --build
```
