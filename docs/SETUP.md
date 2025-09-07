# Setup (local dev)

1. Ensure JDK 17 is installed.
2. From repo root:
   ./mvnw clean package
   ./mvnw spring-boot:run
3. App will run on http://localhost:8080 by default.
4. Example curl:
   curl -X GET http://localhost:8080/actuator/health