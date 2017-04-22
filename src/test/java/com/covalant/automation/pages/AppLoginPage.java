package com.covalant.automation.pages;

import org.openqa.selenium.By;

public class AppLoginPage extends BasePage{

	
	public void login_app(String appUser ,String appPass){
		driver.findElement(By.id("input-email")).sendKeys(appUser);
		driver.findElement(By.id("input-password")).sendKeys(appPass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	public String getErrorMessage(){
		return driver.findElement(By.cssSelector(".alert-danger")).getText();
	}
}
