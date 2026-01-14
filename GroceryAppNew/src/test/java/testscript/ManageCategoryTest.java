package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	LogoutPage logoutpage;
	ManageCategoryPage managecategorypage;

	@Test(priority = 1, groups = { "regression" }, retryAnalyzer = retry.Retry.class, description="Test case to create new category")

	public void isUserAbleToManageCategory() throws IOException, AWTException {

//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		String FruitsCategory = ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		System.out.println(FruitsCategory);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		// loginpage.enterThePassword(password);
		logoutpage = loginpage.loginButtonField();

		// ManageCategoryPage category = new ManageCategoryPage(driver);
		managecategorypage = logoutpage.manageCategoryMoreInfo().manageCategoryNew().enterCategoryName(FruitsCategory)
				.enterSave();
//		category.manageCategoryNew();
//		category.enterCategoryName(FruitsCategory);
//		category.enterSave();
		boolean alert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
	}

}
