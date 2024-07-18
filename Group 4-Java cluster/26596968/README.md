# Movie Rental System

This is a simple movie rental system developed using Core Java, MySQL, and JDBC. The application allows users to manage movies, customers, and rental transactions.

## Features

- **Movie Management**
  - Add a new movie
  - View movie details
  - Update movie information
  - Delete a movie

- **Customer Management**
  - Register a new customer
  - View customer details
  - Update customer information
  - Delete a customer

- **Rental Management**
  - Rent a movie to a customer
  - Return a rented movie
  - View rental history of a customer
  - List currently rented movies

## Database Schema

- **Movie Table:**
  - `movie_id` (Primary Key)
  - `title`
  - `genre`
  - `release_year`
  - `quantity_available`

- **Customer Table:**
  - `customer_id` (Primary Key)
  - `name`
  - `email`
  - `phone_number`

- **Rental Table:**
  - `rental_id` (Primary Key)
  - `movie_id` (Foreign Key references Movie Table)
  - `customer_id` (Foreign Key references Customer Table)
  - `rental_date`
  - `return_date`

## MySQL Code
```
CREATE DATABASE movierentalsystem;

USE movierentalsystem;

CREATE TABLE Movie (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    release_year INT,
    quantity_available INT NOT NULL
);

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE Rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    customer_id INT,
    rental_date DATE,
    return_date DATE,
    FOREIGN KEY (movie_id) REFERENCES Movie(movie_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

```

## Setup

### Prerequisites

1. **Java Development Kit (JDK):**
   - Download and install JDK from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Ensure `java` and `javac` commands are available in your PATH.

2. **MySQL Database:**
   - Download and install MySQL from the [MySQL download page](https://dev.mysql.com/downloads/installer/).
   - Set up a database and user for the application.

3. **MySQL Connector/J:**
   - Download MySQL Connector/J from the [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).
   - Extract the downloaded ZIP file and note the path to the JAR file (e.g., `mysql-connector-java-8.0.23.jar`).
  
### Project Setup

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/your-username/your-repository.git
   cd your-repository

2.	Set Up MySQL Database:
    Create a database and the necessary tables using the provided SQL scripts.

3.	Configure Database Connection:
    Update the DatabaseUtil class with your MySQL database credentials.
```
   public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/movie_rental_db";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```
5.	Compile and Run the Application:
```
    javac -cp .;mysql-connector-java-8.0.23.jar MovieRentalSystem.java

    java -cp .;mysql-connector-java-8.0.23.jar MovieRentalSystem
```
    Replace mysql-connector-java-8.0.23.jar with the path to your MySQL Connector JAR file.

## Usage

Follow the menu options in the console application to manage movies, customers, and rentals.


