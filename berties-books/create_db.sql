CREATE DATABASE myBookshop;
USE myBookshop;

CREATE TABLE books (id INT AUTO_INCREMENT,name VARCHAR(50),price DECIMAL(5, 2) unsigned,PRIMARY KEY(id));
CREATE TABLE userDetails (userID INT AUTO_INCREMENT, first CHAR(50) NOT NULL, last CHAR(50), email VARCHAR(60) NOT NULL, username VARCHAR(50) NOT NULL, password VARCHAR(60) NOT NULL, PRIMARY KEY(userID));

INSERT INTO books (name, price)VALUES('database book', 40.25),('Node.js book', 25.00), ('Express book', 31.99);
CREATE USER 'appuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'app2027';
GRANT ALL PRIVILEGES ON myBookshop.* TO 'appuser'@'localhost';