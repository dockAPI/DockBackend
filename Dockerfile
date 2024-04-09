FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/DockApiBackend-0.0.1-SNAPSHOT.jar dockapi.jar
EXPOSE 8080
CMD ["java", "-jar", "dockapi.jar"]