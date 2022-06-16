import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WikipediaTest {
    WebDriver driver;

    public WikipediaTest(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void searchTest() {
        WikipediaPage wikiPage = new WikipediaPage(driver);
        String expectedWord = "Tomi";

        wikiPage.navigateMainPage();
        wikiPage.sendSearchWord("Tomi");
        String actual = wikiPage.readHeading();
        Assertions.assertEquals(expectedWord, actual);

    }
//    @AfterEach
//    public void tearDown() {
//
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}

