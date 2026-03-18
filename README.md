# 🌾 AgriNexus Platform

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

Configure database

properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/farmer_db
spring.datasource.username=your_username
spring.datasource.password=your_password
Build and run

bash
mvn clean install
mvn spring-boot:run
Access the application

Application: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui.html

H2 Console (if enabled): http://localhost:8080/h2-console

📝 Logging
SLF4J with Logback implementation

Structured logging for better traceability

Different log levels (DEBUG, INFO, WARN, ERROR)

Request/Response logging for debugging

🧪 Testing
API Testing
Use Postman or Swagger UI for API testing

Pre-configured authentication headers required

Sample Test Data
The application includes sample data for testing relationships and validations.

🔄 Future Enhancements
JWT Token-based authentication

Pagination and filtering for list endpoints

File upload for farmer documents

Email notifications

Docker containerization

CI/CD pipeline integration

👥 Contributing
Fork the repository

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

🆘 Support
For support, email your-support-email or create an issue in the repository.

Happy Farming! 🌾
