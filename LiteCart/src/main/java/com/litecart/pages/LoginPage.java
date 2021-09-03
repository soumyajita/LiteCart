package com.litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.litecart.objectRepo.LoginObjectRepo;
import com.litecart.utility.ActionUtility;


public class LoginPage extends LoginObjectRepo{
	public WebDriver driver = null;
	ActionUtility actionUtility = ActionUtility.getInstance();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyLogoDisplay() {
		if (logo != null) {
			System.out.println("Image is diasplayed");
			return true;
		} else
			return false;
	}
	public boolean verifySignIn() {
		actionUtility.click(signInButton);
		actionUtility.sendkeys(email, "testuser@gmail.com");
		actionUtility.sendkeys(password, "12345");
		actionUtility.click(button);
		String actual = actionUtility.getTitle(driver);
	
		System.out.println("actual--" +actual);
		String expected = "Sign In | LITE";
		if (actual.equals(expected))
			return true;
		else
			return false;
	}
}
