package com.litecart.utility;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertUtility {
	

	static WebDriver driver;
	private static AlertUtility instance;
	public static AlertUtility getInstance() {
		if(instance == null) {
			instance = new AlertUtility();
		}
		
		return instance;
	}

	public static  void simpleAlertHandle(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
			System.out.println("alert accepted");
		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}
	}

	public  void promptAlertHandle(WebDriver driver,String dataToEnter) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert promptAlert = driver.switchTo().alert();
			String alertText = promptAlert.getText();
			System.out.println("Alert text is " + alertText);
			promptAlert.sendKeys("dataToEnter");
			promptAlert.accept();
			System.out.println("alert accepted");
		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}
	}

	public void confirmationAlertHandle(WebDriver driver) {
		try {
			Alert confirmationAlert = driver.switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);

			confirmationAlert.accept();
			System.out.println("alert accepted");
		} catch (Exception e) {
			System.out.println("unexpected alert not present");
		}
	}
	

	public void alertDismiss() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
}
