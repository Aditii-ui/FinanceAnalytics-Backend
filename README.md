#  Finance Analytics Backend (Spring Boot + H2 + JWT)

##  Overview

Finance Analytics Backend is a **Spring Boot REST API** that manages financial records and provides dashboard-level analytics such as:

- Total income
- Total expenses
- Net balance
- Category-wise totals
- Monthly trends
- Recent activity tracking

The system demonstrates:

- Layered backend architecture
- Role-based access control
- JWT authentication
- Analytics-ready API design
- Secure REST endpoint implementation

---

#  Tech Stack Used

| Layer | Technology |
|------|-----------|
| Backend Framework | Spring Boot |
| REST APIs | Spring Web (Spring MVC) |
| Database | H2 In-Memory Database |
| ORM | Hibernate (Spring Data JPA) |
| Security | Spring Security |
| Authentication | JWT (JSON Web Token) |
| Build Tool | Maven |
| Java Version | Java 17 |

---

#  Project Architecture

Project structure follows layered architecture:
controller → Handles API requests
service → Business logic layer
repository → Database access layer
model → Entity classes
dto → Request/response objects
security → JWT authentication logic
config → Security configuration
exception → Global exception handling


This improves maintainability and scalability.

---

#  Role-Based Access Control

Three user roles are implemented:

| Role | Access |
|------|--------|
| Viewer | View dashboard analytics |
| Analyst | View records + analytics |
| Admin | Full system access |

Security enforced using:
@PreAuthorize()

annotations.

---

# 🧾 Features Implemented

## Authentication

- User registration
- User login
- Password encryption (BCrypt)
- JWT token authentication

---

## Financial Records

- Create financial record
- View financial records
- Delete financial record
- Filter records by category
- Filter records by type
- Filter records by date range

---

## Dashboard Analytics

- Total income
- Total expenses
- Net balance
- Category summary
- Monthly trends
- Recent activity

---

## User Management

(Admin only)

- View users
- Activate / deactivate users
- Delete users

---

#  Database Used

## H2 Embedded Database

This project uses **H2 in-memory database**.

### Why H2?

- No installation required
- Runs inside Spring Boot
- Ideal for assignment evaluation
- Lightweight and fast
- Automatically creates tables

---

#  Access H2 Console

Open browser:
http://localhost:8080/h2-console

Login credentials:
JDBC URL:
jdbc:h2:mem:finance_dashboard

Username:
sa

Password:
(empty)
Tables created automatically:
users
financial_records

---

#  Authentication Flow

## Step 1 — Register User


