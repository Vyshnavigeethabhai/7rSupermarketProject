package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubcategorySearch_action {
	public WebDriver driver;

	public SubcategorySearch_action(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement selectdropdown;
	@FindBy(xpath = "//option[text()='Vegetables']")
	WebElement categoryoption;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	WebElement subcategoryname;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement search;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	WebElement searchresult;

	public SubcategorySearch_action clicksearchButton() {
		searchbutton.click();
		return this;
	}

	public SubcategorySearch_action clickSelectDropdown() {
		selectdropdown.click();
		categoryoption.click();
		return this;
	}

	public SubcategorySearch_action enterSubcategoryName(String subcategory) {
		subcategoryname.sendKeys(subcategory);
		return this;
	}

	public SubcategorySearch_action clickSearch() {
		search.click();
		return this;

	}

	public boolean isAlertResultShown() {
		return searchresult.isDisplayed();

	}
}