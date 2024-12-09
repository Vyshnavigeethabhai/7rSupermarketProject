package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home_Action;
import pages.Login_action;
import pages.Subcategory_action;
import utilities.ExcelUtility;

public class SubCategoryTest extends Baseclass {
	public Home_Action homepage;
	public Subcategory_action subpage;
  @Test
  public void VerifyUserIsAbleToAddSubcategory() throws IOException {
	  String Username=ExcelUtility.readStringData(1, 0,"LoginTest" );
	  String Password=ExcelUtility.readStringData(1, 1,"LoginTest" );
	  String Subcategory=ExcelUtility.readStringData(1, 0, "SubCategory");
	  Login_action logac=new  Login_action (driver);
	  logac.enterUsernameandPasswordField(Username, Password);
	  homepage=logac.click_submit();
	  subpage=homepage.clickSubcategoryMoreinfo().clicknewButton().clickSelectOption().enterSubcategory(Subcategory).clicksubcategoryFile();
	  subpage.windowScrollDown();
	  subpage.clicksavebutton();
	  boolean Alertdisplayed= subpage.isSubcategoryAddAlert();
	  assertTrue(Alertdisplayed,Constant.SUBCATEGORYALERT);
	  
  }
}
