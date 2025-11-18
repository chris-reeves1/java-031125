import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

class Lesson04_CoreActionsTest {

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
    void coreActions() {
        driver.get("https://duckduckgo.com/");

        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys("Selenium Actions");
        q.sendKeys(Keys.ENTER);

        By resultTitles = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(resultTitles));

        // Hover then click. perform executes the action chain, action- click, right click, hover, drag and drop etc.
        new Actions(driver).moveToElement(first).pause(Duration.ofMillis(150)).click().perform();  

        // On the destination page, verify navigation occurred
        new WebDriverWait(driver, Duration.ofSeconds(12))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("duckduckgo.com")));

        // Use keyboard to navigate back and clear/retarget the input
        driver.navigate().back(); // look at more later
        WebElement q2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q2.sendKeys(Keys.chord(Keys.CONTROL, "a")); // selects all
        q2.sendKeys(Keys.BACK_SPACE); // deletes text to reset
        q2.sendKeys("Selenium");
        q2.sendKeys(Keys.ENTER);

        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"),
                "Title should reflect second query");
    }
}
