package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;



public class AdminCorporatePage extends BasePage
{

	public AdminCorporatePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_Corporate)
	public WebElement Client;


	public boolean Exists(){
		return super.Exists(Client); 
	}


	public void AddCorporateclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno){
		try{
			AddCorpclient(CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno);
			boolean Ele=BillerSearchCorporateclient(ClientRefno);
			if(Ele==true)
				test.log(Status.PASS,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client PASS * " );
			else
				test.log(Status.FAIL,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Add Corporate client" + driver.getTitle() +" * Add Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	public boolean BillerSearchCorporateclient(String ClientRefno){
		boolean existsElement = false;
		try{

			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,ClientRefno);
			Thread.sleep(500);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			Thread.sleep(1000);
			if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
				existsElement=true;
			}
			this.takeScreenShot();	    	

		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsElement;
	}
	public void TableGridview(String CorporateName){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);    
			if(CheckElementExists(EdaatOR.Admin_Corporateclient_tbl)==true) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_Corporateclient_search);
				WebEdit(EdaatOR.Admin_Corporateclient_search,CorporateName);        			
				WebClick(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(1000);
				WebClick(EdaatOR.Admin_Individualclient_Searchname);
				Thread.sleep(1000);
				switchTonextwindow();
				scrollDowntillend(driver);
				this.takeScreenShot();
				WebClick(EdaatOR.Admin_Individualclient_Back);
				test.log(Status.PASS,"#FUNC-Corporate Client Table Exists" + driver.getTitle() +" * Corporatee Client Table Exists PASS * " );
			}       		
			else {
				test.log(Status.FAIL,"#FUNC-Corporate Client Table Not Exists" + driver.getTitle() +" * Corporate Client Table Not Exists FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Table View Corporate client" + driver.getTitle() +" * Table View Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	public void ActivateDactivate(String CorporateName, Map<Object, Object>testdatamap){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);  
			if(CheckElementClickable(EdaatOR.Admin_Corporateclient_search)==true) {
				WebEdit(EdaatOR.Admin_Corporateclient_search,CorporateName);        			
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(2000);
				verifyElementIsPresent(EdaatOR.Admin_Company_ToggleBtn);
				WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
				Thread.sleep(500);
				takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Company_ToggleBtn);
				Thread.sleep(500);
				takeScreenShot();
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				
				
				test.log(Status.PASS,"#FUNC-Corporate Client Deactivate/Activate Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Done PASS * " );
			}	   		
			else {
				test.log(Status.FAIL,"#FUNC-Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Corporate Client Deactivate/Activate Not Done FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Corporate Client Deactivate/Activate Not Done" + driver.getTitle() +" * Table View Corporate client Not Done * " );
			this.takeScreenShot();
		}
	}

	public void Export(){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);  
			if(CheckElementClickable(EdaatOR.Admin_Corporateclient_search)==true) {
				WebClick(EdaatOR.Admin_Individualclient_export);
				Thread.sleep(2000);    
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Export Done" + driver.getTitle() +" * Export Done PASS * " );
			}	   		
			else {
				test.log(Status.FAIL,"#FUNC-Export Not Done" + driver.getTitle() +" * Export Not Done FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Export Not Done" + driver.getTitle() +" * Export Not Done * " );
			this.takeScreenShot();
		}
	}


	public boolean AdminSearchCorporateclientall(String CRNumber,String CorporateName,String Corporateno){
		boolean existsElement = false;
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_Corporateclient_name,CorporateName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,CRNumber);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,Corporateno);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
			existsElement=ExistsCheck("//td[text()='"+CRNumber+"']");
			if(existsElement==true) {
				test.log(Status.PASS,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client PASS * " );
			}
			else {
				test.log(Status.FAIL,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
			}
			Thread.sleep(1000);
			this.takeScreenShot();

		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Search Corporate client" + driver.getTitle() +" * Search Corporate client FAIL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}

	public void AddCorpclient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno){
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Add_Individualclient_Button);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Corporateclient_name,CorporateName);
			WebEdit(EdaatOR.Admin_Corporateclient_Rno,CRNumber);
			WebClick(EdaatOR.Admin_Corporateclient_lang);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner,PersonName);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID,PersonID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email,Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile,MobileNo);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno,ClientRefno);	
			Thread.sleep(1000);            	
			this.takeScreenShot();
			Thread.sleep(1000);   
			WebClick(EdaatOR.Admin_Individualclient_Add);

		}catch(Exception e){
			e.printStackTrace();
			this.takeScreenShot();
		}
	}
	public void DeleteCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String MobileNo,String Email,String ClientRefno, String ResonforDelete){
		try{
			AddCorpclient(CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno );
			BillerSearchCorporateclient(ClientRefno);
			boolean Ele=DeleteCorpClient(ClientRefno,ResonforDelete);
			if(Ele==true)
				test.log(Status.PASS,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client PASS * " );
			else
				test.log(Status.FAIL,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Delete Corporate client" + driver.getTitle() +" * Delete Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}

	public boolean DeleteCorpClient(String ClientRefno,String ResonforDelete){
		boolean existsNID = false;
		try{
			if(getText("//td[text()='"+ClientRefno+"']").equals(ClientRefno)){
				selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Delete");
				WebClick(EdaatOR.Admin_Invoice_Reasontxt);
				Thread.sleep(1000);
				WebClick("//ul/li[contains(text(),'"+ResonforDelete+"')]");
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				WebEdit(EdaatOR.Admin_Individualclient_CustomerRefNumber,ClientRefno);
				WebClick(EdaatOR.Admin_Invoice_Deletechkbox);
				WebClickUsingJS(EdaatOR.Admin_Individualclient_Search);
				Thread.sleep(2000);
				if(CheckElementExists("//td[text()='"+ClientRefno+"']")==true) {
					existsNID=true;
				}
				this.takeScreenShot();	    	
			}

		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	public void UpdateCorporateClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email){
		try{

			boolean Ele=UpdateCorpClient(CorporateName, CRNumber, PersonName, PersonID, ClientRefno,MobileNo, Email);
			if(Ele==true)
				test.log(Status.PASS,"#FUNC-Updated  Corporate client" + driver.getTitle() +" * Updated Corporate client PASS * " );
			else
				test.log(Status.FAIL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Updated Corporate client" + driver.getTitle() +" * Updated Corporate client FAIL * " );
			this.takeScreenShot();
		}
	}





	public boolean UpdateCorpClient(String CorporateName,String CRNumber,String PersonName,String PersonID,String ClientRefno,String MobileNo,String Email){
		boolean existsNID = false;
		try{
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);	    	
			selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
			switchTonextwindow();    	
			WebClear(EdaatOR.Admin_Corporateclient_name);
			WebEdit(EdaatOR.Admin_Corporateclient_name,CorporateName);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner,PersonName);
			WebClear(EdaatOR.Admin_Corporateclient_commissionerID);
			WebEdit(EdaatOR.Admin_Corporateclient_commissionerID,PersonID);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Mobile);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Mobile,MobileNo);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Email);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Email,Email);
			WebClear(EdaatOR.Admin_Corporateclient_commissioner_Crno);
			WebEdit(EdaatOR.Admin_Corporateclient_commissioner_Crno,ClientRefno);
			Thread.sleep(1000);
			this.takeScreenShot();	 
			WebClickUsingJS(EdaatOR.Admin_Corporateclient_Save);
			Thread.sleep(1000);
			if(CheckElementExists("//span[text()='"+CorporateName+"']")==true) {
				existsNID=true;
			}


		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	public void selectSubbiller(Map<Object,Object> testdatamap) throws Exception {
		WebClick(EdaatOR.Admin_Invoice_SBilIdList);
		Thread.sleep(1000);
		WebClick(EdaatOR.Admin_Invoice_ClientRoleId+"["+testdatamap.get("SubBiller").toString()+"]");
		waitForPageToLoad();
		waitForPageToLoad();
	}
	public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
		Thread.sleep(500);
		selectDropdownValue_PartialText(sel, Tem);
	}
	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_AddProductBtn);
		waitForPageToLoad();
	}
	public void SelectProduct(String Cust) {
		WebSelect(EdaatOR.Admin_Invoice_ProductID,Cust);
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
	public void EnterFixedPrice(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Fixed,Price);
		waitForPageToLoad();
	}
	public void ClickOnSaveBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Create);
		waitForPageToLoad();
	}
	public void ClickOnExportBtn() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_ExportButton);
		waitForPageToLoad();
	}

	public void EnterCondition(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Conditon,Price);
		waitForPageToLoad();
	}
	public void EnterPercentage(String Price) {
		WebEdit(EdaatOR.Admin_Invoice_Percentage,Price);
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
	public void WebSelectByVisibleText(String sEleXpath, String sText) {
		try {
			Select select = new Select(driver.findElement(By.xpath(sEleXpath)));
			select.selectByVisibleText(sText);
		} catch (Exception e) {
			// Code to reset implicit wait and select value and then reset implicit wait
			Select select1 = new Select(driver.findElement(By.xpath(sEleXpath)));
			select1.selectByVisibleText(sText);
			test.log(Status.INFO, "WebSelectByVisibleText - Not Found");
		}
	}
	public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

		Thread.sleep(500);	
		waitForPageToLoad();

		waitForPageToLoad();
	}
	
	public void EnterProductPrice(String Price) throws Exception {
		Thread.sleep(1000);
		WebClearUsingKeys(EdaatOR.Admin_Invoice_TaxPric);
		WebEdit(EdaatOR.Admin_Invoice_TaxPric,Price);
		waitForPageToLoad();
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
	public void EnterCondition() {
		WebClickUsingJS(EdaatOR.Admin_Invoice_Conditonbtn);
		waitForPageToLoad();
	}
	public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
		EnterIssuedDate();
		EnterCondition();
		Thread.sleep(1000);
	}
	public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {

		//		EnterDescriptionSaved(testdatamap.get("Description").toString());
		//		EnterDescriptionOne(testdatamap.get("Description").toString());
		String iType=testdatamap.get("InvoiceType").toString();
		if(iType.equalsIgnoreCase("Save")) {
			ClickOnSaveBtn();
		}
		else if(iType.equalsIgnoreCase("Export")){
			ClickOnExportBtn();
		}
		Thread.sleep(1000);
	}
	public int getInvoiceCountAdd() {
		List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
		waitForPageToLoad();
		int count =invoice.size();
		return count;
	}


	public void CreateCorporateClientInvoice(Map<Object,Object> testdatamap) throws Exception {
		try {
			WebClickUsingJS(EdaatOR.Admin_Add_Companyclient);
			Thread.sleep(1000);	    	
			selectDropdownValue_PartialText(EdaatOR.Admin_Invoice_Delete,"Create Invoice");
			switchTonextwindow();
			selectSubbiller(testdatamap);
			Thread.sleep(1000);
			WebSelect(EdaatOR.Admin_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			waitForPageToLoad();
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			Thread.sleep(800);
			ClickOnSaveBtn();
			Thread.sleep(2000);
			waitForPageToLoad();
			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Admin_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				test.log(Status.PASS,"#FUNC- Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice PASS * " );
			}
			else{
				test.log(Status.FAIL,"#FUNC- Create Corporate Client Invoice" + driver.getTitle() +" *Create Corporate Client Invoice FAIL * " );
			}
			this.takeScreenShot();


		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Create Corporate Client Invoice" + driver.getTitle() +" * Create Corporate Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}


}
