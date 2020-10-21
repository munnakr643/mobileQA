package qa.automation.page.tests.tcases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import qa.automation.page.tests.base.BaseTest;

public class LoginPageTc extends BaseTest{
	
	
	@Test
	public void loginWithValidCredentials()  {
	isLoginPageDisplayed();
	clickLoginExistingUser();
	enterUserId("6367357113");
	clickOnContinueBtn();
	enterPassword("Pass@123");
	clickOnLoginBtn();
	
	}

}
