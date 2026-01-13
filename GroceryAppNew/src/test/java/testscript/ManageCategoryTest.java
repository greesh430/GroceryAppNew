package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	
	@Test
	
	public void isUserAbleToManageCategory() throws IOException, AWTException
	{
		
//		String username="admin";
//		String password="admin";

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		String FruitsCategory = ExcelUtility.readStringData(0, 0, "ManageCategoryPage");
		System.out.println(FruitsCategory);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		
		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.manageCategoryMoreInfo();
		category.manageCategoryNew();
		category.enterCategoryName(FruitsCategory);
		category.enterSave();
		boolean alert = category.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);
	}

}
