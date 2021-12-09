package amazonTestCases;

import amazonAutomation.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends DataProvider {
    WebDriver driver;
    int productIndex;
    boolean productFound = false;

    @BeforeTest
    public void openBrowser() {
        driver = initializeDriver();
        driver.get(getUrl());
    }

    @Test(priority = 1)
    public void navigateToSignInPage() {
        Actions actions = new Actions(driver);
        PageFactory.initElements(driver, HomePageObjects.class);
        actions.moveToElement(HomePageObjects.locateSignIn).build().perform();
        HomePageObjects.signInButton.click();
    }

    @Test(priority = 2)
    public void signInPage() {
        PageFactory.initElements(driver, SignInPageObjects.class);
        SignInPageObjects.eMailOrPhoneNumberTextBox.sendKeys(getLoginEmailOrPhoneNumber());
        SignInPageObjects.continueButton.click();
        SignInPageObjects.passwordTextBox.sendKeys(getLoginPassword());
        SignInPageObjects.signInButton.click();
    }

    @Test(priority = 3)
    public void searchTheProduct() {
        PageFactory.initElements(driver, HomePageObjects.class);
        HomePageObjects.searchBox.sendKeys(getSearchText() + Keys.ENTER);
        PageFactory.initElements(driver, SearchResultsPageObjects.class);
        for (WebElement individualElement : SearchResultsPageObjects.searchResults) {
            productIndex++;
            String actualText = individualElement.getText().toLowerCase();
            if (actualText.contains(getSearchText())) {
                productFound = true;
                break;
            }
        }
    }

    @Test(priority = 4)
    public void findTheProduct() {
        if (productFound) {
            SearchResultsPageObjects.product(driver, productIndex).click();
            String productPageHandle = null;
            for (String handle : SearchResultsPageObjects.windowHandles(driver)) {
                if (!handle.equals(SearchResultsPageObjects.searchPageHandle(driver))) {
                    productPageHandle = handle;
                }
            }
            driver.switchTo().window(productPageHandle);
        } else {
            System.out.println("Oops, Product " + getSearchText() + "not found!");
        }
    }

    @Test(priority = 5)
    public void addToCart() {
        if (productFound) {
            PageFactory.initElements(driver, ProductPageObjects.class);
            ProductPageObjects.addToCartButton.click();
            System.out.println("Product " + getSearchText() + " added to the cart.");
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
