package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	LogoutPage logoutpage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to check login functionality using different username and password combinations")

	public void verifyIfUserAbleToLoginUsingValidUsernameValidPassword() throws IOException {
//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.enterTheUsername(username);
//		loginpage.enterThePassword(password);
//		loginpage.loginButtonField();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage, Constant.LOGINVALIDCREDENTIALS);
	}

	@Test(priority = 2, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to check login functionality using different username and password combinations")

	public void verifyIfUserAbleToLoginUsingValidUsernameInvalidPassword() throws IOException {
//		String username="admin";
//		String password="admin1";

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");

//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.enterTheUsername(username);
//		loginpage.enterThePassword(password);
//		loginpage.loginButtonField();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
	}

	@Test(priority = 3, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to check login functionality using different username and password combinations")

	public void verifyIfUserAbleToLoginUsingInvalidUsernameValidPassword() throws IOException {
//		String username="123";
//		String password="admin";

		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
//
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.enterTheUsername(username);
//		loginpage.enterThePassword(password);
//		loginpage.loginButtonField();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
	}

	@Test(priority = 4, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to check login functionality using different username and password combinations")

	public void verifyIfUserAbleToLoginUsingInvalidUsernameInvalidPassword() throws IOException {
//		String username="123";
//		String password="123";

		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");

//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.enterTheUsername(username);
//		loginpage.enterThePassword(password);
//		loginpage.loginButtonField();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
	}

}
