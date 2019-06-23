package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLogin extends TestBase{

	private AndroidDriver<AndroidElement> driver;


	@AndroidFindBy(accessibility="Email address or username")
	MobileElement un;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signin_password_textview")
	MobileElement pwd;


	@AndroidFindBy(accessibility="Sign into the My Sky app to manage your account and find help articles")
	MobileElement signInButton;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_button") 
	MobileElement signUpButton;

	public AppLogin(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void loginToApp() {

		un.sendKeys("anupmohan");
		pwd.sendKeys("anupmohan");
		signInButton.click();
		signUpButton.click();

	}











}