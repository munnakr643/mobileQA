package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class LoginPage extends ScreenManager {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}

	@AndroidFindBy(xpath="//android.widget.EditText[@text='E.g.9876543210']")
	public MobileElement enterMobileNum;

	@AndroidFindBy(xpath="//android.widget.CheckBox[contains(@resource-id,'checkbox')]")
	public MobileElement clickOnCheckbox;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed']")
	public MobileElement proceedBtn;

	@AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'etOTP')]")
	public MobileElement EnterOtp;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Verify OTP']")
	public MobileElement verifyOtp;
}
