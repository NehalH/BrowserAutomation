import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountCheckBoxes {

    private static WebDriver driver;

    public static void main(String[] args) {
        initializeWebDriver();
        navigateToPage();
        countCheckboxes();
        closeBrowser();
    }
    
    private static void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "N:\\Box\\WorkSpace\\Project\\BrowserAutomation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    private static void navigateToPage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.ajio.com/s/30-to-50-percent-off-5105-48811?query=%3Arelevance%3Al1l3nestedcategory%3AMen%20-%20Tshirts%3Al1l3nestedcategory%3AMen%20-%20Sneakers%20%26%20Sports%20Shoes%3Al1l3nestedcategory%3AMen%20-%20Casual%20Shoes%3Al1l3nestedcategory%3AMen%20-%20Track%20Pants%3Agenderfilter%3AMen%3Apricerange%3ARs.2501-5000%3Abrand%3ANIKE&curated=true&curatedid=30-to-50-percent-off-5105-48811&gridColumns=3&segmentIds=");
    }

    private static void countCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        int totalCheckboxes = checkboxes.size();
        int checkedCount = 0;
        int uncheckedCount = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkedCount++;
            } else {
                uncheckedCount++;
            }
        }

        System.out.println("Total checkboxes: " + totalCheckboxes);
        System.out.println("Checked checkboxes: " + checkedCount);
        System.out.println("Unchecked checkboxes: " + uncheckedCount);
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
