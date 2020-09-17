package org.sample;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {
	
	static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void exitBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterMethod
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void testCase1() {
		driver.get("http://adactinhotelapp.com/");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void testCase2() {
		driver.get("https://www.facebook.com/");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void testCase3() {
		driver.get("https://www.snapdeal.com/");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void testCase4() {
		driver.get("https://www.flipkart.com/");
		System.out.println(Thread.currentThread().getId());
	}
}