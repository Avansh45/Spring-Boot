# Spring Boot CRUD Application

A RESTful CRUD (Create, Read, Update, Delete) application built using **Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project demonstrates how to build a layered Spring Boot application using **Controller, Service, and Repository architecture** and perform database operations using **Spring Data JPA**.
## 🚀 Features

- Create a new student
- Get a student by ID
- Get all students
- Update an existing student
- Delete a student
- Automatic ID generation using JPA
- Unique email constraint
- MySQL database integration
- RESTful API endpoints
- Proper HTTP status codes using `ResponseEntity`
- Environment variables for database credentials

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot 4.1.1**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Maven**
- **Postman**
- **IntelliJ IDEA**
- **Git & GitHub**

## 🏗️ Project Architecture

This project follows a layered architecture:

```text
Client (Postman)
       ↓
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
MySQL Database

```
### Layers

- **Controller:** Handles HTTP requests and sends HTTP responses.
- **Service:** Contains the application's business logic.
- **Repository:** Performs database operations using Spring Data JPA.
- **Entity:** Represents the `Student` table in the database.

## 📁 Project Structure

```text
Spring-Boot-CRUD/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── in/avansh/Spring_Boot_CRUD/
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       └── SpringBootCrudApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
└── README.md

```

## 🗄️ Database Configuration

This project uses **MySQL** as the database and **Spring Data JPA** with Hibernate for database operations.

### Database

```sql
CREATE DATABASE students_crud_db;
```
The application connects to the database using the following configuration:

```
spring.datasource.url=jdbc:mysql://localhost:3306/students_crud_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
- `students_crud_db` is the database used by the application.
- `ddl-auto=update` allows Hibernate to create or update tables based on the entity.
- Database credentials are provided using environment variables instead of being stored directly in the source code.
## 🔐 Environment Variables

Database credentials are stored using environment variables to avoid exposing sensitive information in the source code.

Set the following environment variables on your system:

```text
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```
The application reads these values from `application.properties`:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```
## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone <your-repository-url>
```

### 2. Open the Project

Open the `Spring-Boot-CRUD` project in **IntelliJ IDEA**.

### 3. Create the Database

Create the MySQL database:

```sql
CREATE DATABASE students_crud_db;
```

### 4. Set Environment Variables

Configure the following environment variables:

```text
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

### 5. Run the Application

Run the main Spring Boot class:

```text
SpringBootCrudApplication.java
```

The application will start on:

```text
http://localhost:8080
```

## 🌐 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/students` | Create a new student |
| `GET` | `/api/students/get/{id}` | Get a student by ID |
| `GET` | `/api/students/getAll` | Get all students |
| `PUT` | `/api/students/update/{id}` | Update an existing student |
| `DELETE` | `/api/students/delete/{id}` | Delete a student |

## 🧪 API Testing

The REST APIs can be tested using **Postman**.

### Create Student

**Method:** `POST`

**Endpoint:**
```text
http://localhost:8080/api/students
```

**Request Body:**
```json
{
    "name": "Avansh",
    "email": "avansh@example.com",
    "age": 22,
    "rollNo": 101,
    "subject": "Computer Science"
}
```
### Get Student by ID

**Method:** `GET`

**Endpoint:**
```text
http://localhost:8080/api/students/get/{id}
```

**Example:**
```text
http://localhost:8080/api/students/get/1
```

**Response:**
```json
{
    "id": 1,
    "name": "Avansh",
    "email": "avansh@example.com",
    "age": 22,
    "rollNo": 101,
    "subject": "Computer Science"
}
```
### Get All Students

**Method:** `GET`

**Endpoint:**
```text
http://localhost:8080/api/students/getAll
```

**Response:**
```json
[
    {
        "id": 1,
        "name": "Avansh",
        "email": "avansh@example.com",
        "age": 22,
        "rollNo": 101,
        "subject": "Computer Science"
    },
    {
        "id": 2,
        "name": "Rahul",
        "email": "rahul@example.com",
        "age": 21,
        "rollNo": 102,
        "subject": "Information Technology"
    }
]
```
### Update Student

**Method:** `PUT`

**Endpoint:**
```text
http://localhost:8080/api/students/update/{id}
```

**Example:**
```text
http://localhost:8080/api/students/update/1
```

**Request Body:**
```json
{
    "name": "Avansh Updated",
    "email": "avansh.updated@example.com",
    "age": 23,
    "rollNo": 101,
    "subject": "Computer Science"
}
```

**Response:**
```json
{
    "id": 1,
    "name": "Avansh Updated",
    "email": "avansh.updated@example.com",
    "age": 23,
    "rollNo": 101,
    "subject": "Computer Science"
}
```
### Delete Student

**Method:** `DELETE`

**Endpoint:**
```text
http://localhost:8080/api/students/delete/{id}
```

**Example:**
```text
http://localhost:8080/api/students/delete/1
```

**Success Response:**
```text
Student deleted successfully
```

**Response Status:** `200 OK`

**If Student Does Not Exist:**
```text
Student not found
```

**Response Status:** `404 Not Found`

## 💡 Concepts Demonstrated

- REST API development using Spring Boot
- Layered architecture: Controller, Service, Repository
- Dependency Injection using constructor injection
- Spring Data JPA and `JpaRepository`
- Entity mapping using JPA annotations
- CRUD database operations
- Request handling using `@RequestBody`, `@PathVariable`, and mapping annotations
- HTTP status codes using `ResponseEntity`
- MySQL database integration
- Hibernate automatic table management
- Environment variables for database credentials

## 🔮 Future Improvements

- Add input validation using Bean Validation
- Add global exception handling
- Implement pagination and sorting
- Add search and filtering functionality
- Implement **soft delete** for database entries instead of permanently deleting records
- Add Spring Security and authentication
- Add DTOs for request and response handling
- Add unit and integration testing
- Add API documentation using Swagger/OpenAPI

## 👨‍💻 Author

**Avansh Chadgal**

- GitHub: https://github.com/Avansh45
- LinkedIn: https://linkedin.com/in/avanshchadgal