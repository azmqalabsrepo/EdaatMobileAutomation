package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
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
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmGridView;
import com.azmqalabs.edaattestautomation.testscripts.admin.AdminTrackerMgmToggleStatus;

public class AdminTrackerBillerManagementPage extends BasePage {

	public AdminTrackerBillerManagementPage(WebDriver driver, ExtentTest test) {
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

	
	public void verifySearchTrackerBiller(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		boolean Ele=CheckElementExists(EdaatOR.Admin_TrackerBillerMangm_Record);
		if(Ele==true) {
			test.log(Status.PASS,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected PASS * " );
			takeScreenShot();
		}else
			test.log(Status.FAIL,"#FUNC-VerifyBillerApprovalIsClosed" + driver.getTitle() +" * Biller is approval is rejected FAIL ");
	}
	
	
	
	public void VerifyGridViewTrackerManagement(Map<Object, Object> testdatamap) throws Exception {

		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminTrackerMgmGridView.record=false;
		}
		else {
			VerifyValue(testdatamap.get("CompanyName").toString(), EdaatOR.Admin_TrackerBillerMangm_CorpName);
			VerifyValue("Corporate", EdaatOR.Admin_TrackerBillerMangm_CorpType);
			VerifyValue("No", EdaatOR.Admin_TrackerBillerMangm_EmailConf);
			verifyElementIsPresent(EdaatOR.Admin_TrackerBillerMangm_ToggleBtn);
			verifyElementIsPresent(EdaatOR.Admin_SystemMgm_EyeIcon);	
			AdminTrackerMgmGridView.record=true;
		}
	}

	
	public void verifyTrackerBillerMgmToggle(Map<Object, Object> testdatamap) throws Exception {
		searchNotApprovedBillerMgm(testdatamap.get("CompanyName").toString());
		Thread.sleep(1000);
		if(CheckElementExists(EdaatOR.Admin_SystemMgm_RecordNotFound)==true) {
			AdminTrackerMgmToggleStatus.record=false;
		}
		else {
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
		AdminTrackerMgmToggleStatus.record=true;
		}
		
	}
	
	
	public void clickOnApproval() throws InterruptedException {

		WebClick(EdaatOR.Admin_SystemMgm_ApprovalBtn);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_SystemMgm_ApprovalYesBtn);
		Thread.sleep(1000);
		waitForPageToLoad();
	}
	
	public void clickOnActivateLink() {

		WebClick(EdaatOR.Admin_SystemMgm_BillerActivateBtn);
	}
	
	
	public void verifyIndividualClientIDClickable() throws Exception {
		String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
		WebClick(EdaatOR.Admin_TrackerBillerMangm_IndiviClenteID);
		waitForPageToLoad();
		switchToWindow();
		String clientIDAfter=getText(EdaatOR.Admin_IndividualClient_RowCount);
		VerifyValue1(clientID, clientIDAfter);
	}
	
	public void verifyCorporateClientIDClickable() throws Exception {
		String clientID=getText(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
		WebClick(EdaatOR.Admin_TrackerBillerMangm_CopoClientID);
		waitForPageToLoad();
		switchToWindow();
		String clientIDAfter=getText(EdaatOR.Admin_IndividualClient_RowCount);
		VerifyValue1(clientID, clientIDAfter);
	}
}
