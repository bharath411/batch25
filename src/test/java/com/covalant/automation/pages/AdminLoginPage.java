package com.covalant.automation.pages;

import org.openqa.selenium.By;

public class AdminLoginPage extends BasePage{

	//Hi This is comment
	public void login(String user , String pass){
		driver.findElement(By.id("input-username")).sendKeys(user);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.cssSelector(".btn-primary")).click();
	}
}
