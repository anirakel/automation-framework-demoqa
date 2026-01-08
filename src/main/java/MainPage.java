import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    private By searchInput = By.id("search");
    private By searchButton = By.cssSelector("button[type='submit']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchInput, text);
        click(searchButton);
    }
    @FindBy(xpath = "//div[contains(@class,'top-card')][1]")
    private WebElement textBoxCard;
    public void clickElementsCard() {
        log.info("Clicking on Elements card");
        safeClick(textBoxCard);
    }
}
