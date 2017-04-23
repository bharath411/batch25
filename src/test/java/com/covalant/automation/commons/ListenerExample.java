package com.covalant.automation.commons;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExample  implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Finished execution.....");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Before Starting");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
	System.out.println("I am failure test " + arg0.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Staring a test " +  arg0.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Success --  " +  arg0.getMethod().getMethodName());
		
	}

	
	
	
}
