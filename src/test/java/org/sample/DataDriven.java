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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {

	static WebDriver driver;

	@BeforeClass (groups = "Regression")
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\oficj\\Raj\\TestNg\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass (groups = "Regression")
	private void exitBrowser() {
		driver.quit();
	}

	@BeforeMethod (groups = "Regression")
	private void startTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod (groups = "Regression")
	private void endTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test (dataProvider = "products", groups = "Regression")
	private void testCase1(String productName) {
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebElement txtSearch = driver.findElement(By.id("inputValEnter"));
		txtSearch.sendKeys(productName);
		WebElement search = driver.findElement(By.xpath("//span[text()='Search']"));
		search.click();
	}

	@DataProvider(name = "products")
	public Object[][] data() {
		
		return new Object[][] {
			
			{"iphone 7"}, {"iphone 8"}, {"Onplus 7t"}, {"iphone 11"}, {"Hp Laptop"}
			
		};
	}
}
