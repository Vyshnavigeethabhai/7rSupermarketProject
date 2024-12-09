package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category_action {
public WebDriver driver;
public Category_action (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);}
	
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement categorynew;
@FindBy(xpath="//input[@name='category']")WebElement entercategory;
@FindBy(xpath="//input[@name='main_img']")WebElement file;
@FindBy(xpath="//button[@name='create']")WebElement save;
@FindBy(xpath="/html/body/text()[1]")WebElement alertmessage;
	public Category_action clickCategoryNewButton() {
		categorynew.click();
		return this;
	}
	public Category_action enterCategoryField(String CategoryName) {
	entercategory.sendKeys(CategoryName);
	return this;
	
}
	public Category_action clickFile(String fileimage) {
		file.sendKeys(fileimage);
		return this;
		
	}
	public Category_action clickSave() {
		save.click();
		return this;
	}
	public boolean isCategoryAdded() {
		return alertmessage.isDisplayed();
	}	
	}
	


