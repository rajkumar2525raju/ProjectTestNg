package org.sample;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Introduction {

	static WebDriver driver;

	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\oficj\\Raj\\TestNg\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test (priority=-45)
	private void testCase1() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
	}

	@Test (priority=-35)
	private void testCase2() throws InterruptedException {
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(5000);
	}

	@Test(priority=-34, dependsOnMethods = { "testCase4" })
	private void testCase3() throws InterruptedException {
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(5000);
	}

	@Test (priority=-25)
	private void testCase4() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
	}

	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	private void endBrowser() {
		driver.quit();
	}

}
