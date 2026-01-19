package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {

	public WebDriver driver;
	PageUtility pageutility=new PageUtility();


	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and @class='small-box-footer']")
	WebElement managecategorymoreinfobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add' and @class='btn btn-rounded btn-danger']")
	WebElement managecategorynewbutton;
	@FindBy(id = "category")
	WebElement categorynamefield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement groupnamefield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefilefield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebuttonfield;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageCategoryPage manageCategoryMoreInfo() {
		//PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, managecategorymoreinfobutton);
		return this;
		// managecategorymoreinfobutton.click();
	}

	public ManageCategoryPage manageCategoryNew() {
		//PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, managecategorynewbutton);
		return this;
		// managecategorynewbutton.click();
	}

	public ManageCategoryPage enterCategoryName(String FruitsCategory) throws AWTException {
		categorynamefield.sendKeys(FruitsCategory);
		groupnamefield.click();
		// choosefilefield.sendKeys(Constant.IMAGEFILE);
		FileUploadUtility fileuploadutility = new FileUploadUtility(); // page utility click
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", choosefilefield);
		pageutility.clickUsingJavaScript(driver, choosefilefield);
		fileuploadutility.fileUploadUsingRobotclass(choosefilefield, Constant.IMAGEFILE);
		return this;
	}

	public ManageCategoryPage enterSave() {
		//PageUtility pageutility = new PageUtility();
		pageutility.clickUsingJavaScript(driver, savebuttonfield);
		return this;
		// savebuttonfield.click();
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
