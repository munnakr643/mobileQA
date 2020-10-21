package qa.automation.page.screen;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class FormPage extends ScreenManager {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public FormPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}



	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;


	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;


}
