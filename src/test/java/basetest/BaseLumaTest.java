package basetest;

import constants.LumaConstants;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLumaTest {
    protected Logger LOG = LoggerFactory.getLogger(BaseLumaTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = LumaConstants.BASE_URL.getValue();

    public BaseLumaTest(String browser) {
        driver = getWebDriverBrowser(browser);
        driver.get(baseUrl);
    }

    public void setDriver(String newUrl) {
        this.baseUrl = newUrl;
    }

    public String getUrl() {
        return this.baseUrl;
    }

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
}
