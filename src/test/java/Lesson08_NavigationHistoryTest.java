import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson08_NavigationHistoryTest {

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
    void navigationHistory() {
        driver.get("https://duckduckgo.com/");
        // same as:
        // driver.navigate().to(url)
        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys("Selenium navigate back forward refresh");
        q.sendKeys(Keys.ENTER);

        By resultTitle = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(resultTitle));
        String resultsUrl = driver.getCurrentUrl();

        first.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(resultsUrl)));
        String destUrl = driver.getCurrentUrl();

        // back, forward, refresh
        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe(resultsUrl));

        driver.navigate().forward();
        wait.until(ExpectedConditions.urlToBe(destUrl));

        // Refresh and ensure the DOM reloaded (staleness of a prior element)
        WebElement body = driver.findElement(By.tagName("body"));
        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.stalenessOf(body)); // body is no longer there -- good indication of reload. 

        Assertions.assertTrue(driver.getTitle().length() > 0, "Title should be present after refresh");
    }
}
