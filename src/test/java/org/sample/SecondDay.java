package org.sample;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondDay {
	
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
	
	@Test(priority=-1, invocationCount=3)
	public void testCase1() {
		driver.get("http://adactinhotelapp.com/");
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("seleniumaccounttest");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("Selenium123");
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	
	@Test(enabled=false)
	public void testCase2() {
		driver.get("http://adactinhotelapp.com/");
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("selenium");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("Selenium123");
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	
	@Test(priority=-45)
	public void testCase3() {
		driver.get("http://adactinhotelapp.com/");
		Assert.assertTrue(driver.getCurrentUrl().equals("http://ada/"));
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("seleniumaccounttest");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("Selenium");
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
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
