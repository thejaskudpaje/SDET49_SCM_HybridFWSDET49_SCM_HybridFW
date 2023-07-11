package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.POM.LoginPage;
import com.scm.genericUtility.ExcelUtility;
import com.scm.genericUtility.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderPractice {
WebDriver driver;
	@Test(dataProvider = "dataTable")
	public void getData(String un,String pw, String type) {
		System.out.println(un+"  "+pw+"  "+type);
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
//		LoginPage lp=new LoginPage(driver);
//		lp.loginOperation(un, pw, type);
	}
	
	
	@DataProvider
	public Object[][] dataTable() throws IOException{
		System.out.println("haii");
		FileUtility fu=new FileUtility();
		ExcelUtility ex=new ExcelUtility();
		String filePath = fu.getFilepathFromPropertyFile("DataProvider");
		int i=ex.getRowCount(filePath, "login");
		int j=ex.getColCount(filePath, "login",i );
		i=i+1;
		
		Object[][] obj=new Object[i][j];
	
		for(int m=0;m<i;m++) {
			for(int n=0;n<j;n++) {
				obj[m][n]=ex.getExcelCellData(filePath, "login", m, n);
			}
		}	
	
		return obj;
	}
}

