package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "c:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        
	}
	
	@Test (priority=1, groups="Title")
	public void googleTitleTest() {
		
		String title = driver.getTitle();
		
		System.out.println(title);
		assertEquals(title, "Google", "Title is not matched");
	}
	
	@Test(priority=2, groups="Title")
	public void googleLogoTest() {
    boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
    assertTrue(b);
    //asserEquals(b, true); //you can also write this way
    
	}
	@Test (priority=3, groups="Links")
	public void mailLinkTest() {
		boolean d = driver.findElement(By.linkText("Gmail")).isDisplayed();
		assertTrue(d);
	}
	
	@Test (priority=4, groups="Tests")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test (priority=5, groups="Tests")
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test (priority=6, groups="Tests")
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
}
