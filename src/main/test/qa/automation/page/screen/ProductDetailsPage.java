package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;

public class ProductDetailsPage  extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProductDetailsPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.view.View[contains(@resource-id,'atfRedesign_priceblock_priceToPay')]/android.widget.EditText")
	public MobileElement PriceOnProductage;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@resource-id,'title_feature_div')]/android.view.View")
	public MobileElement ProductNameOnProductpage;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Cart']")
	public MobileElement CartOnProdctpage;
}
