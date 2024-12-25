package testcases;

import constants.LumaConstants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.Logout;
import pages.Registration;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TestLogout {
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.get(LumaConstants.BASE_URL.getValue());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Test login, cookie and logout")
    public void testLoginLogOut() {
        driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
        Registration registration = new Registration(driver);
        registration.userRegistrationAddingToCookie("Liam", "Afghan");
        // a20056@b.com
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();
        // confirm you singed out. assert el.getText() == //span[@class='base']
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        Login login = new Login(driver);
        login.userLoginWithCookieCredentials();
        // read browser data for the stored credentials.

//        Set<Cookie> cookies = driver.manage().getCookies();
//        for (Cookie cookie: cookies) {
//            System.out.println(cookie);
//        }
        Logout logout = new Logout(driver);
        logout.logOut();

        // TODO: replace it with wait until url changes then run assertion. @mehajswe
        try {
            Thread.sleep(6000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assert Objects.requireNonNull(driver.getCurrentUrl()).contains("https://magento.softwaretestingboard.com/");
        CookieManager.deleteAllCookies(driver);

        assert registration.isCookieExist();

    }
}
