package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;



public class NavBar extends ScreenManager {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public NavBar(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}


	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Navigation panel, button, double tap to open side panel']")
	public MobileElement HamburgerMenuBtn;

	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Home']")
	public MobileElement AmazonLogo;

	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Cart']")
	public MobileElement CartLogo;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'gno_greeting_text_view')]")
	public MobileElement HelloUser;

}
