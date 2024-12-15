// General task (use Task_12 like base)
//Implement custom Listeners with methods for your variant.
//Add logging for all overridden listener methods using log4j console and file appenders
//Add video recorder for onFail action (you can use any lib for that)

//V12
//        ITestListener method tasks:
//        onTestStart() - Logging the name of the test method being executed.
//        onTestFailure() -  Save html code to file (file name = test name + some unique ID and date).
//
//        ISuiteListener, IExecutionListener, IInvokedMethodListener method tasks:
//        onStart(ISuite suite) - Set up the environment for the test suite or initialise any data required for the test suite.
//        onFinish(ISuite suite) - Tear down the environment or clean up any data created during the execution of the test suite. Close browser if needed.

package task13;

import org.testng.annotations.*;
import task12.DriverProvider;
import task12.MS_BO;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(CustomTest13Listener.class)
public class Task13Test {

    private MS_BO msBo;

    @BeforeClass
    public void setUp() {
        msBo = new MS_BO();
        msBo.goToWebsite();
    }

    @Test
    @Parameters({"dropdownValue"})
    public void selectOptionByValueTest() {
        MS_BO.selectOptionByValue("5");
        assertEquals("5 rows", MS_BO.getSelectedOptionByValueText());
    }

    @Test
    public void selectOptionByIndexTest() {
        MS_BO.selectOptionByIndex(2);
        assertEquals("20 rows", MS_BO.getSelectedOptionByIndexText());
    }

    @Test
    @Parameters({"dropdownValueFailure"})
    public void selectOptionByValueTestFailure() {
        MS_BO.selectOptionByValue("dropdownValueFailure");
        assertEquals("20 rows", MS_BO.getSelectedOptionByIndexText());
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.quitDriver();
    }

}