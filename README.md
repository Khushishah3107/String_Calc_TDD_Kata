# String Calculator TDD Kata

Welcome to the **String Calculator TDD Kata** project! This project is a simple string calculator developed using Test-Driven Development (TDD) principles.

## Project Description

The **String Calculator** is a simple application that performs basic arithmetic operations (addition, subtraction, multiplication, and division) on a string of comma-separated numbers. The project also handles custom delimiters, new lines between numbers, and throws exceptions for negative numbers and division by zero.

## Features

- **Addition, Subtraction, Multiplication, and Division** of numbers.
- Support for **custom delimiters**.
- Handling of **new lines** between numbers.
- **Exception handling** for negative numbers and division by zero.

## Prerequisites

- **Java Development Kit (JDK) 8** or higher
- **Apache Maven 3.6.3** or higher

## Project Structure

```plaintext
String_Calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               ├── calculatorDriver/
│   │               │   ├── Operation.java
│   │               │   └── StringCalculator.java
│   ├── test/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── StringCalculatorTest.java
├── pom.xml
└── README.md
