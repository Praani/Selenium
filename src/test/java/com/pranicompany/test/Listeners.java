package com.pranicompany.test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase is PASSED :" + result.getName() );
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase is FAILED :" + result.getName() );
	}
}
