import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage {
    WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
    }
    private final String url = "https://en.wikipedia.org/wiki/Main_Page";
    private final WebElement searchBox = (WebElement) By.id("searchInput");
    private final By foundHeading = By.id("firstHeading");

    public void navigateMainPage() {
        driver.get(url);
    }
    public void sendSearchWord(String sWord) {

        searchBox.sendKeys(sWord);

    }

    public String readHeading() {

        return driver.findElement(foundHeading).getText();

    }
}
