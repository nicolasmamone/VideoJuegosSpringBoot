# Catálogo de videojuegos - Aplicación web java desarrollada utilizando Spring Boot 
### Descripción
El proyecto consiste en una aplicación web de Catálogo de videojuegos que nos permite ver y buscar videojuegos. Realizado con:
 - Spring MVC, THYMELEAF, BOOTSTRAP para gestionar la presentación y las páginas.
 - JPA, SPRING DATA, MariaDB(Base de datos relacional) para acceder a los datos y gestionarlos.
Es un proyecto monolítico con una arquitectura de tres capas MVC.
### Dependencias
(Son características que nos van a facilitar el desarrollo y que vamos a utilizar durante la construcción de una aplicación)
- SPRING 2.7.12 / JAVA 17
- Gestor de dependencias MAVEN
- SPRING WEB: nos brinda soporte para crear servicio web y crear controladores
- THYMELEAF: Framework para poder crear páginas HTML dinámicas.
- SPRING DATA JPA: es la librería de spring para poder interactuar con una base de datos sql de manera más sencilla
- H2: para crear una base de datos en memoria.
- DEVTOOLS: conjunto de facilidades para acelerar el desarrollo de estas aplicaciones 
- MySQL Connector Java
### Instalación de la Base de Datos
Utilizamos XAMPP para instalar la base de datos (MariaDB) y una herramienta de administración web de la base de datos (PhpMyAdmin).
- Visitamos el sitio de XAMPP en https://www.apachefriends.org, descargamos el instalador y lo ejecutamos.
- Creamos una base "videojuegos", y un usuario que pueda acceder a esa base.    
    - Abrimos PhpMyAdmin, vamos a Cuentas de Usuario > Agregar cuenta de usuario y complementamos los datos (nos aseguramos de tildar la opción "Crear base de datos con el mismo nombre y otorgar todos los privilegios").         
        - USUARIO: videojuegos        
        - CONTRASEÑA: videojuegos
- Configuración del DataSource en Spring    
    - En el archivo application.properties tenemos que configurar el acceso a la base de datos, para que Spring nos deje disponible una conexión lista para usar. El lugar de donde salen estas conexiones se los conoce como DataSource:    
    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/videojuegos?serverTimezone=GMT-3
    spring.datasource.username=videojuegos
    spring.datasource.password=videojuegos
    ```
- Nos queda o ejecutar en el IDE el archivo "schema-mariadb.sql" dentro de la carpeta resources de nuestro proyecto, o copiar el código dentro de este archivo y ejecutar las sentencias Sql en el administrador web de base de datos PhpMyadmin, para generar las tablas, campos y registros.
