package qa.automation.page.tests.base;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import qa.automation.page.screen.AllAppList;
import qa.automation.page.screen.*;
import qa.automation.report.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;




public class BaseTest {

	private final static Logger logger = LogManager.getLogger(BaseTest.class);

	public static AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement> driver;

	protected static QuotePage quotePage;
	protected static HomePage homePage;
	protected static LoginPage loginPage;
	protected static AllAppList allAppList;
	protected static NavBar navBar;
	protected static TwoWheeler twoWheeler;
	protected static UserProfilePage userProfilePage;


	@BeforeClass(alwaysRun = true)
	public void intializeClass() throws IOException, InterruptedException {
		capabilities();
		quotePage = new QuotePage(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		allAppList = new AllAppList(driver);
		navBar = new NavBar(driver);
		twoWheeler = new TwoWheeler(driver);
		userProfilePage = new UserProfilePage(driver);
	}

	public static AndroidDriver<MobileElement> capabilities() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);


		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = (String) prop.get("deviceName");
		// String device= System.getProperty("deviceName");
		String platformName = (String) prop.get("platform");
		String platformVersion = (String) prop.get("platformVersion");
		String amazonPackage = (String) prop.get("amazonAppPackage");
		String amazonActivity = (String) prop.get("amazonAppActivity");
		String pocoPackage = (String) prop.get("pocoAppPackage");
		String pocoActivity = (String) prop.get("pocoAppActivity");
		String automationName = (String) prop.get("automationName");
		String orientationType = (String) prop.get("orientation");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(MobileCapabilityType.ORIENTATION, orientationType);
		capabilities.setCapability("appPackage", pocoPackage);
		;
		capabilities.setCapability("appActivity", pocoActivity);
		;

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	
	public void waitElement(MobileElement element, int timer) {
		WebDriverWait wait = new WebDriverWait(driver, timer);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public static void waitFor(double seconds) {
		try {
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void clickHomeBtn() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	public void clickDoneBtn() {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public void backBtn() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	
	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));

	}

	
	private String getWebContext(AppiumDriver driver) {
		ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
		for (String context : contexts) {
			if (!context.equals("NATIVE_APP")) {
				return context;
			}
		}
		return null;
	}

	public void isLoginPageDisplayed() {
		waitElement(loginPage.proceedBtn, 6);
		assertThat(loginPage.enterMobileNum.isDisplayed(), equalTo(true));
		assertThat(loginPage.proceedBtn.isDisplayed(), equalTo(true));
		ExtentTestManager.getTest().log(LogStatus.PASS, "login pahe verify successfully");
	}


	public void enterUserId(String emailPhone) {
		waitElement(loginPage.enterMobileNum, 6);
		assertThat(loginPage.enterMobileNum.isDisplayed(), equalTo(true));
		loginPage.enterMobileNum.sendKeys(emailPhone);
		ExtentTestManager.getTest().log(LogStatus.PASS, "phone number entered successfully");
	}


	public void launchIceApp() {
		waitElement(allAppList.Ice_Insurance, 3);
		assertThat(allAppList.Ice_Insurance.isDisplayed(), equalTo(true));
		allAppList.Ice_Insurance.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Ice insurance app launched successfully");

	}


	public void openAllApp() {
		waitElement(allAppList.Phone, 6);
		assertThat(allAppList.Phone.isDisplayed(), equalTo(true));
		assertThat(allAppList.Handle_container.isDisplayed(), equalTo(true));
		allAppList.Handle_container.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Opened all apps successfully");
	}

	public void isHomePageDisplayed() {
		waitElement(homePage.quote, 6);
		assertThat(homePage.quote.isDisplayed(), equalTo(true));
		assertThat(homePage.quote.isDisplayed(), equalTo(true));
		assertThat(homePage.quote.isDisplayed(), equalTo(true));
		ExtentTestManager.getTest().log(LogStatus.PASS, "HomePage Displayed successfully");
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
		waitElement(homePage.search, 6);
		assertThat(homePage.search.isDisplayed(), equalTo(true));
		// assertThat(homePage.Search.getText(), equalTo("Search"));
	}

	public void searchApp(String appName) {
		waitElement(homePage.search, 6);
		assertThat(homePage.search.isDisplayed(), equalTo(true));
		homePage.search.click();
		homePage.searchAppInput.sendKeys(appName);


	}

	public void enterTextInSearchBar(String text) {
		waitElement(homePage.search, 6);
		assertThat(homePage.search.isDisplayed(), equalTo(true));
		homePage.search.click();
		homePage.search.sendKeys(text);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public void scrollToTextNclick(String text) {
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"))
				.click();

	}

	public void scrollToText(String text) {
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

	}

	public void scroll(int fromX, int fromY, int toX, int toY) {
//		TouchAction touchAction = new TouchAction(driver);
//		touchAction.press(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
		TouchAction touchAction =new TouchAction(driver)
				.press(PointOption.point(fromX,fromY))
				.waitAction(waitOptions(ofSeconds(2)))
				.moveTo(PointOption.point(toX,toY))
				.release()
				.perform();
	}

	public String getPriceOnLp() {
		waitElement(homePage.quote, 6);
		assertThat(homePage.quote.isDisplayed(), equalTo(true));
		String st = homePage.quote.getText();
		return st;
	}


	public void enterLoginId(String userId) {
		waitElement(loginPage.enterMobileNum, 6);
		assertThat(loginPage.enterMobileNum.isDisplayed(), equalTo(true));
		loginPage.enterMobileNum.sendKeys(userId);
		new TouchAction(driver).tap(new PointOption().withCoordinates(147, 1475)).perform();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Login id:-"+userId+" entered successfully");

	}

	public void enterOtp(String password) {
		waitElement(loginPage.verifyOtp, 6);
		assertThat(loginPage.verifyOtp.isDisplayed(), equalTo(true));
		loginPage.EnterOtp.sendKeys(password);
		loginPage.verifyOtp.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Otp entered successfully");

	}

	public void selectCheckbox() {
		waitElement(loginPage.checkBox, 6);
		assertThat(loginPage.checkBox.isDisplayed(), equalTo(true));
		loginPage.checkBox.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "checkbox clicked successfully");

	}

	public void clickOnProceed() {
		waitElement(loginPage.proceedBtn, 6);
		assertThat(loginPage.proceedBtn.isDisplayed(), equalTo(true));
		loginPage.proceedBtn.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "proceed clicked successfully");
	}

	public void clickOnContinueBtn() {
		waitElement(loginPage.continueBtn, 6);
		assertThat(loginPage.continueBtn.isDisplayed(), equalTo(true));
		loginPage.continueBtn.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Continue clicked successfully");

	}


	public void isIceHomePageDisplayed() {
		waitElement(homePage.Profile, 6);
		assertThat(homePage.Profile.isDisplayed(), equalTo(true));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Iceapp HomePage Displayed successfully");

	}

	public void clickOnLeads() {
		waitElement(homePage.leads, 6);
		assertThat(homePage.leads.isDisplayed(), equalTo(true));
		homePage.leads.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "click on quote btn successfully");
	}

	public void clickOnQuote() {
		waitElement(homePage.quote, 6);
		assertThat(homePage.quote.isDisplayed(), equalTo(true));
		homePage.quote.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "click on quote btn successfully");
	}

	public void clickOnQuoteOnLeadsPage() {
		waitElement(homePage.quoteUnderLeads, 6);
		assertThat(homePage.quoteUnderLeads.isDisplayed(), equalTo(true));
		homePage.quoteUnderLeads.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "click on quote btn successfully");
	}

	public void selectCarInsu() {
		waitElement(homePage.selectCarIns, 6);
		assertThat(homePage.selectCarIns.isDisplayed(), equalTo(true));
		homePage.selectCarIns.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select car insurance successfully");
	}

	public void clickOnSuggestplan() {
		waitElement(homePage.suggestPlans, 6);
		assertThat(homePage.suggestPlans.isDisplayed(), equalTo(true));
		homePage.suggestPlans.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "suggest plans clicked successfully");
	}

	public void enterCustomerName(String custName) {
		waitElement(homePage.customerName, 6);
		assertThat(homePage.customerName.isDisplayed(), equalTo(true));
		homePage.customerName.sendKeys(custName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "customer name "+custName+" entered successfully");
	}

	public void selectHondaCityPetrolExi() {
		waitElement(homePage.selectHonda, 3);
		assertThat(homePage.selectHonda.isDisplayed(), equalTo(true));
		homePage.selectHonda.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Honda successfully");
		waitElement(homePage.selectCityCar, 3);
		assertThat(homePage.selectCityCar.isDisplayed(), equalTo(true));
		homePage.selectCityCar.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Honda city successfully");
		waitElement(homePage.selectPetrol, 3);
		assertThat(homePage.selectPetrol.isDisplayed(), equalTo(true));
		homePage.selectPetrol.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Petrol successfully");
		waitElement(homePage.selectExi, 3);
		assertThat(homePage.selectExi.isDisplayed(), equalTo(true));
		homePage.selectExi.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Exi successfully");
	}

	public void selectTownCity(){
		waitElement(homePage.selectCityName, 3);
		assertThat(homePage.selectCityName.isDisplayed(), equalTo(true));
		homePage.selectCityName.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Mumbai successfully");
		waitElement(homePage.selectMh01, 3);
		assertThat(homePage.selectMh01.isDisplayed(), equalTo(true));
		homePage.selectMh01.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select MH01 successfully");
	}

	public void SelectRegistrationDate(int month){
		waitElement(homePage.selectDate, 3);
		assertThat(homePage.selectDate.isDisplayed(), equalTo(true));
		assertThat(homePage.clickOnCalenderLogo.isDisplayed(), equalTo(true));
		homePage.clickOnCalenderLogo.click();
		homePage.switchInputDate.click();
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.SLASH));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		if (month>=7){
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));}
		else{
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));}
		driver.pressKey(new KeyEvent(AndroidKey.SLASH));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
//		homePage.enterDate.sendKeys("10/10/2018");
		clickDoneBtn();
		homePage.clickOk.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select regesister date successfully");
	}

	public void clickOnNext(){
		waitElement(homePage.next, 3);
		assertThat(homePage.next.isDisplayed(), equalTo(true));
		homePage.next.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Next clicked successfully");
	}

	public void selectNoExpiry(){
		waitElement(homePage.noExpiry, 3);
		assertThat(homePage.noExpiry.isDisplayed(), equalTo(true));
		homePage.noExpiry.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select Expiry successfully");
	}

	public void selectNcb(){
		waitElement(homePage.selectNcb35, 3);
		assertThat(homePage.selectNcb35.isDisplayed(), equalTo(true));
		homePage.selectNcb35.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on Capture button");
		ExtentTestManager.getTest().log(LogStatus.PASS, "select NCB 35% successfully");
	}

	public void selectHDFC(){
		waitElement(homePage.hdfcErgo, 3);
		assertThat(homePage.hdfcErgo.isDisplayed(), equalTo(true));
		homePage.hdfcErgo.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select HDFCErgo successfully");
	}

	public void select1yearCompre(){
		waitElement(homePage.selectComprehensive, 3);
		assertThat(homePage.selectComprehensive.isDisplayed(), equalTo(true));
		homePage.selectComprehensive.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select 1year plan successfully");
	}

	public void clickOnGeneratesQuote(){
		waitElement(homePage.generalQuote, 3);
		assertThat(homePage.generalQuote.isDisplayed(), equalTo(true));
		homePage.generalQuote.click();
	}

	public void clickOnBuyNow(){
		waitElement(homePage.buyNow, 3);
		assertThat(homePage.buyNow.isDisplayed(), equalTo(true));
		homePage.buyNow.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "BuyNow Button Clicked  successfully");
	}

	public void selectTitle(){
		waitElement(homePage.selectMr, 3);
		assertThat(homePage.selectMr.isDisplayed(), equalTo(true));
		homePage.selectMr.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "title has been selected successfully");
	}

	public void enterFirstNamForProposer(String fName){
		waitElement(homePage.firName, 3);
		assertThat(homePage.firName.isDisplayed(), equalTo(true));
		homePage.firName.sendKeys(fName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "First name:-"+fName+" entered successfully");
	}

	public void enterMidtName(String midName){
		waitElement(homePage.midName, 3);
		assertThat(homePage.midName.isDisplayed(), equalTo(true));
		homePage.midName.sendKeys(midName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Middle name:-"+midName+" entered successfully");
	}


	public void enterlastNamForProposer(String lName){
		waitElement(homePage.lastName, 3);
		assertThat(homePage.lastName.isDisplayed(), equalTo(true));
		homePage.lastName.sendKeys(lName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Last name:-"+lName+" entered successfully");
	}

	public void selectDob(){
		waitElement(homePage.dateOfBirth, 3);
		assertThat(homePage.dateOfBirth.isDisplayed(), equalTo(true));
		homePage.clickOnCalenderLogo.click();
		homePage.prevMonth.click();
		homePage.date16.click();

		homePage.clickOk.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Dob entered successfully");
	}

	public void selectGenderAndMaritalStatus(){
		waitElement(homePage.selectMale, 3);
		assertThat(homePage.selectMale.isDisplayed(), equalTo(true));
		homePage.selectMale.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select male successfully");
		waitElement(homePage.selectSingle, 3);
		assertThat(homePage.selectSingle.isDisplayed(), equalTo(true));
		homePage.selectSingle.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select single successfully");
	}

	public void selectGenderAndMaritalStatusForTataAig(){
		waitElement(homePage.male, 3);
		assertThat(homePage.male.isDisplayed(), equalTo(true));
		homePage.male.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select male successfully");
		waitElement(homePage.selectSingle, 3);
		assertThat(homePage.selectSingle.isDisplayed(), equalTo(true));
		homePage.selectSingle.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "select single successfully");
	}

	public void enterEmailId(String email){
		waitElement(homePage.email, 3);
		assertThat(homePage.email.isDisplayed(), equalTo(true));
		homePage.email.sendKeys(email);
		ExtentTestManager.getTest().log(LogStatus.PASS, "email id:-"+email+" entered successfully");
	}

	public void enterphoneNum(String phonenum){
		waitElement(homePage.phone, 3);
		assertThat(homePage.phone.isDisplayed(), equalTo(true));
		homePage.phone.sendKeys(phonenum);
		ExtentTestManager.getTest().log(LogStatus.PASS, "phone number :-"+phonenum+" entered successfully");
	}

	public void enterCommunicationAddress(){
		waitElement(homePage.addressLine1, 3);
		assertThat(homePage.addressLine1.isDisplayed(), equalTo(true));
		homePage.addressLine1.sendKeys("church road");
		waitElement(homePage.addressLine2, 3);
		assertThat(homePage.addressLine2.isDisplayed(), equalTo(true));
		homePage.addressLine2.sendKeys("near taj Hotel");
		waitElement(homePage.addressLine3, 3);
		assertThat(homePage.addressLine3.isDisplayed(), equalTo(true));
		homePage.addressLine3.sendKeys("mumbai");
		ExtentTestManager.getTest().log(LogStatus.PASS, "communication address entered successfully");
	}

	public void enterPincode(String pincode){
		waitElement(homePage.pincode,3);
		assertThat(homePage.pincode.isDisplayed(),equalTo(true));
		homePage.pincode.sendKeys(pincode);
		ExtentTestManager.getTest().log(LogStatus.PASS, "pincode entered successfully");
	}
	public void enterState(){
		waitElement(homePage.selectState,3);
		assertThat(homePage.selectState.isDisplayed(),equalTo(true));
		homePage.selectState.click();
		homePage.cityName.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "state name entered successfully");
	}

	public void enterCityName(){
		waitElement(homePage.selectCityforAddress,3);
		assertThat(homePage.selectCityforAddress.isDisplayed(),equalTo(true));
		homePage.selectCityforAddress.click();
		homePage.distric.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "city name entered successfully");
	}

	public void enterDistric(){
		waitElement(homePage.selectDistric,3);
		assertThat(homePage.selectDistric.isDisplayed(),equalTo(true));
		homePage.selectDistric.click();
		homePage.countyName.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "distric name entered successfully");
	}

	public void enterCounty(){
		waitElement(homePage.selectCountry,3);
		assertThat(homePage.selectCountry.isDisplayed(),equalTo(true));
		homePage.selectCountry.click();
		homePage.permanentAddress.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "country name entered successfully");
	}

	public void selctSameAsComAddForPerm(){
		waitElement(homePage.sameAsCAdd1,3);
		assertThat(homePage.sameAsCAdd1.isDisplayed(),equalTo(true));
		homePage.sameAsCAdd1.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "same as communication address selected successfully");
	}

	public void selctSameAsComAddForRegstn(){
		waitElement(homePage.sameAsCAdd2,3);
		assertThat(homePage.sameAsCAdd2.isDisplayed(),equalTo(true));
		homePage.sameAsCAdd2.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "same as communication address selected successfully");
	}

	public void enterNomineeName(String nominee){
		waitElement(homePage.nomineeName,3);
		assertThat(homePage.nomineeName.isDisplayed(),equalTo(true));
		homePage.nomineeName.sendKeys(nominee);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee name entered successfully");
	}

	public void selectNomineeRelation(){
		waitElement(homePage.nomineeRelation,3);
		assertThat(homePage.nomineeRelation.isDisplayed(),equalTo(true));
		homePage.nomineeRelation.click();
		homePage.nomineeAddress.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee relation selected successfully");
	}

	public void enterNomineeAdress(String address){
		waitElement(homePage.nomineeAddress,3);
		assertThat(homePage.nomineeAddress.isDisplayed(),equalTo(true));
		homePage.nomineeAddress.sendKeys(address);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee address entered successfully");
	}

	public void enterPlateNum(String plateNum){
		waitElement(homePage.licensePlateNum,3);
		assertThat(homePage.licensePlateNum.isDisplayed(),equalTo(true));
		homePage.licensePlateNum.sendKeys(plateNum);
		ExtentTestManager.getTest().log(LogStatus.PASS, "License Plate number entered successfully");
	}

	public void selecManufactureDate(){
		waitElement(homePage.clickOnCalenderLogo,3);
		assertThat(homePage.clickOnCalenderLogo.isDisplayed(),equalTo(true));
		homePage.clickOnCalenderLogo.click();
		homePage.date16.click();
		homePage.clickOk.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Manufacturing date selected successfully");
	}

	public void enterChasisNumber(String chNum17){
		waitElement(homePage.chassisNumber,3);
		assertThat(homePage.chassisNumber.isDisplayed(),equalTo(true));
		homePage.chassisNumber.sendKeys(chNum17);
		ExtentTestManager.getTest().log(LogStatus.PASS, "chassis number entered successfully");
	}

	public void enterEngineNumber(String eNum17){
		waitElement(homePage.engineNumber,3);
		assertThat(homePage.engineNumber.isDisplayed(),equalTo(true));
		homePage.engineNumber.sendKeys(eNum17);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Engine number entered successfully");
	}

	public void selectVehicleHypoType(){
		waitElement(homePage.no,3);
		assertThat(homePage.no.isDisplayed(),equalTo(true));
		homePage.no.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Hypothecated vehcle type selected successfully");
	}

	public void selectPrevInsurerName(){
		waitElement(homePage.actv_valueDropdown,3);
		assertThat(homePage.actv_valueDropdown.isDisplayed(),equalTo(true));
		homePage.actv_valueDropdown.click();
		new TouchAction(driver).tap(new PointOption().withCoordinates(500, 750)).perform();
		ExtentTestManager.getTest().log(LogStatus.PASS, "previous insurer name selected successfully");
	}

	public void selecPolicyExpDate(){
		waitElement(homePage.clickOnCalenderLogo,3);
		assertThat(homePage.clickOnCalenderLogo.isDisplayed(),equalTo(true));
		homePage.policyExDate.click();
		homePage.date16.click();
		homePage.clickOk.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Policy expiry date selected successfully");
	}

	public void enterPrevPolicyNum(String prevpolicyNo){
		waitElement(homePage.prevPolicyNum,3);
		assertThat(homePage.prevPolicyNum.isDisplayed(),equalTo(true));
		homePage.prevPolicyNum.sendKeys(prevpolicyNo);
		ExtentTestManager.getTest().log(LogStatus.PASS, "previous policy number entered successfully");
	}

	public void clickReviewSubmit(){
		waitElement(homePage.reviewSubmit,3);
		assertThat(homePage.reviewSubmit.isDisplayed(),equalTo(true));
		homePage.reviewSubmit.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "review and summit btn clicked  successfully");
	}

	public void clickAgree(){
		waitElement(homePage.agree,3);
		assertThat(homePage.agree.isDisplayed(),equalTo(true));
		homePage.agree.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Yes,Agree btn clicked  successfully");
	}

	public void selecFinancierType(){
		waitElement(homePage.financierType,3);
		assertThat(homePage.financierType.isDisplayed(),equalTo(true));
		homePage.financierType.click();
		homePage.financierNameText.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Financier Type selected successfully");
	}

	public void selectFinancierName(){
		waitElement(homePage.financierName,3);
		assertThat(homePage.financierName.isDisplayed(),equalTo(true));
		homePage.financierName.click();
		homePage.financierNameText.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Financier Type selected successfully");
	}

	public void enterFinancierAddress(String finAdd){
		waitElement(homePage.financierAddress,3);
		assertThat(homePage.financierAddress.isDisplayed(),equalTo(true));
		homePage.financierAddress.sendKeys(finAdd);
		ExtentTestManager.getTest().log(LogStatus.PASS, "financier Address entered successfully");
	}
	public void selectTitleFromDropDown(){
		waitElement(homePage.salutation,3);
		assertThat(homePage.salutation.isDisplayed(),equalTo(true));
		homePage.policyExDate.click();
		homePage.salutation.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Title selected successfully");
	}

	public void enterAdress(String address){
		waitElement(homePage.nomineeAddress,3);
		assertThat(homePage.nomineeAddress.isDisplayed(),equalTo(true));
		homePage.nomineeAddress.sendKeys(address);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Address entered successfully");
	}

	public void enterNomineeNameForTataAig(String nominee){
		waitElement(homePage.name,3);
		assertThat(homePage.name.isDisplayed(),equalTo(true));
		homePage.name.sendKeys(nominee);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee name entered successfully");
	}

	public void selectNomineeRelationForTataAig(){
		waitElement(homePage.nomineeRelation,3);
		assertThat(homePage.nomineeRelation.isDisplayed(),equalTo(true));
		homePage.nomineeRelation.click();
		new TouchAction(driver).tap(new PointOption().withCoordinates(450, 950)).perform();

		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee relation selected successfully");
	}

	public void enterAge(String age){
		waitElement(homePage.age,3);
		assertThat(homePage.age.isDisplayed(),equalTo(true));
		homePage.age.sendKeys(age);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Nominee name entered successfully");
	}

	public void selectComprehensive(){
		waitElement(homePage.comprehensive,3);
		assertThat(homePage.comprehensive.isDisplayed(),equalTo(true));
		homePage.comprehensive.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "comprehensive selected successfully");
	}

	public void selectThirdparty(){
		waitElement(homePage.thirdparty,3);
		assertThat(homePage.thirdparty.isDisplayed(),equalTo(true));
		homePage.thirdparty.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "comprehensive selected successfully");
	}
}
