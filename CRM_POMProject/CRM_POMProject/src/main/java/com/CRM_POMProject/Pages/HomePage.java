package com.CRM_POMProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM_POMProject.Utilities.WaitUtilities;

public class HomePage {
	WaitUtilities objWait;
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		objWait=new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	WebElement plusButton;
	@FindBy(xpath="//span[@class='fa fa-user-plus icon']")
	WebElement AddClientButton;
	@FindBy(xpath="//input[@id='name1']")
	WebElement Name;
	@FindBy(xpath="//input[@id='company1']")
	WebElement company;
	@FindBy(xpath="//input[@id='route']")
	WebElement Address;
	@FindBy(xpath="//input[@id='locality']")
	WebElement city;
	@FindBy(xpath="//input[@id='postal_code']")
	WebElement postcode;
	@FindBy(xpath="//input[@id='telephone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='email1']")
	WebElement email;
	@FindBy(xpath="//input[@id='vat1']")
	WebElement vat;
	@FindBy(xpath="//input[@id='cf1']")
	WebElement ssn;
	@FindBy(xpath="//input[@id='image']")
	WebElement fileupload;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit;
	@FindBy(xpath="//div[@id='titoloclienti']")
	WebElement ClientName;
	
	
	
	
	
	
	public void clickAddButton() {
		plusButton.click();
	}
	public void clickAddClientButton() {
		
		 AddClientButton.click();
	}
	public void addClientDetails() {
		
		Name.sendKeys("shilpa.k.s");
		objWait.waitForElementTobeVisible(company, 60);
		company.sendKeys("Test company");
		Address.sendKeys("Add line1,Add line 2,Add Line3");
		city.sendKeys("trivandrum");
		postcode.sendKeys("686532");
		phone.sendKeys("9744235561");
		email.sendKeys("test@test.com");
		vat.sendKeys("1235");
		ssn.sendKeys("5656");
		fileupload.sendKeys("C:\\Users\\shilpa k s\\Downloads\\download.jpg");
		submit.click();
		
		
		
		
	}
	
	public String clientNameAddedScuceefully()
	{
		objWait.waitForElementTobeVisible(ClientName, 60);//used wait
		String SucMessage=ClientName.getText();
	
		return SucMessage;
	}

	

	
}
