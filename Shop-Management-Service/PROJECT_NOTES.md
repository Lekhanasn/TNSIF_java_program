# Submission Notes - Lekhana S N

## Assigned module
Shopping Mall Management System -> Shop Management Service

## Architecture
POSTMAN -> Spring REST Controller -> Service Layer -> Spring Data JPA Repository Layer -> MySQL Database

## Source alignment
- The Spring Boot Lab Guide specifies this controller/service/repository/database flow and demonstrates CRUD using an Entity, REST Controller, Service, and JpaRepository.
- The Banking System Case Study Presentation emphasizes layered architecture, module-based design, a service interface/implementation pattern, search/retrieval, and TDD.

## Adaptation note
The supplied materials do not define the exact data fields for a Shop entity. Therefore, this implementation defines practical Shop fields (`id`, `name`, `ownerName`, `category`, `floorNumber`, `contact`, `monthlyRent`) so the assigned module can be compiled, executed, and demonstrated in Postman.


## Local database configuration
The project is updated to use the local MySQL root password configured during setup and enables `createDatabaseIfNotExist=true` so the `shopping_mall_db` schema can be created automatically if the account has permission.
