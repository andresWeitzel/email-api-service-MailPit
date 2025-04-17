### Configuration and Execution
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
* Once Docker is running, you can build and deploy the containers

#### Docker Compose setup para Desarrollo

Durante el desarrollo se utiliza [`docker-compose.override.yml`](./docker-compose.override.yml), el cual monta el código fuente y ejecuta la app con `spring-boot:run`, permitiendo cambios en caliente sin necesidad de reconstruir el contenedor.

> 🟡 **Nota**: En el primer uso, es necesario compilar el proyecto al menos una vez para que Maven descargue todas las dependencias.

* Compilar el jar una vez para descargar dependencias
```git
./mvnw clean package -DskipTests
```
* Levantar el entorno en modo desarrollo, cada vez que se quiera ejecutar la app en desarrollo no sera necesario la compilacion del jar, simplemente ejecutar el siguiente comando
```git
docker-compose up
```

#### Docker Compose setup para Produccion

* `docker-compose.yml` está preparado para producción. Usa un Dockerfile que construye la imagen con el JAR compilado.

* Compilar el jar
```git
./mvnw clean package -DskipTests
```
* Levantar el entorno en modo producción
```git
docker-compose -f docker-compose.yml up --build
```

