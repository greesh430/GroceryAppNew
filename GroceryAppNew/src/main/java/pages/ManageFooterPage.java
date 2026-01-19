package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterPage {

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2' and @class='btn btn-sm btn btn-primary btncss']")
	WebElement managefooteredit;
	@FindBy(xpath= "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneField;
	// @FindBy(xpath = "//button[text()='Update']")WebElement updateButton;
	////button[@name='Update']"
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageFooterPage manageFooterMoreInfo() {
		PageUtility pageutility = new PageUtility();
		
		waitutility.waitForElementToBeClickable(driver, managefootermoreinfo);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", managefootermoreinfo);
		
		pageutility.clickUsingJavaScript(driver, managefootermoreinfo);
		return this;
		// managefootermoreinfo.click();
	}

	public ManageFooterPage manageFooterEdit() {
		
		waitutility.waitForElementToBeClickable(driver, managefooteredit);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", managefooteredit);

		pageutility.clickUsingJavaScript(driver, managefooteredit);
		return this;
		// managefooteredit.click();
	}

	public ManageFooterPage updateEmail(String email) {
		emailField.clear();
		//pageutility.javaScriptscrollIntoView(driver, emailField);
		
		waitutility.waitForElementToBeClickable(driver, emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", emailField);
		
		
		
		emailField.sendKeys(email);
		return this;
//		 pageutility.javaScriptscrollIntoView(driver, emailField); // scroll first
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.visibilityOf(emailField));
//		    wait.until(ExpectedConditions.elementToBeClickable(emailField));
//
//		    emailField.clear();            
//		    emailField.sendKeys(email)
	}

	public ManageFooterPage updatePhone(String phone) {
		phoneField.clear();
		
		waitutility.waitForElementToBeClickable(driver, phoneField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", phoneField);
		
		
		phoneField.sendKeys(phone);
		return this;
//		pageutility.javaScriptscrollIntoView(driver, phoneField);
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(phoneField));
//	    wait.until(ExpectedConditions.elementToBeClickable(phoneField));
//
//	    phoneField.clear();
//	    phoneField.sendKeys(phone);

	}

	public ManageFooterPage clickUpdateButton() {
		PageUtility pageutility = new PageUtility();
//	    pageutility.scrollUsingJavaScript(driver);
		waitutility.waitForElementToBeClickable(driver, updateButton);
//		pageutility.clickUsingJavaScript(driver, updateButton);
		//pageutility.actionClassClick(driver, updateButton);
		
		waitutility.waitForElementToBeClickable(driver, updateButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", updateButton);
		
		
		updateButton.click();
		return this;
	 
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();

	}
}
