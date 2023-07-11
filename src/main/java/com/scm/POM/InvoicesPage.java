package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericUtility.WebActionUtility;

public class InvoicesPage {
	@FindBy(id="cmbFilter")private WebElement searchByDD;
	@FindBy(xpath = "//input[@value='Search']")private WebElement searchBtn;
	@FindBy(id="datepicker")private WebElement searchBox;

	
	public InvoicesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchByOption(String opt) {
		WebActionUtility wa=new WebActionUtility();
		wa.select(searchByDD, opt);
	}

	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
}
