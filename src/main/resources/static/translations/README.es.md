<div align="center">
  <img src="../img/email-project.png" alt="Servicio de API de Email">
</div>

<div align="right">
    <img width="20" height="20" src="../icons/backend/java/png/log-four-j.png" />
    <img width="20" height="20" src="../icons/devops/png/docker.png" />
    <img width="20" height="20" src="../icons/database/png/postgres.png" />
    <img width="24" height="24" src="../icons/backend/java/png/java.png" />
    <img width="20" height="20" src="../icons/devops/png/maven.png" />
    <img width="22" height="22" src="../icons/devops/png/postman.png" />
    <img width="22" height="22" src="../icons/devops/png/git.png" />
    <img width="20" height="20" src="../icons/devops/png/prometheus.png" />
    <img width="22" height="22" src="../icons/devops/png/grafana.png" />   
    <img width="20" height="20" src="../icons/backend/java/png/junit.png" />
    <img width="20" height="20" src="../icons/devops/png/swagger.png" />
    <img width="20" height="20" src="../icons/backend/java/png/spring-boot.png" />
</div>

<br>

<br>

<div align="right">
  <a href="./README.es.md" target="_blank">
    <img src="../img/arg-flag.jpg" width="65" height="40" alt="Español" />
  </a>
  <a href="../../../../../README.md" target="_blank">
    <img src="../img/eeuu-flag.jpg" width="65" height="40" alt="English" />
  </a>
</div>

<br>

<div align="center">

# API de Gestión de Usuarios con Email ![(status-completed)](../icons/badges/status-completed.svg)

</div>


API REST integral desarrollada con Spring Boot para gestionar usuarios y enviar notificaciones por email utilizando Mailpit como servidor SMTP. Se integra perfectamente con PostgreSQL para el almacenamiento de datos, e incluye características para registro de auditoría, monitoreo con Prometheus, dashboards de Grafana y documentación automática de API con Swagger/OpenAPI.

* [Lista de reproducción de pruebas funcionales](https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C) <a href="https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C" target="_blank"> <img src="../icons/social-networks/yt.png" width="25" /></a>


## Secciones

<details>
<summary>1. Características</summary>

<br>

* Gestión de Usuarios: Operaciones CRUD completas para la gestión de usuarios
* Notificaciones por Email: Envío automático de emails para eventos de usuarios
* Registro de Auditoría: Seguimiento integral de todas las acciones del sistema
* Monitoreo: Métricas en tiempo real y verificaciones de salud
* Documentación de API: Interfaz Swagger interactiva para exploración de API
* Containerización: Despliegue fácil con Docker
* Integración de Base de Datos: Integración robusta con PostgreSQL
* Visualización de Métricas: Dashboards de Grafana para monitoreo del sistema

</details>


<details>
<summary>2. Requisitos</summary>

<br>

* Java 17 o superior
* Docker y Docker Compose
* Maven para construir el proyecto
* PostgreSQL (si se ejecuta sin Docker)
* Mailpit (si se ejecuta sin Docker)

</details>

<details>
<summary>3. Tecnologías y Dependencias</summary>

<br>

* Spring Boot: Framework principal para construir aplicaciones Java
* Spring Boot Starter Web: Para crear aplicaciones web RESTful
* Spring Boot Starter Mail: Para manejar emails
* Spring Boot Starter Data JPA: Para operaciones de base de datos
* Spring Boot Starter Actuator: Para monitoreo y métricas
* PostgreSQL: Base de datos para persistencia de datos
* Mailpit: Servidor SMTP para pruebas locales de email
* Docker & Docker Compose: Para containerización y orquestación
* Prometheus: Para recolección de métricas
* Grafana: Para visualización de métricas
* Swagger/OpenAPI: Para documentación de API
* Lombok: Para reducir código repetitivo
* JUnit: Para pruebas unitarias

</details>

<details>
<summary>4. Configuración y Ejecución</summary>

<br>

#### [Watch Functional test playlist](https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C)

  <a href="https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C">
    <img src="./src/main/resources/static/img/email-project_yt.png" />
  </a> 

<br>

### Clonar Repositorio
```git
git clone https://github.com/andresWeitzel/email-api-service-MailPit
cd email-api-service-MailPit
```

### Configuración de Docker Compose para Desarrollo

* Antes de construir y ejecutar los contenedores, asegúrate de tener Docker ejecutándose (para Windows, usa [Docker Desktop](https://www.docker.com/products/docker-desktop/))
* Una vez instalado, asegúrate de que Docker esté ejecutándose
```git
docker --version
```
`Importante`: Verifica que ningún otro servicio (ej:postgres) esté ejecutándose como daemon en el sistema, de lo contrario ocurrirá un problema de conexión en el puerto.

* Una vez que Docker esté ejecutándose, puedes construir y desplegar los contenedores con docker compose (Este comando solo se necesita una vez para construir).
* Se creará el contenedor para Mailpit y Postgres. 
```git
docker-compose up --build
```

* Después de crear los contenedores con Docker Compose, cada vez que vamos a iniciar los contenedores usaremos el siguiente comando, de lo contrario lo ejecutaremos desde Docker Desktop. Inicia el entorno en modo desarrollo. Cada vez que quieras ejecutar la aplicación en desarrollo, no necesitarás compilar el jar. Simplemente ejecuta el siguiente comando:
```git
docker-compose up
```
* Otra opción es lanzar los contenedores desde Docker Desktop.
* Ejecuta la aplicación
```git
mvn spring-boot:run
```

</details>

<details>
<summary>5. Estructura del Proyecto</summary>

<br>

```
email-api-service-MailPit/
├── src/
│   ├── main/
│   │   ├── java/com/microservice/
│   │   │   ├── config/           # Clases de configuración
│   │   │   ├── controller/       # Controladores REST
│   │   │   ├── dto/             # Objetos de Transferencia de Datos
│   │   │   ├── exception/       # Manejadores de excepciones
│   │   │   ├── model/           # Modelos de entidades
│   │   │   ├── repository/      # Capa de acceso a datos
│   │   │   ├── service/         # Lógica de negocio
│   │   │   └── EmailApiMailpitApplication.java
│   │   └── resources/
│   │       ├── application.yml  # Configuración de la aplicación
│   │       └── static/          # Recursos estáticos
│   └── test/                    # Clases de prueba
├── docker-compose.yml           # Orquestación de Docker
├── Dockerfile                   # Contenedor de la aplicación
├── pom.xml                      # Dependencias de Maven
└── README.md                    # Documentación del proyecto
```

### Componentes Principales

* **Controllers**: Manejan solicitudes y respuestas HTTP
* **Services**: Implementan la lógica de negocio
* **Repositories**: Capa de acceso a datos
* **DTOs**: Objetos de transferencia de datos para comunicación de API
* **Models**: Entidades JPA para mapeo de base de datos
* **Config**: Clases de configuración de la aplicación
* **Exceptions**: Manejo personalizado de excepciones

</details>

<details>
<summary>6. Flujo de Procesamiento</summary>

<br>

1. **Gestión de Usuarios**: 
   * Operaciones de crear, leer, actualizar y eliminar usuarios
   * Notificaciones por email enviadas automáticamente para eventos de usuarios
   * Registro de auditoría para todas las acciones relacionadas con usuarios

2. **Procesamiento de Email**:
   * Integración del servicio de email con el servidor SMTP de Mailpit
   * Generación de emails basada en plantillas
   * Seguimiento del estado de entrega de emails

3. **Registro de Auditoría**:
   * Seguimiento integral de todas las acciones del sistema
   * Capacidades de filtrado por entidad, acción, nombre de usuario y detalles
   * Retención de datos históricos

4. **Monitoreo y Observabilidad**:
   * Verificaciones de salud en tiempo real a través de Spring Boot Actuator
   * Recolección de métricas con Prometheus
   * Visualización de dashboard con Grafana

</details>

<details>
<summary>7. Ejemplos de API</summary>

<br>

#### [Watch Functional test playlist](https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C)

  <a href="https://www.youtube.com/playlist?list=PLCl11UFjHurDSHfBJ-uQp55RG-xhL162C">
    <img src="./src/main/resources/static/img/email-project_yt.png" />
  </a> 

<br>

### Ejemplos de Gestión de Usuarios

#### Crear Usuario
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez",
    "email": "juan.perez@ejemplo.com"
  }'
```

**Campos Requeridos:**
- `name`: String (obligatorio) - El nombre del usuario
- `email`: String (obligatorio) - Formato de email válido

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "id": 1,
  "name": "Juan Pérez",
  "email": "juan.perez@ejemplo.com"
}
```

**Respuestas de Error:**

**Error de Validación (400):**
```json
{
  "errors": {
    "name": "El nombre es obligatorio"
  },
  "timestamp": "2025-07-14T17:21:59.3410006",
  "status": 400
}
```

**Formato de Email Inválido (400):**
```json
{
  "errors": {
    "email": "El email es inválido"
  },
  "timestamp": "2025-07-14T17:21:59.3410006",
  "status": 400
}
```

**Error de Email Duplicado (400):**
```json
{
  "errors": "El email ya está en uso: El email juan.perez@ejemplotest.com ya existe.",
  "timestamp": "2025-07-14T17:30:37.1875171",
  "status": 400
}
```

**📧 Email de Mailpit (después de la creación exitosa):**
```
From: noreply@email-api-service.com
To: juan.perez@ejemplo.com
Subject: Notificación de Registro de Cuenta

Hola Juan Pérez,

¡Gracias por registrarte con nosotros!
```

<br>

#### Obtener Todos los Usuarios
```bash
curl -X GET http://localhost:8080/api/v1/users
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "content": [
    {
      "id": 1,
      "name": "Juan Pérez",
      "email": "juan.perez@ejemplo.com"
    },
    {
      "id": 2,
      "name": "María García",
      "email": "maria.garcia@ejemplo.com"
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 30,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 2,
  "totalPages": 1,
  "last": true,
  "size": 30,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```

<br>

#### Actualizar Usuario
```bash
curl -X PUT http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez Actualizado",
    "email": "juan.actualizado@ejemplo.com"
  }'
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "id": 1,
  "name": "Juan Pérez Actualizado",
  "email": "juan.actualizado@ejemplo.com"
}
```

**Respuestas de Error:**

**Usuario No Encontrado (404):**
```json
{
  "errors": "Usuario no encontrado con id: 999",
  "timestamp": "2025-07-14T17:45:12.9876543",
  "status": 404
}
```

**Error de Validación (400):**
```json
{
  "errors": {
    "email": "El email es inválido"
  },
  "timestamp": "2025-07-14T17:45:12.9876543",
  "status": 400
}
```

**📧 Email de Mailpit (después de la actualización exitosa):**
```
From: noreply@email-api-service.com
To: juan.actualizado@ejemplo.com
Subject: Notificación de Actualización de Cuenta

Hola Juan Pérez Actualizado,

Tu cuenta ha sido actualizada exitosamente.
```

<br>

#### Eliminar Usuario
```bash
curl -X DELETE http://localhost:8080/api/v1/users/1
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "id": 1,
  "name": "Juan Pérez",
  "email": "juan.perez@ejemplo.com"
}
```

**Respuesta de Error:**

**Usuario No Encontrado (404):**
```json
{
  "errors": "Usuario no encontrado con id: 999",
  "timestamp": "2025-07-14T17:50:25.1234567",
  "status": 404
}
```

**📧 Email de Mailpit (después de la eliminación exitosa):**
```
From: noreply@email-api-service.com
To: juan.perez@ejemplo.com
Subject: Notificación de Eliminación de Cuenta

Hola Juan Pérez,

Tu cuenta ha sido eliminada exitosamente.
```

<br>

#### Obtener Usuario por ID
```bash
curl -X GET http://localhost:8080/api/v1/users/1
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "id": 1,
  "name": "Juan Pérez",
  "email": "juan.perez@ejemplo.com",
  "createdAt": "2025-07-14T17:30:37.1875171",
  "updatedAt": "2025-07-14T17:30:37.1875171"
}
```

**Respuesta de Error:**

**Usuario No Encontrado (404):**
```json
{
  "errors": "Usuario no encontrado con id: 999",
  "timestamp": "2025-07-14T17:50:25.1234567",
  "status": 404
}
```

<br>

### Ejemplos de Registro de Auditoría

#### Crear Registro de Auditoría
```bash
curl -X POST http://localhost:8080/api/v1/audit-log \
  -H "Content-Type: application/json" \
  -d '{
    "entity": "Usuario",
    "action": "CREAR",
    "username": "usuario_admin",
    "details": "Creada nueva cuenta de usuario con email juan.perez@ejemplo.com"
  }'
```

**Campos del Registro de Auditoría:**
- `entity`: String - La entidad siendo auditada (ej: "Usuario")
- `action`: String - La acción realizada (ej: "CREAR", "ACTUALIZAR", "ELIMINAR")
- `username`: String - El nombre de usuario de la persona realizando la acción
- `details`: String - Descripción detallada de la acción
- `timestamp`: LocalDateTime (opcional) - Cuándo ocurrió la acción

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "message": "Registro de auditoría creado exitosamente"
}
```

<br>

#### Actualizar Registro de Auditoría
```bash
curl -X PUT http://localhost:8080/api/v1/audit-log/1 \
  -H "Content-Type: application/json" \
  -d '{
    "entity": "Usuario",
    "action": "ACTUALIZAR",
    "username": "usuario_admin",
    "details": "Información de cuenta de usuario actualizada"
  }'
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200):**
```json
{
  "id": 1,
  "entity": "Usuario",
  "action": "ACTUALIZAR",
  "username": "usuario_admin",
  "details": "Información de cuenta de usuario actualizada",
  "timestamp": "2025-07-14T17:55:42.6543210"
}
```

**Respuesta de Error:**

**Registro de Auditoría No Encontrado (404):**
```json
{
  "errors": "Registro de auditoría no encontrado con id: 999",
  "timestamp": "2025-07-14T17:55:42.6543210",
  "status": 404
}
```

<br>

#### Filtrar Registros de Auditoría
```bash
# Filtrar por entidad
curl -X GET "http://localhost:8080/api/v1/audit-log/entity?entity=Usuario"

# Filtrar por acción
curl -X GET "http://localhost:8080/api/v1/audit-log/action?action=CREAR"

# Filtrar por nombre de usuario
curl -X GET "http://localhost:8080/api/v1/audit-log/username?username=usuario_admin"

# Filtrar por detalles
curl -X GET "http://localhost:8080/api/v1/audit-log/details?details=Creada+nueva+cuenta"
```

**Ejemplos de Respuesta:**

**Respuesta Exitosa (200) - Resultados Filtrados:**
```json
{
  "content": [
    {
      "id": 1,
      "entity": "Usuario",
      "action": "CREAR",
      "username": "usuario_admin",
      "details": "Creada nueva cuenta de usuario con email juan.perez@ejemplo.com",
      "timestamp": "2025-07-14T17:30:37.1875171"
    },
    {
      "id": 3,
      "entity": "Usuario",
      "action": "CREAR",
      "username": "usuario_admin",
      "details": "Creada nueva cuenta de usuario con email maria.garcia@ejemplo.com",
      "timestamp": "2025-07-14T17:35:22.1234567"
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 30,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 2,
  "totalPages": 1,
  "last": true,
  "size": 30,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```

**Respuesta de Resultados Vacíos (200):**
```json
{
  "content": [],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 30,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 0,
  "totalPages": 0,
  "last": true,
  "size": 30,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 0,
  "first": true,
  "empty": true
}
```

<br>

### Códigos de Estado HTTP

**Códigos de Estado de Respuesta Comunes:**

- **200 OK**: Solicitud exitosa
- **201 Created**: Recurso creado exitosamente
- **400 Bad Request**: Error de validación o datos inválidos
- **404 Not Found**: Recurso no encontrado
- **409 Conflict**: Conflicto de recurso (ej: email duplicado)
- **500 Internal Server Error**: Error del servidor

<br>

### Guía de Pruebas Paso a Paso

**1. Iniciar la Aplicación:**
```bash
docker-compose up
```

**2. Crear un Usuario:**
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez",
    "email": "juan.perez@ejemplo.com"
  }'
```

**3. Verificar Mailpit para Email:**
- Abre http://localhost:8025 en tu navegador
- Deberías ver un email de bienvenida enviado a juan.perez@ejemplo.com

**4. Obtener Todos los Usuarios:**
```bash
curl -X GET http://localhost:8080/api/v1/users
```

**5. Actualizar el Usuario:**
```bash
curl -X PUT http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez Actualizado",
    "email": "juan.actualizado@ejemplo.com"
  }'
```

**6. Verificar Mailpit Nuevamente:**
- Actualiza http://localhost:8025
- Deberías ver un email de notificación de actualización

**7. Eliminar el Usuario:**
```bash
curl -X DELETE http://localhost:8080/api/v1/users/1
```

**8. Verificación Final de Mailpit:**
- Verifica http://localhost:8025 una vez más
- Deberías ver un email de confirmación de eliminación

<br>

### Escenarios de Error Comunes

**Prueba estos para testear el manejo de errores:**

**1. Crear Usuario con Nombre Faltante:**
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "email": "juan.perez@ejemplo.com"
  }'
```
**Respuesta Esperada:**
```json
{
  "errors": {
    "name": "El nombre es obligatorio"
  },
  "timestamp": "2025-07-14T17:21:59.3410006",
  "status": 400
}
```

**2. Crear Usuario con Email Inválido:**
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez",
    "email": "email-invalido"
  }'
```
**Respuesta Esperada:**
```json
{
  "errors": {
    "email": "El email es inválido"
  },
  "timestamp": "2025-07-14T17:21:59.3410006",
  "status": 400
}
```

**3. Crear Usuario con Email Duplicado:**
```bash
# Primero, crear un usuario
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez",
    "email": "juan.perez@ejemplo.com"
  }'

# Luego intentar crear otro usuario con el mismo email
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "María García",
    "email": "juan.perez@ejemplo.com"
  }'
```
**Respuesta Esperada:**
```json
{
  "errors": "El email ya está en uso: El email juan.perez@ejemplo.com ya existe.",
  "timestamp": "2025-07-14T17:30:37.1875171",
  "status": 400
}
```

**📧 Email de Mailpit (NO se envía email para error de email duplicado):**
```
No se enviará email a Mailpit cuando hay un error de email duplicado.
La creación del usuario falla antes de que se llame al servicio de email.
```

**4. Obtener Usuario Inexistente:**
```bash
curl -X GET http://localhost:8080/api/v1/users/999
```
**Respuesta Esperada:**
```json
{
  "errors": "Usuario no encontrado con id: 999",
  "timestamp": "2025-07-14T17:50:25.1234567",
  "status": 404
}
```

**📧 Email de Mailpit (NO se envía email para error de no encontrado):**
```
No se enviará email a Mailpit cuando hay un error de "no encontrado".
La operación falla antes de que se llame al servicio de email.
```

### 📧 Resumen de Notificaciones por Email

**Los emails se envían a Mailpit SOLO para operaciones exitosas:**

✅ **CREAR Usuario** → Email de bienvenida enviado
✅ **ACTUALIZAR Usuario** → Email de notificación de actualización enviado  
✅ **ELIMINAR Usuario** → Email de confirmación de eliminación enviado
❌ **Errores de Validación** → No se envía email
❌ **Email Duplicado** → No se envía email
❌ **Usuario No Encontrado** → No se envía email

<br>

### Pruebas de Endpoints de Servicios Dockerizados

- **API de Registro de Auditoría**

  - `POST /api/v1/audit-log`  
  ➡️ [http://localhost:8080/api/v1/audit-log](http://localhost:8080/api/v1/audit-log)

  - `PUT /api/v1/audit-log/{id}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/{id}](http://localhost:8080/api/v1/audit-log/1)
  
  - `DELETE /api/v1/audit-log/{id}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/{id}](http://localhost:8080/api/v1/audit-log/1)
  
  - `GET /api/v1/audit-log`  
    ➡️ [http://localhost:8080/api/v1/audit-log](http://localhost:8080/api/v1/audit-log)
  
  - `GET /api/v1/audit-log/entity?entity={entityName}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/entity?entity=Usuario](http://localhost:8080/api/v1/audit-log/entity?entity=Usuario)
  
  - `GET /api/v1/audit-log/action?action={actionType}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/action?action=CREAR](http://localhost:8080/api/v1/audit-log/action?action=CREAR)
  
  - `GET /api/v1/audit-log/username?username={username}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/username?username=admin](http://localhost:8080/api/v1/audit-log/username?username=admin)
  
  - `GET /api/v1/audit-log/details?details={details}`  
    ➡️ [http://localhost:8080/api/v1/audit-log/details?details=Creada+nueva+cuenta](http://localhost:8080/api/v1/audit-log/details?details=Creada+nueva+cuenta)

- **API de Usuarios**
  
  - `POST /api/v1/users`  
    ➡️ [http://localhost:8080/api/v1/users](http://localhost:8080/api/v1/users)
  
  - `PUT /api/v1/users/{id}`  
    ➡️ [http://localhost:8080/api/v1/users/{id}](http://localhost:8080/api/v1/users/1)
  
  - `DELETE /api/v1/users/{id}`  
    ➡️ [http://localhost:8080/api/v1/users/{id}](http://localhost:8080/api/v1/users/1)
  
  - `GET /api/v1/users/{id}`  
    ➡️ [http://localhost:8080/api/v1/users/{id}](http://localhost:8080/api/v1/users/1)
  
  - `GET /api/v1/users`  
    ➡️ [http://localhost:8080/api/v1/users](http://localhost:8080/api/v1/users)

- **Swagger UI:**
  - `GET /swagger-ui/index.html`  
    ➡️ [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

  - `GET /v3/api-docs` – Documentación OpenAPI  
    ➡️ [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

- **Endpoints de Actuator:**
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

- **MailPit:**
  - `Interfaz Web`  
    ➡️ [http://localhost:8025](http://localhost:8025)
  
  - `Servidor SMTP` 
    ➡️ `smtp://localhost:1025`

- **Prometheus:**
  - `Interfaz Web`
    ➡️ [http://localhost:9090](http://localhost:9090)

- **Grafana:**
  - `Interfaz Web` 
    ➡️ [http://localhost:3000](http://localhost:3000)  
    🧾 Credenciales por defecto:
    - Usuario: `admin`
    - Contraseña: `admin`

- **PostgreSQL:**
  - `URL JDBC`  
    ➡️ `jdbc:postgresql://localhost:5432/mydatabase`  
    *  Usuario: `user`  
    *  Contraseña: `password`

### Ejemplos de Emails de Mailpit

**Cuando accedas a Mailpit en http://localhost:8025, verás emails como estos:**

#### Email de Creación de Usuario
```
From: noreply@email-api-service.com
To: juan.perez@ejemplo.com
Subject: ¡Bienvenido a Nuestro Servicio!

Estimado Juan Pérez,

¡Bienvenido a nuestro servicio! Tu cuenta ha sido creada exitosamente.

Detalles de la Cuenta:
- Nombre: Juan Pérez
- Email: juan.perez@ejemplo.com
- ID de Cuenta: 1

¡Gracias por unirte a nosotros!

Saludos cordiales,
El Equipo del Servicio de API de Email
```

#### Email de Actualización de Usuario
```
From: noreply@email-api-service.com
To: juan.actualizado@ejemplo.com
Subject: Tu Cuenta Ha Sido Actualizada

Estimado Juan Pérez Actualizado,

La información de tu cuenta ha sido actualizada exitosamente.

Detalles Actualizados:
- Nombre: Juan Pérez Actualizado
- Email: juan.actualizado@ejemplo.com
- ID de Cuenta: 1

Si no solicitaste este cambio, por favor contacta soporte inmediatamente.

Saludos cordiales,
El Equipo del Servicio de API de Email
```

#### Email de Eliminación de Usuario
```
From: noreply@email-api-service.com
To: juan.perez@ejemplo.com
Subject: Confirmación de Eliminación de Cuenta

Estimado Juan Pérez,

Tu cuenta ha sido eliminada exitosamente de nuestro sistema.

Detalles de la Cuenta:
- Nombre: Juan Pérez
- Email: juan.perez@ejemplo.com
- ID de Cuenta: 1

Todos tus datos han sido removidos permanentemente.

Saludos cordiales,
El Equipo del Servicio de API de Email
```

**Características de Mailpit:**
- **Vista Previa de Email**: Ver versiones HTML y texto de emails
- **Detalles de Email**: Ver headers, adjuntos y metadatos
- **Búsqueda**: Filtrar emails por remitente, destinatario o contenido
- **Exportar**: Descargar emails para propósitos de prueba
- **Tiempo Real**: Los emails aparecen instantáneamente cuando son enviados por la API

</details>

<details>
<summary>8. Validaciones Implementadas</summary>

<br>

* **Validación de Datos de Usuario**:
  * Validación de formato de email
  * Verificación de unicidad de nombre de usuario
  * Validación de campos requeridos
  * Restricciones de integridad de datos

* **Validación de Email**:
  * Conectividad del servidor SMTP
  * Verificación de formato de email
  * Seguimiento del estado de entrega

* **Validación de Base de Datos**:
  * Verificaciones de salud de conexión
  * Rollback de transacciones en errores
  * Validación de consistencia de datos

* **Validación de API**:
  * Validación de payload de solicitud
  * Manejo de códigos de estado HTTP
  * Formateo de respuestas de error

</details>

<details>
<summary>9. Monitoreo y Reportes</summary>

<br>

El sistema proporciona capacidades integrales de monitoreo y reportes:

* **Verificaciones de Salud**: Monitoreo de salud de la aplicación a través de Spring Boot Actuator
* **Recolección de Métricas**: Métricas de Prometheus para monitoreo de rendimiento
* **Visualización de Dashboard**: Dashboards de Grafana para monitoreo del sistema
* **Reportes de Auditoría**: Rastro de auditoría integral para cumplimiento
* **Reportes de Entrega de Email**: Estado de envío de email y seguimiento de entrega

</details>


<details>
<summary>10. Contribuir</summary>

<br>

1. Haz fork del proyecto
2. Crea tu rama de características (`git checkout -b feature/CaracteristicaIncreible`)
3. Haz commit de tus cambios (`git commit -m 'Agregar alguna Característica Increíble'`)
4. Haz push a la rama (`git push origin feature/CaracteristicaIncreible`)
5. Abre un Pull Request

</details>

<details>
<summary>11. Licencia</summary>

<br>

Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

</details>




















