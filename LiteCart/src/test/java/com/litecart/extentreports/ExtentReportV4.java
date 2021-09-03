package com.litecart.extentreports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.litecart.base.TestBase;



public class ExtentReportV4 extends TestBase {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void extentReportSetup() {
		// location of the extent report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReportF/ExtentReport.html");
		extent = new ExtentReports(); // create object of ExtentReports
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);// Default Theme of Report

		// General information releated to application
		extent.setSystemInfo("Application Name", "ThirtyBee_Automation");
		extent.setSystemInfo("Envirnoment", "Automation testing");
		extent.setSystemInfo("User Name", "Soumya");
		
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	/*@BeforeMethod
	public void setup() {
		try {
			driver = initialization("config.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();

	}*/

	public static void passTest(String testName) {
		test = extent.createTest(testName);
	}

	public void failTest(String testName) {
		test = extent.createTest(testName);
	}

	public void skipTest(String testName) {
		test = extent.createTest(testName);
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.

			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = TakeScreenshot(driver, result.getName());
			// To add it in the extent report

			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			// logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
