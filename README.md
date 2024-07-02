# Java E-Commerce Store

Welcome to the Console E-Commerce Store project! This repository contains the code for an e-commerce store that is controlled through a Java GUI. The store uses MySQL as the database backend and supports transactions using hypothetical coins instead of real currency.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

The Console E-Commerce Store is a Java-based application that provides a simple yet functional interface for managing an online store. Users can browse products, add items to their cart, and complete purchases using hypothetical coins. This project serves as a learning tool for integrating Java with MySQL and building GUI applications.

## Features

- **Product Browsing:** View a list of available products with details.
- **Shopping Cart:** Add and remove items from the shopping cart.
- **Checkout Process:** Complete purchases using hypothetical coins.
- **Admin Interface:** Manage products and user accounts through the GUI.
- **MySQL Integration:** Store and retrieve data using a MySQL database.

## Installation

To install and run this project locally, follow these steps:

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/console-ecommerce-store.git
    cd console-ecommerce-store
    ```

2. **Set up the MySQL database:**
    - Create a new database in MySQL.
    - Import the provided SQL schema and data.
    ```sql
    CREATE DATABASE ecommerce;
    USE ecommerce;
    SOURCE path/to/schema.sql;
    ```

3. **Update database configuration in the Java code:**
    - Open `DatabaseConfig.java`.
    - Update the `DB_URL`, `USER`, and `PASS` constants with your MySQL credentials.

4. **Compile and run the application:**
    - Use an IDE like IntelliJ IDEA or Eclipse, or compile using the command line.
    ```sh
    javac -cp .:mysql-connector-java-8.0.23.jar Main.java
    java -cp .:mysql-connector-java-8.0.23.jar Main
    ```

## Usage

Once the project is set up and running, you can interact with the store through the Java GUI. The main functionalities include:

- **Browsing Products:** Navigate through the product list to see available items.
- **Adding to Cart:** Select products and add them to your shopping cart.
- **Checking Out:** Use hypothetical coins to complete your purchase.
- **Admin Tasks:** Log in as an admin to add, update, or delete products and manage user accounts.

## Database Schema

The MySQL database schema includes the following tables:

- **Users:** Stores user account information.
- **Products:** Stores product details.
- **Orders:** Records of completed purchases.
- **Cart:** Temporary storage for items in the user's cart.

Example schema setup:

```sql
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    coins INT DEFAULT 0
);

CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price INT NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    total INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
