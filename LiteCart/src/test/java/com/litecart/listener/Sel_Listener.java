package com.litecart.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.litecart.base.TestBase;




public class Sel_Listener implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		 
		TestBase.log.info("ready to accept the alert");
		
	}
	public void afterAlertAccept(WebDriver driver) {
		 
		TestBase.log.info("Accepted the alert");
	}
	public void afterAlertDismiss(WebDriver driver) {
		 
		TestBase.log.info("Rejected the alert");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		 
		TestBase.log.info("ready to dismiss the alert");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		 
		TestBase.log.info("ready to navigate to the url: "+url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {

		TestBase.log.info("Navigated to the url: "+url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		 

		TestBase.log.info("ready to navigate to back");
	}

	public void afterNavigateBack(WebDriver driver) {
		 

		TestBase.log.info("navigated to back");
	}

	public void beforeNavigateForward(WebDriver driver) {
		 
		
	}

	public void afterNavigateForward(WebDriver driver) {
		 
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		 
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		 
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		TestBase.log.info("finding an element with name: "+driver.findElement(by).getText());
		TestBase.log.info(by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		TestBase.log.info("found element with name: "+driver.findElement(by).getText());
		TestBase.log.info(by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		TestBase.log.info("clicking on an element with name: "+element.getText());
		
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
	 //TestBase.log.info("clicked on an element with name: "+element.getText());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		 
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		 
		
	}

	public void beforeScript(String script, WebDriver driver) {
		 
		
	}

	public void afterScript(String script, WebDriver driver) {
		 
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		 
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		 
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		 System.out.println("Encounter an exception" +throwable.getMessage());
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		 
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		 
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		 
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		 
		
	}

}
