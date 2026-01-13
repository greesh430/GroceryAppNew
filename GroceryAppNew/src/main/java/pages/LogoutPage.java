package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LogoutPage {
	
	public WebDriver driver;
	
	//@FindBy(xpath="//a[@class='dropdown-toggle']")WebElement profileIcon;
	//@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement profileIcon;
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement profileIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logoutButton;
	@FindBy(xpath="//button[@type='submit']")WebElement loginbuttonfield;
	
public LogoutPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickProfileIcon() 
{
	PageUtility pageutility=new PageUtility();
	pageutility.clickUsingJavaScript(driver, profileIcon); 
//	waitUtility.waitForElementToBeClickable(driver, profileIcon);
//    profileIcon.click();
}

public void clickLogout() 
{
	PageUtility pageutility=new PageUtility();
	pageutility.clickUsingJavaScript(driver, logoutButton);
//	waitUtility.waitForElementToBeClickable(driver, logoutButton);
//    logoutButton.click();
}

public boolean isLoginPageDisplayed()
{
	return loginbuttonfield.isDisplayed();
}

}
