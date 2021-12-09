package amazonTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class DataProvider {

    public WebDriver driver;

    public String dataFilePath() {
        String userWorkingDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        return userWorkingDirectory + pathSeparator + "src" + pathSeparator + "test" +
                pathSeparator + "java" + pathSeparator + "amazonTestCases" + pathSeparator + "data.properties";
    }

    public Properties getPropertiesObject() {
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream(dataFilePath());
            property.load(file);
        } catch (FileNotFoundException exception) {
            System.out.println("The specified file is not present in the given path.");
        } catch (IOException exception) {
            System.out.println("Check the file in the specified path.");
        }
        return property;
    }

    public WebDriver initializeDriver() {

        String browserName = getPropertiesObject().getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public String getUrl() {
        return getPropertiesObject().getProperty("url");
    }

    public String getLoginEmailOrPhoneNumber() {
        return getPropertiesObject().getProperty("loginEmailOrPhoneNumber");
    }

    public String getLoginPassword() {
        return getPropertiesObject().getProperty("loginPassword");
    }

    public String getSearchText() {
        return getPropertiesObject().getProperty("searchText");
    }

}
