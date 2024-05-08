#Joel Darnés Cros, 07/05/2024


## Descripción
Servicio REST en Spring Boot para obtener el precio aplicable según fecha, producto y marca desde una base de datos en memoria H2.

## Requisitos
- Java JDK 17
- Maven 3.x

## Configuración y Ejecución
Para iniciar la aplicación, ejecuta el siguiente comando en la terminal desde el directorio raíz del proyecto:
./mvnw spring-boot:run

### Ejecución de Pruebas
Para correr las pruebas automatizadas, utiliza:
./mvnw test

### Comandos Útiles para Manejo de la Base de Datos con Flyway
rm ./testdb.mv.db
./mvnw flyway:clean
./mvnw flyway:migrate
./mvnw flyway:info


## Uso de la API
Accede a los endpoints del servicio a través de `http://localhost:8080`. Ejemplos de consultas específicas basadas en los requisitos del proyecto:

### Test 1
Consulta a las 10:00 del 14/06/2020 para el producto 35455, marca 1 (ZARA):
http://localhost:8080/api/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1

### Test 2
Consulta a las 16:00 del 14/06/2020 para el producto 35455, marca 1 (ZARA):
http://localhost:8080/api/prices?date=2020-06-14T16:00:00&productId=35455&brandId=1

### Test 3
Consulta a las 21:00 del 14/06/2020 para el producto 35455, marca 1 (ZARA):
http://localhost:8080/api/prices?date=2020-06-14T21:00:00&productId=35455&brandId=1

### Test 4
Consulta a las 10:00 del 15/06/2020 para el producto 35455, marca 1 (ZARA):
http://localhost:8080/api/prices?date=2020-06-15T10:00:00&productId=35455&brandId=1

### Test 5
Consulta a las 21:00 del 16/06/2020 para el producto 35455, marca 1 (ZARA):
http://localhost:8080/api/prices?date=2020-06-16T21:00:00&productId=35455&brandId=1

## Contacto
Para más información, contactar a Joel Darnés Cros a través de joeldarnes@gmail.com