package Com.Patiquette.SCM;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.scm.POM.AddRetailerPage;
import com.scm.POM.AdminHomePage;
import com.scm.POM.InvoicesPage;
import com.scm.POM.LoginPage;
import com.scm.POM.RetailersPage;
import com.scm.genericUtility.BaseClass;
@Listeners(com.scm.genericUtility.ListnersImplementation.class)
public class SearchInvoiceByDate extends BaseClass{

	@Test(groups = "smoke",retryAnalyzer=com.scm.genericUtility.RetryImplementation.class)
	public void SearchInvoiceByDateTest() throws IOException {
		System.out.println("SearchInvoiceByDate");
	// creating objects of POM classes
	LoginPage lp = new LoginPage(driver);
	AdminHomePage adminHP = new AdminHomePage(driver);
	AddRetailerPage addRet = new AddRetailerPage(driver);
	RetailersPage ret = new RetailersPage(driver);
	InvoicesPage ip=new InvoicesPage(driver);
	
	//click on invoice
	adminHP.getInvoicelink().click();
	
	//search by option
	String excelFilePath = fu.getFilepathFromPropertyFile("TestData");
	String Search_By_Option = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_04", "Search_By_Option");
	ip.searchByOption(Search_By_Option);
	
	//enter date
	String date = ex.getExceldDataByTestIDAndColName(excelFilePath, "retailer", "TC_04", "Date");
	ip.getSearchBox().sendKeys(date);
	}
	@Test
	public void testMethod() {
		System.out.println("hellooo");
	}
}
