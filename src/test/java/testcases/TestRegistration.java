package testcases;

import constants.LumaConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Registration;

import java.time.Duration;

public class TestRegistration {
    private WebDriver driver;
    private Registration registration;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(LumaConstants.CREATE_USER_URL.getValue());
        registration = new Registration(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRegistration() {
        String firstName = "Jon";
        String lastName = "Doe";
        registration.userRegistration(firstName, lastName);
        assert driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account");
        WebElement dashboard = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div[2]/div/strong/span"));
        wait.until(ExpectedConditions.visibilityOf(dashboard));
//        assert driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div[2]"))
//                .getText().contains(firstName + " " + lastName);
    }
}
