package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
@FindBy(xpath = "//a[text()='Manage Stock']") private WebElement manageStockLink;

public ManufacturerHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getManageStockLink() {
	return manageStockLink;
}

}
