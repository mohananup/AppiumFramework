package com.app.utils;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.Status;

public class ExecutionListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
    	System.out.println(("*** Running test method " + iTestResult.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "PASS");
        System.out.println("*** Executed " + iTestResult.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "FAIL");
        System.out.println("*** Test execution " + iTestResult.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "SKIPPED");
        System.out.println("*** Test " + iTestResult.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	System.out.println("*** Test failed but within percentage % " + iTestResult.getMethod().getMethodName());

    }

    public void onStart(ITestContext iTestContext) {
    	System.out.println("*** Test Suite " + iTestContext.getName() + " started ***");

    }

    public void onFinish(ITestContext iTestContext) {
        this.sendTestClassStatus(iTestContext);
        System.out.println(("*** Test Suite " + iTestContext.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
    }

    private void sendTestMethodStatus(ITestResult iTestResult, String status) {
        Point point = Point.measurement("testmethod")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("testclass", iTestResult.getTestClass().getName())
                .tag("name", iTestResult.getName())
                .tag("description", iTestResult.getMethod().getDescription())
                .tag("result", status)
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis()))
                .build();
        ResultSender.send(point);
    }

    private void sendTestClassStatus(ITestContext iTestContext) {
        Point point = Point.measurement("testclass")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
                .build();
        ResultSender.send(point);
    }

}
