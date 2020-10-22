package qa.automation.page.screen;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import qa.automation.page.screen.manager.ScreenManager;

public class Preferences extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Preferences(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text='Login. Already a customer?']")
	public MobileElement AlreadyCustrText;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'ap_email_login')]")
	public MobileElement EnterUserId;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'continue')]")
	public MobileElement ContinueBtn;
	
	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'ap_password')]")
	public MobileElement EnterPsw;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'signInSubmit')]")
	public MobileElement LoginBtn;
	
	
}
