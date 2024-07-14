# Payroll System

## Overview

This is a menu-based console application for managing a simple payroll system. It allows users to manage employees, departments, and payroll processing.

## Features

1. **Employee Management**:
   - Add a new employee
   - View employee details
   - Update employee information
   - Delete an employee

2. **Department Management**:
   - Add a new department
   - View department details
   - Update department information
   - Delete a department

3. **Payroll Management**:
   - Process payroll for an employee
   - View payroll details
   - Update payroll information
   - List payroll history for an employee

## Database Schema

- **Employee Table**:
  - `employee_id` (Primary Key)
  - `name`
  - `department_id` (Foreign Key references Department Table)
  - `designation`
  - `salary`

- **Department Table**:
  - `department_id` (Primary Key)
  - `name`
  - `location`

- **Payroll Table**:
  - `payroll_id` (Primary Key)
  - `employee_id` (Foreign Key references Employee Table)
  - `payment_date`
  - `amount`

## Setup Instructions

### Prerequisites

- Install MySQL Server and MySQL Workbench
- Install Java Development Kit (JDK)
- Install an IDE (like Eclipse or IntelliJ IDEA)

### Database Setup

1. Open MySQL Workbench.
2. Connect to your MySQL Server.
3. Create a new database named `payroll_system`.
4. Create the necessary tables using the following SQL scripts:

```sql
CREATE DATABASE payroll_system;

USE payroll_system;

CREATE TABLE department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    location VARCHAR(100)
);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department_id INT,
    designation VARCHAR(50),
    salary DECIMAL(10, 2),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE payroll (
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    payment_date DATE,
    amount DECIMAL(10, 2),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
