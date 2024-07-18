USER TABLE:
  
     CREATE TABLE User (user_id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL UNIQUE, date_of_birth DATE, registration_date DATE NOT NULL);


MAGAZINE TABLE:

    CREATE TABLE Magazine (magazine_id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(100) NOT NULL, genre VARCHAR(50), publication_frequency VARCHAR(50), publisher VARCHAR(100));


ARTICLE TABLE:

     CREATE TABLE Article (article_id INT AUTO_INCREMENT PRIMARY KEY, magazine_id INT, title VARCHAR(100) NOT NULL, author VARCHAR(100), content TEXT, publish_date DATE, FOREIGN KEY (magazine_id) REFERENCES Magazine(magazine_id));


SUBSCRIPTION TABLE:

     CREATE TABLE Subscription (subscription_id INT AUTO_INCREMENT PRIMARY KEY, user_id INT, magazine_id INT, subscription_date DATE NOT NULL, expiry_date DATE, status VARCHAR(10) NOT NULL, FOREIGN KEY (user_id) REFERENCES User(user_id), FOREIGN KEY (magazine_id) REFERENCES Magazine(magazine_id));