package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;

//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement managecontactmoreinfo;
//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @class='btn btn-sm btn btn-primary btncss']")WebElement managecontactedit;
	@FindBy(xpath = "//a[contains(@href,'list-contact')]")WebElement managecontactmoreinfo;
	@FindBy(xpath = "//a[contains(@href,'edit_contact') and contains(@class,'btn-primary')]")WebElement managecontactedit;
	@FindBy(name = "email")WebElement emailField;
	@FindBy(name = "phone")WebElement phoneField;
	// @FindBy(xpath = "//button[@name='Update']")WebElement updateButton;
	// @FindBy(xpath = "//button[@type='submit']")WebElement updateButton;
	// @FindBy(xpath = "//button[contains(text(),'Update')]")WebElement
	// updateButton;
	// @FindBy(xpath="//button[@type='submit'] and //button[@name='Update'] and
	// @class='btn btn-block-sm btn-info'")WebElement updateButton;
//	@FindBy(xpath = "//button[@type='submit' and @name='Update']")WebElement updateButton; 
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")WebElement updateButton;

	// <button type="submit" class="btn btn-block-sm btn-info" name="Update"><i
	// class="fa fa-save"></i> Update</button>
	// @FindBy(xpath = "//*[contains(text(),'Update')]")WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageContactPage manageContact() {
		managecontactmoreinfo.click();
		return this;
	}

	public ManageContactPage manageContactEdit() {
		managecontactedit.click();
		return this;
	}

	public ManageContactPage updateEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public ManageContactPage updatePhone(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
		return this;
	}

	public ManageContactPage clickUpdateButton() {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
//		WaitUtility waitutility = new WaitUtility();
//		waitutility.waitForElementToBeClickable(driver, updateButton);
		//updateButton.click();
    	PageUtility pageutility=new PageUtility();
    	pageutility.scrollUsingJavaScript(driver, updateButton);
    	pageutility.clickUsingJavaScript(driver, updateButton);  
    	return this;
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
