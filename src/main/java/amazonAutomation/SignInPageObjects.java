package amazonAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageObjects {
    @FindBy(css = "#ap_email")
    public static WebElement eMailOrPhoneNumberTextBox;
    @FindBy(css = "#continue")
    public static WebElement continueButton;
    @FindBy(css = "#ap_password")
    public static WebElement passwordTextBox;
    @FindBy(css = "#signInSubmit")
    public static WebElement signInButton;
}
