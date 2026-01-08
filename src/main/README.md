# Automation Framework DemoQA

**Selenium + TestNG automation framework** for [DemoQA](https://demoqa.com/) website.

A structured framework using **Page Object Model (POM)**, data-driven tests, and reusable utilities

## 🛠 Technologies
- Java, Selenium WebDriver, TestNG
- WebDriverManager & Maven
- Jackson (JSON test data)
- Logback (logging)
- 
## 🏗 Project Structure
src/
├── main/java/pages # Page Objects (MainPage, ElementsPage, BasePage)
├── main/java/utils # Utilities (DriverManager, Utils)
├── main/java/data # Test Data Model (UserData)
└── test/java/tests # TestNG Test Classes (TextBox, WebTables)

## 🧪 How to Run
```bash
git clone https://github.com/anirakel/automation-framework-demoqa.git
cd automation-framework-demoqa
mvn clean test

Tests use JSON data from src/main/resources/userData.json.
ChromeDriver is automatically handled via WebDriverManager.
Soft assertions used for multiple validations per test.

✅ Features Tested
Text Box form submission
Web Tables: Add, Edit, Delete rows
