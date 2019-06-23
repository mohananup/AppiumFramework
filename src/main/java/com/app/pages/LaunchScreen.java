package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchScreen extends TestBase{
	private AndroidDriver<AndroidElement> driver;
	
	@FindBy(id="Sign into the My Sky app to manage your account and find help articles")
	WebElement signIn;
	
	@AndroidFindBy(id="com.bskyb.skyservice:id/button")
	MobileElement cont;
	
	
	
public LaunchScreen(AndroidDriver<AndroidElement> driver) {
	this.driver = driver;
	
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
public void clickSignIn() {
	
	cont.click();
	cont.click();
	signIn.click();
	
}



}
