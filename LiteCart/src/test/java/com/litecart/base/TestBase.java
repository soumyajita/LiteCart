package com.litecart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.litecart.utility.LogsUtility;

public class TestBase extends LogsUtility{
	public static WebDriver driver =null;
	Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);
	public WebDriver initialization(String propertyfileName) {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/"+propertyfileName);
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}		
		
		String browserName = prop.getProperty("browser");
		log.info(browserName);

		if (browserName.equals("chrome")) {
			log.info("initializing browser");
			log.warn("chromedriver file should be at specific location");
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			
			log.info("chrome browser opened");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			log.info("initializing browser");
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			log.info("mozilla firefox browser opened");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("IE")) {
			log.info("initializing browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "driver/IEDriverServer.exe");
			log.info("Internet explorer browser opened");
			driver = new InternetExplorerDriver();
		}
		
		log.info("LiteCart Ecommerce application is launched");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("maximizing browser window");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void takeScreenshot() {

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String name = "Demo" + sdf.format(new Date()) + ".png";/// Demo15052021091540.png
		log.info("taking a screenshot");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		log.info("saving a file with name: " + name);
		File dest = new File(System.getProperty("user.dir") + "/screenshot/Demo" + name);
		try {
			log.warn("file location should be proper");
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			log.error("Screenshot is not saved properly");
			
			TestBase.log.error(e.getClass().getName());
		}
	}
}
