package com.litecart.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogsUtility{
	
	public Logger pageLogs() {
		
		String path =(System.getProperty("user.dir")+"/src/main/resources/log4jPage.properties");
		PropertyConfigurator.configure(path);
		Logger logger = Logger.getLogger(this.getClass());
		return logger;
	}
	public  Logger testLogs() {
		
		String path =(System.getProperty("user.dir")+"/src/main/resources/log4jTest.properties");
		PropertyConfigurator.configure(path);
		Logger logger = Logger.getLogger(this.getClass());
		return logger;
	}
}
