# API Automation Framework – Rest Assured + TestNG

This project demonstrates a scalable API automation framework built using **Java, Rest Assured, TestNG, and Maven**.

The framework follows a **service-based layered architecture** with reusable request configuration, POJO-based payload modeling, schema validation, logging, and grouped execution through TestNG.

## Key Highlights

- Service-based API automation framework
- Reusable BaseService with common RequestSpecification
- UserService for domain-specific API operations
- POJO request/response models for serialization/deserialization
- JSON schema validation for API contract verification
- Test data builder for reusable payload generation
- Response validators to avoid duplicate assertions
- Logging for request and response debugging
- Positive and negative API test coverage
- TestNG suite execution using `testng.xml`

## Tech Stack

- Java 11
- Maven
- Rest Assured
- TestNG
- Jackson
- JSON Schema Validator

## Project Structure

```text
src
├── main
│   └── java
│       └── com.api
│           ├── endpoints
│           │   └── ApiRoutes.java
│           ├── services
│           │   ├── BaseService.java
│           │   └── UserService.java
│           ├── pojo
│           │   ├── request
│           │   └── response
│           └── utils
│
└── test
    ├── java
    │   └── com.api
    │       ├── tests
    │       ├── utils
    │       └── testdata
    └── resources
        └── schemas
