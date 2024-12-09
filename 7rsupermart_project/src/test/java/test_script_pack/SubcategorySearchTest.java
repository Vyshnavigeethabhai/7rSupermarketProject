package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home_Action;
import pages.Login_action;
import pages.SubcategorySearch_action;
import utilities.ExcelUtility;

public class SubcategorySearchTest extends Baseclass {
	public Home_Action homepage;
	public SubcategorySearch_action searchpage;
  @Test
  public void VerifyUserIsAbleToSearchCategory() throws IOException {
	  String Username=ExcelUtility.readStringData(1, 0,"LoginTest" );
	  String Password=ExcelUtility.readStringData(1, 1,"LoginTest" );
	  String Subcategory=ExcelUtility.readStringData(1, 0, "SubCategory");
	  Login_action log=new Login_action(driver);
	  log.enterUsernameandPasswordField(Username, Password);
	  homepage=log.click_submit();
	  searchpage=homepage.clickSubcategoryMoreinfo1();
	  searchpage.clicksearchButton().clickSelectDropdown().enterSubcategoryName(Subcategory).clickSearch();
	  boolean searchResultDisplayed=searchpage.isAlertResultShown();
	  assertTrue(searchResultDisplayed,Constant.SUBCATEGORYRESULTSHOWN);
  }
}
