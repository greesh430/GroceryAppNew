package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;

public class ManageNewsPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsMoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement manageNewsAddMenu;
	// @FindBy(xpath = "//span[text()='Manage News']")WebElement manageNewsMenu;
	// @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement
	// addNewNewsButton;
	// @FindBy(xpath = "(//a[@class='btn btn-rounded btn-danger'])[2]")WebElement
	// addNewNewsButton;
	// @FindBy(xpath = "//a[contains(text(),'Add News')]")WebElement
	// addNewNewsButton;
	// @FindBy(xpath = "//a[contains(@class,'btn btn-rounded
	// btn-danger')]")WebElement addNewNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextField;
	// @FindBy(xpath = "//textarea[@name='news']")WebElement newsTextField;
	// @FindBy(xpath = "//button[@name='create']")WebElement saveButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement alertmsg;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage manageNews() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, manageNewsMoreinfo);
		// manageNewsMoreinfo.click();
		return this;
	}

	public ManageNewsPage clickAddNews() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, manageNewsAddMenu);
		// addNewNewsButton.click();
		return this;
	}

	public ManageNewsPage enterNewsText(String News) {
		newsTextField.sendKeys(News);
		return this;
	}

	public ManageNewsPage clickSave() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, saveButton);
//		saveButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
