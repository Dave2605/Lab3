CREATE DATABASE library;

USE library;

CREATE TABLE genres (id INT primary key AUTO_INCREMENT, genre VARCHAR(50));
CREATE TABLE books (id INT primary key AUTO_INCREMENT, name VARCHAR(50), author VARCHAR(20), genre INT,
FOREIGN KEY (genre) REFERENCES genres(id));

INSERT INTO genres VALUES (1, 'adventure');
INSERT INTO genres VALUES (2, 'novel');
INSERT INTO genres VALUES (3, 'fiction');

INSERT INTO books VALUES (1, 'The hobbit', 'J.R.R. Tolkien', 1);
INSERT INTO books VALUES (2, '1984', 'George Orwell', 2);
