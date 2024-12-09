package test_script_pack;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Login_action;
import utilities.ExcelUtility;

public class login_test extends Baseclass {
	//data provider for valid credentials
	  @DataProvider(name="validcredentials")
	  public Object[][] testdata()
	  {
	  Object data[][] ={{"admin","admin"}};
	  return data;
}
	
	@Test(dataProvider="validcredentials")
 
  public void verifyuserisabletologinwithvalidcredentials(String UsernamE,String PassworD) {
	  Login_action log=new Login_action(driver);
	  log.enterUsernameandPasswordField(UsernamE,PassworD);
	  log.click_submit();
	  boolean homepageloaded= log.isHomepageloaded();
	  assertTrue(homepageloaded, Constant.ERRORMESSAGELOGIN);
	 
	  
  }
	
	//Invalid USERNAME
	@Test
  public void verifyuserisabletologinwithinvalidusername() throws IOException  {
		String Username=ExcelUtility.readStringData(2, 0,"LoginTest");
		String Password=ExcelUtility.readStringData(2, 1,"LoginTest");
	  Login_action log=new Login_action(driver);
	  log.enterUsernameandPasswordField(Username, Password);
	  log.click_submit();
	  boolean Alertpopupshown=log.isAlertShown();
	  assertTrue(Alertpopupshown, Constant.ALERTMESSAGEINVALIDUSER);
		log.alertclick();
	
	  
	
  }
// invalid PASSWORD
  
@Test
  public void verifyuserisabletologinwithinvalidpassword() {
	  Login_action log=new Login_action(driver);
	  log.enterUsernameandPasswordField("admin","admi");
	 log.click_submit();
	  boolean warningpopupshown=log.isAlertShown();
	  assertTrue(warningpopupshown, Constant.ALERTMESSAGEIVALIDPASSWORD);
	log.alertclick();
	 
  }
@Test
@Parameters({"Username","Password"})
  
 public void verifyuserisabletologinwithinvalidcredentials(String Username, String Password) throws IOException {
	
	Login_action log=new Login_action(driver);
	  log.enterUsernameandPasswordField(Username,Password);
	  log.click_submit();
	  boolean warningpopupshown=log.isAlertShown();
	  assertTrue(warningpopupshown,Constant.ALERTMESSAGEINVALIDCREDENTIALS);
	  log.alertclick();
	
	
}
}