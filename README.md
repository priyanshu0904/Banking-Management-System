# Banking Management System

A console-based Banking Management System built with Java to practice and demonstrate core Java, object-oriented programming, layered application design, validation, exception handling, collections, and transaction management.

The application provides basic banking operations such as creating accounts, depositing and withdrawing money, transferring funds, viewing transaction statements, listing accounts, and searching accounts by customer name.

## Features

- Create a new customer and bank account
- Support for `SAVINGS` and `CURRENT` account types
- Generate unique customer IDs and account numbers
- Deposit money into an account
- Withdraw money with insufficient-balance validation
- Transfer money between accounts
- Prevent transfers to the same account
- Maintain transaction records
- View account transaction statements
- List all accounts
- Search accounts by customer name
- Validate customer name, email, account type, and transaction amounts
- Custom exception handling for invalid operations
- In-memory data storage using repository classes

## Tech Stack

- **Language:** Java
- **Interface:** Console / Command Line
- **Version Control:** Git & GitHub

## Java Concepts Demonstrated

This project was designed to apply practical Java concepts rather than only learning them individually.

### Object-Oriented Programming

- Classes and objects
- Encapsulation
- Interfaces
- Inheritance
- Polymorphism
- Constructors
- Method overriding

### Collections

- `List`
- `ArrayList`
- Collection searching
- Sorting with `Comparator`
- Stream API

### Functional Programming

- Functional interfaces
- Lambda expressions
- Method references
- Stream operations

### Exception Handling

The project uses custom exceptions for business-level errors, including:

- `ValidationException`
- `AccountNotFoundException`
- `InsufficientFundsException`
- `SameAccountTransferException`

### Other Java Features

- Generics
- `Optional`
- `UUID`
- `LocalDateTime`
- String formatting
- Input handling with `Scanner`

## Application Architecture

The project follows a simple layered architecture to keep responsibilities separated.

```text
┌──────────────────────────────┐
│          Console UI          │
│            Main              │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        Service Layer         │
│       BankServiceImpl        │
│                              │
│  Business Logic & Validation │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│       Repository Layer       │
│                              │
│ AccountRepository            │
│ CustomerRepository           │
│ TransactionRepository        │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         Domain Layer         │
│                              │
│ Customer                     │
│ Account                      │
│ Transaction                  │
└──────────────────────────────┘