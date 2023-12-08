package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.google.sitebricks.routing.Action;



public class BillerSignUpPage extends BasePage
{

	public BillerSignUpPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}


	public void ClickOnBillerLogin() {
		WebClickUsingJS(EdaatOR.Biller_Link);
		waitForPageToLoad();
	}


	public void ClickOnBillerSignUpBtn() {
		WebClickUsingJS(EdaatOR.Biller_SignUp_Btn);
		waitForPageToLoad();
	}

	public void EnterBillerCompanyName(String CompName) {
		WebEdit(EdaatOR.Biller_CompanyName_eField,CompName);
	}


	public void SelectBillerEconomySector(String EconomySector) {
		WebSelect1(EdaatOR.Biller_EconomySector_List,EconomySector);
	}


	public void SelectBillerCountry(String Country) {
		WebSelect1(EdaatOR.Biller_Country_List,Country);
	}

	public void SelectBillerCity(String City) {
		WebSelect1(EdaatOR.Biller_City_List,City);
	}

	public void EnterBillerDistrict(String District) {
		WebEdit(EdaatOR.Biller_District_eField,District);
	}

	public void EnterBillerStreet(String Street) {
		WebEdit(EdaatOR.Biller_Street_eField,Street);
	}
	public void EnterBillerBuildNo(String BuildNo) {
		WebEdit(EdaatOR.Biller_BuildNo_eField,BuildNo);
	}

	public void EnterBillerPostalCode(String PostalCode) {
		WebEdit(EdaatOR.Biller_PostalCode_eField,PostalCode);
	}

	public void EnterBillerMailBox(String MailBox) {
		WebEdit(EdaatOR.Biller_MailBox_eField,MailBox);
	}

	public void EnterBillerOfficNo(String OfficNo) {
		WebEdit(EdaatOR.Biller_OfficNo_eField,OfficNo);
	}

	public void EnterBillerEmplyName(String EmplyName) {
		WebEdit(EdaatOR.Biller_EmplyName_eField,EmplyName);
	}
	public void EnterBillerEmplyJobTitle(String EmplyJobTitle) {
		WebEdit(EdaatOR.Biller_EmplyJobTitle_eField,EmplyJobTitle);
	}

	public void EnterBillerEmplyMobileNum(String EmplyMob) {
		WebEdit(EdaatOR.Biller_EmplyMobileNumber_eField,EmplyMob);
	}

	public void EnterBillerEmplyEmail(String EmplyEmail) {
		WebEdit(EdaatOR.Biller_EmplyEmail_eField,EmplyEmail);
	}


	public void EnterBillerCustomerSupPhNo(String CustomerSupPhNo) {
		WebEdit(EdaatOR.Biller_CustomerSupPhNo_eField,CustomerSupPhNo);
	}

	public void EnterBillerIBANum(String IBANum) {
		WebEdit(EdaatOR.Biller_IBANum_eField,IBANum);
	}

	public void EnterBillerIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_IBANAttmnt_eField);
		getAutoItImagePathFile();
	}


	public void SelectBillerBankCountry(String BankCountry) {
		WebSelect(EdaatOR.Biller_BankCountryType_List,BankCountry);
	}


	public void EnterBillerBankCertPath() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_BankCertAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void SelectBillerCRNumber(String CRNumber) {
		WebSelect(EdaatOR.Biller_CRNumber_eField,CRNumber);
	}


	public void EnterBillerRegiAttachment() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_RegiAttachment_eField);
		getAutoItImagePathFile();
	}

	public void EnterBillerRegistDate(String RegistDate) throws Exception {
		//WebEdit(EdaatOR.Biller_RegistDate_eField,RegistDate);
		WebClick(EdaatOR.Biller_RegistDate_eField);
		//WebClickUsingJS(EdaatOR.Biller_RegistDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_Issuedate);
	}

	public void EnterBillerExperyDate(String ExperyDate) throws InterruptedException {
		//WebEdit(EdaatOR.Biller_ExperyDate_eField,ExperyDate);
		WebClick(EdaatOR.Biller_ExperyDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_exprDate);
	}


	public void EnterBillerTaxno(String Taxno) {
		WebEdit(EdaatOR.Biller_Taxno_eField,Taxno);
	}

	public void ClickOnIsTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_IsTaxable_RadBtn);
	}

	public void ClickOnNoTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_NoTaxable_RadBtn);
	}

	public void EnterTaxRegisAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_TaxRegisAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterBillerFirstName(String FirstName) {
		WebEdit(EdaatOR.Biller_FirstName_eField,FirstName);
	}


	public void EnterBillerSurName(String SurName) {
		WebEdit(EdaatOR.Biller_SurName_eField,SurName);
	}
	public void EnterBillerGradFatherName(String GradFatherName) {
		WebEdit(EdaatOR.Biller_GradFatherName_eField,GradFatherName);
	}
	public void EnterBillerLastName(String LastName) {
		WebEdit(EdaatOR.Biller_LastName_eField,LastName);
	}
	public void EnterBillerNationalID(String NationalID_) {
		WebEdit(EdaatOR.Biller_NationalID_eField,NationalID_);
	}
	public void EnterBillerCommisionIdentyAtt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_CommisionIdentyAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterBillerMemDumAssoAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Biller_MemDumAssoAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterBillerAuthLterTemltAttmnt(String AuthLterTemltAttmnt) {
		WebEdit(EdaatOR.Biller_AuthLterTemltAttmnt_eField, AuthLterTemltAttmnt);
	}

	public void EnterBillerAuthLterTemltAttmnt() {
		//WebClick(EdaatOR.Biller_AuthLterTemltAttmnt_eField);
		WebClickUsingActions(EdaatOR.Biller_AuthLterTemltAttmnt_eField);
	}

	public void EnterBillerCommisionPhNo(String CommisionPhNo) {
		WebEdit(EdaatOR.Biller_CommisionPhNo_eField,CommisionPhNo);
	}
	public void EnterBillerCommisionEmail(String CommisionEmail) {
		WebEdit(EdaatOR.Biller_CommisionEmail_eField,CommisionEmail);
	}
	public void EnterBillerUserID(String UserID) {
		WebEdit(EdaatOR.Biller_UserID_eField,UserID);
	}


	public void EnterBillerPassword(String Password) {
		WebEdit(EdaatOR.Biller_Password_eField,Password);
	}
	public void EnterBillerConfPawd(String ConfPawd) {
		WebEdit(EdaatOR.Biller_ConfPawd_eField,ConfPawd);
	}
	public void ClickOnBillerConfirmation() {
		WebClickUsingJS(EdaatOR.Biller_Confirmation_CheckBox);
		takeScreenShot();
	}

	public void ClickOnBillerCatchBox() throws Exception {
		swithchToFrame(EdaatOR.Biller_ReCatchBox_eField);
		WebClickUsingJS(EdaatOR.Biller_CatchBox_eField);
		driver.switchTo().defaultContent();
	}


	public void ClickOnRegisterBtn() {
		WebClickUsingJS(EdaatOR.Biller_SignUp_btn);
	}

	public void ClickOnCloseBtn() {
		WebClickUsingJS(EdaatOR.Biller_Close_btn);
	}

	public void enterCompanyName(Map<Object,Object> testdatamap) {
		EnterBillerCompanyName(testdatamap.get("CompanyName").toString());
		takeScreenShot();
	}

	public void enterEconomySectorDetails(Map<Object,Object> testdatamap) {
		SelectBillerEconomySector(testdatamap.get("EmpySector").toString());
		takeScreenShot();
	}

	public void enterBillerCountyDetails(Map<Object,Object> testdatamap) {
		SelectBillerCountry(testdatamap.get("BCounty").toString());
		SelectBillerCity(testdatamap.get("BCity").toString());
		EnterBillerDistrict(testdatamap.get("BDistric").toString());
		EnterBillerStreet(testdatamap.get("Street").toString());
		EnterBillerBuildNo(testdatamap.get("BuildNum").toString());
		EnterBillerPostalCode(testdatamap.get("ZipCode").toString());
		EnterBillerMailBox(testdatamap.get("AdditionalNum").toString());
		EnterBillerOfficNo(testdatamap.get("UnitNum").toString());
	}

	public void enterContactInfo(Map<Object,Object> testdatamap) {
		EnterBillerEmplyName(testdatamap.get("EmployeeName").toString());
		EnterBillerEmplyJobTitle(testdatamap.get("EmployeePosition").toString());
		EnterBillerEmplyMobileNum(testdatamap.get("EmployeeMobNumber").toString());
		EnterBillerEmplyEmail(testdatamap.get("EmployeeEmailID").toString());
		EnterBillerCustomerSupPhNo(testdatamap.get("ClientSupPhNum").toString());
		takeScreenShot();
	}

	public String  getPathFile() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//edaat.jpg");
		String sFilename = app.toString();
		return sFilename;
	}

	public void  getAutoItImagePathFile() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		Thread.sleep(800);
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//ImageUpload.exe");
		String sFilename = app.toString();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(800);
	}


	public String  getAuthPathFile() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//SeleniumGrid//attachment//AuthorizationLetterTemplateAttachment.docx)");
		String sFilename = app.toString();
		return sFilename;
	}

	public void enterBankDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterBillerIBANum(testdatamap.get("IBANNumber").toString());
		EnterBillerIBANAttmnt();
		Thread.sleep(2000);
		SelectBillerBankCountry(testdatamap.get("BankAccountType").toString());
		EnterBillerBankCertPath();
		Thread.sleep(2000);
		//verifyElementIsPresent(EdaatOR.Biller_AttachetedImage_Link);
		takeScreenShot();
	}

	public void enterRegistrationInfo(Map<Object,Object> testdatamap) throws Exception {
		SelectBillerCRNumber(testdatamap.get("CRNumber").toString());
		EnterBillerRegiAttachment();
		Thread.sleep(2000);
		EnterBillerRegistDate(testdatamap.get("CRIssueDate").toString());
		Thread.sleep(2000);
		EnterBillerExperyDate(testdatamap.get("CRExpieryDate").toString());
		Thread.sleep(1000);
		String taxable=testdatamap.get("IsTaxable").toString();
		if(taxable.equalsIgnoreCase("Yes")) {
			ClickOnIsTaxableRadBtn();
			EnterBillerTaxno(testdatamap.get("TaxNumber").toString());
		}else {
			ClickOnNoTaxableRadBtn();
		}

		EnterTaxRegisAttmnt();
		Thread.sleep(2000);
		takeScreenShot();
	}


	public void enterAuthorizedPersonInformation(Map<Object,Object> testdatamap) throws Exception {
		EnterBillerFirstName(testdatamap.get("FirstName").toString());
		EnterBillerSurName(testdatamap.get("Surname").toString());
		EnterBillerGradFatherName(testdatamap.get("ThirdName").toString());
		EnterBillerLastName(testdatamap.get("LastName").toString());
		EnterBillerNationalID(testdatamap.get("AuthorizedPersonID").toString());
		EnterBillerCommisionIdentyAtt();
		Thread.sleep(2000);
		EnterBillerMemDumAssoAttmnt();
		Thread.sleep(2000);
		//EnterBillerAuthLterTemltAttmnt(getAuthPathFile());
		EnterBillerAuthLterTemltAttmnt();
		Thread.sleep(2000);
		File classpathRoot = new File(System.getProperty("user.dir")); 
		File app = new File(classpathRoot.getAbsolutePath() +"//SeleniumGrid//attachment//FileUpload.exe"); 
		String sFilename = app.toString(); 
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(2000);
		EnterBillerCommisionPhNo(testdatamap.get("MobileNo").toString());
		EnterBillerCommisionEmail(testdatamap.get("Email").toString());
		takeScreenShot();
	}

	public void enterLoginInfo(Map<Object,Object> testdatamap) {
		EnterBillerUserID(testdatamap.get("UserID").toString());
		EnterBillerPassword(testdatamap.get("Password").toString());
		EnterBillerConfPawd(testdatamap.get("ConPassword").toString());
		takeScreenShot();
	}

	public void BillerRegisterWithNewUserID(Map<Object,Object> testdatamap) {
		try {
			//ClickOnBillerLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("valid")) {
				ClickOnBillerSignUpBtn();
				
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
			//	ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Biller_RegisterComp_btn);
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
			}
			else {
				test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			}
			this.takeScreenShot();
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
		}
	}


	public void BillerRegisterNotBooked(Map<Object,Object> testdatamap) {
		try {
			//ClickOnBillerLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("Invalid")) {
				ClickOnBillerSignUpBtn();
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterBillerCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnBillerConfirmation();
				ClickOnBillerCatchBox();
				ClickOnRegisterBtn();	
				verifyElementIsNotPresent(EdaatOR.Biller_RegisterComp_btn);;
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

}




