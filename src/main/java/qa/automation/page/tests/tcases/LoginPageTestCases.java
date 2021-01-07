package qa.automation.page.tests.tcases;

import org.testng.annotations.Test;
import qa.automation.page.tests.base.BaseTest;

public class LoginPageTestCases extends BaseTest{


	@Test(priority = 0,groups = { "regression" })
	public void verifyLogin() {
		openAllApp();
		searchApp("Ice Insurance");
		launchIceApp();
		selectCheckbox();
		clickOnContinueBtn();
		enterLoginId("9875553434");
		clickOnProceed();
		enterOtp("123456");
		isIceHomePageDisplayed();
		clickHomeBtn();
	}

}
