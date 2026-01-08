import org.testng.annotations.Test;


public class WebTablesTest extends BaseTest {
    @Test(description = "Check default rows and new adding row process")
    public void shouldFillRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        mainPage
                .clickElementsCard();
        elementsPage
                .clickOnWebTableMenu();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Cierra"), "Cierra row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Alden"), "Alden row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Kierra"), "Kierra row is NOT present in the table");
        elementsPage
                .clickOnAddButton()
                .fillFirstName(userData.getFirstName())
                .fillLastName(userData.getLastName())
                .fillEmailForWebTable(userData.getEmail())
                .fillAge(userData.getAge())
                .fillSalary(userData.getSalary())
                .fillDepartment(userData.getDepartment())
                .clickOnSubmitButtonOnWebPage();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Cierra"), "Cierra row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Alden"), "Alden row is NOT present in the table");
        elementsPage.goToNextPageIfExists();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Kierra"), "Kierra row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Poghos"), "Poghos row is NOT present in the table");
        softAssert.assertAll();
    }

    @Test(description = "Check new adding row editing and delete process")
    public void newRowAddingAndDeleteProcess() {
        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        mainPage
                .clickElementsCard();
        elementsPage
                .clickOnWebTableMenu()
                .clickOnAddButton()
                .fillFirstName(userData.getFirstName())
                .fillLastName(userData.getLastName())
                .fillEmailForWebTable(userData.getEmail())
                .fillAge(userData.getAge())
                .fillSalary(userData.getSalary())
                .fillDepartment(userData.getDepartment())
                .clickOnSubmitButtonOnWebPage();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Poghos"), "Poghos row is NOT present in the table");
        elementsPage
                .clickOnEditingButton()
                .fillFirstName(userData.getEditingUser())
                .clickOnSubmitButtonOnWebPage();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Editing User"), "Poghos row is NOT present in the table");
        elementsPage
                .clickOnDeleteButton();
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Cierra"), "Cierra row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Alden"), "Alden row is NOT present in the table");
        softAssert.assertTrue(elementsPage.isRowWithFirstNameDisplayed("Kierra"), "Kierra row is NOT present in the table");
        softAssert.assertAll();
    }
}
