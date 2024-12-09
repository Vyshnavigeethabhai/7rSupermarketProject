package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class Subcategory_action {
public WebDriver driver;
public Subcategory_action(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")WebElement addnew;
	@FindBy(xpath="//select[@id='cat_id']")WebElement selectcategory;
	@FindBy(xpath="//option[text()='Vegetables']")WebElement vegetableOption;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategory;
	@FindBy(xpath="//input[@id='main_img']")WebElement subcategoryfile;
	@FindBy(xpath="//button[@name='create']")WebElement savesubcategory;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;

public Subcategory_action clicknewButton() {
	addnew.click();
	return this;
	
}
public Subcategory_action clickSelectOption() {
	selectcategory.click();
	vegetableOption.click();
	return this;
	
}
public Subcategory_action enterSubcategory(String subCategory) {
	subcategory.sendKeys(subCategory);
	return this;
	
}
public Subcategory_action clicksubcategoryFile() {
	String imagepath=Constant.SUBCATEGORYIMAGE;
	FileUploadUtility fileupload=new FileUploadUtility();
	fileupload.sendKeysFileupload(subcategoryfile, imagepath);
	return this;
}
public Subcategory_action windowScrollDown() {
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
return this;
	
}
public Subcategory_action clicksavebutton() {
	savesubcategory.click();
	return this;
}
public boolean isSubcategoryAddAlert() {
	return alert.isDisplayed();
}
}
