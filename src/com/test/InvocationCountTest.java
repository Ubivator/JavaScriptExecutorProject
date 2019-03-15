package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	/*@Test(invocationCount = 5) // this method will execute test cases given amount of times
	public void sum() {
		int a = 4;
		int b = 8;
		int c = a + b;
		System.out.println("Sum is = " + c);
	}
    */
	/*@Test(invocationTimeOut=2, expectedExceptions = NumberFormatException.class)
	public void infiniteLoop() {
		int i = 1;
		while (i == 1) { // we are not increasing the value of i, so we're creating infinite loop; TCs
							// will be run forever
			System.out.println(i);
		}
	}
   */
	@Test (expectedExceptions = NumberFormatException.class)
	public void number() {
		String x = "100A";
		Integer.parseInt(x);
		}
}
