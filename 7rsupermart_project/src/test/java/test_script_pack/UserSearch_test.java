package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers_Action;
import pages.Home_Action;
import pages.Login_action;
import pages.UserSearch_Action;
import utilities.ExcelUtility;

public class UserSearch_test extends Baseclass {
	public Home_Action homepage;
	public AdminUsers_Action aduser;
	public UserSearch_Action searchpage;
  @Test
  public void VerifyUserIsableToSearch() throws IOException {
	  Login_action act=new Login_action(driver);
	  act.enterUsernameandPasswordField("admin","admin");
	  homepage=act.click_submit();
	  aduser=homepage.click_adminUsers();
	  searchpage=aduser.click_searchButton();
	  
	 
	String Username=ExcelUtility.readStringData(1, 0,"SearchResult");
	  String UserType=ExcelUtility.readStringData(1, 1,"SearchResult");
	  searchpage.enter_username(Username);
	  searchpage.select_userype();
	  searchpage.click_search();
	 boolean serachResultDisplayed=searchpage.isSearchResultShown();
	 assertTrue(serachResultDisplayed,Constant.SEARCHRESULT);
	  
  }
}
