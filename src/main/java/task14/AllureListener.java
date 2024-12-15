//- Add Allure to your framework
//- Attach screenshot and DOM to the report
//- Record video and attach it to the report (не зробив)
//- Run allure dashboard (allure serve -h localhost)


package task14;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import static task11.DriverProvider.getDriver;

public class AllureListener implements ITestListener, IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if(testResult.getStatus() == ITestResult.FAILURE){
            attachDOM();
            makeScreenShot();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        makeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShot(){
        byte[] result = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        System.out.println("Made Screenshot");
        return result;
    }

    @Attachment(value="Page source DOM", type="text/html")
    private String attachDOM(){
        System.out.println("Attached DOM");
        return getDriver().getPageSource();
    }

}