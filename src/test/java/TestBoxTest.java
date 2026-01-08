import org.testng.annotations.Test;

public class TestBoxTest extends BaseTest {
    @Test(description = "Verify user can fill Text Box form successfully")
    public void shouldFillTextBoxForm() {
        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        mainPage
                .clickElementsCard();
        elementsPage
                .clickOnTextBoxMenu()
                .fillFullName(userData.getFullName())
                .fillEmail(userData.getEmail())
                .fillTextBox(userData.getCurrentAddress())
                .fillPermanentAddress(userData.getPermanentAddress());
        softAssert.assertTrue(userData.getFullName().contains(elementsPage.getOutputName()), "Full Name mismatch");
        softAssert.assertTrue(userData.getEmail().contains(elementsPage.getOutputEmail()), "Email mismatch");
        softAssert.assertTrue(userData.getCurrentAddress().contains(elementsPage.getOutputCurrentAddress()), "Current Address mismatch");
        softAssert.assertTrue(userData.getPermanentAddress().contains(elementsPage.getPermanentAddress()), "Permanent Address mismatch");
        elementsPage
                .clickOnSubmitButton();
        softAssert.assertEquals(userData.getFullName(), elementsPage.getNameResult().getText().replace("Name:", "").trim(), "Name mismatch");
        softAssert.assertEquals(userData.getEmail(), elementsPage.getEmailResult().getText().replace("Email:", "").trim(), "Email mismatch");
        softAssert.assertEquals(userData.getCurrentAddress(), elementsPage.getCurrentAddressResult().getText().replace("Current Address :", "").trim(), "Current Address mismatch");
        softAssert.assertEquals(userData.getPermanentAddress(), elementsPage.getPermanentAddressResult().getText().replace("Permananet Address :", "").trim(), "Permanent Address mismatch");
        softAssert.assertAll();
    }

}
