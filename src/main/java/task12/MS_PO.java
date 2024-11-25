package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MS_PO {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select")
    private WebElement listBoxToggle;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select/option")
    private List<WebElement> listBoxOptions;

    public MS_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openListBox() {
        listBoxToggle.click();
    }

    public void selectOptionByValue(String value) {
        for (WebElement option : listBoxOptions) {
            if (option.getAttribute("value").equals(value)) {
                System.out.println("Вибір опції за значенням: " + value);
                option.click();
                break;
            }
        }
    }

    public WebElement getSelectedOptionByValue() {
        for (WebElement option : listBoxOptions) {
            if (option.isSelected()) {
                System.out.println("Отримано вибрану опцію за значенням: " + option.getText());
                return option;
            }
        }
        return null;
    }

    public void selectOptionByIndex(int index) {
        if (index >= 0 && index < listBoxOptions.size()) {
            System.out.println("Вибір опції за індексом: " + index);
            listBoxOptions.get(index).click();
        }
    }

    public WebElement getSelectedOptionByIndex() {
        for (WebElement option : listBoxOptions) {
            if (option.isSelected()) {
                System.out.println("Отримано вибрану опцію за індексом: " + option.getText());
                return option;
            }
        }
        return null;
    }
}