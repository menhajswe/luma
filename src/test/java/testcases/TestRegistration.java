package testcases;

import constants.LumaConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Registration;

public class TestRegistration {
    private final String firstName = "zack";
    private final String lastName = "jack";

    private WebDriver driver;
    private Registration registration;

//    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(LumaConstants.CREATE_USER_URL.getValue());
        registration = new Registration(firstName, lastName, LumaConstants.EMAIL.getValue(), LumaConstants.PASSWORD.getValue());
    }

//    @AfterEach
    public void teardown() {
        driver.quit();
    }

//    @Test
    public void testRegistration() {
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(registration.getFirstName());
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(registration.getLastName());
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(registration.getEmail());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(registration.getPassWorld());
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys(registration.getPassWorld());
        driver.findElement(By.xpath("//button[@class='action submit primary']/span[.='Create an Account']")).click();
    }
}
