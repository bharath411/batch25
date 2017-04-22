package com.covalant.automation.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

	public String getCartMessage(){
		return driver.findElement(By.xpath("//div[@id='content']/p")).getText();
	}
}
