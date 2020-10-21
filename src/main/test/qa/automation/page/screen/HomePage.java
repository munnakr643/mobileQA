package qa.automation.page.screen;

import org.openqa.selenium.WebElement;

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
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public MobileElement Preferences;	
	
	
	
}
