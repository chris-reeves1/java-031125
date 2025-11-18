import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson01_BasicNavigationSearchTest {

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
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void basicSearch() {
        driver.get("https://duckduckgo.com/");
        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys("Selenium WebDriver");
        q.sendKeys(Keys.ENTER);

        By firstResult = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));

        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"),
                "Title should reflect the query");
    }
}
