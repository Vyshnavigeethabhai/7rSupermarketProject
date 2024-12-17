package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews_action {
	public WebDriver driver;

	public ManageNews_action(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newsadd;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textarea;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement textsave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public ManageNews_action clickNewButton() {
		newsadd.click();
		return this;
	}

	public ManageNews_action enterNews(String Text) {
		textarea.sendKeys(Text);
		return this;

	}

	public ManageNews_action clicksave() {
		textsave.click();
		return this;
	}

	public boolean ISAlertMsgShown() {
		return alertmsg.isDisplayed();

	}
}