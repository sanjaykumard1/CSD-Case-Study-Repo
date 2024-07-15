# Library Management System

## Overview

This project is a console-based Library Management System built using Core Java, MySQL, and JDBC. The application allows users to manage books, members, and book loans in a library.

## Features

### Book Management:
- Add a new book
- View book details
- Update book information
- Delete a book

### Member Management:
- Register a new member
- View member details
- Update member information
- Delete a member

### Loan Management:
- Issue a book to a member
- View loan details
- Return a book
- List all loans for a specific member

## Database Schema

### Book Table:
- book_id (Primary Key)
- title
- author
- genre
- publication_year
- quantity

### Member Table:
- member_id (Primary Key)
- name
- email
- phone_number
- membership_date

### Loan Table:
- loan_id (Primary Key)
- book_id (Foreign Key references Book Table)
- member_id (Foreign Key references Member Table)
- issue_date
- return_date
- status (issued/returned)

## Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL database
- JDBC driver for MySQL (MySQL Connector/J)

### Steps

1. *Clone the repository:*
    bash
    git clone https://github.com/yourusername/library-management-system.git
    cd library-management-system
    

2. *Set up the MySQL database:*
    sql
    CREATE DATABASE library_db;

    USE library_db;

    CREATE TABLE Book (
        book_id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        genre VARCHAR(255),
        publication_year INT,
        quantity INT NOT NULL
    );

    CREATE TABLE Member (
        member_id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        phone_number VARCHAR(255),
        membership_date DATE NOT NULL
    );

    CREATE TABLE Loan (
        loan_id INT AUTO_INCREMENT PRIMARY KEY,
        book_id INT,
        member_id INT,
        issue_date DATE NOT NULL,
        return_date DATE,
        status VARCHAR(50) NOT NULL,
        FOREIGN KEY (book_id) REFERENCES Book(book_id),
        FOREIGN KEY (member_id) REFERENCES Member(member_id)
    );
    

3. *Add the MySQL Connector/J JAR file to your project's classpath.*
    - Download the JDBC driver from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
    - Add the JAR file to your project's classpath.

4. *Configure database connection:*
    - Update the DBConnection class with your MySQL database URL, username, and password.

### DBConnection Class Example
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";  // Replace with your DB username
    private static final String PASSWORD = "password";  // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

### Summary

- *Overview*: Describes the project and its features.
- *Features*: Lists the functionalities provided by the system.
- *Database Schema*: Details the structure of the database tables.
- *Setup*: Provides step-by-step instructions for setting up the project.
- *DBConnection Class Example*: Gives an example configuration for the database connection.
- *Running the Application*: Explains how to compile and run the application.
- *Usage*: Describes how to use the application.
- *Exception Handling*: Briefly mentions the handling of exceptions.
- *Code Conventions*: Lists the coding conventions followed.
- *License*: Provides licensing information.
