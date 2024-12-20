package testcases;

import constants.LumaConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login;

import java.time.Duration;

public class TestLogin {
    WebDriver driver;
    Login loginTestUser;
    WebDriverWait wait;


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(LumaConstants.SIGNIN_URL.getValue());
        loginTestUser = new Login(driver);
    }


    @Test()
    @DisplayName("Testing Login")
//    @Disabled("Temporarily disabled for debugging other tests.")
    public void testLogin() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        loginTestUser.userLogin();
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assertions.assertEquals(driver.getCurrentUrl(),expectedUrl);
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div[2]/div/div[1]/p")).getText().contains(""));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
