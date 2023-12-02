package manager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements AppManager, ITestListener, FileHelper {

    private long timeStart, timeEnd;
    @Override
    public void onTestStart(ITestResult result) {
        timeStart = System.currentTimeMillis();
        logger.info("test start interface -->"+result.getName());
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        timeEnd = System.currentTimeMillis();
        logger.info("test success interface -->"+result.getName()+" duration="+(timeEnd-timeStart));
        logger.info("took screenshot with name --> "+takeScreenShot(driver)+".png");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        timeEnd = System.currentTimeMillis();
        logger.info("test failed interface -->"+result.getName()+"duration="+(timeEnd-timeStart));
        logger.info("took screenshot with name --> "+takeScreenShot(driver)+".png");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        timeEnd = System.currentTimeMillis();
        logger.info("test skipped interface -->"+result.getName()+" duration="+(timeEnd-timeStart));
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
        logger.info("test start interface -->"+context.getName());
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("test finish interface -->"+ context.getFailedTests());
        logger.info("test finish interface -->"+ context.getPassedTests());
        ITestListener.super.onFinish(context);
    }
}
