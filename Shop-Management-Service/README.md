# Shop Management Service

## Your assigned module
**Project:** Shopping Mall Management System  
**Module:** Shop Management Service  
**Assigned member:** Lekhana S N

This project follows the Spring Boot lab flow:

`POSTMAN -> Spring REST Controller -> Service Layer -> Spring Data JPA Repository Layer -> MySQL Database`

The uploaded lab guide uses a Product CRUD example. This project adapts that same architecture and CRUD pattern to the Shopping Mall **Shop Management Service** module.

## Shop fields used in this implementation
The lab guide does not specify the exact fields for the Shop Management Service. To make the assigned module runnable and meaningful, this implementation uses:

- `id` - Integer, auto generated
- `name` - String
- `ownerName` - String
- `category` - String
- `floorNumber` - Integer
- `contact` - String
- `monthlyRent` - double

## Software required
- JDK 11 or later
- Maven 3.6+
- MySQL Server / MySQL Workbench
- VS Code with Extension Pack for Java (recommended)
- Postman

## 1. Create the MySQL database
Open MySQL Workbench and run:

```sql
CREATE DATABASE IF NOT EXISTS shopping_mall_db;
USE shopping_mall_db;

CREATE TABLE IF NOT EXISTS shops (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    owner_name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    floor_number INT NOT NULL,
    contact VARCHAR(20) NOT NULL,
    monthly_rent DOUBLE NOT NULL
);
```

The application also has `spring.jpa.hibernate.ddl-auto=update`, so JPA can create/update the table automatically after the database exists.

## 2. Check MySQL credentials
The project defaults to:

```properties
spring.datasource.username=root
spring.datasource.password=admin123
```

Change the password in `src/main/resources/application.properties` if your local MySQL password is different.

You can also run with an environment variable:

Windows PowerShell:
```powershell
$env:DB_PASSWORD="your_mysql_password"
```

Then start the application.

## 3. Open the project in VS Code
1. Extract the ZIP file.
2. Open the `Shop_Management_Service` folder in VS Code.
3. Wait for Maven dependencies to finish loading.
4. Open:
   `src/main/java/com/mall/shopmanagement/ShopManagementServiceApplication.java`
5. Run the `main()` method.

The server runs on **port 8081**.

## 4. Run using terminal
From the project root:

```bash
mvn clean test
mvn spring-boot:run
```

Or package and run:

```bash
mvn clean package
java -jar target/shop-management-service-0.0.1-SNAPSHOT.jar
```

## 5. Postman CRUD operations
### Get all shops
`GET http://localhost:8081/api/shops`

### Get one shop
`GET http://localhost:8081/api/shops/1`

### Insert shop
`POST http://localhost:8081/api/shops`
Header:
`Content-Type: application/json`

Body:
```json
{
  "name": "Fashion Hub",
  "ownerName": "Arun",
  "category": "Clothing",
  "floorNumber": 1,
  "contact": "9876543210",
  "monthlyRent": 45000
}
```

### Update shop
`PUT http://localhost:8081/api/shops/1`
Header:
`Content-Type: application/json`

Body:
```json
{
  "name": "Fashion Hub Premium",
  "ownerName": "Arun",
  "category": "Clothing",
  "floorNumber": 2,
  "contact": "9876543210",
  "monthlyRent": 50000
}
```

### Delete shop
`DELETE http://localhost:8081/api/shops/1`

## 6. Project structure

```text
Shop_Management_Service/
├── pom.xml
├── README.md
├── postman/Shop_Management_Service.postman_collection.json
├── src/
│   ├── main/
│   │   ├── java/com/mall/shopmanagement/
│   │   │   ├── ShopManagementServiceApplication.java
│   │   │   ├── controller/ShopController.java
│   │   │   ├── entity/Shop.java
│   │   │   ├── repository/ShopRepository.java
│   │   │   └── service/ShopService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/
│       └── java/com/mall/shopmanagement/service/ShopServiceTest.java
```

## 7. TDD / testing section
The case-study PPT describes a TDD approach: identify test cases, write failing tests, then make them green while implementing incrementally. This project includes service-layer tests for listing shops, fetching a shop by ID, and handling a missing shop.

Run:

```bash
mvn test
```

## 8. Expected HTTP status codes
- GET all: `200 OK`
- GET by ID found: `200 OK`
- GET by ID missing: `404 NOT FOUND`
- POST: `201 CREATED`
- PUT found: `200 OK`
- PUT missing: `404 NOT FOUND`
- DELETE found: `204 NO CONTENT`
- DELETE missing: `404 NOT FOUND`
