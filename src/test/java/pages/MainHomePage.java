package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainHomePage {
    private WebDriver driver;

    // Define locators
    private static final String HOME_PAGE_URL = "https://magento.softwaretestingboard.com";

    private By whatsNewLocator = By.xpath("//a[@href='https://magento.softwaretestingboard.com/what-is-new.html']");
    private By womenSecLocator = By.xpath("//span[normalize-space()='Women']");
    private By menSelectionLocator = By.xpath("//a[@id='ui-id-5']");
    private By gearLocator = By.xpath("//span[normalize-space()='Gear']");
    private By trainingLocator = By.xpath("//span[normalize-space()='Training']");
    private By saleLocator = By.xpath("//span[normalize-space()='Sale']");
    private By newProducts = By.xpath("//strong[@class='title']");
    private By ulLocator = By.xpath("//div/ol");
    private By listLocator = By.xpath("//div/ol/li");
    private By homePageTitleLocator = By.xpath("//div/h1/span[@class=\"base\"]");
    private By linkToPromoPage = By.xpath("//div/a[@class='block-promo home-main']");
    private By imgMainHomePage = By.xpath("//div/a[@class='block-promo home-main']/img");

    // Constructor
    public MainHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the Home Page
    public void navigateToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    // Get the title of the Home Page
    public String getHomePageTitle() {
        return driver.findElement(homePageTitleLocator).getText();
    }

    // Click on the "What's New" link
    public void clickWhatsNew() {
        driver.findElement(whatsNewLocator).click();
    }

    // Click on the "Women" section
    public void clickWomenSection() {
        driver.findElement(womenSecLocator).click();
    }

    // Click on the "Men" section
    public void clickMenSection() {
        driver.findElement(menSelectionLocator).click();
    }

    // Click on the "Gear" section
    public void clickGearSection() {
        driver.findElement(gearLocator).click();
    }

    // Click on the "Training" section
    public void clickTrainingSection() {
        driver.findElement(trainingLocator).click();
    }

    // Click on the "Sale" section
    public void clickSaleSection() {
        driver.findElement(saleLocator).click();
    }

    // Get the list of new products
    public String getNewProductsTitle() {
        return driver.findElement(newProducts).getText();
    }

    // Get the list of items under "ulLocator"
    public List<WebElement> getListItems() {
        return driver.findElements(listLocator);
    }

    // Get the first item from the list
    public WebElement getFirstListItem() {
        return driver.findElement(listLocator);
    }

    // Click on the promotional link
    public void clickPromoLink() {
        driver.findElement(linkToPromoPage).click();
    }

    // Get the promo image on the home page
    public WebElement getPromoImage() {
        return driver.findElement(imgMainHomePage);
    }

    // Verify if the promo link is displayed
    public boolean isPromoLinkDisplayed() {
        return driver.findElement(linkToPromoPage).isDisplayed();
    }

    // Verify if the promo image is displayed
    public boolean isPromoImageDisplayed() {
        return driver.findElement(imgMainHomePage).isDisplayed();
    }
}
