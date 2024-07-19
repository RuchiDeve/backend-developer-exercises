-- Select the database
CREATE DATABASE stock;
USE stock;

-- Create Table T1
CREATE TABLE T1 (
                    id INT PRIMARY KEY,
                    name VARCHAR(50),
                    age INT
);

-- Create Table T2
CREATE TABLE T2 (
                    id INT PRIMARY KEY,
                    name VARCHAR(50),
                    age INT
);

-- Insert Sample Data into T1
INSERT INTO T1 (id, name, age) VALUES
                                   (23, 'Tar', 46),
                                   (12, 'Bar', 32),
                                   (14, 'Foo', 70);

-- Insert Sample Data into T2
INSERT INTO T2 (id, name, age) VALUES
                                   (14, 'Foobar', 70),
                                   (12, 'Bar', 32);

-- Run the Query
SELECT T1.id, T1.name, T1.age
FROM T1
         LEFT JOIN T2 ON T1.id = T2.id AND T1.name = T2.name AND T1.age = T2.age
WHERE T2.id IS NULL
ORDER BY T1.id;
