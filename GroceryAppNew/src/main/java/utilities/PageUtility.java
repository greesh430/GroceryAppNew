package utilities;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {   //to help page class, creating pageutility class
	
	public void selectByVisibleTextMethod(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void selectByIndexMethod(WebElement element, int index)
	{
		Select select =new Select(element);
		select.selectByIndex(index);	
	}
	public void selectByValueMethod(WebElement element,String value)
	{
		Select select =new Select(element);
		select.selectByValue(value);	
	}
	public void rightClickActionMethod(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
	}
	public void mouseHoverActionMethod(WebDriver driver, WebElement element) 
	{
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
	}
	public void dragAndDropActionMethod(WebDriver driver, WebElement draggable, WebElement droppable) 
	{
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }
	public void keyPressEventMethod(int key1, int key2) throws AWTException 
	{
	    Robot robot = new Robot();
	    robot.keyPress(key1);
	    robot.keyPress(key2);
	    robot.keyRelease(key2);
	    robot.keyRelease(key1);
	}
	public void clickUsingJavaScript(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
	}
	public void scrollUsingJavaScript(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");

	}
	
	public void actionClassClick(WebDriver driver, WebElement element) 
	{
        Actions actions = new Actions(driver);
        actions.click(element).perform();
	}
	
	public void javaScriptscrollIntoView(WebDriver driver, WebElement element)
	{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
	
	}
}


