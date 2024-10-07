//General (V12)
//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.

package task10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task10Test {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Task10() {
        //3. Navigate to the page assigned to your variant.
        driver.get("https://demoqa.com/webtables");

        //4. Select any three different elements.
        WebElement deleteRow1Button = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[7]"));
        WebElement salaryButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[5]/div[1]"));
        WebElement rowsPerPageSelector = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select"));
        WebElement spanSelect1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select/option[1]"));

        //6. Verify the visibility of each element using assertions.
        Assert.assertTrue(deleteRow1Button.isDisplayed());
        Assert.assertTrue(salaryButton.isDisplayed());
        Assert.assertTrue(rowsPerPageSelector.isDisplayed());

        //5. Interact with all the selected elements.
        deleteRow1Button.click();
        salaryButton.click();
        rowsPerPageSelector.click();
        spanSelect1.click();
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
