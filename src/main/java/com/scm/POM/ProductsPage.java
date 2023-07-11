package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[1]/input[@type='checkbox']") private WebElement lastCheckBx;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[2]") private WebElement lastProductCode;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[3]") private WebElement lastProductName;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[4]") private WebElement lastProductPrice;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[5]") private WebElement lastProductUnit;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[6]") private WebElement lastProductCategory;
@FindBy(xpath = "//form/table/tbody/tr[last()]/td[7]") private WebElement lastProductQty;
@FindBy(xpath = "//form/table/tbody/tr[last()]/descendant::img[@alt='edit']") private WebElement lastProductEditLink;


public ProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getLastCheckBx() {
	return lastCheckBx;
}


public WebElement getLastProductCode() {
	return lastProductCode;
}


public WebElement getLastProductName() {
	return lastProductName;
}


public WebElement getLastProductPrice() {
	return lastProductPrice;
}


public WebElement getLastProductUnit() {
	return lastProductUnit;
}


public WebElement getLastProductCategory() {
	return lastProductCategory;
}


public WebElement getLastProductQty() {
	return lastProductQty;
}


public WebElement getLastProductEditLink() {
	return lastProductEditLink;
}

public boolean validateNewProduct(String name, String price,String cat) {
	String actName = lastProductName.getText().trim();
	String actprice=lastProductPrice.getText().trim();
	String actCat=lastProductCategory.getText().trim();
	if(actName.equalsIgnoreCase(name) && actprice.equalsIgnoreCase(price) &&  actCat.equalsIgnoreCase(cat)) {
		return false;
	}
	else
		return false;
}

}
