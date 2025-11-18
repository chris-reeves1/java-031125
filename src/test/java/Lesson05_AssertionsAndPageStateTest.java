import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson05_AssertionsAndPageStateTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        ChromeOptions opts = new ChromeOptions();
        // opts.setBinary("C:\\path\\to\\chrome-for-testing\\chrome-win64\\chrome.exe");
        opts.addArguments("--no-first-run", "--no-default-browser-check", "--window-size=1280,900");
        driver = new ChromeDriver(opts);
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    @AfterEach
    void tearDown() { if (driver != null) driver.quit(); }

    @Test
    void assertionsAndState() {
        final String query = "Selenium Assertions";
        driver.get("https://duckduckgo.com/");

        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys(query);
        q.sendKeys(Keys.ENTER);

        By firstResult = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));

        // Title should reflect the query
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"),
                "Title should include query keyword");

        // URL should have q= param whether first or not (handles ?q=... or &q=...)
        wait.until(ExpectedConditions.urlMatches(".*[?&]q=[^&]+.*"));
        Assertions.assertTrue(driver.getCurrentUrl().matches(".*[?&]q=[^&]+.*"),
                "Search URL should contain q= parameter");

        // The input retains the query text on the results page
        WebElement qValue = driver.findElement(By.name("q"));
        Assertions.assertEquals(query, qValue.getAttribute("value"),
                "Input should keep the query text");

        Assertions.assertFalse(driver.findElements(firstResult).isEmpty(),
                "Should have at least one result");
    }
}
