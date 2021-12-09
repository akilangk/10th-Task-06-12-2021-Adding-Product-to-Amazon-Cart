package amazonAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageObjects {
    @FindBy(xpath = "//span[@id='submit.add-to-cart']")
    public static WebElement addToCartButton;
}
