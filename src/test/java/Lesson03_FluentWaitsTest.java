

import java.time.Duration;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson03_FluentWaitsTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions opts = new ChromeOptions();
        // opts.setBinary("C:\\path\\to\\chrome-for-testing\\chrome-win64\\chrome.exe");
        opts.addArguments("--no-first-run", "--no-default-browser-check", "--window-size=1280,900");
        driver = new ChromeDriver(opts);
    }

    @AfterEach
    void tearDown() { if (driver != null) driver.quit(); }

    @Test
    void fluentWaitDemo() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium FluentWait");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        By resultTitles = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");

        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15)) // time to wait before failing
                .pollingEvery(Duration.ofMillis(250)) // how often the condition is rechecked. defaults to 500ms
                .ignoring(NoSuchElementException.class); // skip exceptions if using findelement (findelements always returns a list - can be empty)

        // Custom condition: wait until at least 5 results are present
        fluent.until(d -> d.findElements(resultTitles).size() >= 5);

        Assertions.assertTrue(driver.findElements(resultTitles).size() >= 5,
                "Expected at least 5 results with FluentWait");
    }
}