# 🥗 Spring Boot Food Inventory App

A full-stack food inventory management application built with **Spring Boot**, **Thymeleaf**, **PostgreSQL**, and deployed using **Docker** on **Render**.  
This project allows users to manage food items, track stock levels, check allergens, and monitor expiration dates.

---

## 🚀 Features

### 📦 Food Management
- Create, read, update, and delete food items  
- View detailed information for each food item  

### ⚠️ Allergy Detection
- Check if a food contains **lactose**  
- Check if a food contains **seafood**  
- Barcode-based allergy lookup  

### 📉 Stock Monitoring
- View **out-of-stock** items  
- View **low-stock** items (threshold configurable)  

### ⏳ Expiration Tracking
- List **expired** foods  
- List foods **expiring soon** (threshold configurable)

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot 4.0.2 / Java 17 |
| View | Thymeleaf |
| Database | PostgreSQL |
| Build Tool | Maven |
| Containerization | Docker |
| Deployment | Render Web Service |

---

# 🌐 **🚀 LIVE DEMO（Click here ）**

## 👉 **🔗 https://spring-boot-food-1-0-0-latest.onrender.com/foods**

### _(⚠️ note：Render free server: it takes 50 seconds to wake up the server)_  

---
# 📸 Screenshots

<p align="center">
  <strong>📦 Food List</strong><br>
  <img src="screenshots/Food List.png" width="800">
</p>

<p align="center">
  <strong>➕ Create Food</strong><br>
  <img src="screenshots/Create foods.png" width="800">
</p>

<p align="center">
  <strong>🥛 Foods Containing Lactose</strong><br>
  <img src="screenshots/Food Containing Lactose.png" width="800">
</p>

<p align="center">
  <strong>📉 Low Stock Foods</strong><br>
  <img src="screenshots/Low Stock Foods.png" width="800">
</p>

## 🐳 Docker

### Build the JAR
```bash
mvn clean package

### Buid Docker image
docker build -t l2025s/spring-boot-food-1.0.0:latest .
### Run localy
docker run -p 8080:8080 l2025s/spring-boot-food-1.0.0:latest

###Deployment (Render)
Render automatily injects a dymanic port via:
PORT=xxxxx
To support this, the application includes:
server.port=${PORT:8080}

Environment Variables:
DB_URL, DB_USERNAME, DB_PASSWORD

---



