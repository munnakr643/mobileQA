/**
 * 
 */
package qa.automation.page.screen.manager;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 *
 */
	
public abstract class ScreenManager {


	public ScreenManager(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * 
	 * @return title of the screen
	 */
	protected abstract String getTitle();

}
