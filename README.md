# 🚀 Portfolio Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Railway-blue?style=for-the-badge&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1.0-yellow?style=for-the-badge&logo=thymeleaf)
![Deployed](https://img.shields.io/badge/Deployed-Railway-purple?style=for-the-badge&logo=railway)

### A Full-Stack Portfolio System with Dynamic Profile Pages

[![Live Demo](https://img.shields.io/badge/Live_Demo-View_Portfolio-28a745?style=for-the-badge&logo=railway)](https://portfolio-production-7853.up.railway.app/)
[![GitHub](https://img.shields.io/badge/GitHub-Repository-181717?style=for-the-badge&logo=github)](https://github.com/king13692468/portfolio)

</div>

---

## 📋 Table of Contents
- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Live Demo](#-live-demo)
- [Screenshots](#-screenshots)
- [Getting Started](#-getting-started)
- [Project Structure](#-project-structure)
- [API Endpoints](#-api-endpoints)
- [Database Schema](#-database-schema)
- [Deployment](#-deployment)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)

---

## 📖 Overview

The **Portfolio Management System** is a full-stack web application that allows users to create and manage their professional portfolios. Users can showcase their projects, link their GitHub and LinkedIn profiles, and share their resumes—all through a clean, user-friendly interface.

This project demonstrates proficiency in **Spring Boot**, **Spring Data JPA**, **MySQL**, and **Thymeleaf**, following industry best practices for MVC architecture and RESTful design.

---

## ✨ Features

### 👤 User Features
| Feature | Description |
|---------|-------------|
| 🔍 **Search Profiles** | Search for any user by username |
| 📝 **Create Profile** | Register with username, name, and social links |
| 👀 **View Portfolio** | Dynamic profile pages at `/p/{username}` |
| 🔗 **External Links** | Direct links to GitHub, LinkedIn, and Resume |
| 📁 **Browse Projects** | View all projects by a user |

### 📁 Project Features
| Feature | Description |
|---------|-------------|
| ➕ **Add Projects** | Users can add projects to their portfolio |
| 📖 **Project Details** | View detailed information about each project |
| 🔗 **Project Links** | GitHub repository and live demo links |

### 🛠️ Technical Features
- ✅ **RESTful API Design** - Clean and consistent endpoint naming
- ✅ **MVC Architecture** - Separation of concerns (Controller-Service-Repository)
- ✅ **Cloud Database** - MySQL hosted on Railway
- ✅ **Dynamic Routing** - Username-based profile pages
- ✅ **Responsive Design** - Works on desktop and mobile devices

---

## 🛠️ Tech Stack

<div align="center">

| Category | Technology | Version |
|----------|------------|---------|
| **Language** | Java | 17 |
| **Framework** | Spring Boot | 3.1.0 |
| **ORM** | Spring Data JPA (Hibernate) | - |
| **Database** | MySQL | 8.0 |
| **Template Engine** | Thymeleaf | 3.1.0 |
| **Build Tool** | Maven | - |
| **Cloud Platform** | Railway | - |
| **Version Control** | Git & GitHub | - |

</div>

---

## 🌐 Live Demo

The application is deployed and accessible online:

<div align="center">

### 🔗 [https://portfolio-production-7853.up.railway.app/](https://portfolio-production-7853.up.railway.app/)

**Try these demo usernames:**
- `shadab` - Main portfolio
- Create your own profile!

</div>

---

## 📸 Screenshots

<div align="center">

### Home Page
![Home Page](https://via.placeholder.com/800x400?text=Home+Page+with+Search)

### Profile Menu
![Profile Menu](https://via.placeholder.com/800x400?text=Profile+Menu)

### Projects List
![Projects List](https://via.placeholder.com/800x400?text=Projects+List)

### Add Project Form
![Add Project Form](https://via.placeholder.com/800x400?text=Add+Project+Form)

</div>

> *Note: Replace placeholder images with actual screenshots of your application*

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.8+
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/king13692468/portfolio.git
   cd portfolio
2. **Configure MySQL database**
   ```bash
   CREATE DATABASE portfolio_db;
3. **Update application.properties**
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
4. **Build and run the application**
   ```bash
   mvn clean install
   mvn spring-boot:run
5. **Access the application**
   ```bash
   http://localhost:8080
## 📁 Project Structure
portfolio/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/portfolio/
│ │ │ ├── controller/
│ │ │ │ └── ProfileController.java
│ │ │ ├── entity/
│ │ │ │ ├── User.java
│ │ │ │ └── Project.java
│ │ │ ├── repository/
│ │ │ │ ├── UserRepository.java
│ │ │ │ └── ProjectRepository.java
│ │ │ └── PortfolioApplication.java
│ │ └── resources/
│ │ ├── templates/
│ │ │ ├── index.html
│ │ │ ├── menu.html
│ │ │ ├── profile.html
│ │ │ ├── projects-list.html
│ │ │ ├── project-details.html
│ │ │ ├── resume.html
│ │ │ ├── create-profile.html
│ │ │ └── create-project.html
│ │ ├── static/
│ │ │ └── css/
│ │ │ └── style.css
│ │ └── application.properties
│ └── test/
│ └── java/
│ └── com/example/portfolio/
│ └── PortfolioApplicationTests.java
├── pom.xml
└── README.md
