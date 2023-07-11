package Com.Patiquette.SCM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.POM.AddProductsPage;
import com.scm.POM.AddRetailerPage;
import com.scm.POM.AdminHomePage;
import com.scm.POM.LoginPage;
import com.scm.POM.ManageStockPage;
import com.scm.POM.ManufacturerHomePage;
import com.scm.POM.NewOrderPage;
import com.scm.POM.ProductsPage;
import com.scm.POM.RetailerHomePage;
import com.scm.POM.RetailersPage;
import com.scm.genericUtility.BaseClass;
import com.scm.genericUtility.ExcelUtility;
import com.scm.genericUtility.FileUtility;
import com.scm.genericUtility.WebActionUtility;
import com.scm.genericUtility.javautility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.scm.genericUtility.ListnersImplementation.class)
public class CreateNewRetailer extends BaseClass{
	@Test(groups = "smoke",retryAnalyzer=com.scm.genericUtility.RetryImplementation.class)
	public void CreateNewRetailerTest() throws Throwable {
      System.out.println("CreateNewRetailer");
		// creating objects of POM classes
		LoginPage lp = new LoginPage(driver);
		AdminHomePage adminHP = new AdminHomePage(driver);
		AddRetailerPage addRet = new AddRetailerPage(driver);
		RetailersPage ret = new RetailersPage(driver);


		// Click on add Reatailer link
		adminHP.getAddRetailerLink().click();

		// Entering text fields
		String excelFilePath = fu.getFilepathFromPropertyFile("TestData");
		String retailerName = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_02", "Retailer_Name");
		retailerName = retailerName+ "" + ju.getRandomNumber();
	String retailerEmail = retailerName + "" + "@gmail.com";
	String retAreaCode = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_02", "Retailer_Area_Code");
	String retPassword = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_02", "Retailer_Password");
	String retPh_no= ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_02", "Retailer_Ph_No");
	addRet.addRetailer(retailerName, retPassword, retAreaCode,retPh_no, retailerEmail);
		System.out.println("Retailer added successfully");
		System.out.println("Retailer name   "+retailerName);


		// Click on retailer link
		adminHP.getRetailerlink().click();
		System.out.println("Showing new retailers table");

		// validating
		boolean res = ret.validateUsername(retailerName);
		sa.assertTrue(res, "validation fail");

sa.assertAll();
	}
}
