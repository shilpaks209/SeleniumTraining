package com.CRM_POMProject.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities

{
	public WebDriver driver;
	public PageUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	public void implicityWait()
	{ 
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public WebElement waitForElementTobeVisible(WebElement elementToBeLoaded, int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	public WebElement waitForElementTobeClickable(WebElement elementToBeLoaded, int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;
	}
	public Alert waitForAlert(int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	public void hitenter(WebElement element)
	{
		element.sendKeys(Keys.ENTER);
	}
	public void sendTestUsingMouseActions(WebElement element, String text)
	{
		Actions action=new Actions(driver);
		action.sendKeys(element,text).build().perform();		
	}
    public void moveToElement(WebElement element)
    {
    	Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();	
    }
    public String catchAlert()
    {
    	Alert obj=driver.switchTo().alert();
    	String s=obj.getText();
    	obj.dismiss();
    	return s;
    }
    public void scroll(WebElement element)
    {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
