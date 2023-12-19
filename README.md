# Swag Labs Test Automation Project

This repository contains a test automation project for Swag Labs using Selenium with Java. The project focuses on automating various test scenarios to ensure the proper functionality of the Swag Labs application.

## Prerequisites
- Java JDK (version X.X.X)
- Maven (version X.X.X)
- WebDriver (e.g., ChromeDriver X.X.X)

## Setup
1. Clone this repository to your local machine.
2. Make sure you have the required dependencies installed.
3. Configure the WebDriver path in the `BaseTest` class.

## Test Scenarios

### 1. Add Product to Cart
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Verify the Products page is opened.
   - Add a product to the cart.
   - Assert that the product is added successfully.

### 2. Verify Sorting of Products (Low to High)
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Sort products from low to high.
   - Verify if the prices are sorted accordingly.

### 3. Verify Sorting of Products (Z to A)
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Sort products from Z to A.
   - Verify if the products are sorted accordingly.

### 4. Verify Sorting of Products from Z to A (Name)
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Get the first and last product names.
   - Sort products from Z to A by name.
   - Verify if the first and last product names are switched.

### 5. Verify Burger Menu Contents
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Open the burger menu and click on the "About" option.
   - Assert that the "About" page is opened.

### 6. Verify Cart Item Count
   - Navigate to Swag Labs.
   - Sign in with valid credentials.
   - Add multiple products to the cart.
   - Assert that the cart item count is updated correctly.

## Running the Tests
Execute the test classes located in the `regressionTest` package to run the test scenarios.

```bash
mvn clean test
