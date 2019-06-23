package com.app.utils;


import static java.lang.String.format;

import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import io.appium.java_client.events.api.general.AlertEventListener;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.TestListenerAdapter;

public class AppiumListener extends TestListenerAdapter implements AppiumWebDriverEventListener, WebDriverEventListener, AlertEventListener {

     
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to accept alert");
    }

     
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("WebDriverEventListener: The alert was accepted");
    }

     
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to dismiss alert");
    }

     
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("WebDriverEventListener: The alert was dismissed");
    }

      public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to navigate to " + url);
    }

      public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("WebDriverEventListener: Navigation to " + url + " was successful");
    }

      public void beforeNavigateBack(WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to navigate back");
    }

      public void afterNavigateBack(WebDriver driver) {
        System.out.println("WebDriverEventListener: Navigation back was successful");
    }

      public void beforeNavigateForward(WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to navigate forward");
    }

      public void afterNavigateForward(WebDriver driver) {
        System.out.println("WebDriverEventListener: Navigation forward was successful");
    }

      public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to refresh");
    }

      public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("WebDriverEventListener: The refreshing was successful");
    }

      public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to find something using " + by.toString()
            + ". The root element is "
            + String.valueOf(element));
    }

      public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: The searching for something using "
            + by.toString() + " has beed finished. "
            + "The root element was "
            + String.valueOf(element));
    }

      public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to click on the element");
    }

      public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: Thee element was clicked");
    }

      public void beforeChangeValueOf(WebElement element, WebDriver driver,
        CharSequence[] keysToSend) {
        System.out.println("WebDriverEventListener: Attempt to click on the element");
    }

      public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to change value of the element");
    }

      public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: The value of the element was changed");
    }

      public void afterChangeValueOf(WebElement element, WebDriver driver,
        CharSequence[] keysToSend) {
        System.out.println("WebDriverEventListener: Thee element was clicked");
    }

      public void beforeScript(String script, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to perform java script: " + script);
    }

      public void afterScript(String script, WebDriver driver) {
        System.out.println("WebDriverEventListener: Java script " + script + " was performed");
    }

      public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("WebDriverEventListener: The exception was thrown: " + throwable.getClass());
    }

     
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        System.out.println(format("WebDriverEventListener: Attempt to take screen shot. Target type is %s", target));
    }

     
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        System.out.println(format("WebDriverEventListener: Screen shot was taken successfully. "
                        + "Target type is %s, result is %s", target, screenshot));
    }

      public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("WebDriverEventListener: Attempt to get text of the element");
    }

      public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("WebDriverEventListener: Got the text of an element");
    }

     
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println(format("WebDriverEventListener: Attempt to switch to window %s", windowName));
    }

     
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println(format("WebDriverEventListener: driver is switched to window %s", windowName));
    }


	public void beforeAlertAccept(WebDriver driver, Alert alert) {
		// TODO Auto-generated method stub
		
	}


	public void afterAlertAccept(WebDriver driver, Alert alert) {
		// TODO Auto-generated method stub
		
	}


	public void afterAlertDismiss(WebDriver driver, Alert alert) {
		// TODO Auto-generated method stub
		
	}


	public void beforeAlertDismiss(WebDriver driver, Alert alert) {
		// TODO Auto-generated method stub
		
	}


	public void beforeAlertSendKeys(WebDriver driver, Alert alert, String keys) {
		// TODO Auto-generated method stub
		
	}


	public void afterAlertSendKeys(WebDriver driver, Alert alert, String keys) {
		// TODO Auto-generated method stub
		
	}
}

