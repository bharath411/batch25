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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OpenCart {

	@Test
	public void dropdownDisplay() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://127.0.0.1/opencart/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		Select selCountry = new Select(driver.findElement(By.id("input-country")));
		// Select selState =new Select(driver.findElement(By.id("input-zone")));

		List<WebElement> countryList = selCountry.getOptions();
		int countrySize = countryList.size();
		System.out.println(countrySize);

		for (int i = 1; i < countrySize; i++) {

			selCountry.selectByIndex(i);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
}
