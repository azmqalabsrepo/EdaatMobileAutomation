package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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



public class AdminReceivablesExportedbillsPage extends BasePage
{

	public AdminReceivablesExportedbillsPage(WebDriver driver,ExtentTest test)
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


	public void ClickOnBReceivableLink() {
		WebClickUsingJS(EdaatOR.Admin_Receivable_Link);
		waitForPageToLoad();
	}


	public void ClickOnAdminExportBillLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportBill_Link);
		waitForPageToLoad();
	}

	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_AddInvoice_btn);
		waitForPageToLoad();
	}

	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CopoRdv);
		waitForPageToLoad();
	}

	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_IndividualRdv);
		waitForPageToLoad();
	}


	public void SelectIndCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Admin_Invoice_CustIDList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectCopCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Admin_Invoice_ComCustIDList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectSubAdmin(String SubAdmin) throws InterruptedException {
		//WebSelect1(EdaatOR.Admin_Invoice_SBilIdList,SubAdmin);
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+SubAdmin+"]");
		waitForPageToLoad();
		waitForPageToLoad();
	}

	public void SelectInvoiceTemplate(String Tem) {
		WebSelect(EdaatOR.Admin_Invoice_TemplateList,Tem);
		waitForPageToLoad();
	}


	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}


	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}

	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}

	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Admin_Invoice_AddBtn);
		waitForPageToLoad();
	}

	public void EnterIssuedDate() throws Exception {
		WebClick(EdaatOR.Admin_Invoice_DateInvoc);
		Thread.sleep(800);
		WebClick(EdaatOR.Admin_RegistDate_exprDate);
	}


	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Admin_Invoice_DurationID,dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_MinTax,Price);
		waitForPageToLoad();
	}

	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}

	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_CreateReapeat);
		waitForPageToLoad();
	}

	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Descript1,Price);
		waitForPageToLoad();
	}

	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_SaveButton);
		waitForPageToLoad();
	}

	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void ClickOnLastCheckBoxBtn() {
		WebClickUsingJS(EdaatOR.Admin_InvoiceLastCheckBox);
		waitForPageToLoad();
	}

	public String getAdminID() {
		String ID=getText(EdaatOR.Admin_Invoice_GetBilId);
		waitForPageToLoad();
		return ID;
	}

	public String getAdminContactID() {
		String ID=getText(EdaatOR.Admin_Invoice_GetContactId);
		waitForPageToLoad();
		return ID;
	}


	public void ClickOnAdminExportContactLink() {
		WebClickUsingJS(EdaatOR.Admin_ExportContact_Link);
		waitForPageToLoad();
	}


	public void naviagteReveiableExportContact() {
		ClickOnBReceivableLink();
		ClickOnAdminExportContactLink();
		waitForPageToLoad();
	}


	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}


	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Admin_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Admin_Invoice_Next)==false){  
			WebClick(EdaatOR.Admin_Invoice_NextPrevLink);
			int count=getInvoiceCount();
			String pageNum=getText(EdaatOR.Admin_Invoice_NextPrevLink);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCount()+((Integer.valueOf(pageNum)-1)*10);
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}

	public void naviagteReveiableExportAdmin() {
		ClickOnBReceivableLink();
		ClickOnAdminExportBillLink();
		waitForPageToLoad();
	}

	public void naviagteCreateInvoicePage() {
		ClickOnExportInvoiceBtn();
		waitForPageToLoad();

	}

	public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
		String client=testdatamap.get("ClientID").toString();
		if(client.equalsIgnoreCase("Individual")) {
			ClickOnIndividualRadBtn();
			SelectIndCustomerID(testdatamap.get("ClientName").toString());
		}
		else if(client.equalsIgnoreCase("Corporate")){
			ClickOnCoporateRadBtn();
			SelectCopCustomerID(testdatamap.get("ClientName").toString());
		}
		String sBill=testdatamap.get("SubAdmin").toString();
		if(!sBill.equalsIgnoreCase("")) {
			SelectSubAdmin(sBill);
		}

	}


	public void selectTemplate(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(500);
		SelectInvoiceTemplate(testdatamap.get("TemplateName").toString());
	}

	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(1000);
		SelectProduct(testdatamap.get("ProductName").toString());
		Thread.sleep(2000);
		waitForPageToLoad();
		EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(500);

	}


	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterIssuedDate();
		//SelectDuration(testdatamap.get("Duration").toString());
		//EnterMinPrice(testdatamap.get("MinPrice").toString());
		EnterCondition();
		Thread.sleep(1000);
		ClickOnCreateInvoiceBtn();
		Thread.sleep(1000);
	}


	public void enterInvoiceCaseSaveType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		ClickOnSaveBtn();

		Thread.sleep(1000);
	}


	public void enterInvoiceCaseExportType(Map<Object,Object> testdatamap) throws Exception {
		EnterDescriptionSaved(testdatamap.get("Description").toString());
		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		Thread.sleep(1000);
		ClickOnExportBtn();
	}


	public void createSaveInvoiceData(Map<Object,Object> testdatamap) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Save")) {
				int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				selectTemplate(testdatamap);
				Thread.sleep(1000);
				addProductDetails(testdatamap);
				enterInvoicDetails(testdatamap);
				enterInvoiceCaseSaveType(testdatamap);
				Thread.sleep(2000);
				waitForPageToLoad();
				ClickOnAdminExportBillLink();
				Thread.sleep(2000);
				waitForPageToLoad();
				int afterSave=getInvoiceCountNextAfteradd();
				VerifyTwoIntValue(intiCount+1, afterSave);
				int val=getInvoiceCountAdd();
				ValidateTwoValue(getText(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
				test.log(Status.PASS,"#FUNC-Save Revieviable Invoice Bill" + driver.getTitle() +" * Save invoice details PASS * " );
				takeScreenShot();
			}

		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Revieviable Invoice Bill" + driver.getTitle() +" * Save Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}


	public void createExportInvoiceData(Map<Object,Object> testdatamap) throws Exception {
		try {
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("Export")) {
				int intiCount=getInvoiceCountNext();
				naviagteCreateInvoicePage();
				enterClientNameOrNationalID(testdatamap);
				selectTemplate(testdatamap);
				addProductDetails(testdatamap);
				enterInvoicDetails(testdatamap);
				enterInvoiceCaseExportType(testdatamap);
				Thread.sleep(2000);
				ClickOnAdminExportBillLink();
				Thread.sleep(2000);
				waitForPageToLoad();
				int afterSave=getInvoiceCountNextAfteradd();
				VerifyTwoIntValue(intiCount+1, afterSave);
				int val=getInvoiceCountAdd();
				ValidateTwoValue(getText(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[6]"), testdatamap.get("BilStatus").toString());
				VerifyObjectEnabled(driver.findElement(By.xpath(EdaatOR.Admin_ExportExcel)));
				ClickOnLastCheckBoxBtn();
				verifyElementIsPresent(EdaatOR.Admin_Export_CancellationBtn);
				verifyElementIsPresent(EdaatOR.Admin_Export_PayOutsideBtn);
				verifyElementIsPresent(EdaatOR.Admin_Export_ViewContactBtn);
				test.log(Status.PASS,"#FUNC-Verify able to export invoice" + driver.getTitle() +" * Export invoice details PASS * " );
				this.takeScreenShot();
			}

		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Verify able to export invoice" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}


	public void verifyInvoiceIDandPrint(Map<Object,Object> testdatamap) throws Exception {
		try {
			String ID=null;
			Thread.sleep(1000);
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("BIlID")) {
				Thread.sleep(3000);
				scrollDowntillend(driver);
				if(CheckElementExists(EdaatOR.Admin_Invoice_BillNo)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getAdminID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Admin_Invoice_BillNo+"/span");
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);

				VerifyValue1(getText(EdaatOR.Admin_Invoice_BillerNumber), ID);
				WebClick(EdaatOR.Admin_Invoice_PrintButton);
				takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Verify Bill Number Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}




	public void verifyExportContact(Map<Object,Object> testdatamap) throws Exception {
		try {
			String ID=null;
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("ExportContact")) {
				naviagteReveiableExportContact();
				Thread.sleep(1000);
				if(CheckElementExists(EdaatOR.Admin_ExportContact_InvID)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getAdminContactID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Admin_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Admin_ExportContact_InvID+"/span");
					WebClick(EdaatOR.Admin_ExportContact_InvID+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Admin_ExportContact_ContactHeader), ID);
				verifyElementIsPresent(EdaatOR.Admin_ExportContact_InvoiceDetails);
				WebClick(EdaatOR.Admin_Invoice_PrintButton);
				test.log(Status.PASS,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}

	public void getInvoiceDetails(Map<Object,Object> testdatamap) throws Exception {
		testdatamap.put("InvoiceID",getText(EdaatOR.Admin_ExportBille_InvoiceID));
	}

}
