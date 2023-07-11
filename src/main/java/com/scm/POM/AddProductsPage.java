package com.scm.POM;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericUtility.WebActionUtility;



public class AddProductsPage {
	
	
@FindBy(id="product:name") private WebElement prodNameTxtBx;
@FindBy(id="product:price") private WebElement prodPriceTxtBx;
@FindBy(id="product:unit") private WebElement produnitDropDown;
@FindBy(id="product:category") private WebElement prodCategoryDropDown;
@FindBy(xpath ="//input[@value='1']")private WebElement radioBtn;
@FindBy(xpath ="//input[@value='Add Product']")private WebElement addProductBtn;


public AddProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getProdNameTxtBx() {
	return prodNameTxtBx;
}

public WebElement getProdPriceTxtBx() {
	return prodPriceTxtBx;
}

public WebElement getProdunitDropDown() {
	return produnitDropDown;
}

public WebElement getProdCategoryDropDown() {
	return prodCategoryDropDown;
}

public WebElement getRadioBtn() {
	return radioBtn;
}

public WebElement getAddProductBtn() {
	return addProductBtn;
}

public void createNewProduct(String name, String price, String unit, String cat ) throws Throwable {
WebActionUtility wa=new WebActionUtility();
prodNameTxtBx.sendKeys(name);
prodPriceTxtBx.sendKeys(price);
wa.select(produnitDropDown, unit);
wa.select(prodCategoryDropDown, cat);
radioBtn.click();
addProductBtn.click();

}


}
