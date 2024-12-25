package pages;

import constants.LumaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.FileReader;

import java.util.List;
import java.util.Map;

public class Login {
    private WebDriver driver;
    private By emailLocator = By.xpath("//input[@id='email']");
    private By passwordLocator = By.xpath("//input[@name='login[password]']");
    private By loginButtonLocator = By.xpath("//button[@class='action login primary']/span[.='Sign In']");

    public Login(WebDriver webDriver) {
        driver = webDriver;
    }

    public void userLogin() {
        List<Map<String, String>> userAndPassword = FileReader.fileReader();
        String email = userAndPassword.getLast().get("email");
        String password = userAndPassword.getLast().get("password");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void userLoginWithCookieCredentials() {
        Cookie emailCookie = driver.manage().getCookieNamed("email");
        Cookie passwordCookie = driver.manage().getCookieNamed("password");
        assert emailCookie != null;
        driver.findElement(emailLocator).sendKeys(emailCookie.getValue());
        assert passwordCookie != null;
        driver.findElement(passwordLocator).sendKeys(passwordCookie.getValue());
        driver.findElement(loginButtonLocator).click();
    }

    public void userLogin(String username, String password) {
        driver.findElement(emailLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void userResetPassword() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword");
        driver.findElement(By.id("email_address")).sendKeys(LumaConstants.EMAIL.getValue());
        driver.findElement(By.xpath("//span[.='Reset My Password']")).click();
    }
}
