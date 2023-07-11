package com.scm.POM;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailersPage {
@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/td[3]") private List<WebElement> UN_ListInTable;

public RetailersPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public boolean validateUsername(String UN) {
	boolean flag=true;
	for(WebElement i:UN_ListInTable) {
		String name=i.getText();
		if(name.equals(UN)) {
			return flag;
		}
	}
	flag=false;
	return flag;
	
}
}
