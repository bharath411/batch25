package com.covalant.automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	public void clickOnShoppingcart(){
		driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
	}
	
	public void openAppLoginPage(){
		driver.findElement(By.cssSelector(".fa-user")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}
}
