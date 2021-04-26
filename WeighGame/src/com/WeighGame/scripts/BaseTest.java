package com.WeighGame.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod  // before method this method will execute
	public void preCondition()
	{
		String url = "http://ec2-54-208-152-154.compute-1.amazonaws.com/"; // opening a web page
		System.setProperty("webdriver.gecko.driver","/Users/lavu/Desktop/exe/geckodriver"); 
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();  // maximize the screen
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
	}
	@AfterMethod  // after method this method will execute
	public void postCondition()
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.quit();
	}
}
