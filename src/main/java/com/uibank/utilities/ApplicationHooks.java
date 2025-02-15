package com.uibank.utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uibank.factory.DriverFactory;

import java.time.Duration;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	// controls the flow of execution of the bdd fw
    protected static WebDriverWait wait;

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
	@Before(order = 1)
	public void getProperty() throws IOException{
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order =1)
	public void launchBrowser()throws IOException{
		
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.int_driver(browserName);
		
		 wait = new WebDriverWait(driver, 10);
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@After(order =0)
	public void quitBrowser() throws IOException{
		
		
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException{
		
		if (scenario.isFailed()){
			
			// take screen shot
			
			String screenshotName = scenario.getName().replaceAll("", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			
			
		}
		if (!scenario.isFailed()){
			
			// take screen shot
			
			String screenshotName = scenario.getName().replaceAll("", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			
			
		}
		
		
	}
	
	
	
	
	

	}


