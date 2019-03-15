package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
    
	//prerequisites (pre-condition) annotations start from @Before
	@BeforeSuite
	public void setUp() {
		System.out.println("BeforeSuite----Set up system properties for Chrome");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("BeforeTest---Launch Chrome browser");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("BeforeClass----Login");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("BeforeMethod----Enter URL");
	}
	
	//Test Cases start from Test
	@Test
	public void googleTitleTest() {
		System.out.println("Test----Google Title Test");
	}
	@Test
	public void searchTest() {
		System.out.println("Test----Search Test");
	}
	
	@Test
	public void googleLogouTest() {
		System.out.println("Test----Google Logout Test");
	}
	//Post-conditions start from @After
	@AfterMethod
	public void logOut() {
		System.out.println("AfterMethod----Logout from app");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("AfterTest-----Delete all cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AfterClass----Close Browser");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("AfterSuite----Generate Test Report");
	}
}
//here is the sequence, hierarchy

//BeforeSuite----Set up system properties for Chrome
//BeforeTest---Launch Chrome browser
//BeforeClass----Login
//BeforeMethod----Enter URL
//Test----Google Logout Test
//AfterMethod----Logout from app
//BeforeMethod----Enter URL
//Test----Google Title Test
//AfterMethod----Logout from app
//BeforeMethod----Enter URL
//Test----Search Test
//AfterMethod----Logout from app
//AfterClass----Close Browser
//AfterTest-----Delete all cookies
