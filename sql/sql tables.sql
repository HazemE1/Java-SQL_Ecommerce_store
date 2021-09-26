CREATE TABLE customers (
username VARCHAR(70) PRIMARY KEY, 
firstname VARCHAR(70), 
lastname VARCHAR(70),	
country VARCHAR(70), 
city VARCHAR(70), 
adress VARCHAR(70), 
pass  VARCHAR(70), 
email VARCHAR(70), 
phonenr VARCHAR(70));

CREATE TABLE orders(
    confirmation nvarchar NOT NULL,
    orderContent nvarchar NOT NULL,
    orderId int PRIMARY KEY, 
    username VARCHAR(70) NOT NULL,
    FOREIGN KEY (username) REFERENCES customers (username)

);
 CREATE TABLE discount(
    code nvarchar primary key NOT NULL,
    [percentage] int,
	[description] nvarchar
 );

 CREATE TABLE suppliers(
    [name] nvarchar primary key NOT NULL,
    tel varchar,
    [address] nvarchar NOT NULL,
);

CREATE TABLE products(
    pName nvarchar  NOT NULL, -- product name
    pCode int  PRIMARY KEY, -- product Code
    stockTotal int NOT NULL, -- all product in stock
    basePrice int,
	supplier nvarchar,
	FOREIGN KEY (supplier) REFERENCES suppliers ([name])
);

CREATE TABLE discount_history(
    startDate date,
	endDate date,
    price int ,
    [percentage] int,
    product_codes nvarchar
);

