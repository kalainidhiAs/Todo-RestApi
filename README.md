

Todo Management System

Description:
The Todo Management System is a RESTful API designed for managing tasks in a simple and efficient way. It allows users to create, read, update, and delete (CRUD) tasks. The application is built using **Spring Boot** and leverages **Hibernate/JPA** for database interaction, with **Lombok** annotations to reduce boilerplate code.

---

Key Features:
1. Task Management:
   - Create new tasks with a title.
   - Update the task title.
   - Mark tasks as completed or incompleted.
   - Delete tasks.

2. Filtering:
   - View all tasks.
   - Filter tasks based on their completion status (`completed` or `incompleted`).

3. Validation:
   - Ensures task data integrity using validation annotations (`@NotBlank`).

4. API Design:
   - RESTful endpoints for seamless integration with front-end applications.
   - Structured request and response handling with status codes.

5. Data Persistence:
   - Uses MySQL (or any relational database) for storing and managing tasks.
   - Spring Data JPA simplifies repository implementation.

6. Scalability:
   - Supports optional pagination and filtering for large datasets (can be extended).
   - Modular and extensible design for future enhancements.

---

Tech Stack:
- Backend: Spring Boot, Spring Data JPA, Hibernate
- Database: MySQL (or any other relational database)
- Validation: Jakarta Bean Validation
- Dependencies Management: Maven

Sample Endpoints:
1. Create Task:
   - `POST /todos`  
   - Body:  
     ```json
     { "task": "Learn Spring Boot" }
     ```

2. Retrieve All Tasks:
   - `GET /todos`

3. Retrieve Task by ID:  
   - `GET /todos/{id}`

4. Update Task:
   - `PUT /todos/{id}`  
   - Body:  
     ```json
     { "task": "Updated Task Title" }
     ```

5. Mark Task as Completed:  
   - `PUT /todos/{id}/mark_completed`

6. Delete Task:
   - `DELETE /todos/{id}`

This application demonstrates the implementation of a CRUD API, adhering to best practices in Spring Boot development.
