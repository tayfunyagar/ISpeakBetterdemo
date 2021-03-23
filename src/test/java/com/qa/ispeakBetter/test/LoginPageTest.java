package com.qa.ispeakBetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakBetter.base.BasePage;
import com.qa.ispeakBetter.pages.LoginPage;
import com.qa.ispeakBetter.util.Constansts;;


public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		
		
	}
	@Test(priority = 1,enabled = true ,description ="Check login page title")
	public void verifyTitle(){
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, Constansts.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority = 2,enabled = true, description = "Flexable package")
	public void filexiblePackage() {
		Assert.assertEquals(loginPage.duration(), "60");
		Assert.assertEquals(loginPage.subscribed(), "2 weeks");
		Assert.assertEquals(loginPage.weeklyClass(), "2 Classes");
		Assert.assertEquals(loginPage.program(), "Conversational English");
		
	}
	
	@Test(priority = 3,enabled = true, description = "Verify login with correct credentials")
	public void loginTest(){
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		String actualtext = loginPage.loginWelcome();
		Assert.assertEquals(actualtext,Constansts.LOGIN_WELCOME_PAGE);
   }
	
	
		 
	
	@AfterMethod 
	public void tearDown(){
	basePage.quitBrowser();
	}
}
