# Amazon Clone

The Amazon Clone is a Spring Boot-based backend service that facilitates e-commerce functionalities, including user management, product management, order tracking, and payment processing. This API also handles user authentication and authorization.

## Features

### User Management:
- User authentication and registration.
- Role-based access control (e.g., CUSTOMER, ADMIN).

### Product & Category Management:
- Add, update, retrieve, and manage product details.
- Manage categories and subcategories.

### Cart & Order Management:
- Add items to the cart and update quantities.
- Place and track orders

### Secure Endpoints:
- Endpoints are secured using JSON Web Tokens (JWT) for authentication.

## Prerequisites
Ensure you have the following installed:

- Java 21
- Maven for dependency management.
- Docker for containerization and streamlined deployment.
- Frontend (Amazon Clone UI) built with Vanilla JavaScript.

## Getting Started

### 1. Clone the Repository
```sh
git clone https://github.com/gunaasin/Amazon-Clone-V1.git
cd Amazon-Clone-V1
```

### 2. Configure the Application
Update the `src/main/resources/application.yml` file with your database configuration:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/amazon_clone_db
    username: your_database_user
    password: your_database_password
  jpa:
    hibernate:
      ddl-auto: update
  client:
    end-point: your_front_end_url

stripe:
  secretKey: your_stripe_secretKey
  primaryKey: your_primary_key
  webhookSecret: your_secret_webhook
```

### 3. Run the Backend Service
Using Maven:
```sh
mvn clean install
mvn spring-boot:run
```
The backend will be available at `http://localhost:8080`.

### 4. Run the Frontend (Optional)
If you are using the Amazon Clone UI (Vanilla JavaScript):
```sh
cd amazon-clone-ui
open with live server
```
Access the frontend at `http://127.0.0.1:5501/`.


## Project Structure
```
amazon-clone-api/
├── src/
│   ├── main/
│   │   ├── java/com/clone/amazon/
│   │   │   ├── address/     
│   │   │   ├── cart/        
│   │   │   ├── cartItem/    
│   │   │   ├── category/    
│   │   │   ├── configration/
│   │   │   ├── delivery/    
│   │   │   ├── orderdetail/  
│   │   │   ├── orders/      
│   │   │   ├── payment/     
│   │   │   ├── product/     
│   │   │   ├── rating/      
│   │   │   ├── review/      
│   │   │   ├── security/    
│   │   │   ├── user/        
│   │   │   ├── web_controller/ 
│   │   │   ├── AmazonApplication/  
│   │   └── resources/
│   │       ├── application.yml  # Application properties
│   │       ├── banner.txt       # Custom banner
├── pom.xml               # Maven configuration
└── Dockerfile            # Dockerfile for backend
```

## Key Endpoints

### Authentication
| Method | Endpoint      | Description |
|--------|--------------|-------------|
| POST   | /signup      | Register a new user. |
| POST   | /signin      | Log in a user and get a JWT. |

### Products
| Method | Endpoint      | Description |
|--------|--------------|-------------|
| GET    | /products    | Get a list of products. |
| POST   | /product/add | Add a new product (Admin only). |
| DELETE | /product/{id} | Delete a product (Admin only). |

### Cart
| Method | Endpoint      | Description |
|--------|--------------|-------------|
| GET    | /cart        | Get cart details. |
| POST   | /cart/add    | Add item to cart. |
| PUT    | /cart/update/{itemId} | Update cart item quantity. |

### Orders
| Method | Endpoint      | Description |
|--------|--------------|-------------|
| POST   | /order/place | Place an order. |
| GET    | /orders      | Get user order details. |
| PUT | /order/update | Order update |

## Common Errors

### 1. Service Not Initialized in the Default Constructor
Ensure Lombok services are working properly, as all are annotated with `@RequiredArgsConstructor`.

### 2. Database Connection Errors
Check your `application.yml` for the correct database URL, username, and password.

## Contact
For queries or support, contact the Amazon Clone developer at `guna.asin06@gmail.com`. 🎉

