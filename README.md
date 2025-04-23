## Configuration and Execution (Docker Compose)
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
<br>


### Testing de Endpoints de Servicios Dockerizados

- **Actuator Endpoints:**
  - `GET /actuator`  
    ➡️ [http://localhost:8080/actuator](http://localhost:8080/actuator)

  - `GET /actuator/health`  
    ➡️ [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

  - `GET /actuator/metrics`  
    ➡️ [http://localhost:8080/actuator/metrics](http://localhost:8080/actuator/metrics)

  - `GET /actuator/prometheus`  
    ➡️ [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

  - `GET /actuator/env`  
    ➡️ [http://localhost:8080/actuator/env](http://localhost:8080/actuator/env)


- **Swagger UI:**
  - `GET /swagger-ui.html`  
    ➡️ [[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui/index.html)

  - `GET /v3/api-docs` – Documentación OpenAPI  
    ➡️ [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)



- **MailPit:**

- `Web UI`  
  ➡️ [http://localhost:8025](http://localhost:8025)

- `SMTP Server` 
  ➡️ `smtp://localhost:1025`


- **Prometheus:**

- `UI Web`
  ➡️ [http://localhost:9090](http://localhost:9090)



- **Grafana:**

- `UI Web` 
  ➡️ [http://localhost:3000](http://localhost:3000)  
  🧾 Credenciales por defecto:
  - Usuario: `admin`
  - Contraseña: `admin`



- **PostgreSQL:**

- `JDBC URL`  
  ➡️ `jdbc:postgresql://localhost:5432/mydatabase`  
  *  Usuario: `user`  
  *  Contraseña: `password`




