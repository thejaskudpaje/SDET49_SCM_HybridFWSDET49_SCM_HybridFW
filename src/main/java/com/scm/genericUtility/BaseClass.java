package com.scm.genericUtility;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.scm.POM.AdminHomePage;
import com.scm.POM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public FileUtility fu=new FileUtility();
	public ExcelUtility ex = new ExcelUtility();
	public WebActionUtility wa = new WebActionUtility();
	public DataBaseUtility db=new DataBaseUtility();
public javautility ju = new javautility();
public SoftAssert sa=new SoftAssert();
	public static WebDriver driver;
	
	
@BeforeSuite(groups = {"smoke","regression"})
public void connectDatabase() throws SQLException {
	db.connectDB();
	System.out.println("Connect to database");
}
//@Parameters("BROWSER")
@BeforeClass(groups = {"smoke","regression"})
public void launchBrowser() throws Throwable {
	String filePath = fu.getFilepathFromPropertyFile("projectEnvConfigFilePath");
	String BROWSER=fu.getValueOfEnvirmentalData(filePath, "Browser");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	wa.waitForElementInDOM(driver);
	driver.manage().window().maximize();
	String envFilePath = fu.getFilepathFromPropertyFile("projectEnvConfigFilePath");
	String url = fu.getValueOfEnvirmentalData(envFilePath, "URL");
	driver.get(url);
;
}

@BeforeMethod(groups = {"smoke","regression"})
public void login() throws IOException {
	
	LoginPage lp = new LoginPage(driver);
	String envFilePath = fu.getFilepathFromPropertyFile("projectEnvConfigFilePath");
	String adminUN = fu.getValueOfEnvirmentalData(envFilePath, "adminUN");
	String PW = fu.getValueOfEnvirmentalData(envFilePath, "PW");
	String excelFilePath = fu.getFilepathFromPropertyFile("TestData");
	String loginType = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Login_Type_Admin");
	lp.loginOperation(adminUN, PW, loginType);
	System.out.println("login as Admin");
}
@AfterMethod(groups = {"smoke","regression"})
public void logout() {
	AdminHomePage adminHP = new AdminHomePage(driver);
	adminHP.getLogoutBtn().click();
	System.out.println("Logging out........");
}
@AfterClass(groups = {"smoke","regression"})
public void closeBrowser() {
	driver.close();
	System.out.println("closing browser........");
}
@AfterSuite(groups = {"smoke","regression"})
public void disconnectDatabase() throws SQLException {
	db.closeDB();
	System.out.println("Disconnecting database.........");
}

}
