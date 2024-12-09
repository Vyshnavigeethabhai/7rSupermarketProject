package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers_Action;
import pages.Home_Action;
import pages.Login_action;
import utilities.ExcelUtility;

public class AdminUsers_test extends Baseclass{
	public Home_Action homepage;
	public AdminUsers_Action aduser;
  @Test
  public void VerifyUserisabletoAddnewUser() throws IOException {
	  
	  Login_action action=new Login_action(driver);
	  action.enterUsernameandPasswordField("admin","admin");
	 homepage=action.click_submit();
	 aduser=homepage.click_adminUsers();
	  
	 
	  String Username=ExcelUtility.readStringData(1, 0,"AdUser");
	  String Password=ExcelUtility.readStringData(1, 1,"AdUser");
	
	  aduser.click_newButton();
	  aduser.enter_usernamefield(Username);
	  aduser.enter_passwordfield(Password);
	  aduser.usertypefield();
	  aduser.click_save();
	  boolean alertmessageDisplayed=aduser.isAlertSuccesfulDisplayed();
	  assertTrue(alertmessageDisplayed,Constant.USERCREATEDMESSAGE);
	  aduser.click_alertclose();
  }
}
