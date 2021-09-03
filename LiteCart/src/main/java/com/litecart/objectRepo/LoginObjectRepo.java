package com.litecart.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepo {
	@FindBy(xpath="//img[@title='LITE']")
	public WebElement logo;
	
	@FindBy(xpath="//a[text()=' Sign In ']")
	public WebElement signInButton;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	public WebElement button;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement emailExist;

}
