import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

        log.info("Initialized page: {}", this.getClass().getSimpleName());
    }

    protected WebElement waitForVisibility(By locator) {
        log.debug("Waiting for visibility of element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        log.debug("Waiting for element to be clickable: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        log.info("Clicking on element located by: {}", locator);
        waitForClickable(locator).click();
        log.info("Clicked on element: {}", locator);
    }

    protected void type(By locator, String text) {
        log.info("Typing text '{}' into element: {}", text, locator);
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
        log.info("Text typed successfully");
    }

    protected void clickOn(WebElement element) {
        log.info("Clicking on WebElement: {}", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("WebElement clicked successfully");
    }

    protected void fillAfterClick(WebElement element, String text) {
        log.info("Clicking on input element: {}", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        log.info("Clearing and typing text: {}", text);
        element.clear();
        element.sendKeys(text);

        log.info("Text entered successfully");
    }

    protected void fillInput(WebElement element, String text) {

        wait.until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        element.clear();
        element.sendKeys(text);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }
}
