# AccountManagement
 Java Project with MySQL Database

This project is a Java application that interacts with a MySQL database. The instructions below will guide you through the setup and execution of the project.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Database Setup](#database-setup)
3. [Project Setup](#project-setup)
4. [Running the Project](#running-the-project)


## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Apache Maven (optional, if using Maven for build)
- IDE of your choice (IntelliJ IDEA, Eclipse, etc.)

## Database Setup

1. **Install MySQL Server:**

   Download and install MySQL from the [official website](https://dev.mysql.com/downloads/installer/).

2. **Create the Database and Tables:**

   Open your MySQL client and run the following SQL script to create the database and tables:

   ```sql
   CREATE DATABASE mydatabase;

   USE mydatabase;

   CREATE TABLE accounts (
       account_number INT PRIMARY KEY,
       account_name VARCHAR(100),
       balance INT
   );


   CREATE TABLE transactions (
       transaction_id INT AUTO_INCREMENT PRIMARY KEY,
       account_number INT,
       amount INT
       FOREIGN KEY (account_number) REFERENCES accounts(account_number)
   );
  ## project setup
   There is only one  file in this project that contains multiple classes for different operaions

  ## Running the project 
  Just click on run button to execute the project
 
  
