package pages;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FileReader;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import static utils.TestPasswordGenerator.emailAndPasswordWriterToFile;

public class Registration {
    private static final Logger LOGGER = LoggerFactory.getLogger(Registration.class);
    private WebDriver driver;

    private By firstNameLocator = By.xpath("//input[@id='firstname']");
    private By lastNameLocator = By.xpath("//input[@id='lastname']");
    private By emailLocator = By.xpath("//input[@id='email_address']");
    private By passwordLocator = By.xpath("//input[@id='password']");
    private By confirmPasswordLocator = By.xpath("//input[@id='password-confirmation']");
    private By submitButtonLocator = By.xpath("//button[@class='action submit primary']");

    public Registration(WebDriver webDriver) {
        this.driver = webDriver;
        // Using randomly generated user and password registration and storing the these
        // mocked email and passwords for later login confirmation.
        try {
            emailAndPasswordWriterToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void userRegistration(String firstName, String lastName) {
        List<Map<String, String>> users = FileReader.fileReader();
        //TODO @menhajswe: Use a list of random names to file the form.
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(emailLocator).sendKeys(users.getLast().get("email"));
        driver.findElement(passwordLocator).sendKeys(users.getLast().get("password"));
        driver.findElement(confirmPasswordLocator).sendKeys(users.getLast().get("password"));
        driver.findElement(submitButtonLocator).click();
        // alt path: By.xpath("//button[@class='action submit primary']/span[.='Create an Account']")
    }


}
