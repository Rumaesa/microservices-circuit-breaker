# ☁️ Spring Boot Microservices Project with Eureka and Circuit Breaker  

This project demonstrates a **Spring Cloud microservices architecture** built with **Eureka Server**, **Producer**, and **Consumer** microservices.  
The setup showcases **service discovery**, **inter-service communication**, and **fault tolerance** using the **Circuit Breaker** pattern to ensure smooth response handling even when one service fails.  

---

## 🏗️ Project Overview  

### 🧭 1. Eureka Server  
**Purpose:**  
Acts as the **Service Registry** where all microservices register themselves for easy discovery.  

**Dependencies:**  
- eureka-server  

**Key Properties:**  
- eureka.client.register-with-eureka=false  
- eureka.client.fetch-registry=false  
- server.port=8761  

---

### 🔄 2. Producer & Consumer Microservices  
**Purpose:**  
Demonstrates communication between two services — **Producer** provides REST endpoints, and **Consumer** calls them.  
Implements a **Circuit Breaker** to handle failures gracefully and return fallback responses if the Producer is unavailable.  

**Dependencies:**  
- eureka-client  
- spring-web  
- spring-boot-starter-actuator  
- resilience4j-spring-boot2  

**Key Annotations:**  
- `@EnableDiscoveryClient` → registers service with Eureka  
- `@CircuitBreaker(name = "serviceName", fallbackMethod = "fallbackMethodName")` → enables fault tolerance  

**Key Properties:**  
- eureka.client.service-url.defaultZone=http://localhost:8761/eureka/  
- management.endpoints.web.exposure.include=*  
- server.port=<unique_port_for_each_service>  

---

## 🚀 Project Startup Order  
1️⃣ **Start Eureka Server** – enables service registration  
2️⃣ **Start Producer Service** – exposes REST endpoints  
3️⃣ **Start Consumer Service** – communicates with Producer and uses Circuit Breaker fallback  

---

✅ **This setup demonstrates:**  
- Dynamic **service registration and discovery**  
- **Inter-service REST communication**  
- **Fault tolerance** using Circuit Breaker  
- **Health and metrics monitoring** via Actuator  
