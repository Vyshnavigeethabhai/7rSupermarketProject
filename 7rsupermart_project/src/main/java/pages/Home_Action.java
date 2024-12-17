package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Action {
	public WebDriver driver;

	public Home_Action(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admindropdown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	WebElement loginpage;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement moreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/a")
	WebElement moreinfo1;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[4]/div/a")
	WebElement subcategorymoreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[9]/div/a")
	WebElement manageNewsMoreInfo;

	public Home_Action click_Admin() {
		admindropdown.click();
		return this;
	}

	public Home_Action click_logout() {
		logoutButton.click();
		return this;
	}

	public AdminUsers_Action click_adminUsers() {
		moreinfo.click();
		return new AdminUsers_Action(driver);

	}

	public Category_action clikMoreinfo1() {
		moreinfo1.click();
		return new Category_action(driver);
	}

	public Subcategory_action clickSubcategoryMoreinfo() {
		subcategorymoreinfo.click();
		return new Subcategory_action(driver);
	}

	public SubcategorySearch_action clickSubcategoryMoreinfo1() {
		subcategorymoreinfo.click();
		return new SubcategorySearch_action(driver);

	}

	public ManageNews_action clickmanageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNews_action(driver);
	}
}