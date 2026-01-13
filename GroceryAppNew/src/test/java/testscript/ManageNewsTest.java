package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	
	public void verifyAddingNews() throws IOException
	{
		
//		String username="admin";
//		String password="admin";
				
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		String News = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		System.out.println(News);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		
		ManageNewsPage newspage=new ManageNewsPage(driver);
		newspage.manageNews();
		newspage.clickAddNews();
		newspage.enterNewsText(News);
		newspage.clickSave();
		
		boolean alert = newspage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ALERTNOTDISPLAYED);
		
	}

}
