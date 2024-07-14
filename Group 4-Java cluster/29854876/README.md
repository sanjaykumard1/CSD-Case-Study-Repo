# Candidate ID 29854876 - Case Study Solution

## Initial Setup Process

### Prerequisites

Ensure you have the following installed on your machine:

- Java Development Kit (JDK)
- MySQL Server
- Git

### Steps to create the tables in the DB

- ```sql
  create database pharmaceutical_inventory;
  ```

- ```sql
  use pharmaceutical_inventory;
  ```

- ```sql
  create table medication(
    medication_id int primary key,
    name varchar(255),
    description varchar(255),
    price decimal(10, 2),
    quantity_in_stock int
    );
  ```
- ```sql
  create table supplier(
    supplier_id int primary key,
    name varchar(255),
    email varchar(255),
    phone_number varchar(10),
    address varchar(255)
    );
  ```

- ```sql
  create table inventory(
    inventory_id int primary key,
    medication_id int,
    supplier_id int,
    quantity_received int,
    date_received date,
    foreign key(medication_id) references medication(medication_id),
    foreign key(supplier_id) references supplier(supplier_id)
    );
  ```
