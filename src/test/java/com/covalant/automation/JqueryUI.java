package com.covalant.automation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JqueryUI {

	WebDriver driver = null;
	String url = "https://jqueryui.com/droppable/";
	String browser  = "firefox";
	@Test
	public void testDragnDrop() {
		//This is a drag and drop example
		WebElement iframeEle  = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframeEle);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions actions  = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).build().perform();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
	
		File file3  =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file2 = new File("D:\\Sc.jpeg");
		try {
			FileUtils.copyFile(file3, file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "Dropped!";
		String actual  =  driver.findElement(By.id("droppable")).getText();
		
		driver.switchTo().defaultContent();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testDragnDrop2() {
		driver.get(url);
		WebElement iframeEle  = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(iframeEle);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions actions  = new Actions(driver);
	
		int x1 = draggable.getLocation().getX();
		int y1 = draggable.getLocation().getY();
		
		int x2 = droppable.getLocation().getX();
		int y2 = droppable.getLocation().getY();
		
		int x = x2 - x1;
		int y = y2 - y1;
		System.out.println("X = " + x + " Y = " + y);
		actions.clickAndHold(draggable).moveByOffset(x, y).release().build().perform();;
		
		String expected = "Dropped!";
		String actual  =  driver.findElement(By.id("droppable")).getText();
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void launch() {

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\jars\\selenium-2.53.1\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\jars\\selenium-2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
}
