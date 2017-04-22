package com.covalant.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenCart {

	WebDriver driver=null;
	String adminUrl = "https://127.0.0.1/opencart/admin/";
	String appUrl = "https://127.0.0.1/opencart";
	String user = "user";
	String pass = "user123";
	String prodcutName="Product11";
	String appUser = "bharath.kristipati@gmail.com";
	String appPass = "selenium123";
	@BeforeMethod
	public void init(){
		driver=new FirefoxDriver();
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void dropdownDisplay() {
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		Select selCountry = new Select(driver.findElement(By.id("input-country")));
		// Select selState =new Select(driver.findElement(By.id("input-zone")));

		List<WebElement> countryList = selCountry.getOptions();
		int countrySize = countryList.size();
		System.out.println(countrySize);

		for (int i = 1; i < countrySize; i++) {

			selCountry.selectByIndex(i);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			if (driver.findElement(By.id("input-zone")).isEnabled()) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Select selState = new Select(driver.findElement(By.id("input-zone")));
				List<WebElement> stateList = selState.getOptions();

				File file = new File("D:\\Country_" + selCountry.getOptions().get(i).getText() + ".txt");
				FileWriter fw = null;
				BufferedWriter bw = null;

				for (WebElement ele : stateList)

				{
					System.out.println(selState.getOptions().get(i).getText());

					try {
						fw = new FileWriter(file, true);
						bw = new BufferedWriter(fw);
						bw.write(selState.getOptions().get(i).getText());
						bw.newLine();
						bw.close();

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			} else {
				// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				i--;

			}

		}

	}
	
	public void openAdminurl(){
		driver.get(adminUrl);
	}
	
	public void openApp(){
		driver.get(appUrl);
	}
	
	public void login(String user , String pass){
		driver.findElement(By.id("input-username")).sendKeys(user);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.cssSelector(".btn-primary")).click();
	}
	
	public void login_app(String appUser ,String appPass){
		driver.findElement(By.id("input-email")).sendKeys(appUser);
		driver.findElement(By.id("input-password")).sendKeys(appPass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	public void logout(){
		driver.findElement(By.cssSelector(".fa-sign-out")).click();
	}
	
	@Test
	public void testLogout(){
		openAdminurl();
		login(user, pass);
		logout();
	}
	
	
	public void clickOnShoppingcart(){
		driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
	}
	
	public void openAppLoginPage(){
		driver.findElement(By.cssSelector(".fa-user")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}
	public String getCartMessage(){
		return driver.findElement(By.xpath("//div[@id='content']/p")).getText();
	}
	
	public String getOrdersNumber(){
		return driver.findElement(By.cssSelector(".tile .fa-shopping-cart+.pull-right")).getText();
	}
	public String getErrorMessage(){
		return driver.findElement(By.cssSelector(".alert-danger")).getText();
	}
	@Test
	public void verifyOpenCart(){
		openApp();
		clickOnShoppingcart();
		
		String actualMessage=getCartMessage();
		
		String expected = "Your shopping cart is empty!";	
		
		Assert.assertEquals(actualMessage, expected);
		
		openAppLoginPage();
		
		login_app(appUser,appPass);
	
		
		String actualError = getErrorMessage();
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualError, expectedError);
		
		openAdminurl();
		
		login(user, pass);
		
		String el = getOrdersNumber();
		Assert.assertEquals(el, "0");
		
		logout();
		
	}
	@Test
	public void addingProduct()
	{
		
		openAdminurl();
		login(user,pass);
		
		Actions act =new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector(".fa-tags"))).click().build().perform();
		act.moveToElement(driver.findElement(By.linkText("Products"))).click().build().perform();
		
		driver.findElement(By.cssSelector(".fa-plus")).click();
		
		driver.findElement(By.id("input-name1")).sendKeys(prodcutName);
		driver.findElement(By.id("input-meta-title1")).sendKeys("Product11");
		
		driver.findElement(By.linkText("Data")).click();
		driver.findElement(By.id("input-model")).sendKeys("P11");
		driver.findElement(By.id("input-price")).sendKeys("1000");
		
		driver.findElement(By.linkText("Discount")).click();
		driver.findElement(By.xpath("//button[@data-original-title='Add Discount']")).click();
		driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Quantity']")).sendKeys("1");
		driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Priority']")).sendKeys("1");
		driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Price']")).sendKeys("100");
		driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date Start']")).sendKeys("2017-04-20");
		driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date End']")).sendKeys("2017-05-20");
		
		driver.findElement(By.linkText("Reward Points")).click();
		driver.findElement(By.id("input-points")).sendKeys("10");
		
		driver.findElement(By.cssSelector(".fa-save")).click();
		
		logout();
		openApp();
		driver.findElement(By.cssSelector(".form-control")).sendKeys(prodcutName);
		driver.findElement(By.cssSelector(".fa-search")).click();
		
		//driver.findElement(By.xpath("//a[text()='Product1']")).getText();
		
				
	}
}
