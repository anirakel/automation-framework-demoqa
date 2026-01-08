import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BaseTest {

    UserData userData = Utils.fromJson("C:\\Users\\Acer\\Desktop\\Java Projects\\Lesson 1\\ListWebPage\\src\\main\\resources\\userData.json", UserData.class);
    SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://demoqa.com/");
        MainPage homePage = new MainPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}