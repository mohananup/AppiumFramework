package com.app.pages;

import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserSignUp extends TestBase{

	private AndroidDriver<AndroidElement> driver;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_first_name")
	MobileElement firstname;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_last_name")
	MobileElement lastname;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_email")
	MobileElement email;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_email_confirmation")
	MobileElement confirmemail;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_password")
	MobileElement pwd;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_password_confirmation")
	MobileElement confirmpwd;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_confirm_terms_switch")
	MobileElement tnc;

	@AndroidFindBy(id="com.bskyb.skyservice:id/signup_confirm_advertising_switch")
	MobileElement privacy;

	@AndroidFindBy(accessibility="Sign into the My Sky app to manage your account and find help articles")
	MobileElement nextBtn;




	public UserSignUp(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void inputfield(String fn, String ln, String eMail, String pwds) {

		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		email.sendKeys(eMail);
		confirmemail.sendKeys(eMail);
		pwd.sendKeys(pwds);
		confirmpwd.sendKeys(pwds);
	}


	public void acceptsTnC() {
    tnc.click();
    privacy.click();
    }
	public void clickNext() {
	    nextBtn.click();
	   
	    
	}
	
	
}


