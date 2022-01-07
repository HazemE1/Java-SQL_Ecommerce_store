CREATE TABLE customers (
	[username] [varchar](70) NOT NULL PRIMARY KEY,
	[firstname] [varchar](70) NOT NULL,
	[lastname] [varchar](70) NOT NULL,
	[country] [varchar](70) NOT NULL,
	[city] [varchar](70) NOT NULL,
	[adress] [varchar](70) NOT NULL,
	[pass] [varchar](70) NOT NULL,
	[email] [varchar](70) NOT NULL,
	[phonenr] [varchar](70) NOT NULL);

CREATE TABLE orders(
	[confirmation] [nvarchar](10) NOT NULL,
	[orderContent] [nvarchar](1000) NOT NULL,
	[orderId] [varchar](50) NOT NULL PRIMARY KEY,
	[username] [varchar](70) NOT NULL,
    FOREIGN KEY (username) REFERENCES customers (username)

);
 CREATE TABLE discount(
	[code] [nvarchar](70) NOT NULL PRIMARY KEY,
	[percentage] [int] NOT NULL,
	[description] [nvarchar](70) NOT NULL,
	[products] [nvarchar](70) NOT NULL,
 );

 CREATE TABLE suppliers(
	[name] [nvarchar](70) NOT NULL PRIMARY KEY,
	[tel] [varchar](70) NULL,
	[address] [nvarchar](70) NOT NULL,
);

CREATE TABLE products(
	[pName] [nvarchar](70) NOT NULL,
	[pCode] [nvarchar](4) NOT NULL PRIMARY KEY,
	[stockTotal] [int] NOT NULL,
	[basePrice] [int] NULL,
	[supplier] [nvarchar](70) NULL,
	FOREIGN KEY (supplier) REFERENCES suppliers ([name])
);

CREATE TABLE discount_history(
	[message] [nvarchar](70) NOT NULL PRIMARY KEY);

