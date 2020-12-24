package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class AllAppList extends ScreenManager {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public AllAppList(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Amazon']")
	public MobileElement Amazon;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Maps']")
	public MobileElement Maps;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Settings']")
	public MobileElement Settings;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Aarogya Setu']")
	public MobileElement Aarogya_Setu;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Calendar']")
	public MobileElement Calendar;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Clock']")
	public MobileElement Clock;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Contacts']")
	public MobileElement Contacts;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Netflix']")
	public MobileElement Netflix;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='Phone']")
	public MobileElement Phone;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'handle_container')]")
	public MobileElement Handle_container;
	
}
