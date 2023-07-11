package Com.Patiquette.SCM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.POM.AddProductsPage;
import com.scm.POM.AdminHomePage;
import com.scm.POM.EditProfilePage;
import com.scm.POM.LoginPage;
import com.scm.POM.ManageStockPage;
import com.scm.POM.ManufacturerHomePage;
import com.scm.POM.NewOrderPage;
import com.scm.POM.ProductsPage;
import com.scm.POM.RetailerHomePage;
import com.scm.genericUtility.BaseClass;
import com.scm.genericUtility.ExcelUtility;
import com.scm.genericUtility.FileUtility;
import com.scm.genericUtility.WebActionUtility;
import com.scm.genericUtility.javautility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.scm.genericUtility.ListnersImplementation.class)
public class EditRetailerProfile extends BaseClass {
	@Test(groups = {"smoke","regression"},retryAnalyzer=com.scm.genericUtility.RetryImplementation.class)

public void newOrderDetailsTest() throws Throwable {
System.out.println("EditRetailerProfile");
	// creating the objects of the utility classes
	ExcelUtility ex = new ExcelUtility();
	FileUtility fu = new FileUtility();
	javautility ju = new javautility();

	
	//  Step:03 creating objects of POM classes
	RetailerHomePage retHp = new RetailerHomePage(driver);
	EditProfilePage editProf=new EditProfilePage(driver);
	AdminHomePage adminHP = new AdminHomePage(driver);
	LoginPage lp = new LoginPage(driver);
	
	//logout as admin
	adminHP.getLogoutBtn().click();
	
	//login as Retailer
	String envFilePath = fu.getFilepathFromPropertyFile("projectEnvConfigFilePath");
	String retailerUN = fu.getValueOfEnvirmentalData(envFilePath, "retailerUN");
	String retailerfPW = fu.getValueOfEnvirmentalData(envFilePath, "PW");
	String excelFilePath = fu.getFilepathFromPropertyFile("TestData");
	String loginType = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Login_Type_Retailer");
	lp.loginOperation(retailerUN, retailerfPW, loginType);
	System.out.println("login as retailer");
	
    //Click on edit profile link
	retHp.getEditProfileLink().click();
	
	//Edit the details
	String exelFilePathTC03 = fu.getFilepathFromPropertyFile("TestData");
	String phNo = ex.getExceldDataByTestIDAndColName(exelFilePathTC03, "retailer", "TC_03", "New_phone_Number");
	String email = ex.getExceldDataByTestIDAndColName(exelFilePathTC03, "retailer", "TC_03", "New_Email");
	editProf.updateProfile(phNo, email);
	
	//handeling alert
	Alert a=driver.switchTo().alert();
	a.accept();
	
	//click on home button
	retHp.getHomeleLink().click();
	
	//validating the Updated data
	//retHp.validateData(phNo,email);
	 String newPhNo = retHp.getPhNo().getText();
	String newEmail = retHp.getEmail().getText();
	sa.assertTrue(newPhNo.equals(phNo), "wrong phone number");
	sa.assertTrue(newEmail.equals(email), "wrong phone number");
	//Reporter.log("pass",true);
	
	
	//logout as retailer
	System.out.println("logout as retailer");
	sa.assertAll();
}
	@Test
	public void dummyBlockTest() {
		System.out.println("Dummy block");
		Reporter.log("dummy block",true);
	}
}
