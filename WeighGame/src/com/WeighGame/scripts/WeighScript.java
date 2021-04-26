package com.WeighGame.scripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.WeighGame.pom.FakeBarValue;
import com.WeighGame.pom.ListOfWeighResults;

public class WeighScript {
	public void passValues(WebDriver driver) 
	{
		List<Integer> list = new ArrayList<Integer>(); //Creating ArrayList to add bar values
		int start = 0;
		int end = 9;
		for(int i=start;i<end;i++)
		{
			list.add(i);      //adding values
		}
		FakeBarValue fBar = new FakeBarValue(driver,list); //instantiating FakeBar model
		String msg = fBar.fakeBar();
		System.out.println(msg);  // printing alert message
		
		ListOfWeighResults lResult = new ListOfWeighResults(driver);
		List<String> outputList = lResult.listOfWeighings();
		System.out.println("The Number Of Weighing is "+outputList.size());
		System.out.println(outputList);  // output list of weighing results
	}
}
