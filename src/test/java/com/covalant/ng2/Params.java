package com.covalant.ng2;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {

	
	@Test
	@Parameters(value={"bro" , "url"})
	public void init(@Optional("ie")String browser, String url){
		System.out.println(browser);
		System.out.println(url);
	}
}
