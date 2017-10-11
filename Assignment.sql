CREATE DATABASE IF NOT EXISTS assignment;
USE assignment;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS players;
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE players (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	FirstName VARCHAR(15) NOT NULL,
	LastName VARCHAR(20) NOT NULL,
	Age INTEGER NOT NULL,
	Number INTEGER NOT NULL,
	Position VARCHAR(20) NOT NULL,
	Nationality VARCHAR(20) NOT NULL,
	Wages INTEGER NOT NULL);

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO players VALUES ( null, 'Matz', 'Sels', '24', '28', 'Goalkeeper', 'Belgian', '30000');
INSERT INTO players VALUES ( null, 'Karl', 'Darlow', '26', '26', 'Goalkeeper', 'English', '20000');
INSERT INTO players VALUES ( null, 'Robbie', 'Elliot', '30', '21', 'Goalkeeper', 'Irish', '20000');
INSERT INTO players VALUES ( null, 'Chancel', 'Mbemba', '22', '18', 'Centre-Back', 'DR Congo', '25000');
INSERT INTO players VALUES ( null, 'Ciaran', 'Clark', '27', '2', 'Centre-Back', 'Irish', '35000');
INSERT INTO players VALUES ( null, 'Grant', 'Hanley', '25', '5', 'Centre-Back', 'English', '15000');
INSERT INTO players VALUES ( null, 'Jamaal', 'Lascelles', '23', '6', 'Centre-Back', 'English', '40000');
INSERT INTO players VALUES ( null, 'Curtis', 'Good', '23', '38', 'Centre-Back', 'Austraillian', '5000');
INSERT INTO players VALUES ( null, 'Paul', 'Dummet', '25', '3', 'Left-Back', 'English', '20000');
INSERT INTO players VALUES ( null, 'Achraf', 'Lazaar', '25', '7', 'Left-Back', 'Moroccan', '15000');
INSERT INTO players VALUES ( null, 'Massadio', 'Haidara', '24', '19', 'Left-Back', 'French', '10000');
INSERT INTO players VALUES ( null, 'DeAndre', 'Yedlin', '23', '22', 'Right-Back', 'American', '35000');
INSERT INTO players VALUES ( null, 'Jesus', 'Gamez', '31', '27', 'Right-Back', 'Spanish', '30000');
INSERT INTO players VALUES ( null, 'Jack', 'Colback', '27', '4', 'Defensive Midfield', 'English', '30000');
INSERT INTO players VALUES ( null, 'Vernon', 'Anita', '27', '8', 'Defensive Midfield', 'Dutch', '25000');
INSERT INTO players VALUES ( null, 'Isaac', 'Hayden', '21', '14', 'Defensive Midfield', 'English', '15000');
INSERT INTO players VALUES ( null, 'Jonjo', 'Shelvey', '24', '12', 'Central Midfield', 'English', '50000');
INSERT INTO players VALUES ( null, 'Mohamed', 'Diame', '29', '15', 'Central Midfield', 'Senegal', '40000');
INSERT INTO players VALUES ( null, 'Matt', 'Ritchie', '27', '11', 'Right Midfield', 'Scotish', '50000');
INSERT INTO players VALUES ( null, 'Yoan', 'Gouffran', '30', '20', 'Left Wing', 'French', '35000');
INSERT INTO players VALUES ( null, 'Rolando', 'Aarons', '21', '16', 'Left Wing', 'Jamaican', '15000');
INSERT INTO players VALUES ( null, 'Christian', 'Atsu', '25', '30', 'Right Wing', 'Ghanain', '25000');
INSERT INTO players VALUES ( null, 'Aleksandar', 'Mitrovic', '22', '45', 'Centre Forward', 'Serbian', '40000');
INSERT INTO players VALUES ( null, 'Ayoze', 'Perez', '23', '17', 'Centre Forward', 'Spain', '25000');
INSERT INTO players VALUES ( null, 'Dwight', 'Gayle', '26', '9', 'Centre Forward', 'English', '45000');
INSERT INTO players VALUES ( null, 'Sammy', 'Ameobi', '24', '34', 'Centre Forward', 'English', '5000');
INSERT INTO players VALUES ( null, 'Daryl', 'Murphy', '33', '33', 'Centre Forward', 'Irish', '10000');

select * from players;



DROP TABLE IF EXISTS staff;
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE staff (
	id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	FirstName VARCHAR(15) NOT NULL,
	LastName VARCHAR(20) NOT NULL,
	Age INTEGER NOT NULL,
	Nationality VARCHAR(20) NOT NULL,
	Wages INTEGER NOT NULL);

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO staff VALUES ( null, 'Rafael', 'Benitez', '57', 'Spanish', '80000');
INSERT INTO staff VALUES ( null, 'Mikel', 'Anita', '42', 'Spanish', '20000');
INSERT INTO staff VALUES ( null, 'Paul', 'Catterson', '46', 'English', '20000');
INSERT INTO staff VALUES ( null, 'Francisco', 'Moreno', '39', 'Spanish', '10000');
INSERT INTO staff VALUES ( null, 'Antonio', 'Perez', '43', 'Spanish', '10000');
INSERT INTO staff VALUES ( null, 'Simon', 'Smith', '49','English', '10000');

select * from staff;
