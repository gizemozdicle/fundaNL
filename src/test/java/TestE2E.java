import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class TestE2E {


    @Test
    public void e2eTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.funda.nl/huur/amsterdam/1500-2000/3+kamers/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(1000);
        List<WebElement> allListItems = driver.findElements(By.className("search-result__header-title-col"));

        List<String> allUrls = new ArrayList<String>();


        for (WebElement allListItem : allListItems) {

            WebElement allFundaListItems = allListItem.findElement(By.tagName("a"));
            String allFundaListItemsUrl = allFundaListItems.getAttribute("href");
            allUrls.add(allFundaListItemsUrl);

        }
        driver.get("https://www.funda.nl/huur/amsterdam/appartement-88136970-grasweg-148/");
        for (int i = 0; i < allUrls.size(); i++) {
            driver.get(allUrls.get(i));
            Thread.sleep(1000);
        }


        driver.close();
    }
}
