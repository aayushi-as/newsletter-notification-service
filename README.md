
# Newsletter Notification Service

Newsletter Notification Service is a backend service built with Spring Boot that facilitates sending bulk emails to users subscribed to various newsletter categories. When a new newsletter for a specific category is added, this service automatically notifies all users subscribed to that category through email.

## Features

### Authentication
- JWT token-based authentication: Ensures secure access to the service by verifying admin with JSON Web Tokens (JWT).

### Bulk Email Notification
- **SMTP SendGrid:**: Handles the bulk email sending process using SendGrid as the SMTP provider for reliable email delivery.

### Avro Schema
- Utilized to define structured data schemas, ensuring consistency in the data format for email notification events.

### Kafka
- **Event Streaming:**: Kafka is used for email event streaming, handling the messaging between services for sending email notifications.
- **Retry Strategy & Dead Letter Topic:**: Implements a retry mechanism for failed messages, sending them to a Dead Letter Topic after retries are exhausted.

## API Documentation
The API endpoints are documented with Swagger UI, providing an interactive interface to test and view available endpoints. 
- **Swagger UI**: [Click here](https://aayushi-as.github.io/newsletter-notification-service/)

## Technology Stack

- **Spring Boot**: Core framework for building the backend
**Spring Kafka**: Kafka integration for event streaming
- **Spring Boot Security**: For securing endpoints and managing user roles
- **Spring Data JPA**: Database persistence and management with MySQL
- **Kafka Schema Registry**: Schema management for Avro
- **SendGrid**: SMTP email provider
- **MySQL**: Database for storing application data
- **JWT**: JSON Web Token for secure user authentication
- **Swagger UI**: API documentation
- **Maven**: Dependency management

## License
This project is licensed under the MIT License. See [LICENSE](https://github.com/aayushi-as/newsletter-notification-service/blob/main/LICENSE) for more details.
