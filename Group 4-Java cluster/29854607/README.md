Objective

The Digital Magazine Management System is a console-based application developed to manage magazines, articles, and subscriptions for a communications and media company. This project demonstrates proficiency in Core Java, MySQL, and JDBC by implementing a menu-based system to handle various operations.
Functionalities

Magazine Management
1.	Add a new magazine: Add details for a new magazine.
2.	View magazine details: Display details of a specific magazine.
3.	Update magazine information: Modify existing magazine information.
4.	Delete a magazine: Remove a magazine from the system.
   
Article Management
1.	Add a new article to a magazine: Insert a new article linked to a specific magazine.
2.	View article details: Display details of a specific article.
3.	Update article information: Modify existing article information.
4.	Delete an article: Remove an article from the system.
   
Subscription Management
1.	Subscribe to a magazine: Create a new subscription for a user to a magazine.
2.	View subscription details: Display details of a specific subscription.
3.	Update subscription information: Modify existing subscription details.
4.	Cancel a subscription: Mark a subscription as inactive.

Database Schema
Magazine Table
•	magazine_id (Primary Key)
•	title
•	genre
•	publication_frequency
•	publisher
Article Table
•	article_id (Primary Key)
•	magazine_id (Foreign Key references Magazine Table)
•	title
•	author
•	content
•	publish_date
Subscription Table
•	subscription_id (Primary Key)
•	user_id (Foreign Key references User Table)
•	magazine_id (Foreign Key references Magazine Table)
•	subscription_date
•	expiry_date
•	status (active/inactive)
User Table
•	user_id (Primary Key)
•	username
•	email
•	date_of_birth
•	registration_date

Requirements
1.	Develop a menu-based console application using Core Java.
2.	Use JDBC for interactions with the MySQL database.
3.	Implement menu options for managing magazines, articles, and subscriptions.
4.	Ensure that the application updates subscription statuses and handles user, magazine, and article data efficiently.
5.	Handle exceptions effectively and provide user-friendly error messages.
6.	Ensure the application code is clean, well-documented, and follows standard coding conventions.
Setup and Installation

Prerequisites
1.	Java Development Kit (JDK) installed
2.	MySQL database server installed
3.	JDBC driver for MySQL
   
Database Configuration
1.	Create a MySQL database named magazine_management.
2.	Execute the SQL script provided in database.sql to create the necessary tables.
3.	Update the database connection details (URL, username, password) in the application's configuration file.

   
Add JDBC Driver to Project
Download the MySQL JDBC Driver from MySQL Connector/J.
Add the JAR file to your project's classpath.
              
1 Right-click your project in the Project Explorer.
2 Select Build Path > Configure Build Path.
3 Go to the Libraries tab.
4  Click Add External JARs....
5  Browse to and select your JAR file.
6  click ok


