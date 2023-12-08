package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerReceivablesExportedbillsPage extends BasePage
{

	public BillerReceivablesExportedbillsPage(WebDriver driver,ExtentTest test)
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
		WebClickUsingJS(EdaatOR.Biller_Receivable_Link);
		waitForPageToLoad();
	}


	public void ClickOnBillerExportBillLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportBill_Link);
		waitForPageToLoad();
	}

	public void ClickOnExportInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
		waitForPageToLoad();
	}

	public void ClickOnCoporateRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
		waitForPageToLoad();
	}

	public void ClickOnIndividualRadBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
		waitForPageToLoad();
	}


	public void SelectCustomerID(String Cust) throws Exception {

		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
		waitForPageToLoad();
	}

	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}

	public void SelectInvoiceTemplate(String Tem) {
		WebSelect(EdaatOR.Biller_Invoice_TemplateList,Tem);
		waitForPageToLoad();
	}


	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
		waitForPageToLoad();
	}


	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
		waitForPageToLoad();
	}

	public void EnterProductPrice(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_TaxPric,Price);
		waitForPageToLoad();
	}

	public void ClickOnProductAddBtn() {
		WebClick(EdaatOR.Biller_Invoice_AddBtn);
		waitForPageToLoad();
	}

	public void EnterIssuedDate() throws Exception {
		WebClick(EdaatOR.Biller_Invoice_DateInvoc);
		Thread.sleep(800);
		WebClick(EdaatOR.Biller_RegistDate_exprDate);
	}


	public void SelectDuration(String dur) {
		WebSelect(EdaatOR.Biller_Invoice_DurationID,dur);
		waitForPageToLoad();
	}

	public void EnterMinPrice(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
		waitForPageToLoad();
	}

	public void EnterCondition() {
		WebClick(EdaatOR.Biller_Invoice_Conditonbtn);
		waitForPageToLoad();
	}

	public void ClickOnCreateInvoiceBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
		waitForPageToLoad();
	}

	public void EnterDescriptionSaved(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
		waitForPageToLoad();
	}

	public void EnterDescriptionOne(String Price) {
		WebEdit(EdaatOR.Biller_Invoice_Descript1,Price);
		waitForPageToLoad();
	}

	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_SaveButton);
		waitForPageToLoad();
	}

	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void ClickOnLastCheckBoxBtn() {
		WebClickUsingJS(EdaatOR.Biller_InvoiceLastCheckBox);
		waitForPageToLoad();
	}

	public String getBillerID() {
		String ID=getText(EdaatOR.Biller_Invoice_GetBilId);
		waitForPageToLoad();
		return ID;
	}

	public String getBillerContactID() {
		String ID=getText(EdaatOR.Biller_Invoice_GetContactId);
		waitForPageToLoad();
		return ID;
	}


	public void ClickOnBillerExportContactLink() {
		WebClickUsingJS(EdaatOR.Biller_ExportContact_Link);
		waitForPageToLoad();
	}


	public void naviagteReveiableExportContact() {
		ClickOnBReceivableLink();
		ClickOnBillerExportContactLink();
		waitForPageToLoad();
	}


	public int getInvoiceCount() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}


	public int getInvoiceCountNext() throws Exception {
		int intiCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextBtn);
			Thread.sleep(1000);
			intiCount=intiCount+getInvoiceCount()+10;
			countRow=true;
		}

		if(countRow==false) {
			intiCount=10;
		}
		return intiCount;
	}


	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddCount));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}

	public int getInvoiceCountNextAfteradd() throws Exception {
		int aftCount=0;
		boolean countRow=false;
		while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
			WebClick(EdaatOR.Biller_Invoice_NextBtn);
			Thread.sleep(1000);
			aftCount=aftCount+getInvoiceCountAdd()+10;
			countRow=true;
		}

		if(countRow==false) {
			aftCount=10;
		}
		return aftCount;
	}

	public void naviagteReveiableExportBiller() {
		ClickOnBReceivableLink();
		ClickOnBillerExportBillLink();
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
		}
		else if(client.equalsIgnoreCase("Corporate")){
			ClickOnCoporateRadBtn();
		}

		SelectCustomerID(testdatamap.get("ClientName").toString());
		String sBill=testdatamap.get("SubBiller").toString();
		if(!sBill.equalsIgnoreCase("")) {
			SelectSubBiller(sBill);
		}

	}


	public void selectTemplate(Map<Object,Object> testdatamap) throws Exception {
		Thread.sleep(500);
		SelectInvoiceTemplate(testdatamap.get("TemplateName").toString());
	}

	public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
		ClickOnProductBtn();
		Thread.sleep(500);
		SelectProduct(testdatamap.get("ProductName").toString());
		//EnterProductPrice(testdatamap.get("ProductPrice").toString());
		ClickOnProductAddBtn();
		Thread.sleep(500);

	}


	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterIssuedDate();
		SelectDuration(testdatamap.get("Duration").toString());
		EnterMinPrice(testdatamap.get("MinPrice").toString());
		EnterCondition();
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
				addProductDetails(testdatamap);
				enterInvoicDetails(testdatamap);
				enterInvoiceCaseSaveType(testdatamap);
				int afterSave=getInvoiceCountNextAfteradd();
				VerifyTwoIntValue(intiCount+1, afterSave);
				int val=getInvoiceCountAdd();
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddCount+"["+val+"]/td[10]"), testdatamap.get("BilStatus").toString());
				test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Save invoice details PASS * " );
			}

		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Individual client" + driver.getTitle() +" * Save Invoice details FAIL * " );
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
				int afterSave=getInvoiceCountNextAfteradd();
				VerifyTwoIntValue(intiCount+1, afterSave);
				int val=getInvoiceCountAdd();
				ValidateTwoValue(getText(EdaatOR.Biller_Invoice_AfteraddCount+"["+val+"]/td[10]"), testdatamap.get("BilStatus").toString());
				VerifyObjectEnabled(driver.findElement(By.xpath(EdaatOR.Biller_ExportExcel)));
				ClickOnLastCheckBoxBtn();
				verifyElementIsPresent(EdaatOR.Biller_Export_CancellationBtn);
				verifyElementIsPresent(EdaatOR.Biller_Export_PayOutsideBtn);
				verifyElementIsPresent(EdaatOR.Biller_Export_ViewContactBtn);
				test.log(Status.PASS,"#FUNC-Verify able to export invoice" + driver.getTitle() +" * Export invoice details PASS * " );
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
			String iType=testdatamap.get("InvoiceType").toString();
			if(iType.equalsIgnoreCase("BIlID")) {
				if(CheckElementExists(EdaatOR.Biller_Invoice_BillNo)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getBillerID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Biller_Invoice_BillNo+"/span");
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Biller_Invoice_BillerNumber), ID);
				WebClick(EdaatOR.Biller_Invoice_PrintButton);

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
				if(CheckElementExists(EdaatOR.Biller_ExportContact_InvID)==false){
					naviagteCreateInvoicePage();
					enterClientNameOrNationalID(testdatamap);
					selectTemplate(testdatamap);
					addProductDetails(testdatamap);
					enterInvoicDetails(testdatamap);
					ID=getBillerContactID();
					enterInvoiceCaseSaveType(testdatamap);
					int afterSave=getInvoiceCountNextAfteradd();
					WebClick(EdaatOR.Biller_Invoice_BillNo+"/span[text(),'"+ID+"']");
				}
				else {
					ID=getText(EdaatOR.Biller_ExportContact_InvID+"/span");
					WebClick(EdaatOR.Biller_ExportContact_InvID+"/span");
				}
				switchToWindow();
				Thread.sleep(1000);
				VerifyValue1(getText(EdaatOR.Biller_ExportContact_ContactHeader), ID);
				verifyElementIsPresent(EdaatOR.Biller_ExportContact_InvoiceDetails);
				WebClick(EdaatOR.Biller_Invoice_PrintButton);
				test.log(Status.PASS,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Bill details PASS * " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Verify Export Contact Clickable and Print" + driver.getTitle() +" * Export Invoice details FAIL * " );
			this.takeScreenShot();
		}
	}


}
