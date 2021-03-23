package com.qa.ispeakBetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakBetter.base.BasePage;
import com.qa.ispeakBetter.util.Constansts;
import com.qa.ispeakBetter.util.ElementUtil;
import com.qa.ispeakBetter.util.JavaScriptUtil;


public class LoginPage extends BasePage {
	//Fields
		WebDriver driver;
		ElementUtil elementUtil;
		//cmdSiginLink
		By SiginLink = By.id("cmdSiginLink");
		By userName = By.id("_email");
		By Password = By.id("_password");
		By loginBT = By.id("cmdSignin");
		By clickSignin = By.id("signin");
		By welcome =By.xpath("//strong[normalize-space()='Tayfun']");
		By duration = By.xpath("//span[@id='select2-class_duration-container']");
		By list = By.className("select2-results__option");
		By subscribed = By.xpath("//span[@id='select2-package_length-container']");
		By weeklyClass = By.xpath("//span[@id='select2-per_week_class_number-container']");
		By program = By.xpath("//span[@id='select2-course_program-container']");
		
		//Constructor
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}
		
		//Page actions
		public String getPageTitle() {
			return elementUtil.waitForGetPageTitle(Constansts.LOGIN_PAGE_TITLE);
			 
		}
		
		public String loginWelcome() {
			elementUtil.waitForElementPresentBy(welcome);
			String welcometext = driver.findElement(welcome).getText();
			return welcometext;
		}
		
		public String duration() {
			JavaScriptUtil.scrollDownSpecific(driver);
			elementUtil.waitForElementPresentBy(duration);
			elementUtil.doClick(duration);
			return elementUtil.selectSingleValue(driver, list, "60");
		}
		
		public String subscribed() {
			elementUtil.waitForElementPresentBy(subscribed);
			elementUtil.doClick(subscribed);
			return elementUtil.selectSingleValue(driver, list, "2 weeks");
		}
		public String weeklyClass() {
			elementUtil.waitForElementPresentBy(weeklyClass);
			elementUtil.doClick(weeklyClass);
			return elementUtil.selectSingleValue(driver, list, "2 Classes");
		}
		public String program() {
			elementUtil.waitForElementPresentBy(program);
			elementUtil.doClick(program);
			return elementUtil.selectSingleValue(driver, list, "Conversational English");
		}
		
		
		public void  doLogin(String username, String password) {
			elementUtil.doClick(SiginLink);
			elementUtil.waitForElementPresentBy(clickSignin);
			elementUtil.doClick(clickSignin);
			elementUtil.isElementEnabled(userName);
			elementUtil.doSendKeys(userName, username);
			elementUtil.waitForElementPresentBy(Password);
			elementUtil.doSendKeys(Password, password);
			elementUtil.waitForElementPresentBy(loginBT);
			elementUtil.doClick(loginBT);
			
			
			//driver.findElement(SiginLink).click();
			//driver.findElement(this.userName).sendKeys(username);
			//driver.findElement(this.Password).sendKeys(password);
			//driver.findElement(loginBT).click();
			
		}
		
		
		
		

	}
