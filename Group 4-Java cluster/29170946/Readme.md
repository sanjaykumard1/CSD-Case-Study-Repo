#  Product Ordering and Tracking System
This is a simple menu-based console application written in Core Java that simulates a product ordering and tracking system for a consumer electronics company. The application allows users to manage orders, track shipments, and update order statuses using JDBC to interact with a MySQL database.
## Setup
### Prerequisites
•	Java Development Kit (JDK) 8 or higher installed
•	MySQL database installed
•	JDBC driver for MySQL (e.g., mysql-connector-java-8.0.25.jar)
### Database Setup
1.	Install MySQL and create a database called electronics_store.
2.	Run the following SQL scripts to create the necessary tables:
- CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
- CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10, 2)
);
- CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
- CREATE TABLE Shipments (
    shipment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    shipment_date TIMESTAMP,
    estimated_delivery_date TIMESTAMP,
    actual_delivery_date TIMESTAMP,
    status VARCHAR(20),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);
## Project Setup
1.	Clone the repository or download the source code.
2.	Place the JDBC driver (mysql-connector-java-8.0.25.jar) in the project classpath.
3.	Compile the Java file:

## Running the Application
1.	Open a terminal and navigate to the project directory.
2.	Run the application:
3.	Follow the on-screen menu to manage orders and shipments.
## Usage
- Enter the appropriate option number to perform specific actions such as placing a new order, updating shipment status, and viewing order details.
- The application uses JDBC to interact with the MySQL database, ensuring data integrity and consistency.
## Features
- Order Management: Place new orders, view order details, update order information, and cancel orders.
- Shipment Tracking: Track shipment status, view shipment details, update shipment status, and cancel shipments.
- Order Status Update: Update order status (e.g., processing, shipped, delivered), view order status history, and cancel order status updates.


