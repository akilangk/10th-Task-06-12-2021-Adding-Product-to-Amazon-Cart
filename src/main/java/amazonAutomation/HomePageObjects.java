package amazonAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
    @FindBy(css = "#nav-link-accountList")
    public static WebElement locateSignIn;
    @FindBy(css = "#nav-flyout-ya-signin .nav-action-inner")
    public static WebElement signInButton;
    @FindBy(css = "#twotabsearchtextbox")
    public static WebElement searchBox;
}
