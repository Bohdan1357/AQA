// General task (V12)
//1. Make up one simple UI end-to-end test case for your test page from Task_10
//2. Automate that scenario using WebDriver
//3. Create PageObject (use Business object if need)for all pages used in scenario

package task11;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task14.AllureListener;

@Listeners({AllureListener.class})
public class Task11Test {
    @Test
    void addRowTest(){
        //Test data
        String firstName = "John";
        String lastName = "Bob";
        String email = "bohdan@gmail.com";
        Integer age = 21;
        Integer salary = 50000;
        String department = "AQA";

        //1. Go to web table page
        new WebTableBO().gotowebtable()
                //2. Click "Add"
                .clickAdd()
                //3. Fill up form
                .fillTheForm(firstName, lastName, email, age, salary, department)
                //4. Click "Submit"
                .clickSubmit()
                //5. Verify table
                .verifyTable(firstName, lastName, email, age, salary, department);
        }

    @Test
    void addRowTestFail(){
        //Test data
        String firstName = "John";
        String lastName = "Bob";
        String email = "bohdan@gmail.com";
        Integer age = 21;
        Integer salary = 50000;
        String department = "AQA";

        //1. Go to web table page
        new WebTableBO().gotowebtable()
                //2. Click "Add"
                .clickAdd()
                //3. Fill up form
                .fillTheForm(firstName, lastName, email, age, salary, department)
                //4. Click "Submit"
                .clickSubmit()
                //5. Verify table
                .verifyTable(firstName, lastName, email, age, salary, department);
        Assert.fail();
    }
}
