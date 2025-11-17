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
Access interactive API documentation at:
