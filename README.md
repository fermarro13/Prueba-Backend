# Prueba-Backend

Este proyecto es la resolución a una prueba técnica de backend, la cuál esta enfocada en la construcción de una API que maneja usuarios y platillos.

## Requirements

- Java 17.0.6 o superior
- MySQL 8 o superior
- Maven 3.8.7 o superior

## Install

Descarga o clona el proyecto del siguiente repositorio:

```sh
https://github.com/fermarro13/Prueba-Backend.git
```

Ejecutar el script https://github.com/fermarro13/Prueba-Backend/blob/master/restaurante.sql en una base de datos mySQL.
Luego configurar los datos de conexión en el archivo application.properties, ubicado en el directorio src/main/resources, se deben configurar las siguiente propiedades:

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/{database-name}
spring.datasource.username={username}
spring.datasource.password={password}
```
La aplicación cuenta con dos usuarios por defecto, con las siguientes credenciales:
```sh
user1 pass
user2 123
```

Para ejecutar la aplicación debemos de utilizar el siguiente comando en la carpeta del proyecto:

```sh
mvn spring-boot:run
```

Opcionalmente se puede configurar cualquier IDE con la configuración necesaria para ejecutar proyectos de Spring-boot, tales como IntelliJ, Eclipse, Netbeans, etc.

## Usage

Luego de ejecutar el script de base de datos correspondiente y haber levantado el proyecto, el endpoint para consultar los platillos por usuario puede ser probado utilizando el siguiente comando cURL.

```sh
curl --location --request GET 'http://localhost:8080/meals/?size={pageSize}&page={numPages}' --header 'Authorization: Basic dXNlcjI6MTIz'
```

o el cliente REST de su preferencia.
