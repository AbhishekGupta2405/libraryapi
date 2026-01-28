# In-Memory Library Management REST API
## 1. Project Title & Goal
In-Memory Library API – A Spring Boot REST API that allows users to add, retrieve, search, and delete books using in-memory storage without any database.

## 2. Setup Instructions

```bash
git clone https://github.com/AbhishekGupta2405/libraryapi.git
cd libraryapi
mvn spring-boot:run
```


## 3. The Logic (How I Thought)

### Why did I choose this approach?

The problem explicitly required in-memory storage, so I avoided databases like MySQL. I used a simple List<Book> to store data, which is suitable for small datasets. I chose Spring Boot because it allows rapid development of REST APIs with minimal configuration. Each API endpoint follows REST principles using proper HTTP methods (POST, GET, DELETE).

### What was the hardest bug I faced, and how did I fix it?

Initially, when retrieving a book by ID, I returned null if the book was not found. This resulted in unclear responses for the client.  
**Fix:** I fixed this by using ResponseEntity to return:  
HTTP 200 OK when the book exists  
HTTP 404 NOT FOUND with a meaningful error message when it does not exists  
This made the API more REST-compliant and user-friendly.

## 4. Output Screenshots

### Add Book (POST /books)
<img width="1101" height="608" alt="11" src="https://github.com/user-attachments/assets/904b1835-b0a0-4cd3-a96f-9e9c6f643dc0" />

### Get Book by ID (GET /books/{id})
<img width="1088" height="713" alt="z2" src="https://github.com/user-attachments/assets/2715761a-3d46-4d61-8a5a-b6b5f2c7334d" />

### Search Books by Year (GET /books/search?year=2024)
<img width="1081" height="705" alt="zimetrics" src="https://github.com/user-attachments/assets/38079233-77c4-485f-b74a-59d75fdf9e87" />

### Delete Book (DELETE /books/{id})
<img width="1085" height="705" alt="z4" src="https://github.com/user-attachments/assets/7e128905-bbfe-4100-a8c3-c680a974f986" />

Screenshots were taken using Postman while testing the API locally.

## 5. Future Improvements

### If I had 2 more days, I would:

- Integrate a database such as MySQL or PostgreSQL using Spring Data JPA to persist book data instead of in-memory storage
- Replace the List with a proper repository layer to support CRUD operations efficiently
- Add database constraints and validations to prevent duplicate book IDs and invalid data
- Implement global exception handling using @ControllerAdvice for consistent error responses
- Add JWT-based authentication and role-based authorization
- Add request validation and custom error handling
- Write unit and integration tests using JUnit and Mockito
- Add Docker support for containerized deployment
- Implement logging and monitoring
