package com.litecart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.litecart.extentreports.ExtentReportV4;
import com.litecart.pages.LoginPage;


public class LoginTest extends ExtentReportV4  {
	LoginPage hp = null;

	@BeforeMethod
	public void setUp() {
		driver = initialization("config.properties");
		hp = new LoginPage(driver);
	}
	@Test
	public void verifyLogo() {
		//passTest("--verifyLogoDisplay--");
		testLogs().info("Logo is displayed..");
		Assert.assertTrue(hp.verifyLogoDisplay(), "image is displayed as expected");
	}
	@Test
	public void validateSignIn() {
	
		testLogs().info("display title..");
		Assert.assertTrue(hp.verifySignIn());
	}



}
