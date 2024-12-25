package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WhatsNew {
    // WebDriver instance
    private WebDriver driver;

    // Page title
    private By titleLocator = By.xpath("//title");

    // Item Locators
    private By itemOneLocator = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[1]/div[1]/a/span/strong");
    private By itemTwoLocator = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[1]/div[1]/div/a[1]/span/strong");
    private By itemThreeLocator = By.xpath("/html/body/div[2]/main/div[4]/div[1]/div[1]/div[1]/div/a[2]/span/span[2]");

    // Luma's latest items
    private By contentHeadingLocator = By.xpath("//div[@class='content-heading']/h2[@class='title']");
    private By contentParagraphLocator = By.xpath("//div[@class='content-heading']/p[@class='info']");
    private By productItemsLocator = By.xpath("//div/ol[@class='product-items widget-product-grid']/li[@class='product-item']");

    // New in women's section
    private By newInWomensTitleLocator = By.xpath("//div[@class='categories-menu']/strong[@class='title']");
    private By newWomenItemsLocator = By.xpath("//div[@class='categories-menu']/ul[@class='items']/li");

    // New in men's section
    private By newInMensTitleLocator = By.xpath("//div[@class='categories-menu']/strong[@class='title'][2]");
    private By newMenItemsLocator = By.xpath("//div[@class='categories-menu']/ul[@class='items'][2]/li");

    // Compare products
    private By compareProductsTitleLocator = By.xpath("//strong[@id='block-compare-heading']");

    // My wish list
    private By wishListLocator = By.xpath("//strong[normalize-space()='My Wish List']");



    // Constructor to initialize the WebDriver
    public WhatsNew(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement getPageTitle() {
//        System.out.println(driver.getCurrentUrl());
        WebElement titleEle = driver.findElement(titleLocator);
        return titleEle;
    }

    public WebElement getFirstItemTitle() {
        return driver.findElement(itemOneLocator);
    }

    public WebElement getSecondItemTitle() {
        return driver.findElement(itemTwoLocator);
    }

    public WebElement getThirdItemDescription() {
        return driver.findElement(itemThreeLocator);
    }

    public String getLumaContentHeading() {
        return driver.findElement(contentHeadingLocator).getText();
    }

    public String getLumaContentParagraph() {
        return driver.findElement(contentParagraphLocator).getText();
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(productItemsLocator);
    }

    public String getNewInWomensTitle() {
        return driver.findElement(newInWomensTitleLocator).getText();
    }

    public List<WebElement> getNewWomenItems() {
        return driver.findElements(newWomenItemsLocator);
    }

    public String getNewInMensTitle() {
        return driver.findElement(newInMensTitleLocator).getText();
    }

    public List<WebElement> getNewMenItems() {
        return driver.findElements(newMenItemsLocator);
    }

    public String getCompareProductsTitle() {
        return driver.findElement(compareProductsTitleLocator).getText();
    }

    // Method to check if the "My Wish List" section is displayed
    public boolean isWishListDisplayed() {
        return driver.findElement(wishListLocator).isDisplayed();
    }

    // Method to get the count of products in the "My Wish List"
    public int getWishListItemsCount() {
        List<WebElement> items = driver.findElements(wishListLocator);
        return items.size(); // Returns the number of items (can be zero if the list is empty)
    }

    // Method to click on a product item (could be used for further navigation or actions)
    public void clickProductItem(int index) {
        List<WebElement> productItems = driver.findElements(productItemsLocator);
        if (index >= 0 && index < productItems.size()) {
            productItems.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Product item index is out of range.");
        }
    }

    // Method to interact with the Wish List (add items, etc.)
    public void clickWishList() {
        driver.findElement(wishListLocator).click();
    }

    // Additional methods to handle images, if needed (based on the TODO in the original code)
    // Example method for handling images:
    public String getPromoImageUrl(int index) {
        // Assuming there's an image element associated with each product item
        WebElement imageElement = driver.findElements(By.xpath("//img[contains(@class,'product-image')]")).get(index);
        return imageElement.getAttribute("src");  // Get the image URL
    }
}
