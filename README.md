# 1. Project Title & Goal
In-Memory Library API – A Spring Boot REST API that allows users to add, retrieve, search, and delete books using in-memory storage without any database.

# 2. Setup Instructions
Follow these steps to run the project locally:

Step 1: Clone the repository
git clone <your-github-repo-link>

Step 2: Navigate to the project directory
cd libraryapi

Step 3: Run the Spring Boot application
mvn spring-boot:run

The application will start on:
http://localhost:8080

# 3. The Logic (How I Thought)

### Why did I choose this approach?

The problem explicitly required in-memory storage, so I avoided databases like MySQL.

I used a simple List<Book> to store data, which is suitable for small datasets.

Spring Boot  was chosen because it allows rapid development of REST APIs with minimal configuration.

Each API endpoint follows REST principles using proper HTTP methods (POST, GET, DELETE).

### What was the hardest bug I faced, and how did I fix it?

Initially, when retrieving a book by ID, I returned null if the book was not found.

This resulted in unclear responses for the client.

I fixed this by using ResponseEntity to return:

HTTP 200 OK when the book exists

HTTP 404 NOT FOUND with a meaningful error message when it does not

This made the API more REST-compliant and user-friendly.

# 4. Output Screenshots

<img width="1101" height="608" alt="11" src="https://github.com/user-attachments/assets/904b1835-b0a0-4cd3-a96f-9e9c6f643dc0" />
<img width="1088" height="713" alt="z2" src="https://github.com/user-attachments/assets/2715761a-3d46-4d61-8a5a-b6b5f2c7334d" />
<img width="1081" height="705" alt="zimetrics" src="https://github.com/user-attachments/assets/38079233-77c4-485f-b74a-59d75fdf9e87" />
<img width="1085" height="705" alt="z4" src="https://github.com/user-attachments/assets/7e128905-bbfe-4100-a8c3-c680a974f986" />

Screenshots were taken using Postman while testing the API locally.

# 5. Future Improvements

If I had 2 more days, I would:

Integrate a database such as MySQL instead of in-memory storage

Replace the List with a proper repository layer to support CRUD operations efficiently

Add database constraints and validations to prevent duplicate book IDs and invalid data

Implement global exception handling using @ControllerAdvice for consistent error responses

Add Swagger/OpenAPI documentation to make the API self-describing and easier to test

Write unit and integration tests using JUnit and Mockito
