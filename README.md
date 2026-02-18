# Selenium-Letcode-Project

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-green)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-Latest-blue)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue)](https://maven.apache.org/)

A robust, production-grade test automation framework for validating web applications. Built with industry best practices using the Page Object Model (POM) design pattern, this project demonstrates professional-level Selenium automation with clean architecture, comprehensive reporting, and cross-browser support.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Architecture & Design Patterns](#architecture--design-patterns)
- [Configuration](#configuration)
- [Test Coverage](#test-coverage)
- [Adding New Tests](#adding-new-tests)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Resources](#resources)

---

## Overview

**Selenium-Letcode-Project** is an end-to-end automation testing framework designed to validate the [LetCode.in](https://letcode.in/) platform. It serves as a reference implementation for professional test automation practices including:

- Clean separation of concerns with Page Object Model
- Reusable action-based components
- Comprehensive test lifecycle management
- Multi-browser cross-platform testing
- Automated HTML report generation
- Configuration-driven test execution

---

## Features

✅ **Page Object Model (POM)** - Maintainable and scalable test architecture  
✅ **Cross-browser Testing** - Chrome, Edge, and Firefox support  
✅ **Action-Based Pattern** - Reusable interaction methods with clean abstractions  
✅ **Test Listeners** - Automatic lifecycle management and driver initialization  
✅ **Custom Assertions** - Enhanced validation with detailed failure messages  
✅ **Configuration Management** - Property-based externalized configuration  
✅ **HTML Reports** - Automated timestamped test execution reports  
✅ **XML Test Suites** - Flexible suite management for parallel or selective execution  
✅ **Comprehensive Logging** - SLF4J integration for detailed debugging  
✅ **Maven Integration** - Industry-standard build and CI/CD compatibility  

---

## Prerequisites

### System Requirements

- **Java Development Kit (JDK)** - Version 17 or higher
- **Maven** - Version 3.6 or higher
- **Git** - For version control
- **Web Browsers** - Chrome, Edge, or Firefox (latest versions recommended)
- **WebDriver Executables** - Corresponding drivers for your selected browsers

### Verify Installation

```bash
java -version
mvn -version
git --version
```

**Expected Output**: All commands should return their respective versions without errors.

---

## Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/Selenium-Letcode-Project.git
cd Selenium-Letcode-Project
```

### Step 2: Configure WebDriver Executables

1. Download the appropriate WebDriver for your browser:
   - **Chrome**: [ChromeDriver](https://chromedriver.chromium.org/) (matches your Chrome version)
   - **Edge**: [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
   - **Firefox**: [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

2. Create the drivers directory and place executables:
   ```bash
   mkdir -p driver-resources/drivers
   # Place downloaded WebDriver executables here
   ```

3. Set executable permissions (Linux/Mac):
   ```bash
   chmod +x driver-resources/drivers/chromedriver
   chmod +x driver-resources/drivers/geckodriver
   chmod +x driver-resources/drivers/msedgedriver
   ```

4. Update WebDriver paths in `src/test/resources/driver-config.properties`:
   ```properties
   driver.chrome.system.value.driver.file.path=driver-resources/drivers/chromedriver.exe
   driver.edge.system.value.driver.file.path=driver-resources/drivers/msedgedriver.exe
   driver.firefox.system.value.driver.file.path=driver-resources/drivers/geckodriver.exe
   ```

### Step 3: Build the Project

```bash
mvn clean install
```

This command compiles the project, runs all tests, and generates reports.

---

## Project Structure

```
Selenium-Letcode-Project/
│
├── src/
│   ├── main/java/com/letcode/automation/
│   │   ├── pages/                             # Page Object Model
│   │   │   ├── AlertPage.java                 # Alert page locators & methods
│   │   │   ├── TablePage.java                 # Table page locators & methods
│   │   │   ├── CommonPageObject.java          # Shared page components
│   │   │
│   │   ├── actions/                           # Action classes
│   │   │   ├── AlertPageActions.java          # Alert interaction operations
│   │   │   └── TablePageActions.java          # Table interaction operations
│   │   │
│   │   ├── listeners/                         # TestNG listeners
│   │       ├── BaseClassListener.java         # Suite-level initialization
│   │       └── TestListener.java              # Test execution tracking
│   │
│   └── test/
│       ├── java/com/letcode/automation/test/
│       │   ├── AlertTest.java                 # Alert test cases
│       │
│       └── resources/
│           └── driver-config.properties       # WebDriver & environment config
│
├── test-suites/                               # TestNG XML suite files
│   ├── AlertTest.xml                          # Alert test suite
│   └── SimpleTableTest.xml                    # Table test suite
│
├── reports/                                    # Generated test reports
│   └── [DATE]/[TEST_NAME]/[TIMESTAMP].html
│
├── driver-resources/
│   └── drivers/                                # WebDriver executables
│       ├── chromedriver.exe
│       ├── msedgedriver.exe
│       └── geckodriver.exe
│
├── pom.xml                                     # Maven configuration
├── README.md                                   # This file
└── .gitignore                                  # Git ignore rules
```

---

## Running Tests

### Quick Start

```bash
# Run all tests
mvn clean test

# Run with verbose output
mvn clean test -X
```

### Run Specific Test Suite

```bash
# Alert tests only
mvn clean test -DsuiteFile=test-suites/AlertTest.xml

# Table tests only
mvn clean test -DsuiteFile=test-suites/SimpleTableTest.xml
```

### Cross-Browser Execution

```bash
# Chrome (default)
mvn clean test -Dbrowser=chrome

# Edge
mvn clean test -Dbrowser=edge

# Firefox
mvn clean test -Dbrowser=firefox
```

### Combined Examples

```bash
# Run Alert tests on Firefox
mvn clean test -DsuiteFile=test-suites/AlertTest.xml -Dbrowser=firefox

# Run Table tests on Edge with verbose output
mvn clean test -DsuiteFile=test-suites/SimpleTableTest.xml -Dbrowser=edge -X
```

---

## Architecture & Design Patterns

### Page Object Model (POM)

Encapsulates web page elements and interactions within dedicated page classes, promoting maintainability and reusability.

**Implementation**:
- **Single Responsibility**: Each page class manages one page/feature
- **Element Locators**: Centralized in `@Getter` annotated fields using XPath, CSS selectors
- **Page Methods**: Action methods return the same or new page object for method chaining
- **No Test Logic**: Pages contain only element locators and low-level operations

**Example**:
```java
@Getter
public class AlertPage {
    private final By simpleAlertButtonLocator = By.xpath("//button[text()='Simple Alert']");
    private final By confirmAlertLocator = By.xpath("//button[text()='Confirm Alert']");
}
```

### Action-Based Pattern

Implements business logic through action classes that provide high-level operations using low-level page operations.

**Benefits**:
- Clear separation from page structure
- Reusable methods for common workflows
- Improved test readability and maintainability
- Easy updates when business logic changes

**Example**:
```java
public class AlertPageActions {
    public String getSimpleAlertMessage() {
        driver.findElement(alertPage.getSimpleAlertButtonLocator()).click();
        return driver.switchTo().alert().getText();
    }
    
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
```

### Test Listener Pattern

Manages test lifecycle events through TestNG listeners for cross-cutting concerns.

**BaseClassListener**:
- Loads configuration properties
- Initializes WebDriver instance
- Navigates to base application URL
- Executes at suite level (before all tests)

**TestListener**:
- Logs test execution details
- Handles test pass/fail/skip events
- Captures screenshots on failure
- Cleans up resources after each test

---

## Configuration

### Driver Configuration (driver-config.properties)

Located at: `src/test/resources/driver-config.properties`

```properties
# WebDriver Executables
driver.chrome.system.key=webdriver.chrome.driver
driver.chrome.system.value.driver.file.path=driver-resources/drivers/chromedriver.exe

driver.edge.system.key=webdriver.msedge.driver
driver.edge.system.value.driver.file.path=driver-resources/drivers/msedgedriver.exe

driver.firefox.system.key=webdriver.gecko.driver
driver.firefox.system.value.driver.file.path=driver-resources/drivers/geckodriver.exe

# Browser Process Cleanup (Windows)
driver.chrome.driver.kill=taskkill /f /im chromedriver.exe
driver.chrome.browser.kill=taskkill /f /im chrome.exe

driver.edge.driver.kill=taskkill /f /im msedgedriver.exe
driver.edge.browser.kill=taskkill /f /im msedge.exe

driver.firefox.driver.kill=taskkill /f /im geckodriver.exe
driver.firefox.browser.kill=taskkill /f /im firefox.exe

# Application URL
driver.letcode.url=https://letcode.in/test
```

### Test Suite Configuration

**AlertTest.xml**: Configures alert-related test cases
**SimpleTableTest.xml**: Configures table-related test cases

Modify `<parameter>` elements in XML files to pass custom parameters to tests.

---

## Test Coverage

### Alert Tests (`AlertTest.java`)

Validates alert handling functionality across different alert types:

| Test Case | Description | Validation |
|-----------|-------------|-----------|
| validateSimpleAlert | Accept simple JavaScript alert | Verify alert message content |
| validateConfirmAlert | Accept/dismiss confirmation dialog | Verify button interactions |
| validatePromptAlert | Handle user input prompts | Verify input acceptance |

**Run Alert Tests**:
```bash
mvn clean test -DsuiteFile=test-suites/AlertTest.xml
```
---

## Test Reports

Test execution generates comprehensive HTML reports automatically.

**Report Location**: `reports/[DATE]/[TEST_NAME]/[TIMESTAMP].html`

**Example Paths**:
```
reports/13.Apr.2025/AlertTest/AlertTest_20250413_144044.html
```

**Report Contents**:
- Test execution summary (passed/failed/skipped counts)
- Individual test case results with execution time
- Detailed assertions and failure messages
- Stack traces for debugging failures
- Browser and environment information

---

## Adding New Tests

### Step 1: Create Test Class

Create a new test class in `src/test/java/com/letcode/automation/test/`:

```java
package com.letcode.automation.test;

import com.letcode.automation.actions.YourPageActions;
import com.letcode.automation.listeners.BaseClassListener;
import com.letcode.automation.listeners.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseClassListener.class, TestListener.class})
public class YourTest {
    private YourPageActions pageActions;
    
    @BeforeClass
    public void setup() {
        pageActions = new YourPageActions();
    }
    
    @Test(priority = 1)
    public void testScenario() {
        // Test implementation
    }
}
```

### Step 2: Create Page Object

Create page class in `src/main/java/com/letcode/automation/pages/`:

```java
package com.letcode.automation.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class YourPage {
    private final By elementLocator = By.xpath("//your/xpath");
}
```

### Step 3: Create Action Class

Create action class in `src/main/java/com/letcode/automation/actions/`:

```java
package com.letcode.automation.actions;

import com.letcode.automation.pages.YourPage;
import org.openqa.selenium.WebDriver;

public class YourPageActions {
    private WebDriver driver;
    private YourPage yourPage = new YourPage();
    
    public void performAction() {
        driver.findElement(yourPage.getElementLocator()).click();
    }
}
```

### Step 4: Create Test Suite (Optional)

Create `test-suites/YourTest.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="YourTestSuite">
    <test name="YourTest">
        <parameter name="browser" value="chrome"/>
        <parameter name="testName" value="YourTest"/>
        <classes>
            <class name="com.letcode.automation.test.YourTest"/>
        </classes>
    </test>
</suite>
```

### Step 5: Run New Tests

```bash
mvn clean test -DsuiteFile=test-suites/YourTest.xml
```

---

## Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Core programming language |
| **Selenium** | 4.x | Web browser automation |
| **TestNG** | Latest | Test framework & assertions |
| **Maven** | 3.6+ | Build & dependency management |
| **Lombok** | Latest | Reduce boilerplate code |
| **SLF4J** | Latest | Logging framework |
| **Maven Surefire** | 3.1.2 | Test execution plugin |

---

## Troubleshooting

### Issue: WebDriver Not Found

**Error**: `Cannot find chromedriver executable`

**Solution**:
1. Verify WebDriver is in `driver-resources/drivers/`
2. Check paths in `driver-config.properties`
3. Ensure file permissions are set correctly:
   ```bash
   chmod +x driver-resources/drivers/chromedriver
   ```

### Issue: Tests Timeout

**Error**: `TimeoutException: timeout after X seconds`

**Solution**:
1. Increase wait times in listeners
2. Verify application URL is accessible
3. Check internet connectivity
4. Adjust timeouts in action classes:
   ```java
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   ```

### Issue: Permission Denied on Linux/Mac

**Error**: `Permission denied executing driver`

**Solution**:
```bash
chmod +x driver-resources/drivers/chromedriver
chmod +x driver-resources/drivers/geckodriver
chmod +x driver-resources/drivers/msedgedriver
```

### Issue: Maven Build Failures

**Error**: `[ERROR] BUILD FAILURE`

**Solution**:
```bash
# Clean Maven cache
mvn clean install -U

# Skip tests during build
mvn clean install -DskipTests

# View detailed error logs
mvn clean test -X
```

### Issue: Stale Element Reference

**Error**: `StaleElementReferenceException`

**Solution**:
- Re-locate elements after page navigation
- Use explicit waits instead of implicit waits
- Refresh page references in action methods

---

## Best Practices Implemented

1. **Page Object Model** - Scalable and maintainable test architecture
2. **Separation of Concerns** - Clear division between pages, actions, tests
3. **DRY Principle** - Reusable methods and components
4. **Configuration Management** - Externalized and parameterized setup
5. **Comprehensive Logging** - Detailed execution logs for debugging
6. **Automated Reporting** - HTML reports with test metrics
7. **Cross-browser Support** - Seamless execution across browsers
8. **Error Handling** - Graceful failure handling and cleanup

---

## Contributing

### Code Quality Standards

- Follow Java naming conventions (camelCase for variables/methods, PascalCase for classes)
- Use meaningful names that describe intent
- Keep methods small and focused
- Write self-documenting code
- Add comments for complex logic
- Use Lombok annotations to reduce boilerplate


## Resources

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Official Documentation](https://testng.org/documentation.html)
- [Maven Project Guide](https://maven.apache.org/guides/)
- [LetCode.in - Test Automation Practice](https://letcode.in/)
- [Page Object Model Best Practices](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
- [Lombok Documentation](https://projectlombok.org/features/all)
- [SLF4J Manual](http://www.slf4j.org/manual.html)

---
