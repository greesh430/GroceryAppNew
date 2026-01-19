package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	LogoutPage logoutpage;
	ManageNewsPage managenewspage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Test case to create new news details")

	public void verifyAddingNews() throws IOException {

//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		String News = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		System.out.println(News);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		// loginpage.loginButtonField();
		logoutpage = loginpage.loginButtonField();

		// ManageNewsPage newspage=new ManageNewsPage(driver);
		managenewspage = logoutpage.manageNews();
		managenewspage.clickAddNews().enterNewsText(News).clickSave();
//		newspage.enterNewsText(News);
//		newspage.clickSave();

		boolean alert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.MANAGENEWS_ERRORMESSAGE);

	}

}
