package pages;

import basetest.BaseLumaTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Cart extends BaseLumaTest {
    // Steps:
    // 1. visit the base url
    // 2. click on a section of the navbar
    // 3. hover over a sublist to open the dropdown
    // 4. click on a link in the dropdown
    // 5. click on a product
    // 6. select a size
    // 7. select a color
    // 8. click on the add to cart button
    // 9. click on the cart icon
    // 10. click on the checkout button
    // 11. fill out the checkout form
    // 12. click on the place order button
    // 13. verify the order was placed
    // 14. click on the account icon
    // 15. click on the sign-out button

    String cartUrl = "";

    By menDropdownLocator = By.id("ui-id-5");
    // //a[@href='https://magento.softwaretestingboard.com/men/tops-men.html']/span[.='Tops']
    By topsLinkLocator = By.xpath("//a[.='Tops']");
    By menDepartmentLocator = By.xpath("//div[@id='store.menu']/nav/ul/li/a/span[.=\"Men\"]");

    public Cart(String browser) {
        super(browser);
    }

    public void clickOnMenDepartment() {
        click(menDepartmentLocator);
    }

    public void hoverOverMenDropdown() {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(menDropdownLocator)).perform();
    }





}
