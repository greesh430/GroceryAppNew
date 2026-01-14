package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;


public class Base {
	
	public WebDriver driver;
	public FileInputStream fileinputestream;
	public Properties properties;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		try
		{
			properties= new Properties();
			fileinputestream=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputestream);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception ("Invalid Browser");
		}
		
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
//	public void browserCloseAndQuit() {
//		//driver.close();
//		driver.quit();
//	}
	
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); 
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}
