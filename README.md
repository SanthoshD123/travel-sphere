# 🌍 Travel Sphere - Travel Package Aggregator

A Spring Boot-based platform to compare and book travel packages (Under Development).

## 📌 Current Features
- ✅ Travel Agency Management
  - Basic CRUD operations for agencies
- ✅ Travel Package Management
  - Basic CRUD operations for travel packages

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot, MySQL
- **Frontend**: Angular, you can check frontend process : (https://github.com/SanthoshD123/travel-sphere-frontend.git)

## 🚀 Setup Instructions

### 1. Database Setup
- Create a MySQL database named `travel_db`
- Update `application.properties` with your database credentials

### 2. Run the Backend
```bash
cd travel-aggregator
mvn spring-boot:run
```
Server will start at `http://localhost:8080`

## 🔌 Available APIs

### Travel Agency Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/v1/agencies` | Get all agencies |
| POST   | `/api/v1/agencies` | Create agency |
| PUT    | `/api/v1/agencies/{id}` | Update agency |
| DELETE | `/api/v1/agencies/{id}` | Delete agency |

### Travel Package Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/v1/packages` | Get all packages |
| GET    | `/api/v1/packages/{id}` | Get package by ID |
| POST   | `/api/v1/packages` | Create package |
| PUT    | `/api/v1/packages/{id}` | Update package |
| DELETE | `/api/v1/packages/{id}` | Delete package |

## 👨‍💻 Contact
- **Developer**: Santhosh D
- **GitHub**: [SanthoshD123](https://github.com/SanthoshD123)

## 🚧 Upcoming Features
- User Interface with Angular
- Search and Filtering
- User Reviews & Ratings
- Booking System Integration
