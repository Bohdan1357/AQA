package task12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
    WebDriver driver;
    public static final DriverProvider INSTANCE = new DriverProvider();

    public WebDriver getDriver() {
        return driver;
    }

    private DriverProvider() {
        setUp();
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
