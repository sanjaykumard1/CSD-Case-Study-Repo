# Case Study 59: Doctor Appointment
## Overview
The Doctor Appointment application is designed to manage patients, doctors, and appointments using a menu-based console interface. It is built using Core Java and MySQL, and it utilizes JDBC for database interactions. The application allows users to perform CRUD (Create, Read, Update, Delete) operations for patients and doctors, and it includes functionality for scheduling appointments.
## Set Up the MySQL Database
In order to design the application first set up MySQL Database.
1.	Create a new MySQL database:

CREATE DATABASE pega;

2.	Switch to the new database:

USE pega;

3.	Create the necessary tables:

Table Patient
CREATE TABLE Patient (
  patient_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  date_of_birth DATE,
  gender VARCHAR(10),
  contact_number VARCHAR(15)
);

Table Doctor
CREATE TABLE Doctor (
  doctor_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  specialization VARCHAR(100),
  contact_number VARCHAR(15)
);

Table Appointment
CREATE TABLE Appointment (
  appointment_id INT PRIMARY KEY AUTO_INCREMENT,
  doctor_id INT,
  patient_id INT,
  appointment_date DATE,
  appointment_time TIME,
  FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
  FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);
## Project Structure
The project is organized into the train package, which includes the following components:

## 1.	Classes
### a.	App.java:
App.java is the main class and serves as the entry point of the application. It contains the main method, which displays the main menu and handles user input to navigate through different functionalities such as Patient Management, Doctor Management, and Appointment Scheduling. The user can choose an option, and the corresponding methods from other classes are invoked to perform the required operations.
### b.	DbUtil.java:
DbUtil.java is a utility class responsible for managing the database connection. It provides a method to establish and return a connection to the MySQL database using JDBC. This class centralizes the database connection logic, making it reusable across different DAO classes.
## 2. Packages
#### a.	train.entity package
The entity package contains classes that represent the data entities used in the hospital information system. These classes map directly to the database tables and encapsulate the data fields, providing getter and setter methods to access and manipulate the data.

•	Patient.java:

Patient.java is a model class representing a patient in the hospital system. It includes fields such as patientId, name, dateOfBirth, gender, and contactNumber. This class provides getter and setter methods for each field, as well as a toString method for displaying patient information.

•	Doctor.java:

Doctor.java is a model class representing a doctor in the hospital system. It includes fields such as doctorId, name, specialization, and contactNumber. This class provides getter and setter methods for each field, as well as a toString method for displaying doctor information.

•	AppointmentScheduling.java:

AppointmentScheduling.java is a model class representing an appointment in the hospital system. It includes fields such as appointmentId, doctorId, patientId, appointmentDate, and appointmentTime. This class provides getter and setter methods for each field, as well as a toString method for displaying appointment information.
### b.	train.dao package
The DAO (Data Access Object) package contains classes that handle the database operations for each entity. These classes interact with the database to perform CRUD operations and any other necessary queries.

•	PatientDAO.java:

PatientDAO.java is responsible for handling database operations related to patients. It includes methods to add, retrieve, update, and delete patient records in the database.

•	DoctorDAO.java:

DoctorDAO.java is responsible for handling database operations related to doctors. It includes methods to add, retrieve, update, and delete doctor records in the database.

•	AppointmentSchedulingDAO.java:

AppointmentSchedulingDAO.java is responsible for handling database operations related to appointments. It includes methods to schedule, update, and validate appointments, as well as checking doctor and patient availability.

## Usage Instructions
When you run the application, you will see a main menu with options for managing patients, managing doctors, and scheduling appointments. Select the desired option by entering the corresponding number.

1.	Patient Management:

Select the patient management option to add, view, update, or delete patient records.

2.	 Doctor Management:

Select the doctor management option to add, view, update, or delete doctor records.

3.	Appointment Scheduling:

Select the appointment scheduling option to display available doctors, list patients, schedule appointments, and update appointments.
