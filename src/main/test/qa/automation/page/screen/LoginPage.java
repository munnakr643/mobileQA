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
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Already a customer? Sign in']")
	public MobileElement SignInBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sign in to your account']")
	public MobileElement SignInUrAccText;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Skip sign in]")
	public MobileElement SkipSignIn;
	
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
