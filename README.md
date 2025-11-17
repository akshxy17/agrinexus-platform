# 🌱 Farmer Management System

A Spring Boot project that manages **Farmers** and their related entities such as **Crops**, **Land**, and **Cattles**.  
This project demonstrates the use of **JPA Relationships** (One-to-One, One-to-Many, Many-to-One, Many-to-Many) to model real-world farming data with comprehensive security, validation, and documentation features.

---

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA / Hibernate**
- **MySQL** (Production) / **H2** (Development)
- **Maven** (Build & Dependency Management)
- **Spring Security** with Basic Authentication
- **Spring Validation** (Field-level validations)
- **SpringDoc OpenAPI** (Swagger UI)
- **SLF4J** (Logging)
- **BCrypt** (Password Encoding)
- **Postman** (API Testing)

---

## 📌 Features

### Core Functionality
- ✅ **Manage Farmers** and their details with CRUD operations
- ✅ **Associate Crops, Land, and Cattles** with Farmers
- ✅ **RESTful APIs** with JSON responses
- ✅ **JPA Relationship Mapping** (One-to-One, One-to-Many, Many-to-One, Many-to-Many)

### Security & Validation
- ✅ **Basic Authentication** (Stateless) with Spring Security
- ✅ **BCrypt Password Encoding** for secure credential storage
- ✅ **Field-level Validations** using Bean Validation API
- ✅ **Global Exception Handling** with `@ControllerAdvice`

### Development & Documentation
- ✅ **Swagger UI** for interactive API documentation
- ✅ **SLF4J Logging** implementation
- ✅ **Comprehensive Error Handling**
- ✅ **MySQL Database** integration

---

## 🏗️ Entity Relationships

### Farmer Entity
- `@OneToMany` → Crops (One Farmer can have multiple Crops)
- `@OneToMany` → Land (One Farmer can own multiple Land plots)
- `@OneToMany` → Cattles (One Farmer can have multiple Cattles)

### Related Entities
- **Crop** - `@ManyToOne` → Farmer
- **Land** - `@ManyToOne` → Farmer  
- **Cattle** - `@ManyToOne` → Farmer

### Additional Relationships
- **One-to-One** relationships between specific entities
- **Many-to-Many** relationships for complex associations

---

## 🔐 Security Configuration

### Authentication
- **Basic Auth** implementation using Spring Security
- **Stateless** session management
- **BCrypt** password encoder for secure credential storage

### Protected Endpoints
- All API endpoints require authentication
- Role-based access control (if implemented)

---

## 📋 API Documentation

### Swagger UI
Access interactive API documentation at: http://localhost:8080/swagger-ui.html


### API Endpoints Overview
- `GET/POST/PUT/DELETE /api/farmers` - Farmer management
- `GET/POST/PUT/DELETE /api/crops` - Crop management  
- `GET/POST/PUT/DELETE /api/lands` - Land management
- `GET/POST/PUT/DELETE /api/cattles` - Cattle management

---

## 🛠️ Validation & Error Handling

### Field Validations
- **Bean Validation** annotations (`@NotNull`, `@Size`, `@Email`, etc.)
- **Custom validators** for business rules
- **Validation groups** for different scenarios

### Exception Handling
- **Global Exception Handler** with `@ControllerAdvice`
- **Custom exception classes** for business logic errors
- **Structured error responses** with appropriate HTTP status codes

---

## 📊 Database Configuration

### Production
- **MySQL** database with connection pooling
- **JPA/Hibernate** for ORM mapping
- **Liquibase/Flyway** for database migrations (if implemented)

### Development
- **H2 in-memory database** for testing
- **Automatic schema generation** during development

---

## 🎯 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+ (for production)
- Your favorite IDE (IntelliJ, Eclipse, VS Code)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd farmer-management-system
