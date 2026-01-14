package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {

	LogoutPage logoutpage;
	ManageContactPage managecontactpage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to create new contact")

	public void isUserAbleToUpdateContactDetails() throws IOException {

//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		System.out.println(username);
		System.out.println(password);

		String phone = ExcelUtility.readIntegerData(1, 0, "ManageContactPage");
		String email = ExcelUtility.readStringData(1, 1, "ManageContactPage");

		System.out.println(phone);
		System.out.println(email);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		//loginpage.loginButtonField();
		logoutpage = loginpage.loginButtonField();

		//ManageContactPage contact = new ManageContactPage(driver);
		managecontactpage = logoutpage.manageContact();
		managecontactpage.manageContactEdit().updatePhone(phone).updateEmail(email).clickUpdateButton();

//		contact.updatePhone(phone);
//		contact.updateEmail(email);
//		contact.clickUpdateButton();

		boolean alert = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);

	}

}
