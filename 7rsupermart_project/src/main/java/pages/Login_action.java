package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class Login_action {
	public WebDriver driver;

	public Login_action(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//button[@class='close']")
	WebElement warning;

	public Login_action enterUsernameandPasswordField(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public Home_Action click_submit() {
		WaitUtility utility = new WaitUtility();
		utility.waitForElementClickable(driver, submitbutton);
		submitbutton.click();
		return new Home_Action(driver);

	}

	public boolean isHomepageloaded() {
		try {
			return homepage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertShown() {
		try {
			return alertmessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void alertclick() {
		warning.click();
	}
}
