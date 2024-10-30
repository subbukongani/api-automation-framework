# API Testing Project

This project provides a robust framework for testing RESTful APIs. The framework is designed for Java and leverages **REST Assured** and **TestNG** for API testing, **Maven** for dependency management, and includes logging, assertions, and custom utility classes for streamlined test execution.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Logging and Reporting](#logging-and-reporting)


## Getting Started

To get started with this project, follow the steps below.

## Prerequisites

Ensure that you have the following installed:
- **Java JDK 11** or later
- **Apache Maven** 3.6.0 or later
- **Git** for cloning the repository (optional but recommended)

## Installation

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/yourusername/api-testing-project.git
cd api-testing-project
## 2. Install Java
Make sure you have **JDK 11** or later installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).

## 3. Install Maven
If Maven is not installed, follow the instructions on the [Maven website](https://maven.apache.org/install.html).

## 4. Build the Project
Use Maven to build the project and download dependencies:
```bash
mvn clean install

## Usage
This project provides a base framework for running API tests using REST Assured and TestNG. Tests are located in the src/test/java directory.

## Project Structure
src/main/java: Contains the main Java code, including utility classes for logging, API requests, and configurations.
src/test/java: Contains TestNG test classes for API testing.
src/test/resources: Contains configuration files such as config.properties.

## Configuration
The config.properties file in the src/test/resources directory holds the configuration parameters:

base.url: The base URL for the API
endpoints: Specific API endpoint paths
Update these values to match your API's configuration as needed.

## Running Tests
Running All Tests
To execute all tests, run:
mvn test
Running a Specific Test Class
You can also run a specific test class using:
mvn -Dtest=YourTestClass test

## Logging and Reporting
This framework includes logging for tracking API requests and responses. Logs can be found in the logs directory after running tests. TestNG provides a report in target/surefire-reports, detailing test results.

Log Example
For each request, details like the request method, URI, headers, and body are logged. Each response logs the status code, headers, and body content, which helps in debugging.

