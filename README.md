# AdvantageShopping Testing Report

## Overview

This document outlines the testing performed on the AdvantageShopping platform. The testing focused on various user operations and transactions to ensure the functionality and reliability of the system.

## Platform

All tests are conducted using Katalon Studio.

## Testing Scope

The following features were tested:

### User Operations
- Register
- Login
- Logout

### Transaction
- Regular Checkout
- Checkout if not logged in

## Testing Details

### User Operations

#### Register
- Test Description: Register a new account with valid and invalid inputs.
- Test Results:
  - Valid inputs: Account successfully created and user automatically logged in.

#### Login
- Test Description: Login to the platform with existing credentials.
- Test Results:
  - Successful login: Username showed in the upper right corner of the page.

#### Logout
- Test Description: Logout from the platform.
- Test Results:
  - Successful logout: User logged out and redirected to the home page.

### Transaction

#### Regular Checkout
- Test Description: Perform a regular checkout process with items in the cart.
- Test Results:
  - Successful checkout: Items purchased and order ID generated. The order and its order ID should be appeared in the 'Transaction History' page.

#### Checkout if not logged in
- Test Description: Attempt checkout without logging into the platform.
- Test Results:
  - User directed to the Login or Register page before proceeding to the next step.
