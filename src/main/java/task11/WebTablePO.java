package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static task11.DriverProvider.getDriver;

public class WebTablePO {

    @FindBy(xpath = "//*[@id=\"addNewRecordButton\"]")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "age")
    WebElement age;

    @FindBy(id = "salary")
    WebElement salary;

    @FindBy(id = "department")
    WebElement department;

    @FindBy(id = "submit")
    WebElement submitButton;

    public WebTablePO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getAddBtn() {
        return addButton;
    }

    public WebElement getFirstNameInput() {
        return firstName;
    }

    public WebElement getLastNameInput() {
        return lastName;
    }
    public WebElement getEmailInput() {
        return email;
    }

    public WebElement getAgeInput() {
        return age;
    }

    public WebElement getSalaryInput() {
        return salary;
    }

    public WebElement getDepartmentInput() {
        return department;
    }

    public WebElement getSubmitBtn() {
        return submitButton;
    }
}
