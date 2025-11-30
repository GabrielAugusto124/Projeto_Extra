CREATE DATABASE shoe_store;
USE shoe_store;
CREATE TABLE customer (
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100), cpf VARCHAR(20),
 cep VARCHAR(10), street VARCHAR(100), city VARCHAR(100), state VARCHAR(2)
);
CREATE TABLE shoe (
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100), size INT, price DECIMAL(10,2), category VARCHAR(20)
);
CREATE TABLE orders (
 id INT AUTO_INCREMENT PRIMARY KEY,
 customer_id INT, total DECIMAL(10,2),
 FOREIGN KEY(customer_id) REFERENCES customer(id)
);
CREATE TABLE order_item (
 id INT AUTO_INCREMENT PRIMARY KEY,
 order_id INT, shoe_id INT, quantity INT,
 FOREIGN KEY(order_id) REFERENCES orders(id),
 FOREIGN KEY(shoe_id) REFERENCES shoe(id)
);
