package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
@FindBy(id="retailer:phone") private WebElement ph_No_textfield;
@FindBy(id="retailer:email") private WebElement email_textfield;
@FindBy(xpath = "//input[@value='Update Profile']") private WebElement updateProfileBtn;

public EditProfilePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void updateProfile(String phNo, String email) {
	ph_No_textfield.clear();
	ph_No_textfield.sendKeys(phNo);
	email_textfield.clear();
	email_textfield.sendKeys(email);
	updateProfileBtn.click();
}

}
