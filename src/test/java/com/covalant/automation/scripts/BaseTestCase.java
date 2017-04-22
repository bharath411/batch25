package com.covalant.automation.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.covalant.automation.commons.DataDriver;

public class BaseTestCase {

	
	public static WebDriver driver=null;
	public static String adminUrl = "";
	public static String appUrl = "";
	public String browser="";
	public String user = "";
	public String pass = "";
	public String prodcutName="";
	public String appUser = "";
	public String appPass = "";
	
	public void dataLoad(){
		DataDriver data= new DataDriver();
		adminUrl = data.getProperty("adminurl");
		appUrl = data.getProperty("appurl");
		browser= data.getProperty("browser");
		user = data.getProperty("user");
		pass = data.getProperty("password");
		prodcutName=data.getProperty("prodcutName");
		appUser =data.getProperty("appUser");
		appPass = data.getProperty("appPass");
	}
	@BeforeMethod
	public void init(){
		dataLoad();
		if(browser.equals("firefox")){
			driver  = new FirefoxDriver();
		}else if(browser.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver", "D:\\jars\\selenium-2.53.1\\chromedriver.exe");
			 driver  = new ChromeDriver();
		}else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\jars\\selenium-2.53.1\\IEDriverServer.exe");
			 driver  = new InternetExplorerDriver();
		}
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
