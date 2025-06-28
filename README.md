# 🛍️ NextShop - Enterprise E-Commerce Platform

**Author:** Srinivas Velishetti  
**Tech Stack:** Java 17, Spring Boot, React, Kafka, DynamoDB, AWS EKS, Docker, Jenkins, Terraform

---

## 🚀 Overview
NextShop is an enterprise-grade, microservices-based e-commerce platform inspired by Amazon, demonstrating scalable architecture, event-driven systems, cloud-native deployment, and centralized observability.

---

## 📦 Modules & Services
- `auth-service`: Login, JWT authentication
- `product-service`: Product listing and search
- `order-service`: Order creation and tracking
- `payment-service`: Payment processing and receipts
- `notification-service`: Email/SMS notification handler
- `gateway-service`: API gateway and routing layer

---

## ☸️ Deployment Options
- **Local Development:** Docker Compose
- **Cloud Deployment:** Kubernetes on AWS EKS

```bash
docker-compose up --build
kubectl apply -f k8s/
```

---

## 📂 Project Structure
```text
nextshop/
├── auth-service/
├── product-service/
├── order-service/
├── payment-service/
├── notification-service/
├── gateway-service/
├── k8s/                 # Kubernetes manifests
├── docker-compose.yml
└── README.md
```

---

## 🧪 Testing
- Unit tests: JUnit, Mockito
- Integration tests: via Docker Compose setup

---

## 🔐 DevOps & Observability
- **CI/CD:** Jenkins + Docker + ECR
- **Monitoring:** Fluent Bit → Splunk (logs)
- **Secrets:** Kubernetes Secrets & ConfigMaps

---

## 🧭 Architecture
See `architecture-diagram.png` for high-level flow.

---

## 🧑‍💻 Local Development
Start any service manually:
```bash
cd auth-service && ./mvnw spring-boot:run
```
Or bring everything up:
```bash
docker-compose up --build
```

---

## 🛠️ Contributing
Feel free to fork and raise PRs. Suggestions welcome!

---

## 📃 License
MIT