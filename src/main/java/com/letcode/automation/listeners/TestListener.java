package com.letcode.automation.listeners;

import com.central.framework.dateutils.DateFormatConstants;
import com.central.framework.dateutils.DateUtils;
import com.central.framework.reportutils.ExtentReportManager;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestListener implements ITestListener {

    // Called when a test case starts
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(
                String.format("TC%s %s",result.getMethod().getPriority(),result.getMethod().getDescription())
        );

        // Optional: Add author and category (customize as needed)
        ExtentReportManager.addAuthor(System.getProperty("user.name"));
        ExtentReportManager.addCategory(result.getTestContext().getName());
        ExtentReportManager.addCategory(result.getMethod().getMethodName());
    }

    // Called when a test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test passed");
    }

    // Called when a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
        // Optional: Add screenshot if available (e.g., path or Base64)
        String screenshotPath = getScreenshotPath(result.getMethod().getMethodName());
        ExtentReportManager.addScreenshotFromPath(screenshotPath, "Failure Screenshot");
    }

    // Called when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test skipped: " + result.getThrowable());
    }

    // Optional: Implement if needed
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        String testName=BaseClassListener.testParameters.get("testName");
        ExtentReportManager.initReports(generatePath(testName,".html"),testName);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReports();
    }

    // Stub: Customize how you capture screenshots
    private String getScreenshotPath(String testName) {
        return generatePath(testName,".png");
    }

    private String generatePath(String testName,String fileFormat){
        return "./reports/" +
                DateUtils.formatDate(LocalDate.now(), DateFormatConstants.DATE_FORMAT_DD_MMM_YYYY_DOT) +
                "/" +
                testName +
                "/" +
                testName +
                "_" +
                DateUtils.formatDateTime(LocalDateTime.now(), "yyyyMMdd_HHmmss") +
                fileFormat;
    }
}
