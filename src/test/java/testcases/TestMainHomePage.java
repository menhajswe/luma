package testcases;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainHomePage;

public class TestMainHomePage {
    private static WebDriver driver;
    private static MainHomePage homePage;

    @BeforeAll
    public static void init() {
        //  TODO: Update the base class to be used here
        driver = new ChromeDriver();
        homePage = new MainHomePage(driver);
    }

    @Test
    public void testHomePageTitle() {
        homePage.navigateToHomePage();
        String title = homePage.getHomePageTitle();
        Assertions.assertEquals("Home Page", title); // Replace with actual title
    }

    @Test
    public void testPromoLink() {
        homePage.navigateToHomePage();
        Assertions.assertTrue(homePage.isPromoLinkDisplayed(), "Promo link should be displayed.");
        homePage.clickPromoLink();
        // TODO: Add more assertions to verify the promotion page is loaded
    }

    @Test
    public void testPromoImage() {
        homePage.navigateToHomePage();
        Assertions.assertTrue(homePage.isPromoImageDisplayed(), "Promo image should be displayed.");
    }

    @Test
    public void testClickWomenSection() {
        homePage.navigateToHomePage();
        homePage.clickWomenSection();
        // TODO: Add assertions to check if the Women section page is loaded
    }

    @Test
    public void testClickGearSection() {
        homePage.navigateToHomePage();
        homePage.clickGearSection();
        // TODO: Add assertions for gear section content
    }

    @Test
    public void testNewProducts() {
        homePage.navigateToHomePage();
        String newProductsTitle = homePage.getNewProductsTitle();
        Assertions.assertEquals("Get fit and look fab in new seasonal styles", newProductsTitle);
    }


    @AfterAll
    public static void quite() {
        driver.quit();
    }
}
