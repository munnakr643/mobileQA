package qa.automation.page.tests.base;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import qa.automation.page.screen.AllAppList;
import qa.automation.page.screen.CheckoutPage;
import qa.automation.page.screen.HomePage;
import qa.automation.page.screen.ListingPage;
import qa.automation.page.screen.LoginPage;
import qa.automation.page.screen.NavBar;
import qa.automation.page.screen.ProductDetailsPage;

public class BaseTest {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement>  driver;

	protected static CheckoutPage checkoutPage;
	protected static HomePage homePage;
	protected static LoginPage loginPage;
	protected static AllAppList allAppList;
	protected static NavBar navBar;
	protected static ListingPage listingPage;
	protected static ProductDetailsPage productDetailsPage;
	
	
	
	public AppiumDriverLocalService startServer()
	{
		//
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{

			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	@BeforeClass(alwaysRun = true)
	public void intializeClass() throws IOException, InterruptedException {
		capabilities();
		checkoutPage = new CheckoutPage(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		allAppList = new AllAppList(driver);
		navBar=new NavBar(driver);
		listingPage=new ListingPage(driver);
		productDetailsPage=new ProductDetailsPage(driver);
	}

	
	
	public static  AndroidDriver<MobileElement> capabilities() throws IOException, InterruptedException
	{

		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/global.properties");
		Properties prop=new Properties();
		prop.load(fis);



		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device=(String) prop.get("deviceName");
		//  String device= System.getProperty("deviceName");
		String platformName=(String) prop.get("platform");
		String platformVersion=(String) prop.get("platformVersion");
		String amazonPackage=(String) prop.get("amazonAppPackage");
		String amazonActivity=(String) prop.get("amazonAppActivity");
		String pocoPackage=(String) prop.get("pocoAppPackage");
		String pocoActivity=(String) prop.get("pocoAppActivity");
		String automationName=(String) prop.get("automationName");
		String orientationType=(String) prop.get("orientation");



		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automationName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		capabilities.setCapability(MobileCapabilityType.ORIENTATION,orientationType);
		capabilities.setCapability("appPackage", pocoPackage);;
		capabilities.setCapability("appActivity", pocoActivity);;

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	/**
	 * Element visibility 
	 */
	public void waitElement(MobileElement element, int timer) {
		WebDriverWait wait = new WebDriverWait(driver, timer);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Element visibility wait timer method
	 */
	public static void waitFor(double seconds) {
		try {
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * method to HomeBtn
	 */
	public void homeBtn() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	/**
	 * method to HomeBtn
	 */
	public void backBtn() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	/**
	 * method to take screenshot
	 */
	public static void getScreenshot(String s) throws IOException
	{
		File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));

	}


	/**
	 * method to handle context
	 */
	private String getWebContext(AppiumDriver driver) {
		ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
		for (String context : contexts) {
			if (!context.equals("NATIVE_APP")) {
				return context;
			}
		}
		return null;
	}

	/**
	 * method to verify login page 
	 */
	public void isLoginPageDisplayed() {
		waitElement(loginPage.SignInUrAccText, 6);
		assertThat(loginPage.SignInUrAccText.isDisplayed(), equalTo(true));
		assertThat(loginPage.SignInBtn.isDisplayed(), equalTo(true));

	}

	public void clickLoginExistingUser() {
		waitElement(loginPage.SignInUrAccText, 6);
		assertThat(loginPage.SignInUrAccText.isDisplayed(), equalTo(true));
		assertThat(loginPage.SignInBtn.isDisplayed(), equalTo(true));
		loginPage.SignInBtn.click();
	}
	public void enterUserId(String emailPhone) {
		waitElement(loginPage.EnterUserId, 6);
		assertThat(loginPage.EnterUserId.isDisplayed(), equalTo(true));
		loginPage.EnterUserId.sendKeys(emailPhone);
	}

	public void clickOnContinueBtn() {
		waitElement(loginPage.ContinueBtn, 6);
		assertThat(loginPage.ContinueBtn.isDisplayed(), equalTo(true));
		loginPage.ContinueBtn.click();
	}
	public void enterPassword(String password) {
		waitElement(loginPage.EnterPsw, 6);
		assertThat(loginPage.EnterPsw.isDisplayed(), equalTo(true));
		loginPage.EnterPsw.sendKeys(password);
	}

	public void clickOnLoginBtn() {
		waitElement(loginPage.LoginBtn, 6);
		assertThat(loginPage.LoginBtn.isDisplayed(), equalTo(true));
		loginPage.LoginBtn.click();
	}

	/**
	 * Method to launch amazon app
	 */
	public void launchAmazonApp() {
		waitElement(allAppList.Amazon, 6);
		assertThat(allAppList.Amazon.isDisplayed(), equalTo(true));
		allAppList.Amazon.click();
	}

	/**
	 * Method to launch all apps
	 */
	public void openAllApp() {
		waitElement(allAppList.Phone, 6);
		assertThat(allAppList.Phone.isDisplayed(), equalTo(true));
		assertThat(allAppList.Handle_container.isDisplayed(), equalTo(true));
		allAppList.Handle_container.click();
	}

	public void isHomePageDisplayed() {
		waitElement(homePage.Mobiles, 6);
		assertThat(homePage.Mobiles.isDisplayed(), equalTo(true));
		assertThat(homePage.Electronics.isDisplayed(), equalTo(true));
		assertThat(homePage.Home.isDisplayed(), equalTo(true));
		assertThat(homePage.Appliances.isDisplayed(), equalTo(true));
		assertThat(homePage.Fashion.isDisplayed(), equalTo(true));
	}

	public void verifyNavBarOnHomePage() {
		waitElement(navBar.AmazonLogo, 6);
		assertThat(navBar.HamburgerMenuBtn.isDisplayed(), equalTo(true));
		assertThat(navBar.AmazonLogo.isDisplayed(), equalTo(true));
		assertThat(navBar.CartLogo.isDisplayed(), equalTo(true));

	}

	public void clcickOnHamburgerMenu() {
		waitElement(navBar.HamburgerMenuBtn, 6);
		assertThat(navBar.HamburgerMenuBtn.isDisplayed(), equalTo(true));
		navBar.HamburgerMenuBtn.click();		
	}

	public void clcickforLogin() {
		waitElement(navBar.HelloUser, 6);
		assertThat(navBar.HelloUser.isDisplayed(), equalTo(true));
		assertThat(navBar.HelloUser.getText(), equalTo("Hello. Sign In"));
		navBar.HelloUser.click();		
	}
	
	public void isSearchBarDisplayed() {
		waitElement(homePage.Search, 6);
		assertThat(homePage.Search.isDisplayed(), equalTo(true));
		//assertThat(homePage.Search.getText(), equalTo("Search"));
	}

	public void enterTextInSearchBar(String text) {
		waitElement(homePage.Search, 6);
		assertThat(homePage.Search.isDisplayed(), equalTo(true));
		homePage.Search.click();
		homePage.Search.sendKeys(text);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void scrollToText(String text) {
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));")).click();
		
	}
	
	public void clickListingProduct() {
		waitElement(listingPage.ProductName, 6);
		assertThat(listingPage.ProductName.isDisplayed(), equalTo(true));
		assertThat(listingPage.Price.isDisplayed(), equalTo(true));
		listingPage.ProductName.click();
	}
	
	public String getProductNameOnLp() {
		waitElement(listingPage.ProductName, 6);
		assertThat(listingPage.ProductName.isDisplayed(), equalTo(true));
		String st=listingPage.ProductName.getText();
		return st;
	}
	
	public String getPriceOnLp() {
		waitElement(listingPage.Price, 6);
		assertThat(listingPage.Price.isDisplayed(), equalTo(true));
		String st=listingPage.Price.getText();
		return st;
	}
	
	public void clickCartOnProductPage() {
		waitElement(productDetailsPage.CartOnProdctpage, 6);
		assertThat(productDetailsPage.CartOnProdctpage.isDisplayed(), equalTo(true));
		productDetailsPage.CartOnProdctpage.click();
	}
	public String getProductNameOnPdp() {
		waitElement(productDetailsPage.ProductNameOnProductpage, 6);
		assertThat(productDetailsPage.ProductNameOnProductpage.isDisplayed(), equalTo(true));
		String st=productDetailsPage.ProductNameOnProductpage.getText();
		return st;
	}
	
	public String getPriceOnPdp() {
		waitElement(productDetailsPage.PriceOnProductage, 6);
		assertThat(productDetailsPage.PriceOnProductage.isDisplayed(), equalTo(true));
		String st=productDetailsPage.PriceOnProductage.getText();
		return st;
	}
}
