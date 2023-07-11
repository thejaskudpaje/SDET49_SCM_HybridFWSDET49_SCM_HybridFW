package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericUtility.WebActionUtility;

public class AddRetailerPage {
@FindBy(id="retailer:username") private WebElement usernameTxtField;
@FindBy(id="retailer:password") private WebElement passwordTxtField;
@FindBy(id="retailer:areaCode") private WebElement areaCodedropDown;
@FindBy(id="retailer:phone") private WebElement phoneNumbertextField;
@FindBy(id="retailer:email") private WebElement emailtextField;
@FindBy(xpath = "//input[@value='Add Retailer']") private WebElement addRetailerBn;


public AddRetailerPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getUsernameTxtField() {
	return usernameTxtField;
}


public WebElement getPasswordTxtField() {
	return passwordTxtField;
}


public WebElement getAreaCodedropDown() {
	return areaCodedropDown;
}


public WebElement getPhoneNumbertextField() {
	return phoneNumbertextField;
}


public WebElement getEmailtextField() {
	return emailtextField;
}


public WebElement getAddRetailerBn() {
	return addRetailerBn;
}

public void addRetailer(String name, String pw,String areaCode, String phNo, String email) throws Throwable {
	usernameTxtField.sendKeys(name);
	passwordTxtField.sendKeys(pw);
	WebActionUtility wa=new WebActionUtility();
	wa.select(areaCodedropDown, areaCode);
	phoneNumbertextField.sendKeys(phNo);
	emailtextField.sendKeys(email);
	addRetailerBn.click();
}

}
