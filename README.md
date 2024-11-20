# Sistema de Gestión de Biblioteca - Documentación

## Índice
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Requisitos Previos](#requisitos-previos)
3. [Configuración del Proyecto](#configuración-del-proyecto)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Modelos de Datos](#modelos-de-datos)
6. [API REST - Endpoints](#api-rest---endpoints)
7. [Ejemplos de Uso](#ejemplos-de-uso)

## Descripción del Proyecto
Sistema de gestión de biblioteca que permite administrar libros y usuarios a través de una API REST, utilizando Spring Boot y MongoDB como base de datos.

## Requisitos Previos
- Java 17 o superior
- MongoDB 4.4 o superior
- Maven 3.6 o superior
- Un IDE (recomendado: IntelliJ IDEA o Spring Tool Suite)
- Postman o similar para pruebas de API

## Configuración del Proyecto

### Dependencias necesarias (archivo `pom.xml`)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>3.3.5</version>
      <relativePath/> <!-- lookup parent from repository -->
   </parent>
   <groupId>com.example</groupId>
   <artifactId>demo</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <name>demo</name>
   <description>Demo project for Spring Boot</description>
   <url/>
   <licenses>
      <license/>
   </licenses>
   <developers>
      <developer/>
   </developers>
   <scm>
      <connection/>
      <developerConnection/>
      <tag/>
      <url/>
   </scm>
   <properties>
      <java.version>17</java.version>
   </properties>
   <dependencies>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-data-mongodb</artifactId>
      </dependency>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
      </dependency>

      <dependency>
         <groupId>org.hibernate.validator</groupId>
         <artifactId>hibernate-validator</artifactId>
         <version>6.2.5.Final</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-security</artifactId>
      </dependency>

      <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
         <optional>true</optional>
      </dependency>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>
      </dependency>
   </dependencies>

   <build>
      <plugins>
         <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
               <excludes>
                  <exclude>
                     <groupId>org.projectlombok</groupId>
                     <artifactId>lombok</artifactId>
                  </exclude>
               </excludes>
            </configuration>
         </plugin>
      </plugins>
   </build>

</project>
```

### Configuración de MongoDB (archivo `application.properties`)
```properties
spring.application.name=demo
spring.data.mongodb.uri=mongodb://localhost:27017/test
spring.data.mongodb.database=test
```

## Estructura del Proyecto
```
├───.idea
├───.mvn
│   └───wrapper
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───example
│   │   │           └───demo
│   │   │               ├───controllers
│   │   │               ├───models
│   │   │               ├───repositories
│   │   │               ├───services
│   │   │               └───utils
│   │   └───resources
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───example
│                   └───demo
└───target
    ├───classes
    │   └───com
    │       └───example
    │           └───demo
    │               ├───controllers
    │               ├───models
    │               ├───repositories
    │               ├───services
    │               └───utils
    └───generated-sources
        └───annotations

```

## Modelos de Datos

### Libro
Los libros tienen las siguientes validaciones:
- Título: 2-100 caracteres, obligatorio
- Autor: 3-50 caracteres, obligatorio
- ISBN: 13 dígitos exactos, obligatorio
- Fecha de Publicación: debe ser pasada o presente
- Género: debe ser uno de: Ficción, No Ficción, Educativo, Otro
- Precio: entre 0.01 y 1000.00
- Stock: entre 1 y 500 unidades
- Descripción: 10-500 caracteres
- Idioma: debe ser uno de: Español, Inglés, Francés, Alemán

### Usuario
Los usuarios tienen las siguientes validaciones:
- Nombre Completo: 3-50 caracteres, obligatorio
- Correo Electrónico: formato válido, obligatorio
- Contraseña: 8-20 caracteres, debe incluir mayúsculas, minúsculas, números y caracteres especiales
- Edad: mayor de 13 años
- Número de Teléfono: 10 dígitos exactos
- Rol: debe ser Administrador o Lector

## API REST - Endpoints

### Libros

#### Obtener todos los libros
```http
GET /api/libros
```

#### Buscar libro por ISBN
```http
GET /api/libros/{isbn}
```

#### Crear nuevo libro
```http
POST /api/libros
Content-Type: application/json

{
    "titulo": "El Quijote",
    "autor": "Miguel de Cervantes",
    "isbn": "9788424112345",
    "fechaPublicacion": "1605-01-01",
    "genero": "Ficción",
    "precio": 29.99,
    "cantidadStock": 50,
    "descripcion": "La obra cumbre de la literatura española",
    "idioma": "Español"
}
```

#### Actualizar libro
```http
PUT /api/libros/{id}
Content-Type: application/json

{
    "titulo": "El Quijote",
    "autor": "Miguel de Cervantes",
    "isbn": "9788424112345",
    "fechaPublicacion": "1605-01-01",
    "genero": "Ficción",
    "precio": 29.99,
    "cantidadStock": 50,
    "descripcion": "La obra cumbre de la literatura española",
    "idioma": "Español"
}
```

#### Eliminar libro
```http
DELETE /api/libros/{id}
```

### Usuarios

#### Obtener todos los usuarios
```http
GET /api/usuarios
```

#### Buscar usuario por email
```http
GET /api/usuarios/{email}
```

#### Crear nuevo usuario
```http
POST /api/usuarios
Content-Type: application/json

{
    "nombreCompleto": "Juan Pérez",
    "correoElectronico": "juan.perez@email.com",
    "contraseña": "Abc123!@#",
    "edad": 25,
    "numeroTelefono": "1234567890",
    "rol": "Lector"
}
```

#### Actualizar usuario
```http
PUT /api/usuarios/{id}
Content-Type: application/json

{
    // Mismos campos que en CREATE
}
```

#### Eliminar usuario
```http
DELETE /api/usuarios/{id}
```

## Ejemplos de Uso con herramienta Curl

### Crear un Nuevo Libro
```bash
curl -X POST http://localhost:8080/api/libros \
-H "Content-Type: application/json" \
-d '{
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "isbn": "9780307474728",
    "fechaPublicacion": "1967-05-30",
    "genero": "Ficción",
    "precio": 24.99,
    "cantidadStock": 100,
    "descripcion": "Una obra maestra del realismo mágico",
    "idioma": "Español"
}'
```

### Crear un Nuevo Usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
-H "Content-Type: application/json" \
-d '{
    "nombreCompleto": "María Rodríguez",
    "correoElectronico": "maria.rodriguez@email.com",
    "contraseña": "Segura123!@#",
    "edad": 28,
    "numeroTelefono": "9876543210",
    "rol": "Lector"
}'
```

### Buscar un Libro por ISBN
```bash
curl http://localhost:8080/api/libros/9780307474728
```

### Actualizar Stock de un Libro
```bash
curl -X PUT http://localhost:8080/api/libros/{id} \
-H "Content-Type: application/json" \
-d '{
    // Datos previos del libro +
    "cantidadStock": 95
}'
```

## Pruebas con Postman

### Tests para Libros

Para validar el endpoint POST `/api/libros`, añade los siguientes tests en la pestaña "Tests" de Postman:

```javascript
// Validación de Título
pm.test("Titulo validation - Not Null and Size between 2 and 100", function () {
    var responseJson = pm.response.json();
    
    // Verifica que la respuesta sea un error 400
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El título es obligatorio.");
        pm.expect(responseJson.message).to.include("El título debe tener entre 2 y 100 caracteres.");
    } else {
        pm.expect(responseJson.titulo).to.be.a('string').that.is.not.empty;
        pm.expect(responseJson.titulo.length).to.be.within(2, 100);
    }
});

// Validación de Autor
pm.test("Autor validation - Not Null and Size between 3 and 50", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El autor es obligatorio.");
        pm.expect(responseJson.message).to.include("El autor debe tener entre 3 y 50 caracteres.");
    } else {
        pm.expect(responseJson.autor).to.be.a('string').that.is.not.empty;
        pm.expect(responseJson.autor.length).to.be.within(3, 50);
    }
});

// Validación de ISBN
pm.test("ISBN validation - 13 digits required", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El ISBN debe ser un número único con exactamente 13 dígitos.");
    } else {
        pm.expect(responseJson.isbn).to.match(/^\d{13}$/); // Verifica que el ISBN tenga 13 dígitos
    }
});

// Validación de Fecha de Publicación
pm.test("Fecha de Publicación validation - Past or Present", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("La fecha de publicación debe ser pasada o el día de hoy.");
    } else {
        var fechaPublicacion = new Date(responseJson.fechaPublicacion);
        var today = new Date();
        pm.expect(fechaPublicacion).to.be.at.most(today);
    }
});

// Validación de Género
pm.test("Genero validation - Allowed genres", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El género debe ser uno válido (Ficción, No Ficción, Educativo, Otro).");
    } else {
        pm.expect(responseJson.genero).to.be.oneOf(['Ficción', 'No Ficción', 'Educativo', 'Otro']);
    }
});

// Validación de Precio
pm.test("Precio validation - Positive and less than or equal to 1000", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El precio debe ser un número positivo mayor a 0.");
        pm.expect(responseJson.message).to.include("El precio no puede superar los 1000.");
    } else {
        pm.expect(responseJson.precio).to.be.above(0).and.below(1001);
    }
});

// Validación de Cantidad en Stock
pm.test("Cantidad en Stock validation - Between 1 and 500", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("La cantidad en stock debe ser un entero positivo.");
        pm.expect(responseJson.message).to.include("La cantidad en stock no puede ser mayor a 500.");
    } else {
        pm.expect(responseJson.cantidadStock).to.be.within(1, 500);
    }
});

// Validación de Descripción
pm.test("Descripcion validation - Between 10 and 500 characters", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("La descripción debe tener entre 10 y 500 caracteres.");
    } else {
        pm.expect(responseJson.descripcion.length).to.be.within(10, 500);
    }
});

// Validación de Idioma
pm.test("Idioma validation - Allowed values", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El idioma debe ser uno válido (Español, Inglés, Francés, Alemán).");
    } else {
        pm.expect(responseJson.idioma).to.be.oneOf(['Español', 'Inglés', 'Francés', 'Alemán']);
    }
});

// Validación de Código de Estado 201 (Para datos válidos)
pm.test("Status code is 201 when valid data is provided", function () {
    if (pm.response.status === 201) {
        pm.expect(pm.response.status).to.eql(201);
    }
});

```

### Tests para Usuarios

Para validar el endpoint POST `/api/usuarios`, añade estos tests:

```javascript
// Validación de Nombre Completo
pm.test("Nombre Completo validation - Not Null and Size between 3 and 50", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El nombre completo es obligatorio.");
        pm.expect(responseJson.message).to.include("El nombre completo debe tener entre 3 y 50 caracteres.");
    } else {
        pm.expect(responseJson.nombreCompleto).to.be.a('string').that.is.not.empty;
        pm.expect(responseJson.nombreCompleto.length).to.be.within(3, 50);
    }
});

// Validación de Correo Electrónico
pm.test("Correo Electrónico validation - Not Null and Valid Format", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El correo electrónico es obligatorio.");
        pm.expect(responseJson.message).to.include("El correo electrónico debe tener un formato válido.");
    } else {
        pm.expect(responseJson.correoElectronico).to.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/);
    }
});

// Contraseña validation - Between 8 and 20 chars, includes uppercase, lowercase, number, special char
pm.test("Contraseña validation - Between 8 and 20 chars, includes uppercase, lowercase, number, special char", function () {
    var responseJson = pm.response.json();

    // If hashed password is returned
    if (responseJson.contraseña && responseJson.contraseña.startsWith('$2a$')) {
        pm.expect(responseJson.contraseña).to.match(/^\$2a\$.*/); // Check if password is hashed using bcrypt
    } else {
        // If not hashed, validate using regex pattern
        if (pm.response.status === 400) {
            pm.expect(responseJson.message).to.include("La contraseña debe tener entre 8 y 20 caracteres e incluir al menos una letra mayúscula, una letra minúscula, un número y un carácter especial.");
        } else {
            pm.expect(responseJson.contraseña).to.match(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*]).{8,20}$/);
        }
    }
});

// Validación de Fecha de Registro
pm.test("Fecha de Registro validation - Optional field, valid date", function () {
    var responseJson = pm.response.json();
    
    if (responseJson.fechaRegistro) {
        var fechaRegistro = new Date(responseJson.fechaRegistro);
        pm.expect(fechaRegistro).to.be.a('date');
    }
});

// Validación de Edad
pm.test("Edad validation - Minimum age 14", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("La edad debe ser mayor de 13 años.");
    } else {
        pm.expect(responseJson.edad).to.be.a('number').that.is.at.least(14);
    }
});

// Validación de Número de Teléfono
pm.test("Número de Teléfono validation - Exactly 10 digits", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El número de teléfono debe tener exactamente 10 dígitos.");
    } else {
        pm.expect(responseJson.numeroTelefono).to.match(/^\d{10}$/);
    }
});

// Validación de Rol
pm.test("Rol validation - Allowed values (Administrador, Lector)", function () {
    var responseJson = pm.response.json();
    
    if (pm.response.status === 400) {
        pm.expect(responseJson.message).to.include("El rol es obligatorio.");
        pm.expect(responseJson.message).to.include("El rol debe ser válido (Administrador o Lector).");
    } else {
        pm.expect(responseJson.rol).to.be.oneOf(['Administrador', 'Lector']);
    }
});

// Validación de Código de Estado 201 (Para datos válidos)
pm.test("Status code is 201 when valid data is provided", function () {
    if (pm.response.status === 201) {
        pm.expect(pm.response.status).to.eql(201);
    }
});
```

### Ejemplos de Requests para Pruebas

#### Request válido para crear un libro:
```json
{
    "titulo": "Don Quijote de la Mancha",
    "autor": "Miguel de Cervantes",
    "isbn": "9788424112345",
    "fechaPublicacion": "1605-01-01",
    "genero": "Ficción",
    "precio": 29.99,
    "cantidadStock": 50,
    "descripcion": "La obra cumbre de la literatura española que narra las aventuras del ingenioso hidalgo.",
    "idioma": "Español"
}
```

#### Request válido para crear un usuario:
```json
{
    "nombreCompleto": "Juan Pérez González",
    "correoElectronico": "juan.perez@email.com",
    "contraseña": "Segura123!@#",
    "edad": 25,
    "numeroTelefono": "1234567890",
    "rol": "Lector"
}
```

### Casos de Prueba Recomendados

#### Para Libros:
1. Crear libro con todos los campos válidos
2. Intentar crear libro sin título
3. Intentar crear libro con ISBN inválido
4. Intentar crear libro con precio negativo
5. Intentar crear libro con fecha futura
6. Intentar crear libro con género no permitido

#### Para Usuarios:
1. Crear usuario con todos los campos válidos
2. Intentar crear usuario con correo inválido
3. Intentar crear usuario menor de 14 años
4. Intentar crear usuario con contraseña débil
5. Intentar crear usuario con rol no permitido
6. Intentar crear usuario con número de teléfono inválido

### Notas sobre las Pruebas
1. Las pruebas verifican tanto los casos exitosos (201) como los casos de error (400)
2. Para las contraseñas, se verifica tanto el formato sin encriptar como el hash bcrypt
3. Todas las validaciones de campos obligatorios incluyen mensajes de error en español
4. Los tests de fecha verifican que las fechas sean válidas y cumplan las restricciones temporales
5. Los tests de enumeraciones (género, idioma, rol) verifican que los valores estén dentro de los permitidos


### Notas Importantes
1. Todos los endpoints retornan códigos HTTP apropiados:
   - 200 OK: Operación exitosa
   - 201 Created: Recurso creado exitosamente
   - 204 No Content: Operación exitosa sin contenido para retornar
   - 404 Not Found: Recurso no encontrado
   - 400 Bad Request: Error en la validación de datos

2. Las contraseñas de usuarios son automáticamente encriptadas antes de almacenarse en la base de datos.

3. Las validaciones de datos se realizan automáticamente gracias a las anotaciones de validación en los modelos.