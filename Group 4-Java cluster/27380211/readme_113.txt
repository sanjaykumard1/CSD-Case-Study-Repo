Candidate ID: 27380211
Name: Sushil Mhetre
Case Study : 113

Media Content Management System :
It is a menu-based console application developed using Core Java, MySQL, and JDBC. 
It allows users to manage media content, users, and subscriptions efficiently. The application ensures the integrity 
of data by handling foreign key constraints and providing user-friendly error messages.

-> Features
1. Media Content Management:
   - Add new media content
   - View media content details
   - Update media content information
   - Delete media content

2. User Management:
   - Add a new user
   - View user details
   - Update user information
   - Delete a user

3. Subscription Management:
   - Create a new subscription
   - View subscription details
   - Update subscription information
   - Cancel a subscription

-> Prerequisites:
Before running the application, following dependencies must be installed:
Java Development Kit (JDK)
MySQL
JDBC Driver for MySQL


-> Database Schema
- Content Table:
  - content_id (Primary Key)
  - title
  - description
  - genre
  - release_date
  - content_type (e.g., movie, series, documentary)

- User Table:
  - user_id (Primary Key)
  - username
  - email
  - date_of_birth
  - registration_date

- Subscription Table:
  - subscription_id (Primary Key)
  - user_id (Foreign Key references User Table)
  - content_id (Foreign Key references Content Table)
  - subscription_date
  - expiry_date
  - status (active/inactive)

-> Implementation Details
1)DatabaseConnection.java
- Manages database connection using JDBC.

2)ContentManagement.java
- Handles all operations related to media content:
  - addContent()
  - viewContent()
  - updateContent()
  - deleteContent()

3)UserManagement.java
- Handles all operations related to users:
  - addUser()
  - viewUser()
  - updateUser()
  - deleteUser()

4)SubscriptionManagement.java
- Handles all operations related to subscriptions:
  - addSubscription()
  - viewSubscription()
  - updateSubscription()
  - cancelSubscription()

5)MediaContentManagementSystem.java
- Provides a menu-driven interface for users to interact with the application.

-> Error Handling
- The application includes error handling to provide user-friendly messages and ensure data integrity, particularly with foreign key constraints.

->How to Run
1. Set up the MySQL database with the provided schema.
2. Update the database connection details in jdbc_connection.java.
3. Compile (javac DatabaseConnection.java ContentManagement.java UserManagement.java SubscriptionManagement.java MediaContentManagementSystem.java)
and run (java MediaContentManagementSystem
)the Java application from the console.

