package com.covalant.automation.pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage{

	public String getOrdersNumber(){
		return driver.findElement(By.cssSelector(".tile .fa-shopping-cart+.pull-right")).getText();
	}
	
	public void logout(){
		driver.findElement(By.cssSelector(".fa-sign-out")).click();
	}
}
