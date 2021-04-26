package com.WeighGame.pom;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeighPage {
	
	@FindBy(id = "left_0")                 // @FindBy is used in Page Objects to specify the object location
	private WebElement firstElementLeft;    
	
	@FindBy(id = "left_1")
	private WebElement secondElementLeft;
	
	@FindBy(id = "left_2")
	private WebElement thirdElementLeft;
	
	@FindBy(id = "right_0")
	private WebElement firstElementRight;
	
	@FindBy(id = "right_1")
	private WebElement secondElementRight;
	
	@FindBy(id = "right_2")
	private WebElement thirdElementRight;
	
	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	private WebElement resetButton;
	
	List<Integer> list;
	WebDriver driver;
	int fakeBarVal = 0;
	int checkSize = 9;
	int firstStep = 6;
	int secondStep = 2;
	WeighResetButton wrButton;
	
	public WeighPage(WebDriver driver,List<Integer> list)  //using constructor getting values
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.list = list;
		wrButton = new WeighResetButton(driver);
	}
	
	public int bowl()
	{
		if(list.size() == checkSize)
		{
			// passing 3 values to left bowl and 3 values to right bowl
			// inspecting elements to the particular square box 
			
			firstElementLeft.sendKeys(String.valueOf(list.get(0)));   
			secondElementLeft.sendKeys(String.valueOf(list.get(1)));   // passing values to left and right bowls 
			thirdElementLeft.sendKeys(String.valueOf(list.get(2)));
			firstElementRight.sendKeys(String.valueOf(list.get(3)));
			secondElementRight.sendKeys(String.valueOf(list.get(4)));
			thirdElementRight.sendKeys(String.valueOf(list.get(5)));
			return firstStep;
		}
		else
		{
			firstElementLeft.sendKeys(String.valueOf(list.get(0)));
			firstElementRight.sendKeys(String.valueOf(list.get(1)));  // if the values less than size pass only two values
			return secondStep;
		}
	}
	
	public boolean validate()
	{
		
		int count = bowl();
		String operator = wrButton.weighBut();  // getting values from the result
		if(operator.equals("="))				// checking particular operators 
		{
			list.subList(0,count).clear();
			if(list.size() == 1)
			{
				fakeBarVal = list.get(0);
				return true;
			}
			resetButton.click();
			if(validate())
			{
				return true;
			}
		}
		else if(operator.equals(">"))
		{
			if(list.size() < checkSize)
			{
				fakeBarVal=list.get(1);
				return true;
			}
			list.subList(0,3).clear();
			resetButton.click();
			if(validate())
			{
				return true;
			}
		}
		else
		{
			if(list.size() < checkSize)
			{
				fakeBarVal = list.get(0);
				return true;
			}
			list.subList(3,list.size()).clear();
			resetButton.click();
			if(validate())
			{
				return true;
			}
		}
		return false;
	}
	
	
	
}