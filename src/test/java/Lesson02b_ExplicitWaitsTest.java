import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson02b_ExplicitWaitsTest {

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
    void explicitWaitDemo() {
        driver.get("https://duckduckgo.com/");
        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys("Selenium explicit waits");
        q.sendKeys(Keys.ENTER);

        By results = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        wait.until(ExpectedConditions.presenceOfElementLocated(results));
        Assertions.assertFalse(driver.findElements(results).isEmpty(), "Expected results with explicit wait");
    }
}