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

  Clone the repository: `git clone https://github.com/Anthony9811/selenium-pom-practice.git`

  Navigate to the project directory.

  Build the project and run tests using Maven: `mvn clean install`

## Repository Structure
* `src/main/java/pages`: This is where the Page Object classes are located. Thanks to the Test Automation University course i learned that it is considered a good practice to create a class for each page when using the POM pattern, so in order to improve the readability of the structure i decided to create subpackages here for tests (such as `login` and `forgotpassword`) that open multiple pages for things like confirmation messages and others.

* `src/test/java/`: Contains the actual test cases (`@Test` methods) and test suites.

* `pom.xml`: - The Maven project configuration file, listing all dependencies (like Selenium and TestNG).

## Key Concepts & Exercises

### Exercise 1: Basic Login Test
Objective: Automate the login process for a sample website.

Concepts: `findElement`, `click`, and `sendKeys`.

### Exercise 2: Data-driven Dropdown Selection

Objective: Automate a dropdown menu to select multiple options using a data provider.

Concepts: Data-driven testing, handling dropdown elements (`Select` class), and working with data providers.

### Exercise 3: Forgot Password Workflow

Objective: Validate the "Forgot Password" functionality by submitting an email and verifying the resulting message.

Concepts: Element interaction, text validation, and handling a basic user flow.

***Note: This test cannot be successfully completed at the moment due to an "Internal Server Error" message appearing on the site. According to the course's assignment (which you can read [here](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter4.3.html)) we are supposed to be redirected to a new page containing a confirmation message that reads “Your e-mail's been sent!”, however, since this is not the case and i have no way to know the element's css selector, id or xpath i've decided to instead test that the "Internal Server Error" message is appearing on screen until it gets fixed, which is why the test passes. This will not only avoid the `NoSuchElementException`, but i will also be able to know when it gets fixed once the test fails.***

### Exercise 4: Hovers Page Interaction

Objective: Automate the "Hovers" page to verify that text and links appear upon hovering over an image.

Concepts: Handling mouse actions (`Actions` class), element visibility, and dynamic content validation.

### Exercise 5: Key Presses

Objective: Automate a test on the "Key Presses" page to verify that the correct feedback message is displayed after a keyboard key is pressed.

Concepts: Simulating keyboard events, sending special keys (`Keys` class), and text validation.

### Exercise 6: Horizontal Slider

Objective: Automate the horizontal slider to move it to a specific value and verify the displayed number.

Concepts: Simulating keyboard events (`Keys` class), sending arrow keys, and numeric value validation.

### Exercise 7: Javascript Alerts

Objective: Automate and interact with different types of JavaScript alerts (Alert, Confirm, and Prompt) and verify the results.

Concepts: Handling JavaScript pop-ups (`Alert` class), `accept`, `dismiss`, and sending text to a prompt.

### Exercise 8: File Upload

Objective: Automate the process of uploading a file and verifying that the upload was successful.

Concepts: Interacting with file input elements, using `sendKeys` and the `File` class to specify a file path, and text validation.

### Exercise 9: Modal

Objective: Automate the dismissal of a modal dialog box that appears upon page load and verify the page state afterward.

Concepts: Handling unexpected pop-ups, interacting with modal dialogs, and dynamic wait conditions.

### Exercise 10: Context Menu

Objective: Automate a right-click action on the page's hot spot and verify the text of the resulting JavaScript alert.

Concepts: Simulating right-clicks (`Actions` class), handling JavaScript alerts, and text validation.

### Exercise 11: Nested Frames

Objective: Navigate to the "Nested Frames" page, switch to the `left` and `bottom` frames, and verify that the text inside each frame is "LEFT" and "BOTTOM" respectively, all within a single test case.

Concepts: Working with nested iframes (`switchTo().frame()`), locating frames by name or index, and text validation.

***The solved exercise assigned for this task can be read [here](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter8.html)***

### Exercise 12: Dynamic Loading

Objective: Automate tests for both dynamic loading examples, focusing on waiting for elements to become either visible or present in the DOM after a page load event.

Concepts: Explicit waits (`WebDriverWait`), waiting for element visibility, and waiting for an element's presence in the DOM.

***The specific assignment solved for this exercise can be read [here](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter9.html)***

### Exercise 13: Using JavaScript

Objective: Automate tests for two JavaScript-heavy pages. For "Infinite Scroll," the goal is to verify that content loads dynamically as the page is scrolled. For "Large & Deep DOM," the objective is to locate and interact with a deeply nested element within a complex DOM structure.

Concepts: Executing JavaScript (`JavascriptExecutor`), simulating scroll events, locating elements within complex page structures, and handling dynamically loaded content.


### Exercise 14: Multi-Select Dropdown

Objective: Modified the dropdown page to select multiple options. This test first uses JavaScript to enable multi-select on the element, then selects the options from a data set and verifies them.

Concepts: Executing JavaScript (`JavascriptExecutor`), modifying element attributes on the fly, using `ArrayList` for data handling, and working with data providers.

***The specific assignment for this exercise can be read [here](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter10.html).***

### Exercise 15: Multiple Windows

Objective: Automate the process of clicking a link that opens a new window, then switch the automation's focus to the new window to perform a validation.

Concepts: Handling multiple browser windows, switching between windows (`switchTo().window())`, and managing window handles.


### Exercise 16: Dynamic Loading (New Tab)

Objective: Go to the Dynamic Loading page, right-click on "Example 2," open it in a new tab, and then switch to that new tab to verify the presence of the "Start" button.

Concepts: Simulating right-click actions (`Actions` class), handling multiple tabs, and waiting for element visibility.

The assignment for this exercise can be read [here](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter11.html)

## Test Reporting & Utility Features

This section highlights key framework functionalities that improve test reliability and reporting.

- **Comprehensive Screenshot Capture:** The framework now includes a dedicated `ScreenshotHelper` class that captures screenshots for all test outcomes: pass, fail, and skip. This provides a complete visual log of the test run, which is invaluable for debugging, auditing, and generating clear reports.

## Course Credits
Some of the exercises in this repository are based on homework assignments from the Test Automation University course **Selenium WebDriver with Java**.
