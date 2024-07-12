
# Telecommunication Service Management System

## Objective
Develop a menu-based console application to manage customers, services, and subscriptions in a telecommunication service management system using Core Java, MySQL, and JDBC.

## Requirements
- JDK
- MySQL Server
- Eclipse IDE (optional)

## Setup

1. **Database Setup**

   Run the following SQL script to create the database and tables:

   ```sql
   CREATE DATABASE telecom_db;

   USE telecom_db;

   CREATE TABLE Customer (
       customer_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       email VARCHAR(100),
       contact_number VARCHAR(15),
       address VARCHAR(255)
   );

   CREATE TABLE Service (
       service_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       description VARCHAR(255),
       price DECIMAL(10, 2)
   );

   CREATE TABLE Subscription (
       subscription_id INT PRIMARY KEY AUTO_INCREMENT,
       customer_id INT,
       service_id INT,
       subscription_date DATE,
       status VARCHAR(50),
       FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
       FOREIGN KEY (service_id) REFERENCES Service(service_id)
   );



**2.Java Project Setup**

- Clone the repository or download the source code.
- Open the project in your IDE (Eclipse or any other Java IDE).
- Ensure you have the MySQL JDBC driver in your project classpath.
- Update the DatabaseConnection.java file with your MySQL root password.



**3.Running the Application**

- Run the Main.java class to start the application.
- Follow the menu options to manage customers, services, and subscriptions.


**4.Functionalities**
  **Customer Management**

- Add new customers
- View customer details
- Update customer information
- Remove customers

**Service Management**

- Add new services (e.g., mobile, internet, TV)
- View service details
- Update service information
- Remove services
- Subscription Management

**Subscribe customers to services**
- View subscription details
- Update subscription information
- Remove subscriptions
