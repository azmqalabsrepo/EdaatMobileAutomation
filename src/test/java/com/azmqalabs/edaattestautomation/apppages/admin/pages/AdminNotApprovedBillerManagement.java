package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminNotApprovedMgmCloseBiller;

public class AdminNotApprovedBillerManagement extends BasePage {

	public AdminNotApprovedBillerManagement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Admin_SystemMgm_SearchItem)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}


	public void enterOnSearchItem(String searchItem) {

		WebEdit(EdaatOR.Admin_SystemMgm_SearchItem, searchItem);
	}



	public void clickOnSearchBtn() {

		WebClick(EdaatOR.Admin_SystemMgm_Searchbtn);
	}


	public void searchNotApprovedBillerMgm(String Search) throws Exception {
		enterOnSearchItem(Search);
		clickOnSearchBtn();
		waitForPageToLoad();
		Thread.sleep(1000);
	}

	public void clickOnActivateLink() {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}

	public void enterOnBillerActiName(Map<Object, Object> testdatamap) {

		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("ArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("EnglishName").toString());
	}


	public void clickOnIsbiller() {

		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBiller);
	}


	public void clickOnIsbillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_SystemMgm_IsBillerYesBtn);
	}


	public void clickOnSave() {
		WebClick(EdaatOR.Admin_SystemMgm_SavesBtn);
	}


	public void clickOnSaveYeBtn() {
		WebClick(EdaatOR.Admin_SystemMgm_SaveYesBtn);
	}


	public void clickOnClose() {
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalCloseBtn);
	}

	
	public void clickOnIsTrackerBiiller() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBiller);
	}

	public void clickOnIsTrackBillerYesbtn() {
		WebClickUsingJS(EdaatOR.Admin_NotAppmMgm_IsTrackerBillerYesbtn);
	}
	
	public void selectTrackerCheckBox() throws Exception {
		clickOnIsTrackerBiiller();
		Thread.sleep(800);
		clickOnIsTrackBillerYesbtn();
		Thread.sleep(800);
	}
	
	public void enterTempBillerCode(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerCode,Benifi);
	}
	public void enterTempBenificaryName(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTemBenificary,Benifi);
	}
	public void enterDuration(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTransferDura,Benifi);
	}

	
	public void selectSuperTrackerBiller(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_TrackerBillerMangm_SelectNewSuper,Benifi);
	}

	public void selectCategoryID(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
	}

	public void clickOnRejectedLink() throws Exception {
		scrollDowntillend(driver);
		WebClick(EdaatOR.Admin_RejectButton);
		Thread.sleep(1000);
		VerifyValue("Are you sure to reject the biller account information?", EdaatOR.Admin_RejectConfiMessage);
		WebClickUsingJS(EdaatOR.Admin_RejectYesButton);
	}
	
	
	public void EnterBilleDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			clickOnIsbiller();
			Thread.sleep(1000);
			clickOnIsbillerYesbtn();
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
			takeScreenShot();		

		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	public void EnterTrackerBillerDetails(Map<Object, Object> testdatamap){
		try{
			enterTempBenificaryName(testdatamap.get("BenificaryName").toString());
			enterTempBillerCode(testdatamap.get("BillerCode").toString());
			enterDuration(testdatamap.get("Duretion").toString());
			enterOnBillerActiName(testdatamap);
			selectCategoryID(testdatamap.get("BenificaryCategory").toString());
			scrollDowntillend(driver);
			selectTrackerCheckBox();
			Thread.sleep(1000);
			selectSuperTrackerBiller(testdatamap.get("SuperBillerName").toString());
			test.log(Status.PASS,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
			takeScreenShot();		

		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-EnterActivateBilleDetaisl" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	public void clickOnApproval() throws InterruptedException {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}


	public void VerifyBillerIsActivated(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		clickOnApproval();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordApproved);
		if(Ele==true) 
			test.log(Status.PASS,"#FUNC-VerifyBillerIsActivated" + driver.getTitle() +" * Verify Biller is able to save and Approve * " );
		else
			test.log(Status.FAIL,"#FUNC-VerifyBillerIsActivated" + driver.getTitle() +" * Verify Biller is able to save and Approve FAILED* " );	
	}



	public void VerifyClosedBillerForDeactivate(Map<Object, Object> testdatamap) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminNotApprovedMgmCloseBiller.record=false;
		}
		else {
			clickOnActivateLink();
			//EnterBilleDetails(testdatamap);
			Thread.sleep(1000);
			clickOnClose();
			Thread.sleep(1000);
			searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
			takeScreenShot();
			boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
			if(Ele==true) {
				test.log(Status.PASS,"#FUNC-VerifyClosedBillerForDeactivate" + driver.getTitle() +" * Biller is notactive ID PASS * " );
				takeScreenShot();
			}else
				test.log(Status.FAIL,"#FUNC-VerifyClosedBillerForDeactivate" + driver.getTitle() +" * Biller is active FAIL * " );	
			AdminNotApprovedMgmCloseBiller.record=true;
		}
	}







	public void VerifyBillerInavlidActivated(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		VerifyValue("Biller code is already in use", EdaatOR.Admin_SystemMgm_ErrorMeesage);
		test.log(Status.PASS,"#FUNC-VerifyBillerInavlidActivated" + driver.getTitle() +" * Verify Biller is not activate for invalid entry * " );
	}


	public void SaveBillerDetails() throws Exception {
		scrollDowntillend(driver);
		clickOnSave();
		Thread.sleep(1000);
		clickOnSaveYeBtn();
		Thread.sleep(1000);
		takeScreenShot();
	}

	public void VerifyBillerApprovalIsRejected(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		clickOnRejectedLink();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsRejected" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsRejected" + driver.getTitle() +" * Biller is approval is rejected FAIL * " );	
		
	}
	
	
	
	public void VerifyBillerApprovalIsClosed(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		clickOnClose();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotApproved);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected FAIL * " );	
		
	}
	
	public void VerifyGridViewNotManagement(Map<Object, Object> testdatamap) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminNotApprovedMgmCloseBiller.record=false;
		}
		else {
			VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_SystemMgm_CorpName);
			VerifyValue("Corporate", EdaatOR.Admin_SystemMgm_CorpType);
			VerifyValue("No", EdaatOR.Admin_SystemMgm_EmailConf);
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable);
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_EyeIcon);	
			AdminNotApprovedMgmCloseBiller.record=true;
		}
	}

	
	
	public void ApproveBiller(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterBilleDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		takeScreenShot();
		clickOnActivateLink();
		clickOnApproval();
	}
	
	
	public void verifyApproveBillerChecker(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		verifyElementIsNotPresent(EdaatOR.Admin_SystemMgm_RecordUnclickable, "Slid Bar is activated");
		verifyElementIsPresent(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		Thread.sleep(2000);
		takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_ApproveMgn_ToggleBtn);
		Thread.sleep(500);
		takeScreenShot();
		VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
		
	}
	
	
	public void VerifyApprovedGridViewAndUpdate(Map<Object, Object> testdatamap) throws Exception {
		VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_ApprovedMgm_BillerName);
		VerifyValue(testdatamap.get("BillerCode").toString(), EdaatOR.Admin_ApprovedMgm_BillerID);
		VerifyValue("Corporate", EdaatOR.Admin_ApprovedMgm_BillerType);
		VerifyValue("No", EdaatOR.Admin_ApprovedMgm_EmailConf);
		verifyElementIsPresent(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		verifyElementIsPresent(EdaatOR.Admin_ApprovedMgm_EyeIcon);	
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		enterTempBenificaryName(testdatamap.get("UpdatedBillerName").toString());
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasName,testdatamap.get("UpdatedArabicName").toString() );
		WebEdit(EdaatOR.Admin_SystemMgm_BillerAliasEnName, testdatamap.get("UpdatedEnglishName").toString());
		SaveBillerDetails();
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		VerifyValue1(testdatamap.get("UpdatedBillerName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerTemBenificary));
		VerifyValue1(testdatamap.get("UpdatedArabicName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasName));
		VerifyValue1(testdatamap.get("UpdatedEnglishName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasEnName));
		
	}
	
	
	
	public void CreateTrackerBill(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		clickOnActivateLink();
		EnterTrackerBillerDetails(testdatamap);
		SaveBillerDetails();
		takeScreenShot();
		clickOnActivateLink();
		clickOnApproval();
	}
	
}
