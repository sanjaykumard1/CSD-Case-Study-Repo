Customer Service Ticketing System
Introduction
This project is a Customer Service Ticketing System designed to manage customer inquiries, assignments to representatives, and ticket resolutions. It includes a Java backend with MySQL database integration.

Prerequisites
Before you begin, ensure you have the following installed on your system:

Java Development Kit (JDK)
Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse
MySQL Database Management System
Setup Instructions
1. Clone the Repository
git clone <repository-url>
cd customerservice-ticketing-system
2. MySQL Database Setup
Create Database and Tables
Connect to MySQL

Open your terminal or command prompt and log in to MySQL:
mysql -u root -p
Enter your MySQL password when prompted.

Create Database

Create a new database named CustomerService:

sql
Copy code
CREATE DATABASE CustomerService;
Use Database

Switch to the newly created database:

sql
Copy code
USE CustomerService;
Create Tables

Copy and execute the following SQL commands to create the necessary tables:

sql
Copy code
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE Representative (
    representative_id INT PRIMARY KEY AUTO_INCREMENT,
    rep_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE Ticket (
    ticket_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    issue_description TEXT,
    status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE Assignment (
    assignment_id INT PRIMARY KEY AUTO_INCREMENT,
    ticket_id INT,
    representative_id INT,
    assignment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id),
    FOREIGN KEY (representative_id) REFERENCES Representative(representative_id)
);

CREATE TABLE Resolution (
    resolution_id INT PRIMARY KEY AUTO_INCREMENT,
    ticket_id INT,
    resolution_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    resolution_details TEXT,
    status VARCHAR(20),
    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id)
);
3. Java Project Setup
Import Project in IDE

Open your IDE (IntelliJ IDEA or Eclipse).
Import the project by selecting the root directory (customerservice-ticketing-system).
Configure Database Connection

Navigate to the MainMenu.java class located in src/com/company/customerservice/main.

Update the MySQL database connection URL, username, and password in the main method:

java
Copy code
String url = "jdbc:mysql://localhost:3306/CustomerService";
String username = "root";
String password = "your_password";
Connection connection = DriverManager.getConnection(url, username, password);
4. Running the Application
Compile and Run

Compile and run the MainMenu.java class to start the application.
Use the provided menu options to interact with the Customer Service Ticketing System.
5. Usage Instructions
Creating Customers, Representatives, Tickets, Assignments, and Resolutions
Use the respective menu options to add, view, update, and delete entries.
Follow the prompts in the console to enter necessary information.