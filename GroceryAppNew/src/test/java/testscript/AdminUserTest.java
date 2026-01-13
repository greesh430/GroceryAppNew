package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	
	@Test
	
	public void adminUserInformations() throws IOException
	{
//		String username="admin";
//		String password="admin";
		
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();	
		
		AdminUserPage adminuser = new AdminUserPage(driver);
		FakerUtility fakerutility=new FakerUtility();
		String uname=fakerutility.createARandomFirstname();
		String pwrd=fakerutility.createARandomLastName();
        adminuser.adminUserMoreInfo();
        adminuser.addNewButtonClick();
        adminuser.enterNewUserName(uname);
        adminuser.enterNewPassword(pwrd);
        adminuser.enterUserType();
        adminuser.saveButton();
        
        boolean alert = adminuser.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);
	}

}
