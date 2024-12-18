package pages;

import constants.LumaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver webDriver) {
        driver = webDriver;
    }

    public void userLogin() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(LumaConstants.EMAIL.getValue());
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(LumaConstants.PASSWORD.getValue());
        driver.findElement(By.xpath("//button[@class='action login primary']/span[.='Sign In']")).click();
    }

    public void userResetPassword() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword");
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(LumaConstants.EMAIL.getValue());
        driver.findElement(By.xpath("//span[.='Reset My Password']")).click();
    }
}
