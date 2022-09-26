package com.CRM_POMProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM_POMProject.Utilities.WaitUtilities;



public class LoginPage {
	WaitUtilities objWait;
	WebDriver driver;
	@FindBy(xpath="//p[text()='Sign in to start your session']")
	WebElement text;
	@FindBy(xpath="//input[@id='identity']")
	WebElement email;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='submit']")
	WebElement signin;
	@FindBy(xpath="//p[text()='Joe Jacobs']")
	WebElement SucessMessage;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		objWait=new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public void setEmail(String email1)
	{
		email.sendKeys(email1);
	}
	public void setPassword(String password1)
	{
		password.sendKeys(password1);
	}
	public void clickSignin()
	{
		signin.click();
		
	}
	public void toClear()
	{
		email.clear();
		password.clear();
		
	}
	
	public String getMessage()
	{
		String Message=text.getText();
	
		return Message;
	}

	
	public String sucessMessage()
	{
		objWait.waitForElementTobeVisible(SucessMessage, 60);//used wait
		String SucMessage=SucessMessage.getText();
	
		return SucMessage;
	}

	

}
