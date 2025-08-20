# Test Automation with Selenium and POM

A project dedicated to learning and practicing automation testing with Selenium WebDriver, Java, and the Page Object Model (POM) design pattern.

## Project Goal:

This repository was created as a personal learning project to solidify my understanding of modern test automation principles. It focuses on hands-on exercises and practical implementations rather than theoretical concepts.


## Key Skills:

- **Selenium WebDriver**: Automating browser interactions.

- **Java**: Writing test logic and code.

- **Page Object Model (POM)**: A design pattern for maintainable and scalable test code.

- **Test Automation Fundamentals**: Understanding how to write effective, reliable tests.


## Getting Started

 ### Prerequisites:

  Java Development Kit (JDK) 8 or higher

  Maven

  An IDE like IntelliJ IDEA, Eclipse or NetBeans

 ### Setup Instructions:

  Clone the repository: git clone https://github.com/Anthony9811/selenium-pom-practice.git

  Navigate to the project directory.

  Build the project and run tests using Maven: `mvn clean install`

## Repository Structure
* `src/main/java/pages`: This is where the Page Object classes are located. Thanks to the Test Automation University course i learned that it is considered a good practice to create a class for eache page when using the POM pattern, so in order to improve the readability of the structure i decided to create subpackages here for tests (such as `login` and `forgotpassword`) for example that open multiple pages for things like confirmation messages, et cetera.

* `src/test/java/`: Contains the actual test cases (@Test methods) and test suites.

* `pom.xml`: - The Maven project configuration file, listing all dependencies (like Selenium and TestNG).

## Key Concepts & Exercises

### Exercise 1: Basic Login Test
Objective: Automate the login process for a sample website.

Concepts: `findElement`, `click`, and `sendKeys`.

### Exercise 2: Data-driven Dropdown Selection

Objective: Automate a dropdown menu to select multiple options using a data provider.

Concepts: Data-driven testing, handling dropdown elements (`Select` class), and working with data providers.

### Exercise 3: Forgot Password Worlkflow

Objective: Validate the "Forgot Password" functionality by submitting an email and verifying the resulting message.

Concepts: Element interaction, text validation, and handling a basic user flow.

***Note: This test can not be successfully completed at the moment due to an "Internal Server Error" message appearing on the site. According to the course's assignment we are supposed to be redirected to a new page containing a confirmation message that reads “Your e-mail's been sent!”, however, since this is not the case and i have no way to know the element's css selector, id or xpath i've decided to instead test that the "Internal Server Error" message is appearing on screen until it gets fixed, which is why the test passes. This will not only avoid the `NoSuchElementException`, but i will also be able to know when it gets fixed once the test fails.***

## Course Credits
Some of the exercises in this repository are based on homework assignments from the Test Automation University course **Selenium WebDriver with Java**.
