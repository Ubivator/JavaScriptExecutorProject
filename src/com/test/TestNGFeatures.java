package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test
	public void loginTest() {
		System.out.println("LoginTest");
		//int i = 9/0;  --try to see what happens; loginTest will be failed, homeTest will be skipped
	}
	
	@Test(dependsOnMethods="loginTest") //HOMETEST METHOD WILL NOT BE EXECUTED IF LOGINtEST FAILS
	public void homeTest() {
		System.out.println("HomeTest");
	}
	
	@Test(dependsOnMethods="loginTest") //HOMETEST METHOD WILL NOT BE EXECUTED IF LOGINtEST FAILS
	public void regPageTest() {
		System.out.println("Registration Page Test");
	}
	
}
