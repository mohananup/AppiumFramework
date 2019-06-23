package com.app.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.events.EventFiringObjectFactory.getEventFiringObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.app.utils.AppiumListener;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static AndroidDriver<AndroidElement> anddriver;
	public static IOSDriver<IOSElement> iosdriver;
	public static Properties prop;
	public static Properties andprop;
	public static Properties iosprop;
	public static DesiredCapabilities caps;
	public static WebDriverWait wait;
	
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest test;
	

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Applications/workspace/Framework/src/main/java/com/app" + "/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {

			andprop = new Properties();
			FileInputStream andip = new FileInputStream("/Applications/workspace/Framework/src/main/java/com/app" + "/android/android.properties");
			andprop.load(andip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {

			iosprop = new Properties();
			FileInputStream iosip = new FileInputStream("/Applications/workspace/Framework/src/main/java/com/app" + "/ios/ios.properties");
			iosprop.load(iosip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@BeforeTest
	public static void initialization() throws MalformedURLException, InterruptedException {
		
		caps = new DesiredCapabilities();
		
		String platformName= prop.getProperty("platform");
		
		try {
		
		
		if(platformName.equalsIgnoreCase("android")){
			System.out.println("devicename ===              "+ andprop.getProperty("platformName"));
		     
		
		    String deviceName = andprop.getProperty("deviceName");
		    		String appActivity = andprop.getProperty("appActivity");
		    		String appPackage = andprop.getProperty("appPackage");
		    		
			caps.setCapability("platformName", platformName);
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("appActivity", appActivity);
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			
			URL url = new URL(prop.getProperty("appiumserver"));
			anddriver = new AndroidDriver<AndroidElement>(url, caps);
			// anddriver = EventFiringWebDriverFactory.getEventFiringWebDriver(anddriver, new AppiumListener());
            
			
		}
		if(platformName.equalsIgnoreCase("iOS")){
			caps.setCapability("platformName", iosprop.getProperty("platform"));
			caps.setCapability("Version", iosprop.getProperty("version"));
			caps.setCapability("device", iosprop.getProperty("deviceName"));
		}
		
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  // Passing General information
		  extent.setSystemInfo("Host name", "localhost");
		  extent.setSystemInfo("Environemnt", "QA");
		  extent.setSystemInfo("user", "anup");
		
		
		
	}catch(IOException e)
		{
		e.printStackTrace();
		System.out.println("cause =" + e.getCause());
		System.out.println("message=" + e.getMessage());
		}
	
	
		anddriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(anddriver, 20);
	
	
	}
	@AfterTest
	public static void teardown() {
		
		//anddriver.close();
		extent.flush();
		anddriver.closeApp();
		anddriver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}