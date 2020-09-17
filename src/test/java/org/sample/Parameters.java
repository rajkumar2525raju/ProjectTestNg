package org.sample;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Parameters {

	static WebDriver driver;

	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\oficj\\Raj\\TestNg\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	private void exitBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println(d);
	}

	@org.testng.annotations.Parameters({ "username", "password", "location", "Hotel", "Room Type", "Room Numbers",
			"Check In", "Check Out", "Adults" })
	@Test
	private void testCase1(@Optional("username") String user, String pass, String loc, String hot, String type,
			String no, String in, String out, String adult) {
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(user);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(pass);
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		WebElement selLocation = driver.findElement(By.id("location"));
		Select s = new Select(selLocation);
		s.selectByVisibleText(loc);
		WebElement selHotel = driver.findElement(By.id("hotels"));
		new Select(selHotel).selectByVisibleText(hot);
		WebElement selRoom = driver.findElement(By.id("room_type"));
		new Select(selRoom).selectByVisibleText(type);
		WebElement selNo = driver.findElement(By.id("room_nos"));
		new Select(selNo).selectByVisibleText(no);
		WebElement checkIn = driver.findElement(By.id("datepick_in"));
		checkIn.clear();
		checkIn.sendKeys(in);
		WebElement checkOut = driver.findElement(By.id("datepick_out"));
		checkOut.clear();
		checkOut.sendKeys(out);
		WebElement room = driver.findElement(By.id("adult_room"));
		new Select(room).selectByVisibleText(adult);
		WebElement search = driver.findElement(By.id("Submit"));
		search.click();
	}

	@org.testng.annotations.Parameters({ "username" })
	@Test
	private void testCase2(String user) throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys(user);
		Thread.sleep(2000);

	}

	@org.testng.annotations.Parameters({ "username" })
	@Test
	private void testCase3(String user) {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys(user);

	}
}
