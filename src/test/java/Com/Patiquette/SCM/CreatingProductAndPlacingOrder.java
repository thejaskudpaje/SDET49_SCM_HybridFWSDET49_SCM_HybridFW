package Com.Patiquette.SCM;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.naming.ldap.LdapName;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.POM.AddProductsPage;
import com.scm.POM.AdminHomePage;
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
public class CreatingProductAndPlacingOrder extends BaseClass {
	@Test(groups = {"smoke","regression"},retryAnalyzer=com.scm.genericUtility.RetryImplementation.class)

	public void creatingProductAndPlacingOrderTest() throws Throwable {
        System.out.println("CreatingProductAndPlacingOrder ");
		//  Step:03 creating objects of POM classes
		LoginPage lp = new LoginPage(driver);
		AdminHomePage adminHP = new AdminHomePage(driver);
		AddProductsPage addProd = new AddProductsPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		ManufacturerHomePage manfHP = new ManufacturerHomePage(driver);
		ManageStockPage mangStock = new ManageStockPage(driver);
		RetailerHomePage retHp = new RetailerHomePage(driver);
		NewOrderPage nwOrderHP = new NewOrderPage(driver);
		

		//  Step:05 clicking on add product
		adminHP.clickAddProduct();

		// Step:06 Code for creading random number
		Random ran = new Random();
		int randNum = ran.nextInt(999);

		//  Step:07 entering the text fields and create new product
		String excelFilePath = fu.getFilepathFromPropertyFile("TestData");
		String prodName = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Product Name");
		prodName = prodName + "" + randNum;
		String prodPrice = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Price");
		String unitType = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Unit_type_Text");
		String category = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Category_Text");
		addProd.createNewProduct(prodName, prodPrice, unitType, category);

		// Step:08 handleling Alert popup
		Alert a = driver.switchTo().alert();
		a.accept();
		System.out.println("Product has been added successfully");

		// Step:09 clicking on products
		adminHP.getProductslink().click();

		// Step:10 validating the product
		boolean res = pp.validateNewProduct(prodName, prodPrice, category);
		
//		sa.assertTrue(res,"product details are not displaying properly");
//		Reporter.log("product details are displaying properly",true);
		if (res) {
			System.out.println("product details are displaying properly");
		} else {
			System.out.println("product details are not displaying properly");
		}

		// Step:11 logout as admin
		adminHP.getLogoutBtn().click();
		System.out.println("logout as admin");

		// Step:12  login as manufacturer
		String envFilePath = fu.getFilepathFromPropertyFile("projectEnvConfigFilePath");
		String manfUN = fu.getValueOfEnvirmentalData(envFilePath, "manfactUN");
		String manfPW = fu.getValueOfEnvirmentalData(envFilePath, "PW");
		excelFilePath = fu.getFilepathFromPropertyFile("TestData");
		String loginType = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Login_Type_Manufacturer");
		lp.loginOperation(manfUN, manfPW, loginType);
		System.out.println("login as manufacturer");

		// Step:13 click on manage stock
		manfHP.getManageStockLink().click();

		//  Step:14 Update the stock

		mangStock.updateStock(prodName, driver);
		a.accept();

		// Step:15 logout as manufacturer
		adminHP.getLogoutBtn().click();
		System.out.println("logout as manufacturer");

		// Step:16 login as retailer
		String retailerUN = fu.getValueOfEnvirmentalData(envFilePath, "retailerUN");
		String retailerfPW = fu.getValueOfEnvirmentalData(envFilePath, "PW");
		excelFilePath = fu.getFilepathFromPropertyFile("TestData");
		loginType = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Login_Type_Retailer");
		lp.loginOperation(retailerUN, retailerfPW, loginType);
		System.out.println("login as retailer");

		// Step:17 click on new order module
		retHp.getNewOrderLink().click();

		// Step:18 entering order quantity and place the order
		String Qty = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_01", "Order_Quantity");
		System.out.println(Qty);
		nwOrderHP.placeOrder(Qty);
		System.out.println("Order placed successfully");
		driver.navigate().back();

		
		
	}
}
