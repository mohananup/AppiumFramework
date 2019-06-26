package com.app.testcases;
import org.testng.annotations.BeforeMethod;
import com.app.InfluxDB.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.app.base.TestBase;
import com.app.pages.AppLogin;
import com.app.pages.LaunchScreen;
import com.app.pages.UserSignUp;
import com.app.utils.TestUtils;
//import com.avenstack.extentreports.ExtentITestListenerClassAdapter;

//@Listeners(ExtentITestListenerClassAdapter.class)
@Listeners(ExecutionListener.class)
public class SignInSky extends TestBase{

	AppLogin applogin;
	LaunchScreen launchscreen;
	String sheetName = "SignUp";
	TestUtils testutils;
	UserSignUp usersignup;

	public SignInSky() {

		super();

	}


	@BeforeMethod 
	public void setup(){

		applogin = new AppLogin(TestBase.anddriver);
		launchscreen = new LaunchScreen(TestBase.anddriver);
		testutils=new TestUtils();
		usersignup=new UserSignUp(TestBase.anddriver);


	}
	@DataProvider
	public Object[][] dataSheet() throws Exception {

		Object data[][] = TestUtils.getTableArray(sheetName);
		return data;
	}



	@Test(description = " launch and sign in")
	public void clickSign() {
        TestBase.test = extent.createTest("clickSign");
		launchscreen.clickSignIn();
		applogin.loginToApp();


	}

	@Test(dataProvider = "dataSheet", description = "Signup method")
	public void inputDataToField(String fn, String ln, String eMail, String pwds) {
		TestBase.test = extent.createTest("inputDataToField");
		usersignup.inputfield(fn, ln, eMail, pwds);
		usersignup.acceptsTnC();
		usersignup.clickNext();
	}

	@Test(enabled=false)
	public void nextsteps() {
		



	}



}
