# Selenium Automation Workspace

A comprehensive test automation ecosystem built with modern Selenium Java practices. This workspace demonstrates enterprise-grade automation framework design with reusable components, design patterns, and best practices.

## 📂 Project Overview

This workspace contains two complementary projects that work together to provide a complete automation testing solution:

### 1. **Selenium-Central-Framework** 🛠️
A modular utility framework providing reusable components for Selenium-based automation projects.

**Purpose**: Simplify common automation tasks and reduce code duplication across projects.

**Key Modules**:
- **selenium-driver-util** - WebDriver lifecycle management and initialization
- **date-util** - Date handling and formatting utilities
- **report-util** - HTML report generation and result logging
- **generic-utils** - Common helper functions and utilities
- **logging-util** - Comprehensive logging with SLF4J integration
- **excel-utils** - Excel file reading and data-driven testing support
- **assert-util** - Custom assertion framework with enhanced validation

**Tech Stack**: 
- Java 17
- Maven (Multi-module POM structure)
- SLF4J for logging
- Selenium WebDriver

---

### 2. **Selenium-Letcode-Project** 🧪
A practical test automation project that validates the LetCode.in website using the Page Object Model pattern.

**Purpose**: Demonstrate real-world automation testing with industry best practices.

**Test Coverage**:
- **Alert Tests** - Handle simple alerts, confirm dialogs, and prompt alerts
- **Table Tests** - Complex table interactions and data validation

**Project Highlights**:

#### Architecture & Design Patterns
- **Page Object Model (POM)** - Organized page classes with locators
- **Action-Based Pattern** - Reusable action classes for page interactions
- **Listener Pattern** - Test lifecycle management with custom listeners
- **Configuration Management** - Properties-based driver and environment configuration

#### Key Components

**Pages** (`src/main/java/com/letcode/automation/pages/`):
- `AlertPage.java` - Locators for alert interactions
- `TablePage.java` - Table element selectors
- `CommonPageObject.java` - Shared navigation and common actions
- `SimpleTableConfig.java` - Configuration for table test scenarios

**Actions** (`src/main/java/com/letcode/automation/actions/`):
- `AlertPageActions.java` - Alert interaction methods
- `TablePageActions.java` - Table navigation and validation methods

**Listeners** (`src/main/java/com/letcode/automation/listeners/`):
- `BaseClassListener.java` - Suite-level setup with driver initialization
- `TestListener.java` - Test-level reporting and execution tracking

**Tests** (`src/test/java/com/letcode/automation/test/`):
- `AlertTest.java` - End-to-end alert test scenarios
- `SimpleTableTest.java` - Table handling and data validation tests

#### Configuration
- **Driver Config** - Multi-browser support (Chrome, Edge, Firefox)
- **WebDriver Path Management** - Configurable driver executable locations
- **Test Suites** - XML-based test suite configuration for parallel/targeted execution

#### Reporting & Test Execution
- **Custom Assertions** - Enhanced validation with detailed failure messages
- **HTML Reports** - Generated test reports with timestamps (stored in `reports/`)
- **Test Suite Management** - XML files for organized test execution
- **Maven Integration** - Surefire plugin for CI/CD compatibility

**Tech Stack**:
- Java 17
- Selenium WebDriver 4.x
- TestNG (Test Framework)
- Maven (Build & Dependency Management)
- Lombok (Boilerplate Reduction)
- SLF4J (Logging)
- Selenium-Central-Framework (Custom Utilities)

---

## 🏗️ Architecture Diagram

```
┌─────────────────────────────────────────────────────────┐
│         Selenium-Letcode-Project (Test Suite)           │
├─────────────────────────────────────────────────────────┤
│  Tests (AlertTest, SimpleTableTest)                     │
│    ↓                                                    │
│  Actions (AlertPageActions, TablePageActions)           │
│    ↓                                                    │
│  Pages (AlertPage, TablePage, CommonPageObject)         │
│    ↓                                                    │
│  Listeners (BaseClassListener, TestListener)            │
└──────────────────────────┬──────────────────────────────┘
                           │ depends on
                           ↓
┌─────────────────────────────────────────────────────────┐
│    Selenium-Central-Framework (Utility Modules)         │
├─────────────────────────────────────────────────────────┤
│  ├─ selenium-driver-util:    WebDriver Management       │
│  ├─ report-util:              Report Generation         │
│  ├─ logging-util:             Logging Framework         │
│  ├─ assert-util:              Custom Assertions         │
│  ├─ excel-utils:              Data Handling             │
│  ├─ date-util:                Date Utilities            │
│  └─ generic-utils:            Helper Functions          │
└─────────────────────────────────────────────────────────┘
```

---

## 📊 Key Features

### For the Test Automation Project
- **Page Object Model** - Clean separation of test logic and page elements  
- **Cross-browser Testing** - Chrome, Edge, Firefox support with configurable drivers  
- **Reusable Actions** - Action-based methods that abstract complex interactions  
- **Custom Assertions** - Enhanced validation with meaningful error messages  
- **Test Listeners** - Automatic driver initialization, reporting, and cleanup  
- **Configuration Management** - Externalized configuration for flexibility  
- **HTML Reports** - Detailed test execution reports with timestamps  
- **XML Test Suites** - Support for parallel and selective test execution  

### For the Central Framework
- **Modular Design** - Each utility is independent and reusable  
- **WebDriver Management** - Simplified driver initialization and lifecycle  
- **Comprehensive Logging** - SLF4J integration for debugging  
- **Custom Assertions** - Hard and soft assertions for flexible validation  
- **Report Generation** - Automated HTML report creation  
- **Excel Support** - Data-driven testing capabilities  
- **Date Utilities** - Common date operations and formatting  
- **Generic Helpers** - Reduced code duplication across projects  

---

##  Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Chrome/Edge/Firefox browser and corresponding WebDriver

### Setup Instructions

1. **Clone the repositories**
   ```bash
   git clone https://github.com/yourusername/Selenium-Central-Framework.git
   git clone https://github.com/yourusername/Selenium-Letcode-Project.git
   ```

2. **Build the Central Framework** (dependency for projects)
   ```bash
   cd Selenium-Central-Framework
   mvn clean install
   ```

3. **Build the Letcode Project**
   ```bash
   cd Selenium-Letcode-Project
   mvn clean install
   ```

4. **Configure WebDrivers**
   - Place your WebDriver executables in `driver-resources/drivers/`
   - Update paths in `src/test/resources/driver-config.properties` if needed

5. **Run Tests**
   ```bash
   # Run all tests
   mvn clean test
   
   # Run specific test suite
   mvn clean test -DsuiteFile=test-suites/AlertTest.xml
   
   # Run with specific browser
   mvn clean test -Dbrowser=chrome
   ```

---

## 📝 Test Execution Examples

### Running Alert Tests
```bash
mvn clean test -DsuiteFile=test-suites/AlertTest.xml
```

### Running Table Tests
```bash
mvn clean test -DsuiteFile=test-suites/SimpleTableTest.xml
```

### Cross-browser Testing
```bash
# Chrome
mvn clean test -Dbrowser=chrome

# Edge
mvn clean test -Dbrowser=edge

# Firefox
mvn clean test -Dbrowser=firefox
```

---

## 📁 Project Structure Details

### Selenium-Letcode-Project Structure
```
src/
├── main/java/com/letcode/automation/
│   ├── actions/          # Reusable action methods
│   ├── pages/            # Page Object classes
│   ├── listeners/        # TestNG lifecycle listeners
├── test/java/com/letcode/automation/test/
│   ├── AlertTest.java           # Alert test scenarios
│   └── SimpleTableTest.java      # Table test scenarios
└── test/resources/
    └── driver-config.properties  # Driver configuration

test-suites/
├── AlertTest.xml         # Alert test suite
└── SimpleTableTest.xml   # Table test suite
reports/                  # Generated HTML test reports
```

### Selenium-Central-Framework Structure
```
├── selenium-driver-util/  # WebDriver utilities
├── date-util/            # Date handling
├── report-util/          # Report generation
├── logging-util/         # Logging framework
├── excel-utils/          # Excel operations
├── assert-util/          # Custom assertions
└── generic-utils/        # General helpers
```

---

## 🔧 Technologies & Dependencies

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 17 | Core language |
| Selenium | 4.x | Web automation |
| TestNG | Latest | Test framework |
| Maven | 3.6+ | Build & dependency management |
| Lombok | Latest | Reduce boilerplate |
| SLF4J | Latest | Logging |
| Maven Surefire | 3.1.2 | Test execution |

---

## 💡 Learning Points & Best Practices Demonstrated

1. **Design Patterns**
   - Page Object Model for maintainable test code
   - Action-based pattern for reusable interactions
   - Listener pattern for cross-cutting concerns

2. **Framework Design**
   - Modular architecture with separation of concerns
   - Dependency injection through framework
   - Configuration externalization

3. **Test Automation**
   - Cross-browser compatibility
   - Parallel test execution support
   - Comprehensive error handling and reporting

4. **Code Quality**
   - Proper logging for debugging
   - Custom assertions with meaningful messages
   - Maven multi-module project structure

---

## 📊 Test Reports

Test execution generates HTML reports automatically:
- Reports are stored in: `reports/[DATE]/[TEST_NAME]/`
- Each test run creates a timestamped report file
- Reports include test steps, assertions, and execution time

**Example Report Path**: 
```
reports/13.Apr.2025/AlertTest/AlertTest_20250413_144044.html
```

---

## 🤝 Contributing

This workspace demonstrates professional test automation practices. Feel free to:
- Extend with additional test cases
- Add more utility modules to the framework
- Implement additional page objects and actions
- Enhance reporting capabilities

---

## 📧 Contact & Support

For questions or suggestions about this automation framework, please reach out.

---

## 📌 Key Takeaways

- **Reusable Framework**: The Central Framework eliminates duplication across projects
- **Production-ready**: Implements industry best practices and patterns
- **Scalable Design**: Easy to add new test cases and extend functionality
- **Professional Quality**: Comprehensive logging, reporting, and error handling
- **Maintainable Code**: Clear separation of concerns and Page Object Model pattern

---

## 📚 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/)
- [Maven Documentation](https://maven.apache.org/)
- [LetCode.in](https://letcode.in/) - Practice website used in this project

---

**Created with ❤️ for automation excellence**
