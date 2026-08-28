# Bank Management System

A console-based Bank Management System developed using Java and Object-Oriented Programming principles. The application provides account management, banking operations, transaction tracking, file-based data persistence, input validation, and custom exception handling.

## Features

* Create Savings and Current accounts
* Secure account login
* Deposit money
* Withdraw money
* Transfer money between accounts
* Check account balance
* View transaction history
* Change account password
* Input validation
* Custom exception handling
* Persistent account data
* Persistent transaction history

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework
* Exception Handling
* File Handling
* Java I/O
* Git & GitHub

## Project Structure

```text
BankManagementSystem/
│
├── src/
│   └── bank/
│       ├── Main.java
│       ├── Bank.java
│       ├── Account.java
│       ├── SavingsAccount.java
│       ├── CurrentAccount.java
│       ├── Customer.java
│       ├── Transaction.java
│       ├── TransactionType.java
│       ├── BankingOperations.java
│       ├── FileManager.java
│       ├── Utils.java
│       │
│       └── exception/
│           ├── InvalidAmountException.java
│           ├── InvalidAccountException.java
│           └── InsufficientBalanceException.java
│
├── data/
│   ├── accounts.txt
│   └── transactions.txt
│
├── .gitignore
└── README.md
```

## OOP Concepts Implemented

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Interfaces
* Constructors
* Method Overriding

## Exception Handling

The application uses custom exceptions for handling banking errors:

* `InvalidAmountException`
* `InvalidAccountException`
* `InsufficientBalanceException`

## Data Persistence

Account and transaction information is stored in text files so that data can be retained after restarting the application.

## How to Run

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the project

Open the project in IntelliJ IDEA or VS Code.

### 3. Compile and run

Run:

```text
src/bank/Main.java
```

### 4. Use the application

From the main menu:

```text
1. Create Account
2. Login
3. Exit
```

After logging in, users can perform banking operations through the customer menu.

## Future Improvements

* MySQL database integration
* Spring Boot REST API
* React-based frontend
* JWT authentication
* Admin dashboard
* Password hashing
* Unit testing
* Docker deployment

## Author

Uday Gawande
udaygawande01@gmail.com