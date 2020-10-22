package qa.automation.page.tests.tcases;

import org.testng.annotations.Test;

import qa.automation.page.tests.base.BaseTest;

public class LoginPageTc extends BaseTest{
	
	
	@Test(priority = -1,groups = { "regression" })
	public void loginWithValidCredentials()  {
	openAllApp();
	launchAmazonApp();
	isHomePageDisplayed();
	clcickOnHamburgerMenu();
	clcickforLogin();
	enterUserId("6367357113");
	clickOnContinueBtn();
	enterPassword("Pass@123");
	clickOnLoginBtn();
	
	}

}
