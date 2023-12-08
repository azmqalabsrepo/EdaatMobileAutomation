package com.azmqalabs.edaattestautomation.apppages.admin.pages;

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



public class AdminSignUpPage extends BasePage
{

	public AdminSignUpPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Admin_Client)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}


	public void ClickOnAdminLogin() {
		WebClickUsingJS(EdaatOR.Admin_Link);
		waitForPageToLoad();
	}


	public void ClickOnAdminSignUpBtn() {
		WebClickUsingJS(EdaatOR.Admin_SignUp_Btn);
		waitForPageToLoad();
	}

	public void EnterAdminCompanyName(String CompName) {
		WebEdit(EdaatOR.Admin_CompanyName_eField,CompName);
	}


	public void SelectAdminEconomySector(String EconomySector) {
		WebSelect1(EdaatOR.Admin_EconomySector_List,EconomySector);
	}


	public void SelectAdminCountry(String Country) {
		WebSelect1(EdaatOR.Admin_Country_List,Country);
	}

	public void SelectAdminCity(String City) {
		WebSelect1(EdaatOR.Admin_City_List,City);
	}

	public void EnterAdminDistrict(String District) {
		WebEdit(EdaatOR.Admin_District_eField,District);
	}

	public void EnterAdminStreet(String Street) {
		WebEdit(EdaatOR.Admin_Street_eField,Street);
	}
	public void EnterAdminBuildNo(String BuildNo) {
		WebEdit(EdaatOR.Admin_BuildNo_eField,BuildNo);
	}

	public void EnterAdminPostalCode(String PostalCode) {
		WebEdit(EdaatOR.Admin_PostalCode_eField,PostalCode);
	}

	public void EnterAdminMailBox(String MailBox) {
		WebEdit(EdaatOR.Admin_MailBox_eField,MailBox);
	}

	public void EnterAdminOfficNo(String OfficNo) {
		WebEdit(EdaatOR.Admin_OfficNo_eField,OfficNo);
	}

	public void EnterAdminEmplyName(String EmplyName) {
		WebEdit(EdaatOR.Admin_EmplyName_eField,EmplyName);
	}
	public void EnterAdminEmplyJobTitle(String EmplyJobTitle) {
		WebEdit(EdaatOR.Admin_EmplyJobTitle_eField,EmplyJobTitle);
	}

	public void EnterAdminEmplyMobileNum(String EmplyMob) {
		WebEdit(EdaatOR.Admin_EmplyMobileNumber_eField,EmplyMob);
	}

	public void EnterAdminEmplyEmail(String EmplyEmail) {
		WebEdit(EdaatOR.Admin_EmplyEmail_eField,EmplyEmail);
	}


	public void EnterAdminCustomerSupPhNo(String CustomerSupPhNo) {
		WebEdit(EdaatOR.Admin_CustomerSupPhNo_eField,CustomerSupPhNo);
	}

	public void EnterAdminIBANum(String IBANum) {
		WebEdit(EdaatOR.Admin_IBANum_eField,IBANum);
	}

	public void EnterAdminIBANAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_IBANAttmnt_eField);
		getAutoItImagePathFile();
	}


	public void SelectAdminBankCountry(String BankCountry) {
		WebSelect(EdaatOR.Admin_BankCountryType_List,BankCountry);
	}


	public void EnterAdminBankCertPath() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_BankCertAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void SelectAdminCRNumber(String CRNumber) {
		WebSelect(EdaatOR.Admin_CRNumber_eField,CRNumber);
	}


	public void EnterAdminRegiAttachment() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_RegiAttachment_eField);
		getAutoItImagePathFile();
	}

	public void EnterAdminRegistDate(String RegistDate) throws Exception {
		//WebEdit(EdaatOR.Admin_RegistDate_eField,RegistDate);
		WebClick(EdaatOR.Admin_RegistDate_eField);
		//WebClickUsingJS(EdaatOR.Admin_RegistDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_RegistDate_Issuedate);
	}

	public void EnterAdminExperyDate(String ExperyDate) throws InterruptedException {
		//WebEdit(EdaatOR.Admin_ExperyDate_eField,ExperyDate);
		WebClick(EdaatOR.Admin_ExperyDate_eField);
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
	}


	public void EnterAdminTaxno(String Taxno) {
		WebEdit(EdaatOR.Admin_Taxno_eField,Taxno);
	}

	public void ClickOnIsTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_IsTaxable_RadBtn);
	}

	public void ClickOnNoTaxableRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_NoTaxable_RadBtn);
	}

	public void EnterTaxRegisAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_TaxRegisAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterAdminFirstName(String FirstName) {
		WebEdit(EdaatOR.Admin_FirstName_eField,FirstName);
	}


	public void EnterAdminSurName(String SurName) {
		WebEdit(EdaatOR.Admin_SurName_eField,SurName);
	}
	public void EnterAdminGradFatherName(String GradFatherName) {
		WebEdit(EdaatOR.Admin_GradFatherName_eField,GradFatherName);
	}
	public void EnterAdminLastName(String LastName) {
		WebEdit(EdaatOR.Admin_LastName_eField,LastName);
	}
	public void EnterAdminNationalID(String NationalID_) {
		WebEdit(EdaatOR.Admin_NationalID_eField,NationalID_);
	}
	public void EnterAdminCommisionIdentyAtt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_CommisionIdentyAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterAdminMemDumAssoAttmnt() throws Exception {
		WebClickUsingActions(EdaatOR.Admin_MemDumAssoAttmnt_eField);
		getAutoItImagePathFile();
	}

	public void EnterAdminAuthLterTemltAttmnt(String AuthLterTemltAttmnt) {
		WebEdit(EdaatOR.Admin_AuthLterTemltAttmnt_eField, AuthLterTemltAttmnt);
	}

	public void EnterAdminAuthLterTemltAttmnt() {
		//WebClick(EdaatOR.Admin_AuthLterTemltAttmnt_eField);
		WebClickUsingActions(EdaatOR.Admin_AuthLterTemltAttmnt_eField);
	}

	public void EnterAdminCommisionPhNo(String CommisionPhNo) {
		WebEdit(EdaatOR.Admin_CommisionPhNo_eField,CommisionPhNo);
	}
	public void EnterAdminCommisionEmail(String CommisionEmail) {
		WebEdit(EdaatOR.Admin_CommisionEmail_eField,CommisionEmail);
	}
	public void EnterAdminUserID(String UserID) {
		WebEdit(EdaatOR.Admin_UserID_eField,UserID);
	}


	public void EnterAdminPassword(String Password) {
		WebEdit(EdaatOR.Admin_Password_eField,Password);
	}
	public void EnterAdminConfPawd(String ConfPawd) {
		WebEdit(EdaatOR.Admin_ConfPawd_eField,ConfPawd);
	}
	public void ClickOnAdminConfirmation() {
		WebClickUsingJS(EdaatOR.Admin_Confirmation_CheckBox);
		takeScreenShot();
	}

	public void ClickOnAdminCatchBox() throws Exception {
		swithchToFrame(EdaatOR.Admin_ReCatchBox_eField);
		WebClickUsingJS(EdaatOR.Admin_CatchBox_eField);
		driver.switchTo().defaultContent();
	}


	public void ClickOnRegisterBtn() {
		WebClickUsingJS(EdaatOR.Admin_SignUp_btn);
	}

	public void ClickOnCloseBtn() {
		WebClickUsingJS(EdaatOR.Admin_Close_btn);
	}

	public void enterCompanyName(Map<Object,Object> testdatamap) {
		EnterAdminCompanyName(testdatamap.get("CompanyName").toString());
		takeScreenShot();
	}

	public void enterEconomySectorDetails(Map<Object,Object> testdatamap) {
		SelectAdminEconomySector(testdatamap.get("EmpySector").toString());
		takeScreenShot();
	}

	public void enterAdminCountyDetails(Map<Object,Object> testdatamap) {
		SelectAdminCountry(testdatamap.get("BCounty").toString());
		SelectAdminCity(testdatamap.get("BCity").toString());
		EnterAdminDistrict(testdatamap.get("BDistric").toString());
		EnterAdminStreet(testdatamap.get("Street").toString());
		EnterAdminBuildNo(testdatamap.get("BuildNum").toString());
		EnterAdminPostalCode(testdatamap.get("ZipCode").toString());
		EnterAdminMailBox(testdatamap.get("AdditionalNum").toString());
		EnterAdminOfficNo(testdatamap.get("UnitNum").toString());
	}

	public void enterContactInfo(Map<Object,Object> testdatamap) {
		EnterAdminEmplyName(testdatamap.get("EmployeeName").toString());
		EnterAdminEmplyJobTitle(testdatamap.get("EmployeePosition").toString());
		EnterAdminEmplyMobileNum(testdatamap.get("EmployeeMobNumber").toString());
		EnterAdminEmplyEmail(testdatamap.get("EmployeeEmailID").toString());
		EnterAdminCustomerSupPhNo(testdatamap.get("ClientSupPhNum").toString());
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
		EnterAdminIBANum(testdatamap.get("IBANNumber").toString());
		EnterAdminIBANAttmnt();
		Thread.sleep(2000);
		SelectAdminBankCountry(testdatamap.get("BankAccountType").toString());
		EnterAdminBankCertPath();
		Thread.sleep(2000);
		//verifyElementIsPresent(EdaatOR.Admin_AttachetedImage_Link);
		takeScreenShot();
	}

	public void enterRegistrationInfo(Map<Object,Object> testdatamap) throws Exception {
		SelectAdminCRNumber(testdatamap.get("CRNumber").toString());
		EnterAdminRegiAttachment();
		Thread.sleep(2000);
		EnterAdminRegistDate(testdatamap.get("CRIssueDate").toString());
		Thread.sleep(2000);
		EnterAdminExperyDate(testdatamap.get("CRExpieryDate").toString());
		Thread.sleep(1000);
		String taxable=testdatamap.get("IsTaxable").toString();
		if(taxable.equalsIgnoreCase("Yes")) {
			ClickOnIsTaxableRadBtn();
			EnterAdminTaxno(testdatamap.get("TaxNumber").toString());
		}else {
			ClickOnNoTaxableRadBtn();
		}

		EnterTaxRegisAttmnt();
		Thread.sleep(2000);
		takeScreenShot();
	}


	public void enterAuthorizedPersonInformation(Map<Object,Object> testdatamap) throws Exception {
		EnterAdminFirstName(testdatamap.get("FirstName").toString());
		EnterAdminSurName(testdatamap.get("Surname").toString());
		EnterAdminGradFatherName(testdatamap.get("ThirdName").toString());
		EnterAdminLastName(testdatamap.get("LastName").toString());
		EnterAdminNationalID(testdatamap.get("AuthorizedPersonID").toString());
		EnterAdminCommisionIdentyAtt();
		Thread.sleep(2000);
		EnterAdminMemDumAssoAttmnt();
		Thread.sleep(2000);
		//EnterAdminAuthLterTemltAttmnt(getAuthPathFile());
		EnterAdminAuthLterTemltAttmnt();
		Thread.sleep(2000);
		File classpathRoot = new File(System.getProperty("user.dir")); 
		File app = new File(classpathRoot.getAbsolutePath() +"//SeleniumGrid//attachment//FileUpload.exe"); 
		String sFilename = app.toString(); 
		Runtime.getRuntime().exec(sFilename);
		Thread.sleep(2000);
		EnterAdminCommisionPhNo(testdatamap.get("MobileNo").toString());
		EnterAdminCommisionEmail(testdatamap.get("Email").toString());
		takeScreenShot();
	}

	public void enterLoginInfo(Map<Object,Object> testdatamap) {
		EnterAdminUserID(testdatamap.get("UserID").toString());
		EnterAdminPassword(testdatamap.get("Password").toString());
		EnterAdminConfPawd(testdatamap.get("ConPassword").toString());
		takeScreenShot();
	}

	public void AdminRegisterWithNewUserID(Map<Object,Object> testdatamap) {
		try {
			//ClickOnAdminLogin();
			
				ClickOnAdminSignUpBtn();
				
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterAdminCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterAuthorizedPersonInformation(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnAdminConfirmation();
			//	ClickOnAdminCatchBox();
				ClickOnRegisterBtn();	
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_RegisterComp_btn);
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
				takeScreenShot();
			
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
		}
	}


	public void AdminRegisterNotBooked(Map<Object,Object> testdatamap) {
		try {
			//ClickOnAdminLogin();
			if(testdatamap.get("SignUpDate").toString().equalsIgnoreCase("Invalid")) {
				ClickOnAdminSignUpBtn();
				enterCompanyName(testdatamap);
				enterEconomySectorDetails(testdatamap);
				enterAdminCountyDetails(testdatamap);
				enterContactInfo(testdatamap);
				enterBankDetails(testdatamap);
				enterRegistrationInfo(testdatamap);
				enterLoginInfo(testdatamap);
				ClickOnAdminConfirmation();
				ClickOnAdminCatchBox();
				ClickOnRegisterBtn();	
				verifyElementIsNotPresent(EdaatOR.Admin_RegisterComp_btn);;
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}

}




