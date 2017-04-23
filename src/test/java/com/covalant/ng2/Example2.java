package com.covalant.ng2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.covalant.automation.commons.ListenerExample;
@Listeners(value={ListenerExample.class,ListenerExample.class})
public class Example2 {

	@BeforeSuite
	public void beforeSUite(){
		System.out.println("BeforeSuite");
	}
	@BeforeClass
	public void init_Sample2(){
		System.out.println("Init_Sample2");
	}
	
	@Test(priority=1)
	public void login_Sample2(){
		System.out.println("This is login_Sample2");
	}
	
	@Test(priority=2 )
	public void verifyProfile_Sample2(){
		System.out.println("This is verifyProfile_Sample2");
	}
	@Test(priority=2)
	public void updateProfile_Sample2(){
		System.out.println("This is updateProfile_Sample2");
	}
	@Test
	public void deleteProfile_Sample2(){
		System.out.println("This is deleteProfile_Sample2");
	}
	@Test(priority=3)
	public void logout_Sample2(){
		System.out.println("This is logout_Sample2");
	}
	
	@AfterClass
	public void tearDown(){
		System.out.println("tearDown");
	}
	
}
