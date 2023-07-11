package com.scm.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplementation extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		javautility ju=new javautility();
		String DHMS = ju.getDateTimeMinSec();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+methodName+""+DHMS+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}






}
