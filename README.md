# REST Assured API Automation Framework

## Task

Scenario :- All the users of City `FanCode` should have more than half of their todos task completed.

Given User has the todo tasks

And User belongs to the city FanCode

Then User Completed task percentage should be greater than 50%


### Key Features
- Automated API testing using **Rest Assured**.
- Organized structure with **Endpoints** and **Test** classes.
- Validation of JSON response data using Rest Assured’s powerful assertions.

## Prerequisites

- **Java** 8 or higher
- **Maven** for managing dependencies
- IDE such as IntelliJ IDEA or Eclipse
- Internet access (to reach the public **JSONPlaceholder** API)

### Libraries Used
- **Rest Assured**: For making HTTP requests and validating responses.
- **TestNG**: For writing and managing test cases.
- **Maven**: For dependency management.

## Project Structure

```plaintext
src
 └── main
     └── java
         └── api
             ├── endpoints      # Contains endpoint classes to interact with APIs
             ├── utilities      # Helper classes (Headers, Keys, Routes)
 └── test
     └── java
         └── api
             └── tests          # Test classes with assertions and validations

```
## Getting Started

Follow these steps to set up and run the project on your local machine.

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/shazadkhan123456789/RestAssuredFancodeTest.git
cd RestAssuredFancodeTest
```

## Install Dependencies

This project uses Maven for dependency management. Make sure you have Maven installed, then run the following command to install all necessary dependencies:

```bash
mvn clean install
```
This will download all the required libraries and plugins specified in the pom.xml file.

## Run Tests

To run the tests, use the following Maven command:

```bash
mvn test
```
The tests will run, and the results will be displayed in the console, showing which tests passed or failed.

## View Reports

If you wish to generate a report for the test execution 

```bash
mvn surefire-report:report
```

