package qa.automation.page.tests.tcases;

import org.testng.annotations.Test;

import qa.automation.page.tests.base.BaseTest;

public class HomePageTc extends BaseTest {

	
	@Test(priority = 1,groups = { "regression" })
	public  void verifyHomePage() {
		openAllApp();
		launchAmazonApp();
		isHomePageDisplayed();
		homeBtn();

	}
}
