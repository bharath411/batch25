package com.covalant.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandle {
	WebDriver driver = null;
	@Test
	public void testAlertF(){
		launch("firefox");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		String expected ="You pressed OK!";
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		/*String actual =driver.findElement(By.id("demo")).getText();
		Assert.assertEquals(actual, expected);*/
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@title='Save']")).click();
		tearDown();
	}
	
	public void tearDown(){
		
		driver.quit();
	}
	public void launch(String browser){
		
		if(browser.equals("firefox")){
			driver  = new FirefoxDriver();
		}else if(browser.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver", "D:\\jars\\selenium-2.53.1\\chromedriver.exe");
			 driver  = new ChromeDriver();
		}else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\jars\\selenium-2.53.1\\IEDriverServer.exe");
			 driver  = new InternetExplorerDriver();
		}
		String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
}
