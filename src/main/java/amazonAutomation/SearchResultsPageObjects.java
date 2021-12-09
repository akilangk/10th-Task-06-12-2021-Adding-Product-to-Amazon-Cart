package amazonAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class SearchResultsPageObjects {
    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row'] //div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']")
    public static List<WebElement> searchResults;

    public static String searchPageHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static Set<String> windowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public static WebElement product(WebDriver driver, int productIndex) {
        String productXpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row'] //div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16'][" + productIndex + "] //a[@class='a-link-normal a-text-normal']";
        return driver.findElement(By.xpath(productXpath));
    }
}
