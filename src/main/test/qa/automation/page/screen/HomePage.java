package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;


public class HomePage extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HomePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Mobiles']")
	public MobileElement Mobiles;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Electronics']")
	public MobileElement Electronics;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Home']")
	public MobileElement Home;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Mobiles']")
	public MobileElement Appliances;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Fashion']")
	public MobileElement Fashion;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Select delivery location']")
	public MobileElement SelectLocation;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	public MobileElement Search;
}
