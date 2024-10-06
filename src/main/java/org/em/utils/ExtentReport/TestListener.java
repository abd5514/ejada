package org.em.utils.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.em.core.instance.SelInstance;

import org.em.utils.error_handlers.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.em.utils.ExtentReport.Utility.getScreenShot;


public class TestListener extends SelInstance implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentManager.getInstance ();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public static final String SKIPPED = " Skipped AND RETRYING";
    public static final String TEST_SKIPPED = " Test Skipped";
    private static final String TEST_PASSED = " Test passed";
    private static final String STARTED = " Started!";
    private static final String PASSED = " Passed!";
    private static final String FAILED = " Failed!";

    public synchronized void onTestStart(ITestResult result) {
        Logger.info((result.getMethod ().getDescription () + STARTED));
        test = extent.createTest(result.getMethod().getDescription (),result.getMethod ().getMethodName ());
        extentTest.set(test);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        Logger.info((result.getMethod ().getDescription () + PASSED));

        // TODO Auto-generated method stub
        extentTest.get().pass (PASSED);
    }

    public  synchronized void  onTestFailure(ITestResult result) {
        if(extentTest.get ()==null){
            System.out.println ("nulllllllll");
        }
        if(result.getMethod ().getDescription ()==null){
            System.out.println (" failure is nullllllll");
        }
        Logger.info((result.getMethod ().getDescription () + FAILED));


        try {
            extentTest.get().fail(result.getThrowable().getMessage ());
            extentTest.get ().addScreenCaptureFromPath (getScreenShot ());

        }catch (Exception e){
            System.out.println (e.getMessage ());
            e.printStackTrace ();
            throw new RuntimeException (e);
        }
    }

    public synchronized void onTestSkipped(ITestResult result) {
        extentTest.get ().skip (result.getMethod ().getMethodName () );
        //Logger.info((result.getMethod ().getDescription () + SKIPPED));

        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public  void onStart(ITestContext context) {
        Logger.info("Extent Reports Test Suite " + STARTED);

        // TODO Auto-generated method stub


    }

    public void onFinish(ITestContext context) {
        Logger.info(("Extent Reports Test Suite is ending!"));

        extent.flush();

    }

}



