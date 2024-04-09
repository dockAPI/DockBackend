# DockAPI Backend

DockAPI Backend is a RESTful API designed to manage projects with Docker configurations. It allows users to upload project details including GitHub link, Docker configurations, and documentation links. This API is built using Spring Boot and MongoDB.

## Features

- **Create**: Upload project details including GitHub link, Docker configurations, and documentation links.
- **Read**: Fetch project details by GitHub ID.
- **Update**: Update project details.
- **Delete**: Delete project details.

## Technologies Used

- **Spring Boot**: Framework for building the API.
- **MongoDB**: NoSQL database for storing project details.
- **Lombok**: Library to reduce boilerplate code.
- **Spring Data MongoDB**: Provides seamless integration with MongoDB.
- **RESTful API**: Follows REST architectural principles for communication.

## API Endpoints

- **POST /add**: Create a new project with provided details.
- **GET /get/{githubId}**: Fetch project details by GitHub ID.
- **GET /get**: Fetch all projects.
- **PUT /update/{githubId}**: Update project details by GitHub ID.
- **DELETE /delete/{githubId}**: Delete project by GitHub ID.

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/example/DockAPIBackend.git
2. **cd DockAPIBackend**
   ```bash
   ./mvnw spring-boot:run
