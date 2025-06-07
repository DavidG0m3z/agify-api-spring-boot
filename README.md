# agify-api-spring-boot

Esta es una API RESTful desarrollada con [Spring Boot](https://spring.io/projects/spring-boot) que se integra con la [API pública de Agify.io](https://agify.io/). Permite a los usuarios consultar la edad estimada de una persona basándose en su nombre.

## Características

* API RESTful para predicción de edad por nombre.
* Integración robusta con la API de Agify.io utilizando Spring WebFlux para llamadas no bloqueantes.
* Manejo de errores para fallos en la comunicación con Agify.io.

## Tecnologías Utilizadas

* [Java 21](https://www.oracle.com/java/technologies/downloads/)
* [Spring Boot 3.x](https://spring.io/projects/spring-boot)
* [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
* [Project Lombok](https://projectlombok.org/)
* [Apache Maven](https://maven.apache.org/)

## Cómo Ejecutar Localmente

Para levantar y probar la API en tu máquina local:

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/agify-api-spring-boot.git](https://github.com/tu-usuario/agify-api-spring-boot.git)
    ```
    (Asegúrate de reemplazar `tu-usuario` con tu nombre de usuario de GitHub real).

2.  **Navega al directorio del proyecto:**
    ```bash
    cd agify-api-spring-boot
    ```

3.  **Compila y ejecuta la aplicación Spring Boot:**
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará en el puerto 8080 por defecto.

## Endpoints

Una vez que la aplicación esté corriendo, puedes acceder a los siguientes endpoints:

* **`GET /api/age?name=NOMBRE`**: Predice la edad estimada para el nombre proporcionado.

## Cómo Usar con Postman

[Postman](https://www.postman.com/) es una herramienta popular para probar APIs REST. Sigue estos pasos para interactuar con tu API localmente:

1.  **Asegúrate de que tu aplicación Spring Boot esté corriendo** (ver sección "Cómo Ejecutar Localmente" arriba).
2.  **Abre Postman.**

### Realizar una Solicitud GET para Predecir la Edad

1.  En Postman, haz clic en el botón `+` para abrir una nueva pestaña de solicitud.
2.  Selecciona el método **`GET`** del menú desplegable.
3.  En el campo de URL, ingresa la dirección de tu endpoint:
    ```
    http://localhost:8080/api/age
    ```
4.  Debajo del campo de URL, navega a la pestaña **`Params`**.
5.  En la columna `KEY`, ingresa `name`.
6.  En la columna `VALUE`, ingresa el nombre para el que deseas predecir la edad (ej., `David`). Verás que la URL se actualiza automáticamente a `http://localhost:8080/api/age?name=David`.
7.  Haz clic en el botón **`Send`**.

### Ejemplos de Respuestas:

* **Respuesta Exitosa (HTTP 200 OK):**
    ```json
    {
        "name": "David",
        "age": 30,
        "count": 12345
    }
    ```
    (Los valores `age` y `count` variarán según la respuesta de Agify.io).

* **Respuesta si el Nombre no se encuentra o Error del Servidor (HTTP 404 Not Found o 500 Internal Server Error):**
    Dependiendo de cómo configures el manejo de errores en tu `AgifyController` para los casos donde Agify.io no devuelve un resultado o falla, podrías ver:
    * **JSON de error de Spring Boot (ej. si devuelve 404):**
        ```json
        {
            "timestamp": "2024-06-06T15:30:00.000+00:00",
            "status": 404,
            "error": "Not Found",
            "path": "/api/age"
        }
        ```
       
    * **Otras respuestas según tu implementación.**

---
