import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[1]")
    private WebElement textBoxMenu;
    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[2]")
    private WebElement checkBoxMenu;
    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[3]")
    private WebElement radioButtonMenu;
    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[4]")
    private WebElement webTablesMenu;
    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[5]")
    private WebElement buttonsMenu;
    @FindBy(xpath = "//div[@class='element-list collapse show']//ul//li[6]")
    private WebElement linksMenu;
    @FindBy(xpath = "//div[contains(@class,'col-md-3')]//label[@id='userName-label']")
    private WebElement fullNameLabel;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement fullNameInput;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmailInput;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddressTextBox;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddressInput;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[1]")
    private WebElement nameResult;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[2]")
    private WebElement emailResult;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[3]")
    private WebElement currentAddressResult;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']//p[4]")
    private WebElement permananetAddressResult;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement addButton;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageInput;
    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salaryInput;
    @FindBy(xpath = "//input[@id='department']")
    private WebElement departmentInput;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButtonWebTables;
    @FindBy(xpath = "//div[@class='action-buttons']//span[@id='edit-record-4']")
    private WebElement editingButton;

    @FindBy(xpath = "//span[@id='delete-record-4']")
    private WebElement deleteButton;

    public ElementsPage clickOnSubmitButton() {
        log.info("Clicking on Submit Button");
        clickOn(submitButton);
        return this;
    }

    public ElementsPage clickOnDeleteButton() {
        log.info("Clicking on Delete Button");
        clickOn(deleteButton);
        return this;
    }

    public ElementsPage clickOnEditingButton() {
        log.info("Clicking on Editing Button");
        safeClick(editingButton);
        return this;
    }

    public ElementsPage clickOnSubmitButtonOnWebPage() {
        log.info("Clicking on Submit Button On Web Page");
        clickOn(submitButtonWebTables);
        return this;
    }

    public ElementsPage clickOnTextBoxMenu() {
        log.info("Clicking on Text Box Menu");
        clickOn(textBoxMenu);
        return this;
    }

    public ElementsPage clickOnWebTableMenu() {
        log.info("Clicking on Web Table Menu");
        clickOn(webTablesMenu);
        return this;
    }

    public ElementsPage clickOnAddButton() {
        log.info("Clicking on Add Button");
        clickOn(addButton);
        return this;
    }

    public ElementsPage fillFullName(String fullName) {
        log.info("Click Full Name. ");
        fillAfterClick(fullNameInput, fullName);
        return this;
    }

    public ElementsPage fillEmail(String email) {
        log.info("Click Email . ");
        fillInput(userEmailInput, email);
        return this;
    }

    public ElementsPage fillTextBox(String textBox) {
        log.info("Fill Text Box . ");
        fillAfterClick(currentAddressTextBox, textBox);
        return this;
    }

    public ElementsPage fillPermanentAddress(String permanentAddress) {
        scrollToElement(permanentAddressInput);
        log.info("Fill Permanent Address . ");
        fillInput(permanentAddressInput, permanentAddress);
        return this;
    }

    public ElementsPage fillFirstName(String firstName) {
        log.info("Fill First Name . ");
        fillInput(firstNameInput, firstName);
        return this;
    }

    public ElementsPage fillLastName(String lastName) {
        log.info("Fill Last Name . ");
        fillInput(lastNameInput, lastName);
        return this;
    }

    public ElementsPage fillEmailForWebTable(String emailForWebTable) {
        log.info("Fill Last Name . ");
        fillInput(emailInput, emailForWebTable);
        return this;
    }

    public ElementsPage fillAge(String age) {
        log.info("Fill Age . ");
        fillInput(ageInput, age);
        return this;
    }

    public ElementsPage fillSalary(String salary) {
        log.info("Fill Salary . ");
        fillInput(salaryInput, salary);
        return this;
    }

    public ElementsPage fillDepartment(String department) {
        log.info("Fill Department . ");
        fillInput(departmentInput, department);
        return this;
    }

    public String getOutputName() {
        return fullNameInput.getText();
    }

    public String getOutputEmail() {
        return userEmailInput.getText();
    }

    public String getOutputCurrentAddress() {
        return currentAddressTextBox.getText();
    }

    public String getPermanentAddress() {
        return permanentAddressInput.getText();
    }

    public WebElement getNameResult() {
        return nameResult;
    }

    public WebElement getEmailResult() {
        return emailResult;
    }

    public WebElement getCurrentAddressResult() {
        return currentAddressResult;
    }

    public WebElement getPermanentAddressResult() {
        return permananetAddressResult;
    }

    public boolean isRowWithFirstNameDisplayed(String firstName) {
        try {
            return driver.findElement(
                    By.xpath("//div[@class='rt-tr-group'][.//div[text()='" + firstName + "']]")
            ).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToNextPageIfExists() {
        List<WebElement> nextButtons = driver.findElements(By.cssSelector(".-next button"));
        if (!nextButtons.isEmpty() && nextButtons.get(0).isEnabled()) {
            nextButtons.get(0).click();
        }
    }
}
