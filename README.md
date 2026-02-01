# Finito 🏋️‍♂️

A comprehensive Spring Boot backend API for tracking fitness, nutrition, and lifestyle activities with AI agent integration.

## 📋 Overview

Finito is a RESTful API backend designed to power fitness tracking applications and AI-powered health assistants. It provides a complete digital twin system for managing user profiles, inventory (food items), meal plans, workout plans, shopping, and activity logging.

## ✨ Features

### Core Functionality

- **User Profile Management** - Track biological stats (weight, height, BMI) and fitness goals
- **Inventory System** - Manage personal food inventory with automatic categorization
- **Shop Catalog** - Browse and search available products with pagination
- **Meal Planning** - Create and manage personalized meal plans
- **Workout Planning** - Design and track workout routines
- **Activity Logging** - Record lifestyle activities with impact scoring
- **Procurement System** - Order products and track delivery status
- **Health Monitoring** - Calculate readiness scores based on activity patterns

### AI Agent Ready

All endpoints are designed with AI agent integration in mind:
- Detailed OpenAPI/Swagger documentation
- Descriptive operation summaries for LLM understanding
- Consistent response formats
- User identification via `X-User-Id` headers

## 🛠️ Tech Stack

- **Framework**: Spring Boot 4.0.2
- **Language**: Java 21
- **Database**: SQLite (via Hibernate)
- **ORM**: Spring Data JPA
- **Documentation**: SpringDoc OpenAPI 3.0.1
- **Build Tool**: Maven
- **Utilities**: Lombok

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd finito
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

The API will start on `http://localhost:8080`

### Access API Documentation

Once running, visit:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## 📚 API Endpoints

### User Profile (`/api/v1/profile`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get user's biological profile |
| POST | `/` | Create new user profile |
| PUT | `/` | Update profile stats or goals |
| DELETE | `/` | Delete user and all associated data |

### Inventory (`/api/v1/inventory`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get user's current inventory |
| POST | `/add` | Add item to inventory |
| POST | `/consume` | Consume/reduce item quantity |
| PUT | `/update` | Update item quantity |
| DELETE | `/remove` | Remove item from inventory |

### Shop Catalog (`/api/v1/shop`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/catalog` | Get paginated product catalog |
| GET | `/search?query={name}` | Search products by name |
| POST | `/products` | Create new shop product |
| PUT | `/products/{id}` | Update product details |
| DELETE | `/products/{id}` | Delete product |
| PATCH | `/products/{id}/stock` | Toggle stock availability |

### Meal Plans (`/api/v1/meals`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get user's meal plans |
| POST | `/save` | Save new meal plan |

### Workout Plans (`/api/v1/workouts`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get user's workout plans |
| POST | `/save` | Save new workout plan |

### Activity Logging (`/api/v1/activity`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/log` | Log new activity with impact score |
| GET | `/history` | Get activity history (filterable by type) |

### Procurement (`/api/v1/procurement`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/order` | Place order for shop products |
| GET | `/orders` | Get user's order history |
| GET | `/readiness` | Calculate readiness score |

### Health Check (`/api/v1/health`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/ping` | Simple health check |

## 🔑 Authentication

The API uses a simple header-based user identification system:

```
X-User-Id: <user-identifier>
```

Default value: `477565737444656661756c7455736572` (hex-encoded "GuestDefaultUser")

> **Note**: This is a hackathon/demo implementation. For production, implement proper authentication (JWT, OAuth2, etc.)

## 📦 Data Models

### UserProfile
```json
{
  "userId": "string",
  "weight": 70.5,
  "height": 175.0,
  "bmi": 23.0,
  "goals": "Build muscle and lose fat"
}
```

### InventoryItem
```json
{
  "id": 1,
  "userId": "string",
  "name": "Chicken Breast",
  "category": "Protein",
  "quantity": 5.0,
  "unit": "kg",
  "imageUrl": "https://..."
}
```

### ShopProduct
```json
{
  "id": 1,
  "name": "Organic Chicken Breast",
  "price": 12.99,
  "category": "Protein",
  "inStock": true,
  "imageUrl": "https://..."
}
```

### ActivityLog
```json
{
  "id": 1,
  "userId": "string",
  "timestamp": "2026-02-01T15:30:00",
  "activityType": "EXERCISE",
  "description": "30-minute run",
  "impactScore": 8
}
```

## 🎯 Use Cases

### For AI Agents
- Query user's current inventory to suggest recipes
- Log activities based on user conversations
- Create meal plans based on available ingredients
- Order missing ingredients from shop
- Track fitness progress and adjust goals

### For Frontend Applications
- Build nutrition tracking dashboards
- Create meal planning interfaces
- Display workout progress
- Manage shopping lists
- Visualize activity patterns

## 🔧 Configuration

### Database
The application uses SQLite with the database file located at:
```
./hackathon.db
```

### CORS
CORS is enabled for all origins (`*`) to support frontend development. Update `WebConfig.java` for production settings.

### Sample Data
The application includes data seeders that populate:
- Sample shop products (proteins, vegetables, grains)
- Demo inventory items
- Sample activity logs

## 📁 Project Structure

```
src/main/java/com/data_merchants/finito/
├── config/          # Configuration and data seeders
├── controller/      # REST API endpoints
├── dto/            # Data Transfer Objects
├── exception/      # Exception handlers
├── model/          # JPA entities
├── repository/     # Data access layer
└── service/        # Business logic
```

## 🤝 Contributing

This is a hackathon project. Feel free to fork and extend!


## 👥 Authors

Data Merchants Team

## 🙏 Acknowledgments

Built for **IBM Dev Day AI Demystified** Hackathon with ❤️

---

