# Employee Management API

## Overview

This project is a Spring Boot-based RESTful API for managing employee information. It provides endpoints to perform CRUD operations (Create, Read, Update, Delete) on employee records. The API integrates with a relational database to persist employee data and exposes endpoints to manage the lifecycle of employee entities.

## Features
- Add new employees
- Retrieve a list of all employees
- Update employee details
- Delete employee records
- Search employees by ID
## Technologies Used
- Java 11
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- H2 Database
- Lombok (for reducing boilerplate code)
  
# Getting Started
## Prerequisites
To run this project, you'll need to have the following software installed:

- Java 11 or higher
- Maven
- MySQL (or any other relational database)
- IDE like IntelliJ IDEA, Eclipse, or VS Code
## Installation & Setup
### Clone the repository:

```bash
git clone https://github.com/Sitesh01/EmployeeManagement-API.git
cd EmployeeManagement-API
```
### Configure the Database: 
In the `src/main/resources/application.properties` file, configure the database connection for MySQL.

Example for MySQL:
```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
If you're using an in-memory database (H2) for development, the configuration might already be set up.

### Run the application: 
To run the application using Maven:
```
mvn spring-boot:run
```
### Access the API: 
Once the application is running, you can access the API via http://localhost:8080/api/employees.

## API Endpoints:

Here’s a list of the key endpoints available in the Employee Management API

| HTTP Method	|     Endpoint           |              Description            |
| ----------- | ---------------------- | ----------------------------------- |
| GET         | /api/employees	       | Get all employees                   |
| GET        	| /api/employees/{id}    | Get employee by ID                  | 
| POST   	    | /api/employees	       | Create a new employee               |
| PUT   	    | /api/employees/{id}	   | Update an employee’s information    |
| DELETE      |	/api/employees/{id}	   | Delete an employee                  |

## Example Usage:
To create a new employee, send a POST request to /api/employees with the following payload

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "position": "Software Engineer",
  "salary": 60000
}
```

## Project Structure
The project follows a typical Spring Boot structure:

```bash
EmployeeManagement-API/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   │   └── com.siteshkumar.em_project/
 │   │   │       ├── controller/   # REST controllers
 │   │   │       ├── model/        # Employee entity
 │   │   │       ├── repository/   # JPA repository interfaces
 │   │   │       ├── service/      # Service layer for business logic
 │   │   └── resources/
 │   │       ├── application.properties  # Database and app configuration
 ├── pom.xml   # Project dependencies
 └── README.md # Project documentation
```
 
## Testing
The project includes unit tests for the service layer and controller layer. To run the tests, use the following command:

```bash
mvn test
```
You can also use Postman or cURL to test the API manually by sending HTTP requests.
