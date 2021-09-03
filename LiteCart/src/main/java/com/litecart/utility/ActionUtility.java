package com.litecart.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionUtility extends LogsUtility{
	static WebDriver driver;
	
	private static ActionUtility singleInstance =null;
	public static ActionUtility getInstance() {
		if(singleInstance == null) {
			singleInstance = new ActionUtility();
		}
		
		return singleInstance;
	}

	public  String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public  void getTextMsg(WebElement element) {
		String msg = element.getText();
		pageLogs().info("msg" +msg);
		
	}

	public void sendkeys(WebElement element, String datatoEnter) {
		element.sendKeys(datatoEnter);
	}

	public  void click(WebElement element) {
		element.click();
	}

	public  void clear(WebElement button) {
		button.clear();
	}

}
