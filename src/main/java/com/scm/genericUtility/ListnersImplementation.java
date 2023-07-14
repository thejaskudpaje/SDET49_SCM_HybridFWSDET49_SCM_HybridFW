package com.scm.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation extends BaseClass implements ITestListener {
ExtentReports report;
ExtentTest test;

	public void onFinish(ITestContext context) {
	report.flush();
	}

	public void onStart(ITestContext context) {
     Random ran=new Random();
     int randNum=ran.nextInt(999);
     
     ExtentSparkReporter spark =new ExtentSparkReporter("ExtentReport/Report.html"+randNum);
     spark.config().setTheme(Theme.DARK	);
     spark.config().setDocumentTitle("ExtentReport");
     spark.config().setReportName("thejas");
     
     report=new ExtentReports();
     report.attachReporter(spark);
     report.setSystemInfo("platform", "windows10");
     report.setSystemInfo("Execuited by", "thejas");
     report.setSystemInfo("revised By", "deepak");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestStart(ITestResult result) {
    test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		String screenshot =WebActionUtility.takeScreenshot(driver, result.getName());
		test.addScreenCaptureFromPath(screenshot);
	}
	
	

//	public void onTestFailure(ITestResult result) {
//		String methodName=result.getMethod().getMethodName();
//		javautility ju=new javautility();
//		String DHMS = ju.getDateTimeMinSec();
//		TakesScreenshot t=(TakesScreenshot)driver;
//		File src = t.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./Screenshot/"+methodName+""+DHMS+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
//		
//	}






}
