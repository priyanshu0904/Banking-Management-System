Banking Management System

A console-based Banking Management System developed in Java to demonstrate practical implementation of Object-Oriented Programming, Collections, Exception Handling, Generics, Functional Interfaces, Lambda Expressions, Layered Architecture, Validation, and Repository-Service design.

---

Features

- Create a new bank account
- Deposit money
- Withdraw money
- Transfer money between accounts
- View account statement
- List all accounts
- Search accounts by customer name
- Generate unique customer and account IDs
- Validate user input
- Custom exception handling
- Transaction tracking
- Layered application architecture

---

Tech Stack

Technology| Usage
Java| Core application development
Java Collections| In-memory data storage
Generics| Type-safe validation and repositories
Lambda Expressions| Functional validation
Custom Exceptions| Application error handling
Git & GitHub| Version control

---

Java Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Inheritance
- Interfaces
- Polymorphism
- Enums
- Constructors
- Access Modifiers
- "static"
- "final"
- Exception Handling
- Custom Exceptions
- Generics
- Functional Interfaces
- Lambda Expressions
- Method References
- Collections
- Streams
- UUID
- Layered Architecture
- Repository Pattern
- Service Layer
- Input Validation

---

Architecture

flowchart TD
    A[User] --> B[Main / Console UI]

    B --> C[BankService]

    C --> D[BankServiceImpl]

    D --> E[CustomerRepository]
    D --> F[AccountRepository]
    D --> G[TransactionRepository]

    E --> H[(Customer Data)]
    F --> I[(Account Data)]
    G --> J[(Transaction Data)]

    D --> K[Validation]
    D --> L[Custom Exceptions]

The application follows a simple layered architecture where each layer has a specific responsibility.

---

Layer Responsibilities

1. Presentation Layer

Responsible for interacting with the user through the console.

Main.java

Responsibilities:

- Display menu
- Read user input
- Call service methods
- Display results
- Handle user interaction

---

2. Service Layer

Contains the main business logic.

BankService.java
BankServiceImpl.java

Responsibilities:

- Open accounts
- Deposit money
- Withdraw money
- Transfer money
- Search accounts
- Generate statements
- Perform business validations
- Create transactions

---

3. Repository Layer

Responsible for storing and retrieving application data.

CustomerRepository.java
AccountRepository.java
TransactionRepository.java

Responsibilities:

- Save customers
- Find customers
- Save accounts
- Find accounts
- Store transactions
- Retrieve account information

---

4. Domain Layer

Contains the main entities used by the banking system.

Customer.java
Account.java
Transaction.java
Type.java

These classes represent the core banking data.

---

5. Validation Layer

The project uses a generic functional interface for reusable validation.

@FunctionalInterface
public interface Validation<T> {
    void validate(T value) throws ValidationException;
}

Example:

Validation<Double> validateAmount = amount -> {
    if (amount == null || amount < 0) {
        throw new ValidationException("Please enter a valid amount");
    }
};

This allows different types of values to be validated using the same interface.

---

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
└── README.md

---

Core Banking Operations

Open Account

The user provides:

- Customer name
- Email
- Account type
- Initial deposit

The system then:

1. Validates customer information.
2. Creates a customer.
3. Generates a customer ID.
4. Generates an account number.
5. Creates the account.
6. Stores the account.
7. Optionally records the initial deposit.

---

Deposit

The deposit operation:

1. Validates the amount.
2. Finds the account.
3. Updates the account balance.
4. Creates a deposit transaction.

---

Withdraw

The withdrawal operation:

1. Validates the amount.
2. Finds the account.
3. Checks available balance.
4. Deducts the amount.
5. Creates a withdrawal transaction.

If the balance is insufficient, an appropriate custom exception is thrown.

---

Transfer

The transfer operation moves money between two accounts.

Sender Account
      │
      │ Withdraw
      ▼
   Balance
      │
      │ Deposit
      ▼
Receiver Account

The system validates the transfer amount and ensures that the sender has sufficient funds.

---

Account Statement

The account statement displays the transaction history associated with an account.

Example:

Account Statement
-------------------------
Account Number : ACC123
Customer       : John Doe
Balance        : 25000.00

Transactions
-------------------------
DEPOSIT     +10000.00
WITHDRAW     -2000.00
DEPOSIT      +5000.00
TRANSFER     -3000.00

---

Validation

The project uses reusable validation logic instead of writing the same validation code repeatedly.

Examples of validated values:

- Customer name
- Email
- Account type
- Transaction amount

Account types are restricted to valid values such as:

SAVINGS
CURRENT

Invalid input results in a custom "ValidationException".

---

Exception Handling

The application uses custom exceptions to represent application-specific errors.

Examples:

AccountNotFoundException
ValidationException
InsufficientBalanceException

Example:

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}

The "super(message)" call passes the error message to the parent "RuntimeException" class.

---

Application Flow

flowchart TD
    A[Start Application] --> B[Display Banking Menu]

    B --> C{Select Operation}

    C -->|Open Account| D[Validate Customer Details]
    D --> E[Create Customer]
    E --> F[Create Account]
    F --> B

    C -->|Deposit| G[Validate Amount]
    G --> H[Find Account]
    H --> I[Update Balance]
    I --> J[Create Transaction]
    J --> B

    C -->|Withdraw| K[Validate Amount]
    K --> L[Check Account]
    L --> M{Sufficient Balance?}
    M -->|Yes| N[Update Balance]
    N --> O[Create Transaction]
    O --> B
    M -->|No| P[Throw Exception]
    P --> B

    C -->|Transfer| Q[Validate Transfer]
    Q --> R[Withdraw From Sender]
    R --> S[Deposit To Receiver]
    S --> T[Create Transactions]
    T --> B

    C -->|Statement| U[Retrieve Transactions]
    U --> B

    C -->|List Accounts| V[Retrieve Accounts]
    V --> B

    C -->|Search Customer| W[Search Customer]
    W --> B

    C -->|Exit| X[End Application]

---

Console Menu

The application provides operations similar to:

1. Open Account
2. Deposit
3. Withdraw
4. Transfer
5. Account Statement
6. List Accounts
7. Search Account
0. Exit

---

Data Storage

The current application uses in-memory storage through Java Collections and repository classes.

This means the data exists only while the application is running.

A future version can replace the repository implementation with a database without significantly changing the service layer.

Possible future databases:

- MySQL
- PostgreSQL
- Oracle

---

How to Run

1. Clone the Repository

git clone https://github.com/priyanshu0904/Banking-Management-System.git

2. Open the Project

Open the project in an IDE such as IntelliJ IDEA.

3. Configure Java

Use a modern JDK compatible with the project.

4. Run

Run:

Main.java

The banking menu will appear in the console.

---

Future Improvements

The project can be extended with:

- Database integration using JDBC
- MySQL/PostgreSQL
- Maven or Gradle
- Spring Boot REST API
- Spring Data JPA
- Spring Security
- JWT Authentication
- User registration and login
- Role-based authorization
- Persistent transaction history
- RESTful APIs
- Unit testing with JUnit
- Mockito
- Logging
- Docker
- CI/CD
- Frontend application
- Cloud deployment

---

Learning Objective

This project was created to move from learning individual Java concepts to applying them together in a real-world style application.

It demonstrates how concepts such as:

Core Java
   ↓
OOP
   ↓
Collections
   ↓
Generics
   ↓
Functional Programming
   ↓
Exception Handling
   ↓
Validation
   ↓
Repository Layer
   ↓
Service Layer
   ↓
Application

can work together to build a structured Java application.

---

Project Status

Completed — Console-based Banking Management System

The project is intentionally built with core Java concepts and is suitable for further evolution toward a Spring Boot backend application.

---

Author

Priyanshu

Software Developer | Java Backend | DSA | UI Design

---

License

This project is available for educational and learning purposes.