package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
    private WebDriver driver;
    private By dropDownLocator = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]");
    private By singoutButtonLocator = By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]");


    public Logout(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void logOut() {
//        Login login = new Login(driver);
//        login.userLogin();
        // thin how to test logout
        driver.findElement(dropDownLocator).click();
        driver.findElement(singoutButtonLocator).click();
    }
}
