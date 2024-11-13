# LearningFramework

![Selenium](https://img.shields.io/badge/Selenium-Automation-blue)
![Docker](https://img.shields.io/badge/Docker-Container-blue)
![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-orange)
![GitHub](https://img.shields.io/github/license/BenJay41/LearningFramework)
![GitHub stars](https://img.shields.io/github/stars/BenJay41/LearningFramework)
![GitHub forks](https://img.shields.io/github/forks/BenJay41/LearningFramework)

## Overview

**LearningFramework** is a Selenium-based test automation framework that follows the **Page Object Model (POM)** design pattern. It integrates with **Jenkins** for Continuous Integration, utilizes **Docker** for parallel and cross-platform testing, and employs **ngrok** to expose local servers for testing purposes.

## Key Features

- **Selenium** for browser automation.
- **Page Object Model (POM)** to separate test logic from UI interactions.
- **Jenkins** for Continuous Integration (CI) and Continuous Delivery (CD).
- **Docker** for cross-platform and parallel test execution.
- **ngrok** for secure tunneling of local services.
- **Trigger tests on GitHub push** using Jenkins.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Docker Usage](#docker-usage)
- [Continuous Integration with Jenkins](#continuous-integration-with-jenkins)
- [Folder Structure](#folder-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will help you set up and run the framework on your local machine for development and testing.

### Prerequisites

- **Java** (version 8 or higher)
- **Maven** (for managing project dependencies)
- **Docker** (for containerized testing)
- **ngrok** (for secure tunneling)
- **Jenkins** (optional, for CI/CD)
- **Git** (for version control)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/BenJay41/LearningFramework.git
   cd LearningFramework
   ```

### Running Tests

 **Run Tests with Jenkins**

   Tests can be triggered automatically via Jenkins on a push event to GitHub. Ensure Jenkins is set up with GitHub webhooks.
   
   
**Run Tests with Maven**

   **To execute the tests using Maven, run the following command:**
   
   ```bash
   mvn test
   ```

### Docker Usage

   **Building the Docker Image**
   _**To build a Docker image for running the tests, use the following command:**_

   `docker build -t learningframework`

  **Running Tests in Docker**
_**To run the tests in a Docker container:**_

`docker run -it learningframework`





