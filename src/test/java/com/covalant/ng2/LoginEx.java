package com.covalant.ng2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginEx {

	
	//@Test
	@Parameters(value={"user","pass"})
	public void login1(String user , String pass){
		System.out.println(user + "  " + pass);
	}
	
	@Test(dataProvider="log")
	public void login2(String user , String pass){
		if(user.contains("raju")){
			Assert.fail();
		}
		System.out.println(user + "  " + pass);
	}
	
	
	@DataProvider(name="log")
	public Object[][] dataP(){
		
		Object[][] obj = {   {"bharath","bharath123"} ,{"nagesh","nagesh123"} ,
								{"raju","raju123"} ,{"sathish" , "sathish123"}  };
		return obj;
	}
	
	@Test(dataProvider="log_ex")
	public void login3(String user , String pass){
		if(user.contains("raju")){
			Assert.fail();
		}
		System.out.println(user + "  " + pass);
	}
	
	
	@DataProvider(name="log_ex")
	public Object[][] dataPex(){
		ExcelReaderDp dp = new ExcelReaderDp();
		Object[][] obj = dp.getData();
		return obj;
	}
}
