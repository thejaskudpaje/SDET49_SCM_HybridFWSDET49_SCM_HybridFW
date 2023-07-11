package com.scm.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStockPage {
	
@FindBy(xpath = "//table[@class='table_displayData']/tbody")private WebElement stockTable;
@FindBy(id="btnSubmit") private WebElement submitButton;


public ManageStockPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getStockTable() {
	return stockTable;
}


public WebElement getSubmitButton() {
	return submitButton;
}

public void updateStock(String prodName,WebDriver driver) {
	 List<WebElement> allProdNames = driver.findElements(By.xpath("//table[@class='table_displayData']/tbody/tr/td[2]"));
	 boolean flag=false;
	 for(WebElement i:allProdNames) {
		 String actName=i.getText();
		 if(actName.equals(prodName)) {
			
		driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr/td[2][text()='"+prodName+"']/following-sibling::td[2]/input[@value='0']")).sendKeys("10");
		System.out.println("Quantity successfully updated");
		driver.findElement(By.id("btnSubmit")).submit();
		flag=false;
		break;
		 }		 
	 }
	 if(flag=false)  {
		 System.out.println("Product is not displaying");
	 }
}
}
