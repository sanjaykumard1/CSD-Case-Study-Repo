CREATE DATABASE IF NOT EXISTS magazinemanagement;

USE magazinemanagement;

CREATE TABLE IF NOT EXISTS Magazine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    publication_frequency VARCHAR(100),
    publisher VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Article (
    article_id INT AUTO_INCREMENT PRIMARY KEY,
    magazine_id INT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    content TEXT,
    publish_date DATE,
    FOREIGN KEY (magazine_id) REFERENCES Magazine(id)
);

CREATE TABLE IF NOT EXISTS Subscription (
    subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    magazine_id INT,
    subscription_date DATE,
    expiry_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (magazine_id) REFERENCES Magazine(id)
);

CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
SHOW TABLES IN magazinemanagement;
