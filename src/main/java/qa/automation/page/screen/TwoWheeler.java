package qa.automation.page.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import qa.automation.page.screen.manager.ScreenManager;

public class TwoWheeler extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TwoWheeler(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	
	@AndroidFindBy(xpath = "cash.one")
	private MobileElement cashOne;
	
	@AndroidFindBy(xpath = "cash.two")
	private MobileElement cashTwo;
	
	@AndroidFindBy(xpath = "cash.three")
	private MobileElement cashThree;
	
}
