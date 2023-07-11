package com.scm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

@FindBy(xpath = "//a[text()='Add Products']") private WebElement addProductsLink;
@FindBy(xpath="//a[text()='Add Retailers']") private WebElement addRetailerLink;
@FindBy(xpath="//a[text()='Add Manufacturer']") private WebElement addManufacturerLink;
@FindBy(xpath="//a[text()='Add Distributor']") private WebElement addDistributorLink;
@FindBy(xpath="//a[text()='Manage Category']") private WebElement manageCategoryLink;
@FindBy(xpath="//a[text()='Manage Area']") private WebElement manageAreaLink;
@FindBy(xpath="//a[text()='Change Password']") private WebElement changePasswordlink;
@FindBy(xpath="//a[text()='Retailers']") private WebElement retailerlink;
@FindBy(xpath="//a[text()='Manufacturers']") private WebElement Manufacturerslink;
@FindBy(xpath="//a[text()='Distributors']") private WebElement Distributorslink;
@FindBy(xpath="//a[text()='Products']") private WebElement Productslink;
@FindBy(xpath="//a[text()='Orders']") private WebElement Orderslink;
@FindBy(xpath="//a[text()='Invoice']") private WebElement Invoicelink;
@FindBy(xpath="//input[@value='Log out']") private WebElement logoutBtn;



public AdminHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddProductsLink() {
	return addProductsLink;
}

public WebElement getAddRetailerLink() {
	return addRetailerLink;
}

public WebElement getAddManufacturerLink() {
	return addManufacturerLink;
}

public WebElement getAddDistributorLink() {
	return addDistributorLink;
}

public WebElement getManageCategoryLink() {
	return manageCategoryLink;
}

public WebElement getManageAreaLink() {
	return manageAreaLink;
}

public WebElement getChangePasswordlink() {
	return changePasswordlink;
}

public WebElement getRetailerlink() {
	return retailerlink;
}

public WebElement getManufacturerslink() {
	return Manufacturerslink;
}

public WebElement getDistributorslink() {
	return Distributorslink;
}

public WebElement getProductslink() {
	return Productslink;
}

public WebElement getOrderslink() {
	return Orderslink;
}

public WebElement getInvoicelink() {
	return Invoicelink;
}

public WebElement getLogoutBtn() {
	return logoutBtn;
}

public void clickAddProduct() {
	addProductsLink.click();
}



}
