# DockAPI Backend

DockAPI is a Unified cloud platform and API hub designed to manage projects with Docker configurations. It allows users to upload project details including GitHub link, Docker configurations, and documentation links. This API is built using Spring Boot and MongoDB.

## Features

- **Create**: Upload project details including GitHub link, Docker configurations, and documentation links.
- **Read**: Fetch project details by GitHub ID.
- **Update**: Update project details.
- **Delete**: Delete project details.
- **Unified Cloud Platform Integration**: DockAPI integrates with leading cloud platforms (AWS, Google Cloud Platform, Microsoft Azure) to enable seamless API deployment and management.
- **Containerization Support**: Leverages Docker, Kubernetes, and AWS ECS for portability, scalability, and fault tolerance.
- **Serverless Integration**: Compatible with AWS Lambda, Google Cloud Functions, and Azure Functions to support serverless API deployment.
- **Easy Deployment Features**:
  - **One-Click Deployment**: Simplifies API deployment with a single click.
  - **Automated Scaling**: Scales applications dynamically based on usage.
  - **Rolling Updates**: Ensures smooth updates without downtime.

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

1. **Run this Command**:
  
   ```bash
   ./mvnw spring-boot:run
