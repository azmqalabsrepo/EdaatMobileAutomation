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

public class AdminApprovedBillerManagement extends BasePage {

	public AdminApprovedBillerManagement(WebDriver driver, ExtentTest test) {
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

	public void enterTempBillerCode(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerCode,Benifi);
	}
	public void enterTempBenificaryName(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTemBenificary,Benifi);
	}
	public void enterDuration(String Benifi) {
		WebEdit(EdaatOR.Admin_SystemMgm_BillerTransferDura,Benifi);
	}

	public void selectCategoryID(String Benifi) {
		WebSelectByVisibleText(EdaatOR.Admin_SystemMgm_BillerCategoryID,Benifi);
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
		clickOnSave();
		Thread.sleep(1000);
		clickOnSaveYeBtn();
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
		Thread.sleep(1000);
		VerifyValue1(testdatamap.get("UpdatedBillerName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerTemBenificary));
		VerifyValue1(testdatamap.get("UpdatedArabicName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasName));
		VerifyValue1(testdatamap.get("UpdatedEnglishName").toString(), WebGetTextAttribute(EdaatOR.Admin_SystemMgm_BillerAliasEnName));

	}
}
