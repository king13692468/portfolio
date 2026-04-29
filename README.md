# <p align="center">📌 <strong>PORTFOLIO MANAGEMENT SYSTEM</strong> 📌</p>

<p align="center">
  <strong><big>A web-based portfolio application built using Spring Boot that allows users to showcase their personal details and projects through a unique username-based profile link.</big></strong>
</p>

<br>

## <strong>🚀 FEATURES</strong>
- ✅ Dynamic user profile using `/p/{username}` URL
- ✅ Displays user details (GitHub, LinkedIn, Resume)
- ✅ Lists all projects associated with the user
- ✅ Individual project view support
- ✅ Integrated with MySQL database for data storage

<br>

## <strong>🛠 TECH STACK</strong>

| Technology | Purpose |
|------------|---------|
| **Java (Spring Boot)** | Backend Framework |
| **Spring MVC + Thymeleaf** | Web Layer & Templating |
| **Spring Data JPA (Hibernate)** | Database ORM |
| **MySQL** | Database (Railway Cloud DB) |
| **Maven** | Build Tool |

<br>

## <strong>📂 HOW IT WORKS</strong>
1. User data is stored in MySQL database
2. Each user has a unique username
3. Visiting `/p/{username}` loads their profile
4. Projects are fetched using user ID and displayed dynamically

<br>

## <strong>🌐 DEPLOYMENT</strong>
| Component | Platform |
|-----------|----------|
| **Backend** | Railway |
| **MySQL Database** | Railway |
| **Access** | Public URL |

<br>

## <strong>▶️ RUN LOCALLY</strong>

bash
git clone <your-repo-link>
cd portfolio
mvn spring-boot:run
<strong>⚙️ CONFIGURATION</strong>
Set database credentials in application.properties:

properties
spring.datasource.url=jdbc:mysql://<host>:<port>/<db>
spring.datasource.username=root
spring.datasource.password=your_password

<strong>🔗 URL STRUCTURE</strong>
text
https://your-domain.com/p/{username}
Example:

text
https://your-domain.com/p/shadabmobin

<strong>📌 FUTURE IMPROVEMENTS</strong>
🔐 Add user authentication (login/signup)

🎨 UI enhancements

🖼️ Project image upload support

📊 Admin dashboard


<strong>👨‍💻 AUTHOR</strong>
<p><strong>Md Shadab Mobin</strong></p> ```


