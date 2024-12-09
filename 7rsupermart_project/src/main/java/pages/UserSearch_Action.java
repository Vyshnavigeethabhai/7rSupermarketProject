package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserSearch_Action {
public WebDriver driver;
public UserSearch_Action(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
	@FindBy(xpath="//input[@id='un']")WebElement usernamefield;
	@FindBy(xpath="//select[@name='ut']")WebElement selecttype;
	@FindBy(xpath="//select[@id='ut']/option[2]")WebElement staffoption;
	@FindBy(xpath="//button[@name='Search']")WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement searchresult;
	
		
		
	
	public void enter_username(String username) {
		usernamefield.sendKeys(username);
		
	}
	public void select_userype() {
		selecttype.click();
		Select select=new Select(selecttype);
		select.selectByVisibleText("Staff");
	
	
	}
	public void click_search() {
		search.click();
		
	}
	public boolean isSearchResultShown() {
		return searchresult.isDisplayed();
	}
}

