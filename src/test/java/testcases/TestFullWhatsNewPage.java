package testcases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFullWhatsNewPage {
    private static final String baseUrl = "https://magento.softwaretestingboard.com/what-is-new.html";
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getPageTitle() {
        String titleContent = (String) js.executeScript(
                "var metaTag = document.getElementsByName('title')[0];" +
                        "return metaTag ? metaTag.getAttribute('content') : null;"
        );
        assertEquals("What's New", titleContent, "The content attribute should be \"What's new\".");
    }

    @Test
    @DisplayName("Testing link to new collections page.")
    public void testNewCollectionLink() {
        String expectedUrl = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
        String script = "document.getElementsByClassName(\"block-promo new-main\")[0].click()";
        js.executeScript(script);
        String result = (String) js.executeScript("return window.location.href");
        assertEquals(expectedUrl, result);
        js.executeScript("history.back()");
    }

    @Test
    public void testSizeOfTitle() {
        long expectedSize = 6;
        String script ="return document.getElementsByClassName('title').length";
        Long result = (Long) js.executeScript(script);
        assert result != null;
        assertEquals(expectedSize, result);
    }

    @Test
    public void testMainColumnTitleValues() {
        String script = "const elements = document.querySelectorAll(\".title\");" +
                "const textElements = Array();" +
                "elements.forEach(element => textElements.push(element.textContent));" +
                "return textElements;";
        List<String> retrievedList = (List<String>) js.executeScript(script);
        for (int i = 0; i < 3; i++) {
            assert retrievedList != null;
            assertEquals(retrievedList.get(i), listOfTitles(i));
        }
    }

    private String listOfTitles(int index) {
        String[] titles = {
                "The very latest yoga styles  plus twists on timeless classics",
                "Whatever day brings",
                "A sense of renewal",
                "Luma's Latest",
                "New in women's",
                "New in men's"
        };
        return titles[index];
    }

    @Test
    public void testFirstLink() {
        String script = "return document.getElementsByClassName(\"block-promo new-main\")[0].href;";
        String expectedLink = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
        String result = (String) js.executeScript(script);
        assertEquals(expectedLink, result);
    }

    @Test
    @DisplayName("Testing Link for CoolTeach")
    public void testSecondLink() {
        String expectedResult = "https://magento.softwaretestingboard.com/collections/performance-new.html";
        String result = (String) js.executeScript("return document.getElementsByClassName(\"block-promo-wrapper block-promo-2columns\")[0].childNodes[1].href");
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Testing link for Eco-friendly cloths")
    public void testThirdLink() {
        String expectedResult = "https://magento.softwaretestingboard.com/collections/eco-new.html";
        String result = (String) js.executeScript("return document.getElementsByClassName(\"block-promo-wrapper block-promo-2columns\")[0].childNodes[3].href");
        assertEquals(expectedResult, result);
    }

    // TODO: add test coverage: img link, css checks

    @Test
    @DisplayName("Test Latest arrival products")
    public void testLatestProductsOne() {
        WebElement product = (WebElement) js.executeScript("return document.querySelectorAll('div ol li')[0];");
        assert product != null;
        List<String> extractedText = extractLines(product.getText());
        double price = extractNumber(extractedText.get(4));
        assertEquals("Montana Wind Jacket", extractedText.getFirst());
        assertEquals(49.0, price);
//        wait.until(ExpectedConditions.visibilityOf(product));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        String scriptForCheckingSizeExist = """
                const isExist = () => {
                    const sizes = ['XS', 'S', 'M', 'L', 'XL'];
                    let result = false;
                    for (let el = 0; el < sizes.length; el++) {
                    if (document.querySelectorAll('div ol li')[0].textContent.includes(sizes[el]) === true) {
                        result = true;
                    } else {
                     result = false;
                    }}
                    return result;
                }
                return isExist();
                """;
        Boolean exist = (Boolean) js.executeScript(scriptForCheckingSizeExist);
        assert exist != null;
        assertTrue(exist);
    }

    @Test
    @DisplayName("Show add cart item on mouse hover")
    public void testAddCartButton() {
        driver.manage().window().fullscreen();
        WebElement addToCartButton = (WebElement) js.executeScript(
                "return document.getElementsByTagName('ol')[0].children[0];");
        Actions mouseAction = new Actions(driver);
        mouseAction.scrollToElement(addToCartButton).perform();
        mouseAction.moveToElement(addToCartButton).perform();// Simulate mouse hover
        assertTrue(addToCartButton.isDisplayed(), "Add to Cart button should be displayed after hover");
    }

    @Test
    public void testMontanaWindJacket() {
        js.executeScript("document.querySelector(\"a[title='Montana Wind Jacket']\").click();");
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/montana-wind-jacket.html"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://magento.softwaretestingboard.com/montana-wind-jacket.html", currentUrl);
    }

    private List<String> extractLines(String text) {
        // Split the text by line breaks (\n or \r\n for Windows line breaks)
        String[] lines = text.split("\\r?\\n");
        List<String> extractedLines = new ArrayList<>();
        for (String line : lines) {
            extractedLines.add(line.trim());
        }
        return extractedLines;
    }

    private double extractNumber(String text) {
        String pricePattern = "\\$\\d{1,3}(?:,\\d{3})*(?:\\.\\d{2})?";
        Pattern pattern = Pattern.compile(pricePattern);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String priceString = matcher.group();
            priceString = priceString.replaceAll("[\\$,]", "");
            return Double.parseDouble(priceString);
        }
        return 0.0;
    }
}
