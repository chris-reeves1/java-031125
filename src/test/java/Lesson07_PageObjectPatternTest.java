import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson07_PageObjectPatternTest {

    WebDriver driver;
    WebDriverWait wait;

    // --- Pages as static inner classes to keep to a single file ---
    static class DdgHomePage {
        private final WebDriver driver;
        private final WebDriverWait wait;
        private final By input = By.name("q");

        DdgHomePage(WebDriver driver, WebDriverWait wait) { this.driver = driver; this.wait = wait; }

        DdgHomePage open() {
            driver.get("https://duckduckgo.com/");
            wait.until(ExpectedConditions.elementToBeClickable(input));
            return this;
        }

        DdgResultsPage search(String query) {
            WebElement q = driver.findElement(input);
            q.clear();
            q.sendKeys(query);
            q.sendKeys(Keys.ENTER);
            return new DdgResultsPage(driver, wait);
        }
    }

    static class DdgResultsPage {
        private final WebDriver driver;
        private final WebDriverWait wait;
        private final By resultTitle = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");

        DdgResultsPage(WebDriver driver, WebDriverWait wait) { this.driver = driver; this.wait = wait; }

        DdgResultsPage awaitLoaded() {
            wait.until(ExpectedConditions.presenceOfElementLocated(resultTitle));
            return this;
        }

        int resultCount() { return driver.findElements(resultTitle).size(); }

        String firstTitle() {
            var list = driver.findElements(resultTitle);
            return list.isEmpty() ? "" : list.get(0).getText();
        }
    }

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
    void pageObjectFlow() {
        var results = new DdgHomePage(driver, wait)
                .open()
                .search("Selenium Page Object")
                .awaitLoaded();

        Assertions.assertTrue(results.resultCount() > 0, "Expected results");
        Assertions.assertFalse(results.firstTitle().isBlank(), "First title should not be blank");
    }
}
