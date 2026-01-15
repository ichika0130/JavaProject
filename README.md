# JavaProject
Final Project for University

### Technology Stack
Java 17 (Amazon Corretto / OpenJDK)

Spring Boot 3.2.1

Spring Data JPA & H2 Database (In-Memory)

MapStruct / Lombok (Data Mapping & Boilerplate)

SpringDoc OpenAPI (Swagger UI)

### Task 1: Basic REST Controller

A basic ProductController has been implemented.

A HashMap is used as temporary data storage for validation.

Basic POST and GET methods have been implemented.

So we run it and get into http://localhost:8080/greeting
You will see:
<img width="1085" height="964" alt="image" src="https://github.com/user-attachments/assets/9ad5b77c-95a8-4e94-9446-939ca45993b1" />

@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }
Through this part you can see that: I used @RequestParam to get the value after the URL"?", for example ?name=n-ubna
You will see:
<img width="1099" height="970" alt="image" src="https://github.com/user-attachments/assets/89ee74b4-f673-4cad-84b6-96d5ee0ad153" />


Let's go to the task2 then

###  Task 2: Advanced API Features & DB Integration

1. Layered Architecture Design

In Task 2, I implemented strict code layering to ensure separation of concerns:

Controller Layer: Handles HTTP requests, using `@PathVariable` and `@RequestBody` for RESTful resource location.

Service Layer: The core of business logic, handling data transformation and business rule validation.

Repository Layer: Based on Spring Data JPA, it implements basic CRUD persistence operations with zero code by inheriting the `JpaRepository` interface.

<img width="406" height="819" alt="image" src="https://github.com/user-attachments/assets/6e0aec69-65d9-4999-8597-91b404347cfe" />

2. Data Transfer Objects & Mapping (DTO & Mapping)

To protect internal entities from direct exposure to the frontend, I introduced the Request/Response pattern:

UpdateProductRequest: A dedicated data object for update operations, ensuring API security.

ProductResponse: A unified output model, formatting JSON data returned to the client.

Automated Mapping: Internally, object conversion is implemented manually (or in conjunction with a Mapper) through the Service layer, reflecting the norms of object-oriented design.

<img width="967" height="642" alt="image" src="https://github.com/user-attachments/assets/7b90a585-30a5-4d25-bf39-fa04029364aa" />
<img width="975" height="628" alt="image" src="https://github.com/user-attachments/assets/a240356f-34f3-4c4e-8c9c-c2df5931913a" />

3. Robust Exception Handling Mechanism (Global Exception Handling)

This is a major highlight of Task 2. Instead of directly throwing a 500 error, I implemented global exception interception:

<img width="772" height="146" alt="image" src="https://github.com/user-attachments/assets/bc012fa2-0e88-46f7-a826-911fc304f399" />


Custom Supplier: Common error logic (such as productNotFoundException(id)) is encapsulated using ProductExceptionSupplier.

Status Code Management: Combined with @ControllerAdvice, a precise 404 Not Found status code and user-friendly JSON error message are returned when a resource does not exist, improving the API user experience.

<img width="992" height="593" alt="image" src="https://github.com/user-attachments/assets/ea72127e-50ad-41a7-9d47-c071541be242" />


4. Persistence Layer and Database Integration (JPA & H2)

From Memory to Database: The original HashMap storage solution was migrated to an H2 in-memory database.
<img width="849" height="530" alt="image" src="https://github.com/user-attachments/assets/151e9c51-a98f-49a1-998b-f1c916ee71fc" />

Automatic Table Creation: Utilizing JPA's ddl-auto feature, the database table structure is automatically generated based on the Product entity class.

Debugging tools: The `/h2-console` console is enabled for convenient real-time monitoring of the database status. JDBC connection address: `jdbc:h2:mem:testdb`.
<img width="1898" height="924" alt="image" src="https://github.com/user-attachments/assets/cc0c8ea7-7e58-4abf-83db-092a7dd65709" />
<img width="1040" height="702" alt="image" src="https://github.com/user-attachments/assets/fd2921bb-53ca-42eb-a156-b6d4eeb1f9de" />

5. Automated API Documentation (Swagger/OpenAPI): Springdoc-openapi is integrated, achieving zero-maintenance documentation.

Access address: http://localhost:8080/swagger-ui/index.html
<img width="1861" height="924" alt="image" src="https://github.com/user-attachments/assets/5d4272da-ec3b-457a-b5eb-fe209a2fe478" />

Through Swagger UI, API smoke testing can be performed directly in the browser, greatly improving development and debugging efficiency.
<img width="1787" height="885" alt="image" src="https://github.com/user-attachments/assets/1d347d96-1dc8-4de1-a580-1b1e0ab8cca0" />

## Quick Start
1. Clone the repository.
2. Ensure you have **Java 17** installed.
3. Run the application: `./mvnw spring-boot:run`
4. Access **Swagger UI**: `http://localhost:8080/swagger-ui/index.html` to test all APIs.
5. Access **H2 Console**: `http://localhost:8080/console` (JDBC URL: `jdbc:h2:mem:testdb`) to view persistence data.

