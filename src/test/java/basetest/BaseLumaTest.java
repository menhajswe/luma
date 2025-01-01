package basetest;

import constants.LumaConstants;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseLumaTest {
    // update the logger to use either selenium or log4j
    protected Logger LOG = LoggerFactory.getLogger(BaseLumaTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected int timeoutInSec = 5;

    protected String baseUrl = LumaConstants.BASE_URL.getValue();

    public BaseLumaTest(String browser) {
        driver = getWebDriverBrowser(browser);
        driver.get(baseUrl);
    }

    public void setTimeoutInSec(int timeoutInSec) {
        this.timeoutInSec = timeoutInSec;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec));
    }

    public int getTimeoutInSec() {
        return this.timeoutInSec;
    }

    public void updateUrl(String newUrl) {
        this.baseUrl = newUrl;
        driver.get(newUrl);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        return isDisplayed(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isDisplayed(ExpectedCondition expectedCondition) {
        try {
            wait.until(expectedCondition);
        } catch (TimeoutException ex) {
            LOG.error(() -> "Element not found: " + ex.getMessage() + " after waiting for " + timeoutInSec + " seconds");
            return false;
        }
        return true;
    }

    public void setDriver(String newUrl) {
        this.baseUrl = newUrl;
    }

    public String getUrl() {
        return this.baseUrl;
    }


    // TODO: Add capabilities to detect the host machine's OS and browser
    private WebDriver getWebDriverBrowser(String browserType) {
        return switch (browserType.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            default -> {
                System.out.println("Using default browser chrome");
                yield new ChromeDriver();
            }
        };
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
