package testscript;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	LogoutPage logoutpage;
	AdminUserPage adminuserpage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to create new admin user")

	public void adminUserInformations() throws IOException {
//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		//AdminUserPage adminuser = new AdminUserPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String uname = fakerutility.createARandomFirstname() + LocalDateTime.now();
		String pwrd = fakerutility.createARandomLastName();
		adminuserpage = logoutpage.adminUserMoreInfo();
		adminuserpage.addNewButtonClick().enterNewUserName(uname).enterNewPassword(pwrd).enterUserType()
				.saveButtonClick();
//        adminuserpage.enterNewUserName(uname);
//        adminuserpage.enterNewPassword(pwrd);
//        adminuserpage.enterUserType();
//        adminuserpage.saveButtonClick();

		boolean alert = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);

	}

}
