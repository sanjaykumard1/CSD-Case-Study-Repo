# DIGITAL_MAGAZINE_MANAGEMENT_SYSTEM

_The case study is a digital magazine management system that allows users to manage magazines, articles, and subscriptions. The system has four main tables: Magazine, Article, Subscription, and User._

Setup Instructions
Prerequisites:
**Java Development Kit (JDK) installed**
**MySQL Server installed**
**MySQL JDBC driver**

Download and install JDK from the Oracle JDK download page.
Ensure java and javac commands are available in your PATH.

Download and install MySQL from the MySQL download page.
Set up a database and user for the application.
MySQL Connector/J:

Download MySQL Connector/J from the MySQL Connector/J download page.
Extract the downloaded ZIP file and note the path to the JAR file (e.g., mysql-connector-java-8.0.23.jar).

**Tables :**
The Magazine Table has the following columns:
**- magazine_id (Primary Key)**
**- title**
**- genre**
**- publication_frequency**
**- publisher**

_**SQL CODE FOR THE ABOVE TABLE:**_
   CREATE TABLE Magazine (magazine_id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(100) NOT NULL, genre VARCHAR(50), publication_frequency VARCHAR(50), publisher VARCHAR(100));

The Article Table has the following columns:
**- article_id (Primary Key)**
**- magazine_id (Foreign Key references Magazine Table)**
**- title**
**- author**
**- content**
**- publish_date**

_**SQL CODE FOR THE ABOVE TABLE:**_
    CREATE TABLE Article (article_id INT AUTO_INCREMENT PRIMARY KEY, magazine_id INT, title VARCHAR(100) NOT NULL, author VARCHAR(100), content TEXT, publish_date DATE, FOREIGN KEY (magazine_id) REFERENCES Magazine(magazine_id));

The Subscription Table has the following columns:
**- subscription_id (Primary Key)**
**- user_id (Foreign Key references User Table)**
**- magazine_id (Foreign Key references Magazine Table)**
**- subscription_date**
**- expiry_date**
**- status (active/inactive)**

_**SQL CODE FOR THE ABOVE TABLE:**_
    CREATE TABLE Subscription (subscription_id INT AUTO_INCREMENT PRIMARY KEY, user_id INT, magazine_id INT, subscription_date DATE NOT NULL, expiry_date DATE, status VARCHAR(10) NOT NULL, FOREIGN KEY (user_id) REFERENCES User(user_id), FOREIGN KEY (magazine_id) REFERENCES Magazine(magazine_id));

The User Table has the following columns:
**- user_id (Primary Key)**
**- username**
**- email**
**- date_of_birth**
**- registration_date**

_**SQL CODE FOR THE ABOVE TABLE:**_
    CREATE TABLE User (user_id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL UNIQUE, date_of_birth DATE, registration_date DATE NOT NULL);

The system has the following functionalities:
- Magazine Management:
    - Add a new magazine
    - View magazine details
    - Update magazine information
    - Delete a magazine
- Article Management:
    - Add a new article to a magazine
    - View article details
    - Update article information
    - Delete an article
- Subscription Management:
    - Subscribe to a magazine
    - View subscription details
    - Update subscription information
    - Cancel a subscription



The requirements of the case study are:
- Develop a menu-based console application using Core Java.
- Use JDBC for interactions with the MySQL database.
- Implement menu options for managing magazines, articles, and subscriptions.
- Ensure that the application updates subscription statuses and handles user, magazine, and article data efficiently.
- Handle exceptions effectively and provide user-friendly error messages.
- Ensure the application code is clean, well-documented, and follows standard coding conventions.
