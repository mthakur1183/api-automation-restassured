# API Automation Framework - Rest Assured + TestNG

This project is a service-based API automation framework built using **Java**, **Rest Assured**, **TestNG**, and **Maven**.  
It demonstrates a scalable and maintainable design for testing REST APIs using layered architecture, reusable services, POJO-based request/response models, schema validation, logging, and grouped execution through TestNG.

## Features

- Service-based framework design
- Reusable `BaseService` with common request configuration
- `UserService` for domain-specific API operations
- Request and response POJOs for serialization/deserialization
- Reusable response validation utilities
- Test data builder for request payload creation
- JSON schema validation for API contract checks
- Request and response logging
- Positive and negative test coverage
- Test grouping and suite execution using `testng.xml`

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