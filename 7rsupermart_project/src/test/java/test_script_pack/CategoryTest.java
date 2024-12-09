package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Locale.Category;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Category_action;
import pages.Home_Action;
import pages.Login_action;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class CategoryTest extends Baseclass{
	public Home_Action homepage;
	public Category_action cat;
  @Test
  public void VerifyUSERABLETOCREATEVEGETABLES() throws IOException {
	  String Username=ExcelUtility.readStringData(1, 0,"LoginTest" );
	  String Password=ExcelUtility.readStringData(1, 1,"LoginTest" );
	  String Category=ExcelUtility.readStringData(1, 0, "Category");
	Login_action login=new Login_action(driver);
	login.enterUsernameandPasswordField(Username, Password);
	homepage=login.click_submit();
	cat=homepage.clikMoreinfo1();
	cat.clickCategoryNewButton();
	
	cat.enterCategoryField(Category);
	cat.clickFile(Constant.FILEIMAGE);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	cat.clickSave();
	/*boolean alertShown=cat.isCategoryAdded();
	assertTrue(alertShown,Constant.CATEGORYALERT);*/
  }
}
