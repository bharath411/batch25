package com.covalant.ng2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Example1 {

	@BeforeClass
	public void init(){
		System.out.println("Init");
	}
	
	@Test(priority=1)
	public void login(){
		System.out.println("This is login");
	}
	
	@Test(priority=2)
	public void verifyProfile(){
		System.out.println("This is verifyProfile");
	}
	@Test(priority=2)
	public void updateProfile(){
		System.out.println("This is updateProfile");
	}
	@Test(priority=2)
	public void deleteProfile(){
		System.out.println("This is deleteProfile");
	}
	@Test(priority=3)
	public void logout(){
		System.out.println("This is logout");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
		
	}
	@AfterClass
	public void tearDown(){
		System.out.println("tearDown");
	}
	
}
