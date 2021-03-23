package com.qa.ispeakBetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakBetter.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;

 //ElementUtil elementUtil;


By header = By.xpath("//h1[contains(text(),'Dashboard')]");
By accountName = By.id("welcome");

//consructer

public HomePage(WebDriver driver){
	this.driver = driver;
}

public String getHomePageTitle() {
	String title = driver.getTitle();
	return title;
}


public String getPageHeader() {
	String Pageheader = driver.findElement(header).getText();
		return Pageheader;
}

public String getLoggedInUserAccountName() {
	return driver.findElement(accountName).getText();
}

}

