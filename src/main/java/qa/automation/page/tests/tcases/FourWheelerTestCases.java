package qa.automation.page.tests.tcases;

import org.testng.annotations.Test;
import qa.automation.page.tests.base.BaseTest;

public class FourWheelerTestCases extends BaseTest {


    @Test(priority = 1,groups = { "regression" })
    public void verifyCopmPlanForHondaCityPetrolExiWithReliance() {
        //Reg
        openAllApp();
        searchApp("Ice Insurance");
        launchIceApp();
        isIceHomePageDisplayed();
        clickOnQuote();
        waitFor(2);
        selectCarInsu();
        clickOnSuggestplan();
        enterCustomerName("Mohan Rao");
        clickOnNext();
        waitFor(3);
        selectHondaCityPetrolExi();
        selectTownCity();
        SelectRegistrationDate();
        waitFor(3);
        clickOnNext();
        selectExpiry();
        selectNcb();
        waitFor(2);
        scroll(500,1500 ,500,500);
        selectHDFC();
        select1yearCompre();
        clickOnGeneratesQuote();
        waitFor(5);
        clickOnBuyNow();
        selectTitle();
        enterFirstNamForProposer("Manav");
        enterMidtName("Kumar");
        enterlastNamForProposer("Singh");
        scrollToText("Phone");
        selectDob();
        selectGenderAndMaritalStatus();
        enterEmailId("manav@gmail.com");
        enterphoneNum("6367357113");
        clickOnNext();
        enterCommunicationAddress();
        enterPincode("400001");
        scrollToText("District Name");
        enterState();
        enterCityName();
        enterDistric();
        enterCounty();
        scrollToText("Permanent Address");
        selctSameAsComAddForPerm();
        scrollToText("Registration Address");
        selctSameAsComAddForRegstn();
        waitFor(5);
        clickOnNext();
        enterNomineeName("AbcAny");
        selectDob();
        selectNomineeRelation();
        enterNomineeAdress("Mumbai");
        clickOnNext();
        enterPlateNum("MH-01-SDF-4522");
        selecManufactureDate();
        scrollToText("Vehicle IDV");
        enterChasisNumber("12345678909876543");
        enterEngineNumber("98765432101234567");
        selectVehicleHypoType();
        clickOnNext();
        selectPrevInsurerName();
        selecPolicyExpDate();
        enterPrevPolicyNum("12345");
        clickOnNext();
        scrollToText("Review & Submit");
        clickReviewSubmit();
        clickHomeBtn();
    }
}
