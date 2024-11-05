
# Quiz App - Microservices 
Before diving into this project, recently I've done same project implemented using monolithic architecture application with new github repository : https://github.com/bsainath99/quizApp-monolithic.git

In this project, I have implemented quiz application using Microservices architecture.

Same as monolithic application, but the code is in 2 different projects, with main objective of **LOOSE COUPLING**.
For this, we use EUREKA SERVER configuration. And all **@EnableFeignClients** annotations in both  main application classes of Question and Quiz services.

And within the Quiz Service, in feign package, please check out **/QuizInterface.java** file whihc is used to connect the both services.

In general, when we say Quiz, a user will get a set of questions whihc are of MCQ type and then based on what we choose, we get a score based on correct answers provided by user.

  To achive that we need set of questions for attemptng the quiz in database say ike 10-15. So, I've used PostgreSQL database for string the questions and other stuff. 
  
   And then, we have a spring boot application. We need to do CRUD operations with Questions. 

 We need multiple layers for getting questions from DB like: 
User --> Controller --> Service --> DAO / Repository.

Repeat the same steps for Quiz as well.


Apart from those 2 services, we have to create Service Registry application to enable the **EUREKA SERVER** using **@EnableEurekaServer** annotation in the main application class.

## Features

- CRUD Operations: for both Question and Quiz Services
- PostgreSQL Database: Used PostgreSQL for data storage, with Spring Data JPA for ORM.
- Postman : Used Postman to test every end point 


## Tech Stack

- Java: Programming language for building the application.
- PostgreSQL: Relational database management system for data persistence.
- Spring Boot: Framework for creating the RESTful API.
- Postman: Tool for testing the API endpoints.

## API Endpoints
### **QUESTION SERVICE**

### Base URL: `/question`

#### **CREATE**

- **POST** `/question/add`
  - **Description**: Add a new question to the system.
  - **Request Body**: `Question` (JSON)
  - **Example Request**:
    ```json
    {
      "id": 1,
      "category": "Science",
      "questionText": "What is the speed of light?"
    }
    ```
  - **Response**: A string indicating the success or failure of the addition.
  
---

#### **READ**

- **GET** `/question/allQuestions`
  - **Description**: Retrieve all questions available in the system.
  - **Request Body**: None
  - **Response**: List of `Question` objects in JSON format.
  - **Example Response**:
    ```json
    [
      {
        "id": 1,
        "category": "Science",
        "questionText": "What is the speed of light?"
      },
      {
        "id": 2,
        "category": "Math",
        "questionText": "What is 2+2?"
      }
    ]
    ```

- **GET** `/question/category/{cat}`
  - **Description**: Retrieve questions based on their category.
  - **Path Variable**: `cat` (String) - The category of the questions.
  - **Request Body**: None
  - **Response**: List of `Question` objects in JSON format filtered by the category.
  - **Example Request**: `/question/category/Science`
  - **Example Response**:
    ```json
    [
      {
        "id": 1,
        "category": "Science",
        "questionText": "What is the speed of light?"
      }
    ]
    ```

---

#### **DELETE** 

- **DELETE** `/question/delete`
  - **Description**: Delete a question from the system.
  - **Request Body**: `Question` (JSON)
  - **Response**: A string indicating the success or failure of the deletion.

---

### Notes:
- `Question`: Replace with your actual `Question` model structure.
- Ensure to uncomment the delete method and implement it as necessary if you plan to support deletion.

### **QUIZ SERVICE**

### Base URL: `/quiz`

#### **CREATE**

- **POST** `/quiz/create`
  - **Description**: Create a new quiz by specifying category, number of questions, and title.
  - **Request Parameters**:
    - `category` (String): The category of the quiz.
    - `numQ` (int): Number of questions in the quiz.
    - `title` (String): Title of the quiz.
  - **Request Body**: None (uses query parameters).
  - **Response**: A string indicating the success or failure of the quiz creation.
  - **Example Request**: `/quiz/create?category=Science&numQ=5&title=Science%20Quiz`
  - **Example Response**:
    ```json
    {
      "message": "Quiz created successfully"
    }
    ```

---

#### **READ**

- **GET** `/quiz/get/{id}`
  - **Description**: Retrieve quiz questions by quiz ID.
  - **Path Variable**: 
    - `id` (Integer): The ID of the quiz.
  - **Request Body**: None
  - **Response**: List of `QuestionWrapper` objects in JSON format, containing the quiz questions.
  - **Example Request**: `/quiz/get/1`
  - **Example Response**:
    ```json
    [
      {
        "questionId": 1,
        "questionText": "What is the speed of light?",
        "options": ["300,000 km/s", "150,000 km/s", "500,000 km/s"]
      },
      {
        "questionId": 2,
        "questionText": "What is 2+2?",
        "options": ["3", "4", "5"]
      }
    ]
    ```

---

#### **SUBMIT**

- **POST** `/quiz/submit/{id}`
  - **Description**: Submit answers for a quiz and calculate the result.
  - **Path Variable**: 
    - `id` (Integer): The ID of the quiz.
  - **Request Body**: A list of `Response` objects in JSON format, containing the user's answers.
  - **Response**: Integer value representing the score/result of the quiz.
  - **Example Request**:
    ```json
    [
      {
        "questionId": 1,
        "answer": "300,000 km/s"
      },
      {
        "questionId": 2,
        "answer": "4"
      }
    ]
    ```
  - **Example Response**:
    ```json
    {
      "score": 2
    }
    ```

---

### Notes:
- Replace `QuestionWrapper` and `Response` with the actual structure of your model if necessary.
- Ensure your request body matches the expected format based on your model.


## Getting Started
### Prerequisites

- Java 11 or higher
- PostgreSQL
- Maven
- Spring 
### Installation
- Clone the repository: git clone https://github.com/bsainath99/quizApp-monolithic.git
- Navigate to the project directory: cd quizApp-monolithic
- Set up the PostgreSQL database and configure your application.properties file with the database credentials.
- Run the application: go to main() file, clikc Run As --> Spring Boot application
- Testing You can test the API endpoints using Postman or any API client of your choice.
- Ensure you have the necessary authorization headers when making requests to secure endpoints.

The main objective of this project is how a microservices architecture application looks like, how it wokrs and internal work-flow of application is show-cased here.
As mentioned in beginning, the same project has been implemented using monolithic application with new repo : **https://github.com/bsainath99/quizApp-monolithic.git**
