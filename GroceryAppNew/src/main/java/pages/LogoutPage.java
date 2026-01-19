package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LogoutPage {

	public WebDriver driver;

	// @FindBy(xpath="//a[@class='dropdown-toggle']")WebElement profileIcon;
	// @FindBy(xpath="//a[@data-toggle='dropdown']")WebElement profileIcon;
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement profileIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logoutButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbuttonfield;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")
	WebElement adminusermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")
	WebElement managecategorymoreinfobutton;
	@FindBy(xpath = "//a[contains(@href,'list-contact')]")
	WebElement managecontactmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsMoreinfo;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUserPage adminUserMoreInfo() {
		adminusermoreinfo.click();
		return new AdminUserPage(driver);
	}

	public ManageCategoryPage manageCategoryMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, managecategorymoreinfobutton);
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage manageContact() {
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage manageFooterMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, managefootermoreinfo);
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage manageNews() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, manageNewsMoreinfo);
		return new ManageNewsPage(driver);
	}

	public void clickProfileIcon() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, profileIcon);
	}

	public void clickLogout() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, logoutButton);
//	waitUtility.waitForElementToBeClickable(driver, logoutButton);
//    logoutButton.click();
	}

	public boolean isLoginPageDisplayed() {
		return loginbuttonfield.isDisplayed();
	}

}
