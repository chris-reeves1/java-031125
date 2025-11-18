import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

class Lesson06_ScreenshotsTest {

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
    void takeScreenshotAfterResults() throws IOException {
        driver.get("https://duckduckgo.com/");
        WebElement q = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        q.sendKeys("Selenium screenshot");
        q.sendKeys(Keys.ENTER);

        By firstResult = By.cssSelector("[data-testid='result'] h2 a, #links .result__title a");
        wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));

        Path dir = Paths.get("target", "screenshots");
        Files.createDirectories(dir);
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path file = dir.resolve("ddg_results_" + ts + ".png");

        byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(file, png);

        Assertions.assertTrue(Files.exists(file), "Screenshot file should exist: " + file);
    }
}