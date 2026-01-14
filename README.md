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

Task 2.B (Swagger UI): Integrates springdoc-openapi; automated documentation can be viewed at http://localhost:8080/swagger-ui/index.html.

Task 2.C/E (CRUD Operations): Implements complete CRUD logic.

Task 2.D (Exception Handling): Uses @ControllerAdvice and a custom ProductExceptionSupplier to uniformly handle exceptions such as 404 Not Found, avoiding ugly 500 errors.

Task 2.G (JPA & H2): Migrates in-memory storage to an H2 Database and performs persistence operations using Spring Data JPA.


