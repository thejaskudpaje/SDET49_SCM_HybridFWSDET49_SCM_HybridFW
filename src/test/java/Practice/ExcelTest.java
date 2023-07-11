package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.scm.genericUtility.ExcelUtility;
import com.scm.genericUtility.FileUtility;

public class ExcelTest {
public static void main(String[] args) throws IOException {
	FileUtility fu=new FileUtility();
	ExcelUtility ex=new ExcelUtility();
	String filePath = fu.getFilepathFromPropertyFile("DataProvider");
	FileInputStream fis=new FileInputStream(filePath);
	Workbook wb = WorkbookFactory.create(fis);
	int rowcount = wb.getSheet("login").getLastRowNum();
	int colCount = wb.getSheet("login").getRow(0).getLastCellNum();
	System.out.println("row="+rowcount+"col="+colCount);
	
}
}
