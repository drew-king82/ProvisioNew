/*
Capstone Project for CSD460
Justin Brehms
12/10/2021
*/

--delete database if already EXISTS
--this command should be active only on first initialization.

DROP SCHEMA IF EXISTS proviso;

-- drop user if already exists 
DROP USER IF EXISTS 'proviso_user'@'localhost';

-- create youtunes_user and grant them all privileges to the youtunes_user database 
CREATE USER 'proviso_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'provisopass';

-- grant all privileges to the youtunes_user database to user youtunes_user on localhost 
GRANT ALL PRIVILEGES ON provisio.* TO 'proviso_user'@'localhost';

--create database 
CREATE DATABASE proviso;

--use database
USE proviso;

-- drop tables if they are present
DROP TABLE IF EXISTS customer; 
DROP TABLE IF EXISTS reservation; 

-- create customer table 
CREATE TABLE customer (
	cust_id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(200) NOT NULL,
	lastName VARCHAR(200)  NOT NULL,
	firstName VARCHAR(155) NOT NULL,
	password VARCHAR(200) NOT NULL,
	loyalty INT NOT NULL,
	PRIMARY KEY(cust_id)
);

-- create reservation table
CREATE TABLE reservation (
	reservation_id	 INT 			NOT NULL AUTO_INCREMENT,
	roomSize		 ENUM('1','2','3','4')	 NOT NULL,
	wifi			 BOOLEAN	 				NOT NULL,
	breakfast	 	BOOLEAN		 	 		NOT NULL,
	parking		  	BOOLEAN	  				NOT NULL,
	cost	 		DOUBLE	 				NOT NULL,
	checkIn	   		DATE	 				NOT NULL,
	checkOut 		DATE	 				NOT NULL,
	numberNights 	INT		 				NOT NULL,
	guests	 		ENUM('1', '2')	 		NOT NULL,
	loyalty	 		INT, 					
	cust_id	 		INT		 				NOT NULL,
	PRIMARY KEY(reservation_id),
	CONSTRAINT fk_customer
	FOREIGN KEY(cust_id, loyalty)
	REFERENCES customer(cust_id, loyalty)
); 


-- insert customer statements 
INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('paul@house-atreides.com', 'Atreides', 'Paul', 'password', '0');

INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('Leto@house-atreides.com', 'Atreides', 'Leto', 'password', '0');

INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('duncan@house-atreides.com', 'Idaho', 'idaho', 'password', '0');
	
INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('jessica@benegesserit.org', 'Lady', 'Jessica', 'password', '0');
	
INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('feyd@house-harkonnen.com', 'Harkonnen', 'Feyd-Rautha', 'password', '0');

INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('vladimir@house-harkonnen.com', 'Harkonnen', 'Vladimir', 'password', '0');

INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('nurel@red-chasm-sietch.org', 'Ichwan-Bedwine', 'Nurel', 'password', '0');
	
INSERT INTO customer(email, lastName, firstName, password, loyalty)
	VALUES('stilgar@sietch-tabr.org', 'Stilgar', 'Naib', 'password', '0');

	
-- insert reservation statements
INSERT INTO reservation(roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id)
	VALUES('1', TRUE, TRUE, FALSE, 95.00, 2022-01-03, 2022-01-06, 3, 
	1, loyalty, (SELECT cust_id FROM customer WHERE email = 'paul@house-atreides.com'));
	
INSERT INTO reservation(roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id)
	VALUES('2', TRUE, TRUE, FALSE, 115.00, 2022-05-27, 2022-06-03, 7, 
	2, loyalty, (SELECT cust_id FROM customer WHERE email = 'paul@house-atreides.com'));
	
INSERT INTO reservation(roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id)
	VALUES('4', TRUE, TRUE, TRUE, 95.00, YYYY-MM-DD, YYYY-MM-DD, numberNights, 
	guests, loyalty, (SELECT cust_id FROM customer WHERE email = 'Leto@house-atreides.com'));
/*
INSERT INTO reservation(reservation_id, roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id cust_id)
	VALUES('', '1', TRUE, TRUE, FALSE, 95.00, YYYY-MM-DD, YYYY-MM-DD, numberNights, 
	guests, loyalty, (SELECT cust_id FROM customer WHERE email = 'paul@house-atreides.com'));

INSERT INTO reservation(reservation_id, roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id cust_id)
	VALUES('', '1', TRUE, TRUE, FALSE, 95.00, YYYY-MM-DD, YYYY-MM-DD, numberNights, 
	guests, loyalty, (SELECT cust_id FROM customer WHERE email = 'paul@house-atreides.com'));
	
INSERT INTO reservation(reservation_id, roomSize, wifi, breakfast, parking, cost, checkIn, checkOut, numberNights, guests, loyalty, cust_id cust_id)
	VALUES('', '1', TRUE, TRUE, FALSE, 95.00, YYYY-MM-DD, YYYY-MM-DD, numberNights, 
	guests, loyalty, (SELECT cust_id FROM customer WHERE email = 'paul@house-atreides.com'));
*/