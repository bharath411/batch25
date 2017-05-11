package com.covalant.cal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.covalant.calc.Calculator;

public class TestCalculator {

	
	@Test
	public void testAddPositive(){
		
		int a = 23;
		int b = 60;
		
		int expected  =80;
		
		Calculator cal = new Calculator();
		int actual  = cal.add(a,b);
		
		Assert.assertEquals(actual,expected);
	}
}
