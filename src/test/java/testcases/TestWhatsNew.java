package testcases;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WhatsNew;
import static org.junit.jupiter.api.Assertions.*;

public class TestWhatsNew {
    private static WebDriver driver;
    private static WhatsNew whatsNewPage;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/what-is-new.html");
        whatsNewPage = new WhatsNew(driver);
    }

//    @BeforeEach
//    public void initPage() {
//        whatsNewPage = new WhatsNew(driver);
//    }

    @Test
    public void testPageTitle() {
//        String title = whatsNewPage.getPageTitle().getText();
//        assertTrue(title.contains("What's New"));
    }

    @Test
    public void testFirstItemTitle() {
        WebElement firstItemTitle = whatsNewPage.getFirstItemTitle();
        assertTrue(firstItemTitle.getText().contains("The very latest yoga styles  plus twists on timeless classics"));
    }

    @Test
    public void testSecondItemTitle() {
//        String secondItemTitle = whatsNewPage.getSecondItemTitle().getText();
//        assertTrue(secondItemTitle.contains("Whatever day brings"));
    }

    @Test
    public void testThirdItemDescription() {
//        String thirdItemDescription = whatsNewPage.getThirdItemDescription().getText();
//        assertTrue(thirdItemDescription.contains("Enjoy comfort of body and mind"),
//                "Third item description should contain " + "'Enjoy comfort of body and mind'");
    }

    @Test
    public void testLumaContentHeading() {
//        String lumaContentHeading = whatsNewPage.getLumaContentHeading();
//        assertTrue(lumaContentHeading.contains("A sense of renewal"));
    }

    @Test
    public void testLumaContentParagraph() {
        String lumaContentParagraph = whatsNewPage.getLumaContentParagraph();
//        assertTrue(lumaContentParagraph.contains("eco-friendly choices"),
//                "Luma's content paragraph should contain 'eco-friendly choices'.");
    }

    @Test
    public void testProductItems() {
//        int numberOfProductItems = whatsNewPage.getProductItems().size();
//        assertTrue(numberOfProductItems > 0, "There should be at least one product item.");
    }

    @Test
    public void testNewWomenItems() {
//        int womenItemsCount = whatsNewPage.getNewWomenItems().size();
//        assertTrue(womenItemsCount > 0, "There should be new items in the Women's section.");
    }

    @Test
    public void testNewMenItems() {
//        int menItemsCount = whatsNewPage.getNewMenItems().size();
//        assertTrue(menItemsCount > 0, "There should be new items in the Men's section.");
    }

    @Test
    public void testCompareProductsTitle() {
//        String compareProductsTitle = whatsNewPage.getCompareProductsTitle();
//        assertEquals("Compare Products", compareProductsTitle, "Compare Products title should match.");
    }

    @Test
    public void testWishListIsDisplayed() {
//        assertTrue(whatsNewPage.isWishListDisplayed(), "My Wish List section should be displayed.");
    }

    @Test
    public void testWishListItemsCount() {
//        int wishListItemsCount = whatsNewPage.getWishListItemsCount();
//        assertEquals(0, wishListItemsCount, "The wish list should initially be empty.");
    }

    @AfterEach
    public void tearDown() {
        // Optional: Perform additional cleanup if necessary after each test
    }

    @AfterAll
    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
