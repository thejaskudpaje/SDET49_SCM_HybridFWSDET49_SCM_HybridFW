package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
@FindBy(xpath = "//a[text()='New Order']") private WebElement newOrderLink;
@FindBy(xpath = "//a[text()='Edit Profile']") private WebElement editProfileLink;
@FindBy(xpath = "//a[text()='Home']") private WebElement homeleLink;
@FindBy(xpath = "(//table[@class='table_displayData'])[1]/tbody/tr[2]/td[3]") private WebElement phNo;
@FindBy(xpath = "(//table[@class='table_displayData'])[1]/tbody/tr[2]/td[4]") private WebElement email;


public RetailerHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getNewOrderLink() {
	return newOrderLink;
}
public WebElement getEditProfileLink() {
	return editProfileLink;
}

public WebElement getHomeleLink() {
	return homeleLink;
}

public WebElement getPhNo() {
	return phNo;
}

public WebElement getEmail() {
	return email;
}
public void validateData(String phnumber,String emailID) {
	if(phNo.getText().trim().equals(phnumber) && email.getText().trim().equals(emailID) ) {
		System.out.println("data successfully updated");
	}
	else
		System.out.println("Error in updating the data");
}

}
