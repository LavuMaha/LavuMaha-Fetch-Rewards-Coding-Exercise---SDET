package com.WeighGame.scripts;

import org.testng.annotations.Test;

public class ExecutingScripts extends BaseTest { //extends BaseTest
	@Test //Test annotations
	public void testValues()
	{
		WeighScript ws = new WeighScript(); //instantiating weighScript
		ws.passValues(driver);
	}
}
