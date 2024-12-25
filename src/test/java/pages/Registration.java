package pages;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.FileReader;

import java.io.IOException;
import java.util.Map;
import java.util.List;

import static utils.TestPasswordGenerator.emailAndPasswordWriterToFile;

public class Registration {
    private static final Logger LOGGER = LoggerFactory.getLogger(Registration.class);
    private WebDriver driver;
    Map<String, String> loginCredentials;

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
            loginCredentials = emailAndPasswordWriterToFile();
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

    public void userRegistrationAddingToCookie(String firstName, String lastName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        String email = loginCredentials.get("email");
        String password = loginCredentials.get("password");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(confirmPasswordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        // alt path: By.xpath("//button[@class='action submit primary']/span[.='Create an Account']")

        // Storing login validation for logout purpose.
        Cookie emailCookie = new Cookie("email", email);
        Cookie passwordCookie = new Cookie("password", password);
        driver.manage().addCookie(emailCookie);
        driver.manage().addCookie(passwordCookie);
    }

    public boolean isCookieExist() {
        Cookie cookieEmail = driver.manage().getCookieNamed("email");
        Cookie cookiePass = driver.manage().getCookieNamed("password");
        if ((cookieEmail == null || cookieEmail.getValue().isEmpty()) &&
                (cookiePass == null || cookiePass.getValue().isEmpty())) {
            return false;
        }
        return true;
    }
}
