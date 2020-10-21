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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import qa.automation.page.screen.CheckoutPage;
import qa.automation.page.screen.FormPage;
import qa.automation.page.screen.HomePage;
import qa.automation.page.screen.LoginPage;

public class BaseTest {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement>  driver;

	protected static CheckoutPage checkoutPage;
	protected static HomePage homePage;
	protected static FormPage formPage;
	protected static LoginPage loginPage;

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
		formPage = new FormPage(driver);
		loginPage = new LoginPage(driver);

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
		String appPackage=(String) prop.get("appPackage");
		String appActivity=(String) prop.get("appActivity");
		String automationName=(String) prop.get("automationName");
		String orientationType=(String) prop.get("orientation");



		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automationName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		capabilities.setCapability(MobileCapabilityType.ORIENTATION,orientationType);
		capabilities.setCapability("appPackage", appPackage);;
		capabilities.setCapability("appActivity", appActivity);;

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

}
