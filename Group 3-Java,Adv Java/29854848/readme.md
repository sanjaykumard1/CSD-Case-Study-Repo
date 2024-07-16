
	
	# Customer Service Ticketing System

	
	This is a simple Customer Service Ticketing System built in Java with JDBC for database connectivity. 
	It lets you manage customer service tickets, assign them to representatives, and resolve them. 
	The application works with a MySQL database 
	and is a console-based application developed using Core Java, MySQL, and JDBC. 
	It simulates a customer service system for a consumer electronics company.

	The application consists of the following functionalities.
	Each functionality is implemented by a seperate method.


	1. Ticket Management:
	   - Create a new customer service ticket
	   - View ticket details
	   - Update ticket information
	   - Delete a ticket

	2. Ticket Assignment:
	   - Assign a ticket to a customer service representative
	   - View assigned tickets
	   - Update assignment information
	   - Delete assignment records

	3. Ticket Resolution:
	   - Resolve a customer service ticket
	   - View resolved tickets
	   - Update resolution information
	   - Delete resolution records

	4. Customer Management:
	   - Add a new customer

	5. Representative Management:
	   - Add a new representative

	## Database Schema which briefly describes the key.

	Customer Table:
	   'customer_id' (Primary Key)
	  'name'
	  'email'
	  

	  Representative Table:
	  'representative_id' (Primary Key)
	  'name'
	  'email'
	  

	Ticket Table:
	  'ticket_id' (Primary Key)
	  'customer_id'(Foreign Key references Customer Table)
	  'creation_date'
	'issue_description'
	  'status'

	Assignment Table:
	  'assignment_id' (Primary Key)
	  'ticket_id' (Foreign Key references Ticket Table)
	  'representative_id' (Foreign Key references Representative Table)
	  'assignment_date'
	  'status'

	Resolution Table:
	  'resolution_id' (Primary Key)
	  'ticket_id' (Foreign Key references Ticket Table)
	  'resolution_date'
	  'resolution_details'
	  'status'

   Setup Prerequisites

	* Java Development Kit (JDK) 11
	* MySQL Server
	* MySQL JDBC Driver

	The application is structured in a single Java class CustomerServiceApp. 
	It uses a command-line interface to interact with the user and 
	performs 14 CRUD operations on the MySQL database using JDBC.

	The main method displays the main menu and 
	processes user input to call the appropriate method based on the user's choice.

	public static void main(String[] args) {
	    while (true) {
	        // Display menu and get user choice
	        // Call corresponding method
	    }
	}


	Database Setup:
	1.Install MySQL and start the MySQL server.
	2.Create the CustomerService database and the required tables by executing the following SQL script:

     sql
     
	CREATE DATABASE CustomerService;

	USE CustomerService;

	CREATE TABLE Customer (
	    customer_id INT AUTO_INCREMENT PRIMARY KEY,
	    name VARCHAR(100),
	    email VARCHAR(100)
	    
	);

	CREATE TABLE Representative (
	    representative_id INT AUTO_INCREMENT PRIMARY KEY,
	    name VARCHAR(100),
	    email VARCHAR(100)
	   
	);

	CREATE TABLE Ticket (
	    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
	    customer_id INT,
	    creation_date DATE,
	    issue_description TEXT,
	    status VARCHAR(50),
	    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
	);

	CREATE TABLE Assignment (
	    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
	    ticket_id INT,
	    representative_id INT,
	    assignment_date DATE,
	    status VARCHAR(50),
	    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id),
	    FOREIGN KEY (representative_id) REFERENCES Representative(representative_id)
	);

	CREATE TABLE Resolution (
	    resolution_id INT AUTO_INCREMENT PRIMARY KEY,
	    ticket_id INT,
	    resolution_date DATE,
	    resolution_details TEXT,
	    status VARCHAR(50),
	    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id)
	);



	Running the Application
	1.Compile the Java program:

	"javac CustomerServiceApp.java"
		
	2.Run the Java program:

	"java CustomerServiceApp"



