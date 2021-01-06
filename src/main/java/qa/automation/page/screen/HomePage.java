package qa.automation.page.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.automation.page.screen.manager.ScreenManager;


public class HomePage extends ScreenManager {
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HomePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Mobiles']")
	public MobileElement Mobiles;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Electronics']")
	public MobileElement Electronics;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Home']")
	public MobileElement Home;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Mobiles']")
	public MobileElement Appliances;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Fashion']")
	public MobileElement Fashion;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Select delivery location']")
	public MobileElement SelectLocation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search for apps and content']")
	public MobileElement search;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search for apps and content']")
	public MobileElement searchAppInput;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile']")
	public MobileElement Profile;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Quote']")
	public MobileElement quote;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Suggest Plans']")
	public MobileElement suggestPlans;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Car Insurance']")
	public MobileElement selectCarIns;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Customer Name (Optional)']")
	public MobileElement customerName;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Next']")
	public MobileElement next;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='HONDA']")
	public MobileElement selectHonda;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='City']")
	public MobileElement selectCityCar;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Petrol']")
	public MobileElement selectPetrol;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mumbai']")
	public MobileElement selectCityName;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='1.3 EXI (1343 CC)']")
	public MobileElement selectExi;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'MH01')]")
	public MobileElement selectMh01;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='DD/MM/YYYY']")
	public MobileElement selectDate;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Not expired Yet']")
	public MobileElement selectExpiry;

	@AndroidFindBy(xpath="//android.widget.CompoundButton[@text='35%']")
	public MobileElement selectNcb35;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='1 yr Comprehensive/ Standard Policy']")
	public MobileElement selectComprehensive;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save this quote as Lead']")
	public MobileElement quoteSave;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='HDFC ERGO General']")
	public MobileElement hdfcErgo;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Generate Quote']")
	public MobileElement generalQuote;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Buy Now']")
	public MobileElement buyNow;

	@AndroidFindBy(xpath="//android.widget.Button[@text='View Details']")
	public MobileElement viewDetails;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Mr.']")
	public MobileElement selectMr;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='First Name']")
	public MobileElement firName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Middle Name']")
	public MobileElement midName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Last Name']")
	public MobileElement lastName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Date Of Birth']")
	public MobileElement dateOfBirth;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	public MobileElement email;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Phone']")
	public MobileElement phone;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	public MobileElement selectMale;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Single']")
	public MobileElement selectSingle;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Address Line 1']")
	public MobileElement addressLine1;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Address Line 2']")
	public MobileElement addressLine2;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Address Line 3']")
	public MobileElement addressLine3;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Pincode']")
	public MobileElement pincode;

	@AndroidFindBy(xpath="//android.widget.Spinner[contains(@resource-id,'actv_value')]")
	public MobileElement selectState;

	@AndroidFindBy(xpath="(//android.widget.Spinner[contains(@resource-id,'actv_value')])[2]")
	public MobileElement selectCityforAddress;

	@AndroidFindBy(xpath="(//android.widget.Spinner[contains(@resource-id,'actv_value')])[3]")
	public MobileElement selectDistric;

	@AndroidFindBy(xpath="(//android.widget.Spinner[contains(@resource-id,'actv_value')])[4]")
	public MobileElement selectCountry;

	@AndroidFindBy(xpath="//android.widget.CheckBox[@text='Same as Communication Address']")
	public MobileElement sameAsCAdd1;

	@AndroidFindBy(xpath="//android.widget.CheckBox[contains(@text,'Same as')]")
	public MobileElement sameAsCAdd2;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Permanent Address']")
	public MobileElement permanentAddress;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Registration Address']")
	public MobileElement registrationAddress;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='City Name']")
	public MobileElement cityName;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='District Name']")
	public MobileElement distric;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Country Name']")
	public MobileElement countyName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Name']")
	public MobileElement nomineeName;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Address']")
	public MobileElement nomineeAddress;

	@AndroidFindBy(xpath="//android.widget.Spinner[contains(@resource-id,'actv_value')]")
	public MobileElement nomineeRelation;

	@AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'License Plate Number')]")
	public MobileElement licensePlateNum;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Manufacturing Date']")
	public MobileElement ManfuctDate;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Chassis Number']")
	public MobileElement chassisNumber;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Engine Number']")
	public MobileElement engineNumber;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Review & Submit']")
	public MobileElement reviewSubmit;

	@AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'text_input_end_icon')]")
	public MobileElement clickOnCalenderLogo;

	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Change to previous month']")
	public MobileElement prevMonth;

	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Change to next month']")
	public MobileElement nextMonth;

	@AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'month_navigation_fragment_toggle')]")
	public MobileElement selectYear;

	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Switch to text input mode']")
	public MobileElement switchInputDate;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date']")
	public MobileElement enterDate;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='16']")
	public MobileElement date16;

	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public MobileElement clickOk;

	@AndroidFindBy(xpath="//android.widget.Spinner[contains(@resource-id,'actv_value')]")
	public MobileElement actv_valueDropdown;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Yes']")
	public MobileElement yes;

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='No']")
	public MobileElement no;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Policy Expiry Date']")
	public MobileElement policyExpiryDate;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Previous Policy Number']")
	public MobileElement prevPolicyNum;

	@AndroidFindBy(xpath="(//android.widget.ImageButton[contains(@resource-id,'text_input_end_icon')])[2]")
	public MobileElement policyExDate;

}

