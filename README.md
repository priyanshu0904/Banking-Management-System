# Banking Management System

A console-based Banking Management System built using Java to demonstrate practical Core Java, Object-Oriented Programming, Collections, Generics, Functional Programming, Exception Handling, Validation, and layered architecture.

## Features

- Create a new bank account
- Deposit money
- Withdraw money
- Transfer money between accounts
- View account statement
- List all accounts
- Search accounts by customer name
- Input validation
- Custom exception handling
- Transaction tracking
- Unique customer and account ID generation
- Layered architecture
- Repository-based data management

## Tech Stack

| Technology | Usage |
|---|---|
| Java | Application development |
| Java Collections | In-memory data storage |
| Generics | Type-safe programming |
| Lambda Expressions | Functional validation |
| Functional Interfaces | Reusable validation |
| Custom Exceptions | Error handling |
| Git & GitHub | Version control |
| IntelliJ IDEA | Development environment |

## Java Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces
- Enums
- Constructors
- Access Modifiers
- `static`
- `final`
- Exception Handling
- Custom Exceptions
- Generics
- Functional Interfaces
- Lambda Expressions
- Method References
- Collections
- Streams
- UUID
- Input Validation
- Repository Pattern
- Service Layer

## Architecture

````mermaid
flowchart LR
    U([User])

    subgraph Presentation["Presentation Layer"]
        M[Main]
    end

    subgraph Service["Service Layer"]
        BS[BankService]
        BSI[BankServiceImpl]
    end

    subgraph Repository["Repository Layer"]
        CR[CustomerRepository]
        AR[AccountRepository]
        TR[TransactionRepository]
    end

    subgraph Model["Model Layer"]
        C[Customer]
        A[Account]
        T[Transaction]
        TY[Type]
    end

    subgraph Utility["Utility Layer"]
        V[Validation]
    end

    subgraph Exception["Exception Layer"]
        E[Custom Exceptions]
    end

    U --> M
    M --> BS
    BS --> BSI

    BSI --> CR
    BSI --> AR
    BSI --> TR

    CR --> C
    AR --> A
    TR --> T
    T --> TY

    BSI --> V
    BSI --> E

Project Structure

Banking-Management-System/
│
├── src/
│   │
│   ├── exceptions/
│   │   ├── AccountNotFoundException.java
│   │   ├── InsufficientBalanceException.java
│   │   ├── ValidationException.java
│   │   └── ...
│   │
│   ├── model/
│   │   ├── Account.java
│   │   ├── Customer.java
│   │   ├── Transaction.java
│   │   └── Type.java
│   │
│   ├── repository/
│   │   ├── AccountRepository.java
│   │   ├── CustomerRepository.java
│   │   └── TransactionRepository.java
│   │
│   ├── service/
│   │   ├── BankService.java
│   │   └── BankServiceImpl.java
│   │
│   ├── util/
│   │   └── Validation.java
│   │
│   └── Main.java
│
├── .gitignore
└── README.md

Architecture Layers

Presentation Layer

The presentation layer is responsible for interacting with the user through the console.

Main class:

Main.java

Responsibilities:

- Display the banking menu
- Read user input
- Call service methods
- Display results
- Handle console interaction

Service Layer

The service layer contains the main business logic of the application.

Classes:

BankService.java
BankServiceImpl.java

Responsibilities:

- Open accounts
- Deposit money
- Withdraw money
- Transfer money
- Search accounts
- Generate account statements
- Apply business rules
- Validate operations
- Create transactions

Repository Layer

The repository layer manages data storage and retrieval.

Repositories:

CustomerRepository.java
AccountRepository.java
TransactionRepository.java

Responsibilities:

- Store customers
- Find customers
- Store accounts
- Find accounts
- Store transactions
- Retrieve transaction history

Model Layer

The model layer contains the core entities of the banking system.

Models:

Customer.java
Account.java
Transaction.java
Type.java

Utility Layer

The utility layer contains reusable utility components.

Utility:

Validation.java

Exception Layer

Contains custom exceptions used to represent application-specific errors.

Examples:

AccountNotFoundException
InsufficientBalanceException
ValidationException

Validation

The project uses a generic functional interface to create reusable validation logic.

@FunctionalInterface
public interface Validation<T> {

    void validate(T value) throws ValidationException;
}

Amount Validation

Validation<Double> validateAmount = amount -> {

    if (amount == null || amount < 0) {
        throw new ValidationException("Please enter a valid amount");
    }
};

Account Type Validation

Valid account types are:

SAVINGS
CURRENT

Invalid account types result in a "ValidationException".

Exception Handling

The application uses custom exceptions to handle application-specific failures.

AccountNotFoundException

Used when an account cannot be found.

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

The "super(message)" call passes the message to the parent "RuntimeException" class.

ValidationException

Used when user-provided data does not satisfy the required validation rules.

InsufficientBalanceException

Used when an account does not have enough balance to perform a withdrawal or transfer.

Core Banking Operations

Open Account

The account creation process follows these steps:

1. Receive customer name.
2. Receive email.
3. Receive account type.
4. Validate customer information.
5. Create customer.
6. Generate customer ID.
7. Generate account number.
8. Create account.
9. Store account.
10. Process initial deposit if provided.

Deposit

The deposit operation:

1. Validates the amount.
2. Finds the account.
3. Updates the account balance.
4. Creates a transaction record.

Withdraw

The withdrawal operation:

1. Validates the amount.
2. Finds the account.
3. Checks the available balance.
4. Updates the balance.
5. Creates a withdrawal transaction.

If sufficient balance is not available, an "InsufficientBalanceException" is thrown.

Transfer

The transfer operation moves money from one account to another.

Sender Account
      │
      ▼
Withdraw Amount
      │
      ▼
Check Balance
      │
      ▼
Deposit Amount
      │
      ▼
Receiver Account

The operation involves:

1. Validate transfer amount.
2. Find sender account.
3. Find receiver account.
4. Check sender balance.
5. Withdraw from sender.
6. Deposit into receiver.
7. Record transaction information.

Account Statement

The statement displays the account's transaction history.

Example:

Account Statement
--------------------------------
Account Number : ACC123
Customer       : John Doe
Balance        : 25000.00

Transactions
--------------------------------
DEPOSIT        +10000.00
WITHDRAW        -2000.00
DEPOSIT         +5000.00
TRANSFER        -3000.00

List Accounts

Displays all accounts currently available in the system.

Search Accounts

Allows users to search for accounts using customer information such as customer name.

Application Flow

flowchart TD
    START([Start Application]) --> MENU[Display Menu]

    MENU --> CHOICE{Choose Operation}

    CHOICE -->|Open Account| OPEN[Enter Customer Details]
    OPEN --> VALIDATE1[Validate Details]
    VALIDATE1 --> CUSTOMER[Create Customer]
    CUSTOMER --> ACCOUNT[Create Account]
    ACCOUNT --> INITIAL{Initial Deposit?}
    INITIAL -->|Yes| DEPOSIT1[Process Initial Deposit]
    INITIAL -->|No| MENU
    DEPOSIT1 --> MENU

    CHOICE -->|Deposit| VALIDATE2[Validate Amount]
    VALIDATE2 --> FIND1[Find Account]
    FIND1 --> BALANCE1[Update Balance]
    BALANCE1 --> TRANSACTION1[Create Transaction]
    TRANSACTION1 --> MENU

    CHOICE -->|Withdraw| VALIDATE3[Validate Amount]
    VALIDATE3 --> FIND2[Find Account]
    FIND2 --> CHECK{Sufficient Balance?}
    CHECK -->|Yes| BALANCE2[Update Balance]
    BALANCE2 --> TRANSACTION2[Create Transaction]
    TRANSACTION2 --> MENU
    CHECK -->|No| ERROR1[Throw Exception]
    ERROR1 --> MENU

    CHOICE -->|Transfer| VALIDATE4[Validate Amount]
    VALIDATE4 --> FIND3[Find Sender]
    FIND3 --> FIND4[Find Receiver]
    FIND4 --> CHECK2{Sufficient Balance?}
    CHECK2 -->|Yes| WITHDRAW[Withdraw From Sender]
    WITHDRAW --> DEPOSIT2[Deposit To Receiver]
    DEPOSIT2 --> TRANSACTION3[Create Transactions]
    TRANSACTION3 --> MENU
    CHECK2 -->|No| ERROR2[Throw Exception]
    ERROR2 --> MENU

    CHOICE -->|Statement| STATEMENT[Find Account Transactions]
    STATEMENT --> DISPLAY1[Display Statement]
    DISPLAY1 --> MENU

    CHOICE -->|List Accounts| LIST[Retrieve All Accounts]
    LIST --> DISPLAY2[Display Accounts]
    DISPLAY2 --> MENU

    CHOICE -->|Search Account| SEARCH[Search Customer]
    SEARCH --> DISPLAY3[Display Results]
    DISPLAY3 --> MENU

    CHOICE -->|Exit| END([End Application])

Console Menu

========================================
       BANKING MANAGEMENT SYSTEM
========================================

1. Open Account
2. Deposit
3. Withdraw
4. Transfer
5. Account Statement
6. List Accounts
7. Search Account
0. Exit

========================================

Data Storage

The current implementation uses Java Collections and repository classes for in-memory data storage.

Application
     │
     ▼
Repository
     │
     ▼
Java Collections
     │
     ├── Customers
     ├── Accounts
     └── Transactions

The data exists only while the application is running.

The repository-based design makes it possible to replace the in-memory storage with a database in the future without significantly changing the business logic.

Future Improvements

Database

- JDBC
- MySQL
- PostgreSQL
- Database transactions
- Connection pooling

Backend

- Spring Framework
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs

Security

- Spring Security
- JWT Authentication
- Role-based authorization
- Password encryption

Testing

- JUnit
- Mockito
- Integration testing

DevOps

- Maven / Gradle
- Docker
- CI/CD
- Linux
- Cloud deployment
- Logging and monitoring

Frontend

The console application can later be converted into a full-stack application with a web-based frontend.

Learning Objective

The main objective of this project is to understand how individual Java concepts can be combined to build a structured application.

Core Java
     │
     ▼
Object-Oriented Programming
     │
     ▼
Collections & Generics
     │
     ▼
Functional Programming
     │
     ▼
Exception Handling
     │
     ▼
Validation
     │
     ▼
Repository Pattern
     │
     ▼
Service Layer
     │
     ▼
Banking Application

Future Architecture

The current Core Java application can evolve into a production-style Java backend.

flowchart LR
    CLIENT[Client / Frontend] --> API[REST API]

    API --> SPRING[Spring Boot]

    SPRING --> SECURITY[Spring Security]
    SPRING --> SERVICE[Service Layer]
    SERVICE --> JPA[Spring Data JPA]
    JPA --> HIBERNATE[Hibernate]
    HIBERNATE --> DB[(PostgreSQL / MySQL)]

    SPRING --> KAFKA[Apache Kafka]
    SPRING --> CACHE[Redis]
    SPRING --> LOGGING[Logging & Monitoring]

    SPRING --> DOCKER[Docker]
    DOCKER --> CLOUD[Cloud Deployment]

Project Status

Completed

This project currently implements the core banking functionality using Java and in-memory storage.

It is designed as a foundation for progressing toward a complete Java backend application using Spring Boot, databases, REST APIs, security, testing, Docker, and cloud technologies.

How to Run

Clone the Repository

git clone https://github.com/priyanshu0904/Banking-Management-System.git

Open the Project

Open the cloned project in IntelliJ IDEA or another Java IDE.

Run the Application

Run:

src/Main.java

The Banking Management System menu will appear in the console.

Author

Priyanshu

Software Developer | Java Backend | DSA | UI Design

License

This project is created for educational and learning purposes.