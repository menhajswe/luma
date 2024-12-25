package testcases;

import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {
    private WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public void addCookieEmailPasswordKeyValuePair(String email, String password) {
        driver.manage().addCookie(new Cookie(email, password));
    }

    public void addEmailToCookie(String emailKey, String emailValue) {
        driver.manage().addCookie(new Cookie(emailKey, emailValue));
    }

    public void addPasswordToCookie(String passwordKey, String passwordValue) {
        driver.manage().addCookie(new Cookie(passwordKey, passwordValue));
    }

    public void deleteCookie() {
        try {
            throw new ExecutionControl.NotImplementedException("Not implemented");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
//        driver.manage().deleteCookie();
    }

    public static void deleteAllCookies(WebDriver webDriver) {
        webDriver.manage().getCookies().clear();
    }
}
