package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrderPage {
@FindBy(xpath = "//input[@value='Post Order']") private WebElement placeOrderBtn;
@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr[last()-1]/td[5]/input[@class='quantity']")private WebElement lastProductQtyTextBx;


public NewOrderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getPlaceOrderBtn() {
	return placeOrderBtn;
}


public WebElement getLastProduct() {
	return lastProductQtyTextBx;
}

public void placeOrder(String qty) {
	lastProductQtyTextBx.sendKeys(qty);
	placeOrderBtn.click();
}


}
