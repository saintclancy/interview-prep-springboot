# interview-prep-springboot

## Interview Prep Project 📘 
### Goal 🎯

- Practice building a Spring Boot REST API end-to-end with clean structure, common patterns, and extra polish for interviews.

### Project Skeleton 🏗️ 

- Initialize Spring Boot project (Maven/Gradle, Java 17+, Spring Boot starter web)

- Dependencies: Spring Web, Spring Data JPA, H2/MySQL, Lombok (optional), Validation

### Layers:

- Controller (API endpoints)

- Service (business logic)

- Repository (database)

- Model/Entity (data objects)

- DTO (input/output objects, optional for polish)

### Common Features to Practice 🔑

- CRUD endpoints (GET, POST, PUT, DELETE)

- Validation (e.g. @NotNull, @Size, @Valid)

- Error handling (@ControllerAdvice, ResponseEntity)

- Logging (SLF4J logger)

- Pagination/Sorting (if repo returns a list)

- Unit test example (JUnit + Mockito)

### Interview Flow Strategy 📋

1. Clarify requirements – ask what the service should do (CRUD? filtering? relationships?).

2. Outline solution – quickly sketch project layers or talk through approach.

3. Start coding skeleton – entity + repo → service → controller.

4. Add bells & whistles – validation, exception handling, pagination, etc.

5. Explain while coding – narrate your design choices simply.

### Quick Reference 📝

- @RestController, @Service, @Repository

- @Autowired / constructor injection

- @Entity, @Id, @GeneratedValue

- JpaRepository<Entity, Long>

- @GetMapping, @PostMapping, etc.

- ResponseEntity<?> for flexibility

### Extra Credit (if time) 🚀

- Swagger/OpenAPI docs

- H2 in-memory DB for demo

- Dockerfile for containerization
