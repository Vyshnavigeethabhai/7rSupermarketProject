package test_script_pack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import constants.Constant;
import pages.Home_Action;
import pages.Login_action;
import pages.ManageNews_action;
import utilities.ExcelUtility;

public class ManageNewsTest extends Baseclass{
	public Home_Action homepage;
	public ManageNews_action managenews;
	
  @Test(retryAnalyzer=retrypackage.Retry.class)
  public void VerifyUserAbleToAddNews() throws IOException {
	  String Username=ExcelUtility.readStringData(1, 0,"LoginTest" );
	  String Password=ExcelUtility.readStringData(1, 1,"LoginTest" );
	  String News=ExcelUtility.readStringData(1, 0,"ManageNews");
	  Login_action action=new Login_action(driver);
	  action.enterUsernameandPasswordField(Username, Password);
	 homepage=action.click_submit();
	 managenews=homepage.clickmanageNewsMoreInfo().clickNewButton().enterNews(News).clicksave();
	 boolean AlertDisplayed=managenews.ISAlertMsgShown();
	 assertTrue(AlertDisplayed,Constant.MANAGENEWSALERT);
	 
  }
}
