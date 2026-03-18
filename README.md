# 🌾 AgriNexus Platform

Backend system for managing agricultural data including farmers, land records, crops, and livestock.  
Designed to model real-world relationships between entities and provide a structured way to manage and access this data through REST APIs.

---

## 🧩 Overview

AgriNexus focuses on organizing agricultural data in a way that reflects how entities are connected in real scenarios.  
The system handles relationships between farmers and their associated resources, ensuring consistency, clarity, and ease of extension.

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL / H2  
- Spring Security (Basic Auth)  
- Bean Validation  
- Swagger (OpenAPI)  
- Maven  

---

## 🏗️ Core Design

The application is structured around key domain entities:

- **Farmer**  
- **Crop**  
- **Land**  
- **Cattle**  

### Relationships

- One-to-Many → Farmer → Crops, Land, Cattle  
- Many-to-One → Reverse mapping  
- Additional mappings for complex associations  

### Design Goals

- Clear ownership of data  
- Minimal redundancy  
- Easy extension for future features  

---

## 🔐 Security

- Basic authentication using Spring Security  
- Passwords stored using BCrypt  
- Stateless request handling  

---

## 🧪 API Access

Swagger UI available at: http://localhost:8080/swagger-ui.html


### Main Endpoints

/api/farmers
/api/crops
/api/lands
/api/cattles


---

## 🛠️ Error Handling & Validation

- Centralized exception handling using `@ControllerAdvice`  
- Structured error responses  
- Field-level validation using standard annotations  

---

## 🚀 Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/agrinexus-platform.git
cd agrinexus-platform

spring.datasource.url=jdbc:mysql://localhost:3306/farmer_db
spring.datasource.username=your_username
spring.datasource.password=your_password

mvn clean install
mvn spring-boot:run
