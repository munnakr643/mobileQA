package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class UserProfilePage extends ScreenManager {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfilePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id,'rs_results_styled_price_v2')])[3]/android.widget.TextView")
	public MobileElement Price;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'item_title')])[3]")
	public MobileElement ProductName;

}
