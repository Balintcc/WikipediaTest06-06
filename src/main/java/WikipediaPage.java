import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage {
    WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
    }
    private final String url = "https://en.wikipedia.org/wiki/Main_Page";
    private final By searchBox = By.id("searchInput");

    private final By searchButton = By.id("searchButton");
    private final By foundHeading = By.id("firstHeading");

    public void navigateMainPage() {
        driver.get(url);
    }
    public void sendSearchWord(String sWord)  {

        driver.findElement(searchBox).sendKeys(sWord);
//        driver.findElement(searchBox).sendKeys(Keys.ENTER);

        driver.findElement(searchButton).click();


    }

    public String readHeading() {

        return driver.findElement(foundHeading).getText();

    }
}
