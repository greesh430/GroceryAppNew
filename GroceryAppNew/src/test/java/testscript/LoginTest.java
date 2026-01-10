package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest extends Base {
	
	@Test(priority=1)
	
	public void verifyIfUserAbleToLoginUsingValidUsernameValidPassword()
	{
		String username="admin";
		String password="admin";
		
//		WebElement userName=driver.findElement(By.name("username"));
//		userName.sendKeys(username);
//		WebElement passWord=driver.findElement(By.name("password"));
//		passWord.sendKeys(password);
//		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
//		signIn.click();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		boolean homePage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homePage);
	}
	
	@Test(priority=2)
	
	public void verifyIfUserAbleToLoginUsingValidUsernameInvalidPassword()
	{
		String username="admin";
		String password="admin1";
		
//		WebElement userName=driver.findElement(By.name("username"));
//		userName.sendKeys(username);
//		WebElement passWord=driver.findElement(By.name("password"));
//		passWord.sendKeys(password);
//		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
//		signIn.click();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	
	@Test(priority=3)
	
	public void verifyIfUserAbleToLoginUsingInvalidUsernameValidPassword()
	{
		String username="123";
		String password="admin";
		
//		WebElement userName=driver.findElement(By.name("username"));
//		userName.sendKeys(username);
//		WebElement passWord=driver.findElement(By.name("password"));
//		passWord.sendKeys(password);
//		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
//		signIn.click();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	
	@Test(priority=4)
	
	public void verifyIfUserAbleToLoginUsingInvalidUsernameInvalidPassword()
	{
		String username="123";
		String password="123";
		
//		WebElement userName=driver.findElement(By.name("username"));
//		userName.sendKeys(username);
//		WebElement passWord=driver.findElement(By.name("password"));
//		passWord.sendKeys(password);
//		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
//		signIn.click();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.loginButtonField();
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
