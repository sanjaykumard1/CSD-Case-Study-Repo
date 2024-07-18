Objective: 
Develop a menu-based console application to assess your proficiency in Core Java, MySQL, and JDBC. The application will simulate an online retail store management system, allowing users to manage products, customers, and reviews.
Functionalities:
1.	Product Management:
o	Add a new product
o	View product details
o	Update product information
o	Delete a product
2.	Customer Management:
o	Add a new customer
o	View customer details
o	Update customer information
o	Delete a customer
3.	Review Management:
o	Add a new review for a product
o	View reviews for a product
o	Delete a review
Database Schema:
•	Product Table:
o	product_id (Primary Key)
o	name
o	description
o	price
o	stock_quantity
•	Customer Table:
o	customer_id (Primary Key)
o	name
o	email
o	phone_number
o	address
•	Review Table:
o	review_id (Primary Key)
o	product_id (Foreign Key references Product Table)
o	customer_id (Foreign Key references Customer Table)
o	rating (integer between 1 and 5)
o	comment
o	review_date
Requirements:
•	Develop a menu-based console application using Core Java.
•	Use JDBC for interactions with the MySQL database.
•	Implement menu options for managing products, customers, and reviews.
•	Ensure that the application updates the stock_quantity in the Product table appropriately after a product is added or deleted.
•	Handle exceptions effectively and provide user-friendly error messages.
•	Ensure the application code is clean, well-documented, and follows standard coding conventions.
