CREATE DATABASE IF NOT EXISTS shopping_mall_db;
USE shopping_mall_db;

CREATE TABLE IF NOT EXISTS shops (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    owner_name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    floor_number INT NOT NULL,
    contact VARCHAR(20) NOT NULL,
    monthly_rent DOUBLE NOT NULL
);
