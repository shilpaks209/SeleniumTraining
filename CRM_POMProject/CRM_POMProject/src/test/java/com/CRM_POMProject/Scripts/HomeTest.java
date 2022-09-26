package com.CRM_POMProject.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM_POMProject.Constants.Constants;
import com.CRM_POMProject.Pages.HomePage;

public class HomeTest extends BaseTest{
	HomePage objHome;
  @Test(priority=5,groups= {"Sanity Test"})
  public void addClient() {
	  
	  objHome=new HomePage(driver);
	  objHome.clickAddButton();
	  objHome.clickAddClientButton();
	  objHome.addClientDetails();
	  Assert.assertEquals(objHome.clientNameAddedScuceefully(),Constants.ClientName);
  }
}
