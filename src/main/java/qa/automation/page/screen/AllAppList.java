package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class AllAppList extends ScreenManager{@Override
protected String getTitle() {
	// TODO Auto-generated method stub
	return null;
}

	public AllAppList(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}


	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Phone']")
	public MobileElement Phone;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'handle_container')]")
	public MobileElement Handle_container;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Ice Insurance']")
	public MobileElement Ice_Insurance;
}
