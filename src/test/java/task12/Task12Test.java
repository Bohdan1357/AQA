//Implement PageFactory for a few pages.
//Implement Wrapper for common WebElements (choose your variant).
//Implement methods for your web element with console logging. (Choose your variant with specific methods)
//Use those methods in simple TC scenario

//V12
//List boxes:
//selectOptionByValue - selects an option from a list box by its value
//selectOptionByIndex - selects an option from a list box by its index
//getSelectedOption - retrieves the currently selected option in a list box

package task12;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Task12Test {

    private MS_BO msBo;

    @BeforeClass
    public void setUp() {
        msBo = new MS_BO();
        msBo.goToWebsite();
    }

    @Test
    public void selectOptionByValueTest() {
        MS_BO.selectOptionByValue("5");
        assertEquals("5 rows", MS_BO.getSelectedOptionByValueText());
    }

    @Test
    public void selectOptionByIndexTest() {
        MS_BO.selectOptionByIndex(2);
        assertEquals("20 rows", MS_BO.getSelectedOptionByIndexText());
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.quitDriver();
    }

}
