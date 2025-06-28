# 📝 Blog System

## 📌 **Giới thiệu**

**Blog System** là dự án fullstack xây dựng hệ thống Blog cho phép người dùng:
- Đăng ký, đăng nhập
- Đăng bài viết, xem bài viết
- Comment bài viết
- Phân quyền User / Admin

Dự án nhằm thực hành:
- Spring Boot REST API
- MongoDB NoSQL Database
- Angular Frontend với Angular Material
- JWT Authentication & Authorization

---

## 🚀 **Công nghệ sử dụng**

| Layer | Technology |
|--|--|
| **Backend** | Spring Boot, Spring Data MongoDB, Spring Security, JWT |
| **Database** | MongoDB |
| **Frontend** | Angular, Angular Material |
| **Tools** | VSCode, Postman, Git |

## 🎯 **Kết quả mong đợi**

- Hiểu rõ cách kết hợp Spring Boot + MongoDB + Angular
- Thành thạo thiết kế REST API cho NoSQL
- Thành thạo JWT Authentication + Authorization
- Xây dựng UI Angular 

## 💡 **Hướng mở rộng**

- Like / Unlike bài viết
- Upload hình ảnh (Cloudinary, AWS S3)
- Dashboard Admin nâng cao (thống kê bài viết, người dùng)
- Tích hợp WebSocket để real-time comments

---

## 🛠️ **Run Project**

### 🔧 **Backend**
```bash
# Vào folder backend
cd backend
# Build project
mvn clean install
# Run
mvn spring-boot:run
