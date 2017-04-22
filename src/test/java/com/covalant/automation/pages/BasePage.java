package com.covalant.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.covalant.automation.scripts.BaseTestCase;

public class BasePage {

	
	WebDriver driver =BaseTestCase.driver;
	public void openApp(){
		driver.get(BaseTestCase.appUrl);
	}
	
	public void openAdminurl(){
		driver.get(BaseTestCase.adminUrl);
	}
}
