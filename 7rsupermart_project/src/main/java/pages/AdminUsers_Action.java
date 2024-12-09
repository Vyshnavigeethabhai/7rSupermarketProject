package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsers_Action {
public WebDriver driver;
public AdminUsers_Action(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//input[@id='username']")WebElement usernamefield;
@FindBy(xpath="//input[@id='password']")WebElement passwordfield;
@FindBy(xpath="//select[@id='user_type']")WebElement usertypefield;
@FindBy(xpath="//select[@id='ut']/option[2]")WebElement option;
@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
@FindBy(xpath="//button[@class='close']")WebElement alertclose;
@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;


public AdminUsers_Action click_newButton() {
	newbutton.click();
	return this;
}
public AdminUsers_Action enter_usernamefield(String username) {
	usernamefield.sendKeys(username);
	return this;
}
public AdminUsers_Action enter_passwordfield(String password) {
	passwordfield.sendKeys(password);
	return this;
}
public AdminUsers_Action usertypefield() {
	usertypefield.click();
	//Select select=new Select(usertypefield);
	//select.selectByVisibleText("Staff");
	PageUtility page=new PageUtility();
	page.selectByIndex(usertypefield, 2);
	return this;
}
public AdminUsers_Action click_save() {
	savebutton.click();
	return this;
}
public boolean isAlertSuccesfulDisplayed() {
	return alertmessage.isDisplayed();
	
}
public void click_alertclose() {
	alertclose.click();
}
public UserSearch_Action click_searchButton() {
    searchbutton.click();
    return new UserSearch_Action(driver);
}
}