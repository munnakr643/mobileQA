package qa.automation.page.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AppiumDriver<MobileElement>  driver;

	
	public Utilities(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
	}

	
	public void scrollToText()
	{
	     ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"+text\"));");
	}
	public void scrollToText(String text) {
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		//text(\"India Bangalore\"));"
	}
}
