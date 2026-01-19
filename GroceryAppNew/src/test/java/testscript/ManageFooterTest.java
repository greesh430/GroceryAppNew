package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {

	LogoutPage logoutpage;
	ManageFooterPage managefooterpage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case for manage footer update")

	public void verifyUserAbletoUpdateEmailPhone() throws IOException {
//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		String phone = ExcelUtility.readIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.readStringData(1, 1, "ManageContactPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		// loginpage.loginButtonField();
		logoutpage = loginpage.loginButtonField();

		// ManageFooterPage footer = new ManageFooterPage(driver);
		managefooterpage = logoutpage.manageFooterMoreInfo();
		managefooterpage.manageFooterEdit().updateEmail(email).updatePhone(phone).clickUpdateButton();
//        footer.updateEmail(phone);
//        footer.updatePhone(email);
//        footer.clickUpdateButton();

		boolean alert = managefooterpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.MANAGEFOOTER_ERRORMESSAGE);

	}

}
