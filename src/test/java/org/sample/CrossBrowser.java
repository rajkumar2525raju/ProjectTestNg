package org.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

	static WebDriver driver;

	@Parameters({ "browser" })
	@Test
	public void testCase1(String launcherName) {

		if (launcherName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\oficj\\Raj\\TestNg\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (launcherName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\oficj\\Raj\\TestNg\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://adactinhotelapp.com/");
		System.out.println(Thread.currentThread().getId());
		driver.quit();
	}
}
