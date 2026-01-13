package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base{
	
	@Test
	
	public void verifyUserAbletoUpdateEmailPhone() throws IOException
	{
//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		String phone = ExcelUtility.readIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.readStringData(1, 1, "ManageContactPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();	
		
		ManageFooterPage footer = new ManageFooterPage(driver);
		footer.manageFooterMoreInfo();
        footer.manageFooterEdit();
        footer.updateEmail(phone);
        footer.updatePhone(email);
        footer.clickUpdateButton();
        
        boolean alert = footer.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
		
	}

}
