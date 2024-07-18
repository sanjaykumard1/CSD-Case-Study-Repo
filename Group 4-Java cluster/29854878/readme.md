
# Insurance Management System

This project is a console-based Insurance Management System implemented in Core Java, MySQL, and JDBC. The application allows users to manage policies, customers, and claims. 

## Features

1. **Policy Management**
   - Add a new policy
   - View policy details
   - Update policy information
   - Delete a policy

2. **Customer Management**
   - Register a new customer
   - View customer details
   - Update customer information
   - Delete a customer

3. **Claim Management**
   - Submit a new claim
   - View claim details
   - Update claim information
   - Delete a claim

## Database Schema

### Policy Table
| Column           | Type     | Constraint       |
|------------------|----------|------------------|
| policy_id        | INT      | PRIMARY KEY      |
| policy_number    | VARCHAR  |                  |
| type             | VARCHAR  |                  |
| coverage_amount  | DECIMAL  |                  |
| premium_amount   | DECIMAL  |                  |

### Customer Table
| Column           | Type     | Constraint       |
|------------------|----------|------------------|
| customer_id      | INT      | PRIMARY KEY      |
| name             | VARCHAR  |                  |
| email            | VARCHAR  |                  |
| phone_number     | VARCHAR  |                  |
| address          | VARCHAR  |                  |

### Claim Table
| Column           | Type     | Constraint       |
|------------------|----------|------------------|
| claim_id         | INT      | PRIMARY KEY      |
| policy_id        | INT      | FOREIGN KEY      |
| customer_id      | INT      | FOREIGN KEY      |
| claim_date       | DATE     |                  |
| status           | VARCHAR  |                  |

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- JDBC Driver for MySQL

### Setting Up the Database

1. Create a MySQL database:
    ```sql
    CREATE DATABASE insurance_management;
    ```

2. Use the created database:
    ```sql
    USE insurance_management;
    ```

3. Create the `Policy` table:
    ```sql
    CREATE TABLE Policy (
        policy_id INT AUTO_INCREMENT PRIMARY KEY,
        policy_number VARCHAR(255),
        type VARCHAR(255),
        coverage_amount VARCHAR(255),
        premium_amount VARCHAR(255)
    );
    ```

4. Create the `Customer` table:
    ```sql
    CREATE TABLE Customer (
        customer_id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255),
        email VARCHAR(255),
        phone_number VARCHAR(255),
        address VARCHAR(255)
    );
    ```

5. Create the `Claim` table:
    ```sql
    CREATE TABLE Claim (
        claim_id INT AUTO_INCREMENT PRIMARY KEY,
        policy_id INT,
        customer_id INT,
        claim_date DATE,
        status VARCHAR(50),
        FOREIGN KEY (policy_id) REFERENCES Policy(policy_id),
        FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
    );
    ```

### Running the Application

1. Clone the repository

2. Configure the database connection in `JDBCUtil.java`:
    ```java
    public class JDBCUtil {
        private static final String URL = "jdbc:mysql://localhost:3306/insurance_management";
        private static final String USER = "your_db_user";
        private static final String PASSWORD = "your_db_password";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
    ```

3. Compile and run the application:
    ```sh
    javac -d bin src/*.java
    java -cp "bin:mysql-connector-java-8.0.23.jar" Main
    ```

## Usage

The application presents a menu-based interface with options to manage policies, customers, and claims. Follow the on-screen options to perform the desired operations.


