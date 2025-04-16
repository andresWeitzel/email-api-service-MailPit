# Imagen base de Java 17 (ajustá si usás otra versión)
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR generado por Spring Boot
COPY target/email-api-mailpit-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto del servidor Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
