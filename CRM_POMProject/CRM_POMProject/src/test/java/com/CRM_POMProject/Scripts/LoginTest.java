package com.CRM_POMProject.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CRM_POMProject.Constants.Constants;
import com.CRM_POMProject.Pages.LoginPage;
import com.CRM_POMProject.Utilities.ExcelRead;


public class LoginTest extends BaseTest 
{
	LoginPage objLogin;
	  @Test(dataProvider= "validUserInvalidPass",priority=1)
	  public void verifysigninValidEmailInvalidPassword(String email1,String password1) 
	  {
		objLogin=new LoginPage(driver);
		objLogin.setEmail(email1);
		objLogin.setPassword(password1);
		objLogin.clickSignin();
Assert.assertEquals(objLogin.getMessage(),Constants.infomessage);
		
	  }
	  @Test(dataProvider= "InvalidUserValidPass",priority=2)
	  public void verifysigninInvalidEmailValidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			objLogin.clickSignin();
			Assert.assertEquals(objLogin.getMessage(),Constants.infomessage);
			
	  }
	  @Test(dataProvider= "InvalidUserInvalidPass",groups= {"Sanity Test"},priority=3)
	  public void verifysigninInvalidEmailInvalidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			objLogin.clickSignin();
			SoftAssert s=new SoftAssert();//Used soft Assert
			s.assertEquals(objLogin.getMessage(),Constants.infomessage);
			s.assertAll();
	  }
	  
	  
	  @Test(dataProvider= "ValiduserValidPass",groups= {"Sanity Test"},priority=4)
	  public void verifysigninValidEmailValidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			
			objLogin.clickSignin();	
			Assert.assertEquals(objLogin.sucessMessage(),Constants.sucessmessage);//Assertion
	  }
	   
	  @DataProvider
	  public Object[][] validUserInvalidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserInvalidpass");
			return data;
	}
	  @DataProvider
	  public Object[][] InvalidUserValidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserValidPass");
			return data;
	  }
	  @DataProvider
	  public Object[][] InvalidUserInvalidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserInvalidpass");
			return data;
	  }
	  @DataProvider
	  public Object[][] BlankUser() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "Blank");
			return data;
	  }
	  @DataProvider
	  public Object[][] ValiduserValidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserValidpass");
			return data;
	  }
	}  
	  
  

