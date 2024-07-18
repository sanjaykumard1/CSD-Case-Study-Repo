create database raghu2;
use raghu2;
CREATE TABLE Room (
    room_number INT PRIMARY KEY,
    type VARCHAR(50),
    price_per_night DECIMAL(10, 2),
    availability_status BOOLEAN
);

CREATE TABLE Guest (
    guest_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE Reservation (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT,
    guest_id INT,
    check_in_date DATE,
    check_out_date DATE,
    total_price DECIMAL(10, 2),
    FOREIGN KEY (room_number) REFERENCES Room(room_number) ON DELETE CASCADE,
    FOREIGN KEY (guest_id) REFERENCES Guest(guest_id) ON DELETE CASCADE
);
