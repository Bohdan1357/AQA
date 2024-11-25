package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static task12.DriverProvider.getDriver;

public class MS_BO {
    private WebDriver driver;
    private static MS_PO msPo;

    public MS_BO goToWebsite() {
        getDriver().get("https://demoqa.com/webtables");
        return this;
    }

    public MS_BO() {
        this.driver = getDriver();
        this.msPo = new MS_PO(driver);
    }

    public static void selectOptionByValue(String value) {
        msPo.selectOptionByValue(value);
    }

    public static String getSelectedOptionByValueText() {
        WebElement selectedOption = msPo.getSelectedOptionByValue();
        return selectedOption != null ? selectedOption.getText() : null;
    }

    public static void selectOptionByIndex(int index) {
            msPo.selectOptionByIndex(index);
    }

    public static String getSelectedOptionByIndexText() {
        WebElement selectedOptionIndex = msPo.getSelectedOptionByIndex();
        return selectedOptionIndex != null ? selectedOptionIndex.getText() : null;
    }
}
