package com.covalant.ng2;

import org.testng.annotations.Test;

public class GEx1 {

	
	@Test(groups={"regression"})
	public void test1(){
		System.out.println("Test1");
	}
	@Test(groups={"smoke"})
	public void test2(){
		System.out.println("Test2");
	}
	@Test(groups={"regression"})
	public void test3(){
		System.out.println("Test3");
	}
	@Test(groups={"regression" , "smoke"})
	public void test4(){
		System.out.println("Test4");
	}
	@Test(groups={"smoke"})
	public void test5(){
		System.out.println("Test5");
	}
	@Test(groups={"sanity"})
	public void test6(){
		System.out.println("Test6");
	}
	@Test(groups={"regression","sanity"})
	public void test7(){
		System.out.println("Test7");
	}
	@Test(groups={"sanity","smoke"})
	public void test8(){
		System.out.println("Test8");
	}
	
}
