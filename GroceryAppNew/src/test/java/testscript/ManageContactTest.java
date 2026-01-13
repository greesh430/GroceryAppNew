package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {

	@Test

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
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();

		ManageContactPage contact = new ManageContactPage(driver);
		contact.manageContact();
		contact.manageContactEdit();
		
		contact.updatePhone(phone);
		contact.updateEmail(email);
		contact.clickUpdateButton();

		boolean alert = contact.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);

	}

}
