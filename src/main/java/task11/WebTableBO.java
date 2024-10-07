package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static task11.DriverProvider.driver;

public class WebTableBO {
    WebTablePO webTablePO = new WebTablePO();
    public WebTableBO gotowebtable() {
        DriverProvider.getDriver().get("https://demoqa.com/webtables");
        return this;
    }

    public WebTableBO clickAdd() {
        Assert.assertTrue(webTablePO.getAddBtn().isDisplayed(), "Cannot find add button");
        webTablePO.getAddBtn().click();
        return this;
    }

    public WebTableBO clickSubmit() {
        Assert.assertTrue(webTablePO.getSubmitBtn().isDisplayed(), "Cannot find submit button");
        webTablePO.getSubmitBtn().click();
        return this;
    }

    public WebTableBO fillTheForm(String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        Assert.assertTrue(webTablePO.getFirstNameInput().isDisplayed(), "Cannot find first name input");
        webTablePO.getFirstNameInput().sendKeys(firstName);

        Assert.assertTrue(webTablePO.getLastNameInput().isDisplayed(), "Cannot find last name input");
        webTablePO.getLastNameInput().sendKeys(lastName);

        Assert.assertTrue(webTablePO.getEmailInput().isDisplayed(), "Cannot find email input");
        webTablePO.getEmailInput().sendKeys(email);

        Assert.assertTrue(webTablePO.getAgeInput().isDisplayed(), "Cannot find age input");
        webTablePO.getAgeInput().sendKeys(age.toString());

        Assert.assertTrue(webTablePO.getSalaryInput().isDisplayed(), "Cannot find salary input");
        webTablePO.getSalaryInput().sendKeys(salary.toString());

        Assert.assertTrue(webTablePO.getDepartmentInput().isEnabled(), "Cannot find department input");
        webTablePO.getDepartmentInput().sendKeys(department);
        return this;
    }

    public void verifyTable(String firstName, String lastName, String email, Integer age, Integer salary, String department) {
        // Find table
        WebElement table = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]"));

        // Find table rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean recordFound = false;

        // Check if new record exists
        for (WebElement row : rows) {
            String newFirstName = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
            String newLastName = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]")).getText();
            String newEmail = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]")).getText();
            Integer newAge = Integer.valueOf(row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]")).getText());
            Integer newSalary = Integer.valueOf(row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]")).getText());
            String newDepartment = row.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]")).getText();


            //String newFirstName = row.findElement(By.xpath(".//td[contains(text(), '" + firstName + "')]")).getText();
            //String newLastName = row.findElement(By.xpath(".//td[contains(text(), '" + lastName + "')]")).getText();
            //String newEmail = row.findElement(By.xpath(".//td[contains(text(), '" + email + "')]")).getText();
            //String newAge = row.findElement(By.xpath(".//td[contains(text(), '" + age + "')]")).getText();
            //String newSalary = row.findElement(By.xpath(".//td[contains(text(), '" + salary + "')]")).getText();
            //String newDepartment = row.findElement(By.xpath(".//td[contains(text(), '" + department + "')]")).getText();


            // Check if new row equals to our input
            if (newFirstName.equals(firstName) && newLastName.equals(lastName) && newEmail.equals(email) && newAge.equals(age) && newSalary.equals(salary) && newDepartment.equals(department)) {
                recordFound = true;
                System.out.println("Запис знайдено в таблиці.");
                break;
            }
            if (!recordFound) {
                throw new AssertionError("Новий запис не знайдено в таблиці.");
            }
        }
    }
}
