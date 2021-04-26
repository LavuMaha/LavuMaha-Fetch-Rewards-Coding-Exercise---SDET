package com.WeighGame.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeighResetButton {
	@FindBy(id = "weigh")
	private WebElement weighButton;
	
	@FindBy(id = "reset")
	private WebElement sign;
	
	public WeighResetButton(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String weighBut()
	{
		weighButton.click();    // to check weight
		return sign.getText();	  // returning operator
	}
}
