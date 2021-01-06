package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class QuotePage extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public QuotePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}

	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Cart']")
	public MobileElement CartOnProdctpage;
}
