import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountObjects {

    private static WebDriver driver;

    public static void main(String[] args) {
        initializeWebDriver();
        navigateToPage();
        countObjects();
        closeBrowser();
    }

    private static void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "N:\\Box\\WorkSpace\\Project\\BrowserAutomation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    private static void navigateToPage() {
        driver.get("https://www.ajio.com/");
    }

    private static void countObjects() {
        java.util.List<WebElement> elements = driver.findElements(By.xpath("//*"));
        int totalObjects = elements.size();
        System.out.println("Total objects on the page: " + totalObjects);
    }

    private static void closeBrowser() {
        try {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error while closing the browser: " + e.getMessage());
        }
    }
}


