package com.WeighGame.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfWeighResults {
	@FindBy(xpath = "//li[contains(text(),'')]")  // @FindBy is used in Page Objects to specify the object location
	private List<WebElement> selectWeighings;
	
	public ListOfWeighResults(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public List<String> listOfWeighings()
	{
		List<String> listWeigh = new ArrayList<String>(); //creating arraylist to add results from weighing section
		for(int j=0;j<selectWeighings.size();j++)
		{
			listWeigh.add(selectWeighings.get(j).getText());
		}
		return listWeigh;   //returning list
	}
}
