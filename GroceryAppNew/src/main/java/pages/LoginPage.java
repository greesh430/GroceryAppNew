package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(name = "username")
	WebElement usernamefield;
	@FindBy(name = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbuttonfield;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement alertmessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterTheUsername(String username) {
		usernamefield.sendKeys(username);
		return this;

	}

	public LoginPage enterThePassword(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public LogoutPage loginButtonField() {
		loginbuttonfield.click();
		return new LogoutPage(driver);
	}

	public boolean isHomePageDisplayed() {
		return dashBoard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}

}
