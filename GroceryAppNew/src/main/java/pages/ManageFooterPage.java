package pages;

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
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2' and @class='btn btn-sm btn btn-primary btncss']")WebElement managefooteredit;
	@FindBy(name = "email")WebElement emailField;
	@FindBy(name = "phone")WebElement phoneField; 
	//@FindBy(xpath = "//button[text()='Update']")WebElement updateButton;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	
	public ManageFooterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManageFooterPage manageFooterMoreInfo()
	{
		PageUtility pageutility=new PageUtility();
    	pageutility.clickUsingJavaScript(driver, managefootermoreinfo); 
    	return this;
		//managefootermoreinfo.click();
	}

	public ManageFooterPage manageFooterEdit()
	{	
		PageUtility pageutility=new PageUtility();
    	pageutility.clickUsingJavaScript(driver, managefooteredit); 
    	return this;
        //managefooteredit.click();
	}

    public ManageFooterPage updateEmail(String email) 
    {        
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public ManageFooterPage updatePhone(String phone) 
    {        
        phoneField.clear();
        phoneField.sendKeys(phone);
        return this;
    }

    public ManageFooterPage clickUpdateButton() 
    {
    	PageUtility pageutility=new PageUtility();
    	pageutility.scrollUsingJavaScript(driver, updateButton);
    	pageutility.clickUsingJavaScript(driver, updateButton); 
    	return this;
    	//updateButton.click();
    }

    public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	
    }
}
	 

