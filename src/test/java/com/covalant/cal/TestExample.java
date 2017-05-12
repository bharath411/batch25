package com.covalant.cal;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExample {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("I am before bhargavi Class");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("I am after Class");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I am before Method");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am After Method");
	}
	@Test
	public void test1(){
		System.out.println("I am test1");
	}
	
	@Test
	public void test2(){
		System.out.println("I am test2");
	}
	
	
	@Test
	public void test3(){
		System.out.println("I am test3");
	}

}
