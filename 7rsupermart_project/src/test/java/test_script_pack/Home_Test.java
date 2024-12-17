package test_script_pack;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Login_action;
import pages.Home_Action;
import utilities.ExcelUtility;

public class Home_Test extends Baseclass {
	public Home_Action homepage;

	@Test
	public void UserIsAbleToLogout() throws IOException {
		String Username = ExcelUtility.readStringData(1, 0, "LoginTest");
		String Password = ExcelUtility.readStringData(1, 1, "LoginTest");

		Login_action logout = new Login_action(driver);
		logout.enterUsernameandPasswordField(Username, Password);

		homepage = logout.click_submit();
		homepage.click_logout();

		Home_Action logout1 = new Home_Action(driver);
		logout1.click_Admin();
		// logout1.click_logout();
		String expectedTitle = "Login | 7rmart supermarket";
		String actualtitle = driver.getTitle();
		System.out.println("Page title is:" + "" + actualtitle);
		assertEquals(actualtitle, expectedTitle, "title does not match");

	}

}
