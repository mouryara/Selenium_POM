package utilities;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.CreateOpptyPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Author: Ramesh Mourya.
 */
public class Listeners extends CommonFunction implements ITestListener{

    static Logger log = Logger.getLogger(CreateOpptyPage.class.getName());

    public Listeners() {
    }

    public Listeners(WebDriver driver) {
        super( driver );
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    /**
     * This funtion will invoke when any test fails & will capture screesnhot of failed test case in user directory
     * under Screenshots folder.
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {

        String methodName = result.getName().toString().trim();
        try {
            CommonFunction.captureScreenshot(methodName);
            log.info("Method"+" "+methodName+" "+"Failed.Please see screenshot in Screenshots folder");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
