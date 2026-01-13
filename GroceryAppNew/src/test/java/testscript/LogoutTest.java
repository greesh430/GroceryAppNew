package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class LogoutTest extends Base {
	
	@Test
	
	public void verifyUserAbleToLogout() throws IOException, InterruptedException
	{

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		
		LogoutPage home = new LogoutPage(driver);
		home.clickProfileIcon();
		home.clickLogout();
		
//		WaitUtility wait=new WaitUtility();
//		wait.waitForVisibility(driver, loginpage, 5);
		boolean isLoginPageDisplayed = home.isLoginPageDisplayed();
		Assert.assertTrue(isLoginPageDisplayed, Constant.LOGOUTERROR);
	}
		

}
