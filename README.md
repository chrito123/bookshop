# Book Pricing API

## Overview

The **Book Pricing API** is a Spring Boot-based web application designed to calculate the total price of a basket of books with discounts applied. The application is built with Java 21, uses Gradle as its build system, and leverages OpenAPI 3.0 for API documentation. It follows a TDD approach to ensure robust and maintainable code.

## Features

- **Calculate Price:**  
  Computes the total price for a basket of books with discount rules applied for different groups of distinct titles.
  
- **REST API:**  
  Exposes a POST endpoint to calculate the price of the basket.

- **OpenAPI Documentation:**  
  The API is documented using an OpenAPI YAML file. Interactive documentation is available via Swagger UI.

- **Global Error Handling:**  
  Provides standardized error responses using a global `ErrorResponse` DTO.

## Technologies Used

- **Java 21**
- **Spring Boot 3.1.1**
- **Gradle** (with Gradle wrapper)
- **springdoc-openapi-starter-webmvc-ui** for interactive API documentation

## Installation

### Prerequisites

- **Java 21**  
- **Gradle** (or use the provided Gradle wrapper)
- **Git**

### Clone the Repository

```
git clone https://github.com/chrito123/bookshop
cd bookshop
```

### Build the Project

Use the Gradle wrapper to build the project:

```
./gradlew build
```

## Running the Application

Start the application with:

```
./gradlew bootRun
```

The application will start on port **8080** by default. You can access the Swagger UI documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

## API Usage

### Endpoint: Calculate Price

- **URL:** `/api/books/calculate-price`
- **Method:** `POST`
- **Request Body:**


 ```json
  {
    "basket": {
      "Clean Code": 2,
      "The Clean Coder": 2,
      "Clean Architecture": 2,
      "Test Driven Development by Example": 1,
      "Working Effectively With Legacy Code": 1
    }
  }
  ```

- **Response:**  
  Returns a number representing the calculated price.

### Error Responses

In case of errors, the API returns a standardized JSON error response. For example:

```
{
  "status": 400,
  "error": "Bad Request",
  "message": "Basket is empty."
}
```


## Contact

For questions or feedback, please contact Sanchez Christian at christian.sanchezvillagomez@capgemini.com.
