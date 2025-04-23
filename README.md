### Configuration and Execution (Docker Compose)
* If any of the following steps don't work, watch this [x](x)
* Repository Clone
```git
git clone https://github.com/andresWeitzel/email-api-service-MailPit
cd email-api-service-MailPit
```
<br>

#### Docker Compose Setup for Development

* Before building and running the containers, make sure you have Docker running (for Windows, use [Docker Desktop]([https://nodejs.org/en/download](https://www.docker.com/products/docker-desktop/)))
* Once installed, make sure Docker is running
```git
docker --version
```
`Important`: Check that no other service (ej:postgres) is running as a daemon on the system, otherwise a connection problem will occur on the port.
* Once Docker is running, you can build and deploy the containers with docker compose (This command is only needed once to build).
* The container for Mailpit and Postgres will be created. 
```git
docker-compose up --build
```
* After creating the containers with Docker Compose, each time we are going to start the containers we will use the following command, otherwise we will run it from Docker Desktop. Start the environment in development mode. Every time you want to run the app in development, you won't need to compile the jar. Simply run the following command:
```git
docker-compose up
```



<br>

#### Docker Compose Setup for Production

* Pending

  <br>

### Testing
* The MailPit web interface will be available at `http://localhost:8025`, where you can view sent emails.
* You can test the API using Postman or swagger or any HTTP client by sending request to `http://localhost:8080/api/v1/users` with the following JSON body.
* The Swagger UI web interface will be available at `http://localhost:8080/swagger-ui/index.html`, where you can test all endpoints.

