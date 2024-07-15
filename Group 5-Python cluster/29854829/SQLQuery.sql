-- CASE STUDY : RETAIL SALES MANAGEMENT SYSTEM

-- Creating Database schema with the name Retail_sales_management
CREATE DATABASE Retail_sales_management;

-- Selecting the Database Retail_sales_management to perform operations
USE Retail_sales_management;

-- Creating the Customers table with the specified structure
CREATE TABLE Customers (
	customer_id INT PRIMARY KEY,
	name VARCHAR(100),
	contact_info VARCHAR(100),
	loyalty_points INT
	);

SELECT * FROM Customers;

-- Creating the Transactions Table
CREATE TABLE Transactions (
	transaction_id INT PRIMARY KEY,
	customer_id INT FOREIGN KEY REFERENCES Customers (customer_id),
	product_name VARCHAR(100),
	quantity_sold INT,
	sale_amount DECIMAL(10,2),
	transaction_date DATE,
	);
	
SELECT * FROM Transactions;

-- Inserting values into Customers table

INSERT INTO Customers VALUES (1000,'Ana','Anna Nagar, Chennai',35),
	(1003,'Mario','Adyar, Chennai',120),
	(1034,'Christina','Mylapore, Chennai',67);

-- Inserting values into Transactions table

INSERT INTO Transactions VALUES (1,1000,'Hair dryer',1,3200,'2024-07-13'),
	(2,1000,'Freezer',1,6000,'2024-07-13'),
	(3,1000,'Coffee machine',1,5050,'2024-07-13'),
	(4,1000,'Blender',1,1600,'2024-07-13');
	
INSERT INTO Transactions VALUES (23,1003,'Microwave',2,10000,'2024-07-10'),
			(24,1003,'Blender',1,1600,'2024-07-10');

-- Problem Statements:
-- 1. Write a query to find the total sales amount for each customer.

SELECT c.customer_id, 
	SUM(t.sale_amount) AS total_sales_amount
FROM Customers c
JOIN Transactions t
ON c.customer_id = t.customer_id
GROUP BY c.customer_id;


-- 2. Write a query to find the names of customers and their total sales amounts.

SELECT c.customer_id, 
	c.name,
	SUM(t.sale_amount) AS total_sales_amount
FROM Customers c
LEFT JOIN Transactions t
ON c.customer_id = t.customer_id
GROUP BY c.customer_id, c.name;


-- 3. Write a query to find the names of customers who have never made a purchase.

SELECT c.customer_id, c.name
FROM Customers c
LEFT JOIN Transactions t
ON c.customer_id = t.customer_id
where t.customer_id IS NULL;


-- 4. Write a query to find the products that have been sold more than 50 times.

SELECT product_name, 
	count(product_name) AS no_of_times_sold
FROM Transactions 
GROUP BY product_name
HAVING count(product_name) > 50 ;


-- 5. Write a query to find the customer names and their loyalty points for those who have made more than 10 transactions.

SELECT c.customer_id, 
	c.name, 
	c.loyalty_points,
	COUNT(t.transaction_id) AS no_of_transactions
FROM Customers c
JOIN Transactions t
ON c.customer_id = t.customer_id
GROUP BY c.customer_id, c.name, c.loyalty_points
HAVING COUNT(t.transaction_id) > 10 ;

