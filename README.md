# 🛍️ Inventory Management System

A Spring Boot–based backend application to manage products and categories for a shopping website. This project demonstrates core backend development principles using Java, Spring Boot, REST APIs, and MySQL.

---

## 🚀 Features

- CRUD operations on `Product` and `Category` entities
- RESTful API design using Spring Boot
- MySQL integration for persistent data storage
- Exception handling and clean architecture principles
- Follows layered architecture: Controller → Service → Repository

---

## 🛠️ Tech Stack

| Tool         | Purpose                        |
|--------------|--------------------------------|
| Java         | Core backend logic             |
| Spring Boot  | REST API framework             |
| MySQL        | Relational database            |
| Gradle       | Dependency and build tool      |
| Postman      | API testing                    |
| Git & GitHub | Version control and hosting    |

---

## 📡 Sample API Endpoints

| Method | Endpoint                   | Description              |
|--------|----------------------------|--------------------------|
| GET    | `/products/all`            | Get all products         |
| POST   | `/products`                | Create a new product     |
| PUT    | `/products/{id}`           | Update a product         |
| DELETE | `/products/{id}`           | Delete a product         |
| GET    | `/products/categories/all` | Get all categories       |

---

## 🔧 Setup Instructions

1. Clone this repo:
   ```bash
   git clone https://github.com/Saravana13/MyProject1.git
   cd MyProject1

2. Configure your application.properties file:
   ```bash
   spring.application.name=MyProject1
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.show-sql=true
   

3. Start MySQL server and create the database:
   ```bash
   CREATE DATABASE inventory_db;

4. Run the project via your IDE or command line:
   ```bash
   mvn spring-boot:run

# 👨‍💻 Author
## Saravana Kumar M
- [LinkedIn ](http://www.linkedin.com/in/saravana-kumar-m-255606144)
- [GitHub](https://github.com/Saravana13/MyProject1/tree/master)