package com.WeighGame.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FakeBarValue {
	
	@FindBy(xpath = "//button[contains(@id,'coin_')]")  // @FindBy is used in Page Objects to specify the object location
	private List<WebElement> fbar;
	
	WebDriver driver;
	Alert alert;
	WeighPage wPage;
	
	public FakeBarValue(WebDriver driver,List<Integer> list) //using constructor getting values
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);  // to initialize web elements
		wPage = new WeighPage(driver,list);
	}
	
	public String fakeBar()
	{
		boolean isValid = wPage.validate(); // calling method from weighPage and getting value
		String alertMsg = "";
		if(isValid == true)
		{
			for(int i=0;i<fbar.size();i++)  // looping values to click fake bar
			{
				if((fbar.get(i).getText()).equals(String.valueOf(wPage.fakeBarVal)))
				{
					fbar.get(i).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					}
					alert = driver.switchTo().alert();  //using alert class to get alert message
					alertMsg = alert.getText();
					alert.accept();	
				}
			}
		}
		return alertMsg; // returning alert message
	}
	

}
