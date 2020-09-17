package org.sample;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondClass {
	
	static WebDriver driver;
	
	@BeforeClass (groups="Sanity")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass (groups="Sanity")
	public void exitBrowser() {
		driver.quit();
	}
	
	@BeforeMethod (groups="Sanity")
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterMethod (groups="Sanity")
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void testCase1() {
		System.out.println("s");
	}
	
	@Test (groups="Smoke")
	public void testCase2() {
		driver.get("https://www.google.com/");
	}
	
	@Test (groups="Sanity")
	public void testCase3() {
		driver.get("https://www.facebook.com/");
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("123@gmail.com");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("Pass@word1");
	}
	
	@Test
	public void testCase4() {
		driver.get("http://adactinhotelapp.com/");
		SoftAssert s = new SoftAssert();
		s.assertTrue(driver.getCurrentUrl().equals("45652"));
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("selenium");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("Selenium");
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		s.assertAll();
	}
}
