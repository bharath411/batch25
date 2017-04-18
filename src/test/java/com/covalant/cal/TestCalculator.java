package com.covalant.cal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.covalant.calc.Calculator;

public class TestCalculator {

	
	@Test
	public void testAddPositive(){
		
		int a = 20;
		int b = 40;
		
		int expected  =60;
		
		Calculator cal = new Calculator();
		int actual  = cal.add(a,b);
		
		Assert.assertEquals(actual,expected);
	}
}
