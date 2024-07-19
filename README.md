# Backend Developer Exercises
## Overview
This repository contains solutions for three backend developer exercises.
Each exercise showcases different skills in Java programming, SQL query writing, and RESTful API development.
## Exercises
## Exercise 1: Smallest Non-Occurring Integer
## Description:
A Java program that identifies the smallest positive integer not present in a given array.

## Implementation:

Implemented in src/main/java/org/example/Main.java.
The findSmallestNonOccurringInteger method determines the smallest non-occurring integer by utilizing a HashSet for efficient lookups.
### Usage:

Compile the Java program.
Run the program to see the smallest non-occurring integers for sample arrays.

## Exercise 2: SQL Query for Missing Records
## Description:
A SQL script that identifies records present in Table T1 but not in Table T2.

## Implementation:

Located in exercise2/script.sql.
The script creates two tables, inserts sample data, and then executes a query to find records in T1 that do not exist in T2.
SQL Script:

## Exercise 3: RESTful API for Stock Management
## Description:
A Java-based RESTful API to manage stocks using Spring Boot and Reactive Programming.

## Implementation:

Developed using Spring Boot.
Contains endpoints to manage stock information:
## GET /api/stocks: Retrieve a list of stocks.
## GET /api/stocks/{id}: Retrieve a specific stock by ID.
## POST /api/stocks: Create a new stock.
## PUT /api/stocks/{id}: Update the price of a stock by ID.

## Notes:
The stock list is maintained in memory.
Stock object includes fields: id, name, currentPrice, createDate, and lastUpdate.
Setup:

Navigate to exercise3/.
### Use Maven to build and run the application:
### mvn spring-boot:run

