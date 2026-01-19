package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")
	WebElement adminusermoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addnewbuttonclick;
//	@FindBy(xpath="//input[@id='username']")WebElement newUserUsername;
//	@FindBy(xpath="//input[@id='password']")WebElement newUserPassword;
	@FindBy(xpath = "//input[@name='username']")
	WebElement newUserUsername;
	@FindBy(xpath = "//input[@name='password']")
	WebElement newUserPassword;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement saveButton;
	// @FindBy(xpath = "//div[@class='alert alert-success
	// alert-dismissible']")WebElement alertmsg;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmsg;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUserPage adminUserMoreInfo() {
		adminusermoreinfo.click();
		return this;
	}

	public AdminUserPage addNewButtonClick() {
		addnewbuttonclick.click();
		return this;
	}

	public AdminUserPage enterNewUserName(String uname) {
		newUserUsername.sendKeys(uname);
		return this;
	}

	public AdminUserPage enterNewPassword(String pwrd) {
		newUserPassword.sendKeys(pwrd);
		return this;
	}

	public AdminUserPage enterUserType() {
//		Select drop = new Select(userTypeDropdown);
//        drop.selectByIndex(1);
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndexMethod(userTypeDropdown, 1);
		return this;
	}

	public AdminUserPage saveButtonClick() {
		saveButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
