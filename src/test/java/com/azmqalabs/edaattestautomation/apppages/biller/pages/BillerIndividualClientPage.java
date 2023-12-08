package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerIndividualClientPage extends BasePage
{

	public BillerIndividualClientPage(WebDriver driver,ExtentTest test)
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

	
	public void AddIndividualclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
        try{
        		Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
        		boolean Ele=BillerSearchIndividualclient(NationalID);
	        	if(Ele==true)
	        		test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
        	else
    	    	test.log(Status.FAIL,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
    	}catch(Exception e){
    	test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
            this.takeScreenShot();
        	}
    	}
	
	public void TableGridview(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	    
	    	if(CheckElementExists(EdaatOR.Biller_Invoice_table)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_Individualclient_SearchByname);
    			WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "client");        			
    			WebClick(EdaatOR.Biller_Individualclient_Search);
    			Thread.sleep(1000);
    			WebClick(EdaatOR.Biller_Corpclient_Searchname);
    			Thread.sleep(1000);
    			switchTonextwindow();
    			scrollDowntillend(driver);
    			this.takeScreenShot();
    			WebClick(EdaatOR.Biller_Individualclient_Back);
    			test.log(Status.PASS,"#FUNC-Individual Client Table Exists" + driver.getTitle() +" * Individual Client Table Exists PASS * " );
	    		}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Individual Client Table Not Exists" + driver.getTitle() +" * Individual Client Table Not Exists FAIL * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FATAL,"#FUNC-Table View Individual client" + driver.getTitle() +" * Table View Individual client FAIL * " );
	        this.takeScreenShot();
	    }
	}
	
	
	public void Export(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementClickable(EdaatOR.Biller_Individualclient_export)==true) {
	    		WebClick(EdaatOR.Biller_Individualclient_export);
				Thread.sleep(2000);    			
				test.log(Status.PASS,"#FUNC-Export Individual client Done" + driver.getTitle() +" * Export Individual client Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Export Individual client Not Done" + driver.getTitle() +" * Export Individual client Not Done FAIL  * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FATAL," #FUNC-Export Individual client Not Done " + driver.getTitle() +" * Export Individual client Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	
	
	public void ActivateDeactivate(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementExists(EdaatOR.Biller_Individualclient_Deactivate)==true) {
	    		WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "client");        			
				WebClick(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Individual Client Deactivate/Activate Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Individual Client Deactivate/Activate Not Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL  * " );
	    		}
	    }catch(Exception e){
	    	test.log(Status.FATAL," #FUNC-Individual Client Deactivate/Activate Not Done " + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	

public void Download(Map<Object,Object> testdatamap){
    try{
    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(2000);
		boolean Ele=BillerSearchIndividualclient(testdatamap.get("NationalID").toString());
    	if(Ele==true) {
    		test.log(Status.PASS,"#FUNC-Download ID " + driver.getTitle() +" * Download ID PASS * " );
    		WebClick(EdaatOR.Biller_InvoiceName);
    		switchTonextwindow();
    		WebClick(EdaatOR.Biller_Imgdownload);
    	}else
	    	test.log(Status.FAIL,"#FUNC-Download ID" + driver.getTitle() +" * Download ID FAIL * " );
	}catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Download ID" + driver.getTitle() +" * Download ID FAIL * " );
	this.takeScreenShot();
	}
}

public boolean BillerSearchIndividualclient(String NationalID){
	boolean existsElement = false;
	try{
             	
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	Thread.sleep(2000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
        	Thread.sleep(1000);
        	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
        		existsElement=true;
		    }
	    	this.takeScreenShot();	    	
	    
    }catch(Exception e){
    	e.printStackTrace();
   	 	this.takeScreenShot();
    }
    return existsElement;
}

public boolean BillerSearchIndividualclientall(String ClientName,String NationalID,String Refno){
	boolean existsElement = false;
	try{
			WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
        	Thread.sleep(2000);
        	WebEdit(EdaatOR.Biller_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,Refno);
			Thread.sleep(1000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
        	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
			Thread.sleep(1000);
			this.takeScreenShot();
       	
    }catch(Exception e){
//       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
        this.takeScreenShot();
    }
    return existsElement;
}

public void Addclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
    try{
            WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
        	Thread.sleep(1000);
        	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient_Button);
        	Thread.sleep(1000);
        	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
        	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
        	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
        	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
        	WebClick("//a[text()='"+Date+"']");
        	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
        	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
        	Thread.sleep(1000);            	
        	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
        	this.takeScreenShot();
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
        	
    }catch(Exception e){
    	 e.printStackTrace();
    	 this.takeScreenShot();
    }
}
public void DeleteIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ResonforDelete){
    try{
    		Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
        	BillerSearchIndividualclient(NationalID);
        	boolean Ele=DeleteIndClient(NationalID,ResonforDelete);
        	if(Ele==true)
        	test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
        	else
    	    	test.log(Status.FAIL,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FATAL,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
        this.takeScreenShot();
    }
}

public boolean DeleteIndClient(String NationalID,String ResonforDelete){
	boolean existsNID = false;
	try{
    	if(getText("//td[text()='"+NationalID+"']").equals(NationalID)){
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Delete");
    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	WebClick("//li[text()='"+ResonforDelete+"']");
    	WebClick(EdaatOR.Biller_Invoice_Deletebtn);
    	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
    	WebClick(EdaatOR.Biller_Invoice_Deletechkbox);
    	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
    	Thread.sleep(2000);
    	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
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
public void UpdateIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email){
    try{
    		
        	boolean Ele=UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month,Date, MobileNo, Email);
        	if(Ele==true)
        	test.log(Status.PASS,"#FUNC-Updated  Individual client" + driver.getTitle() +" * Updated Individual client PASS * " );
        	else
    	    	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FATAL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
        this.takeScreenShot();
    }
}



public boolean UpdateIndClient(String FullName,String SecondName,String ThirdName,String LastName,String Year,String Month,String Date,String MobileNo,String Email){
	boolean existsNID = false;
	try{
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
//	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	switchTonextwindow();
    	WebClear(EdaatOR.Biller_Individualclient_fname);
    	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
    	WebClear(EdaatOR.Biller_Individualclient_sname);
    	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
    	WebClear(EdaatOR.Biller_Individualclient_tname);
    	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
    	WebClear(EdaatOR.Biller_Individualclient_lname);
    	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
    	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
    	WebClick("//a[text()='"+Date+"']");
    	WebClear(EdaatOR.Biller_Individualclient_MobileNo);
    	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
    	WebClear(EdaatOR.Biller_Individualclient_Email);
    	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
    	this.takeScreenShot();	
    	WebClick(EdaatOR.Biller_Individualclient_Add);
    	Thread.sleep(2000);
    	if(CheckElementExists("//td[text()='"+MobileNo+"']")==true) {
	    	existsNID=true;
	    }
    	   	
    	    	
    }catch (Exception e) {
    	e.printStackTrace();
   	 	this.takeScreenShot();
	}
	return existsNID;
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
public int getInvoiceCount() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}
public void naviagteCreateInvoicePage() {
	ClickOnExportInvoiceBtn();
	waitForPageToLoad();

}
public void ClickOnExportInvoiceBtn() {
	WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
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
	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}
public void SelectCustomerID(String Cust) throws Exception {
		
		WebClick(EdaatOR.Biller_Invoice_CustIDList);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
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
public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {

	Thread.sleep(500);	
	waitForPageToLoad();
	
	waitForPageToLoad();
}
public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
	Thread.sleep(500);
	WebClickUsingJS(EdaatOR.Biller_Invoice_Subbill);
	SelectInvoiceTemplate(drop,testdatamap.get("SubBiller").toString());
	waitForPageToLoad();
	EnterFixedPrice(testdatamap.get("FixedPrice").toString());
	EnterPercentage(testdatamap.get("FixedPercentage").toString());
	
}
public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
	Thread.sleep(500);
	selectDropdownValue_PartialText(sel, Tem);
}
public void ClickOnProductBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
	waitForPageToLoad();
}
public void SelectProduct(String Cust) {
	WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
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
public void EnterFixedPrice(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Fixed,Price);
	waitForPageToLoad();
}


public void EnterCondition(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
	waitForPageToLoad();
}
public void EnterPercentage(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Percentage,Price);
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
public void ClickOnExportBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
	waitForPageToLoad();
}

public void ClickOnSaveBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_Create);
	waitForPageToLoad();
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
//		SelectDuration(testdatamap.get("Duration").toString());
//		EnterMinPrice(testdatamap.get("MinPrice").toString());
//		EnterCondition(testdatamap.get("InvoiceCondition").toString());
//		ClickOnCreateInvoiceBtn();
	Thread.sleep(1000);
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

public void CreateIndividualClientInvoice(Map<Object,Object> testdatamap) throws Exception {
	try {
		
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Create Invoice");
//	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	switchTonextwindow();
//			String iType=testdatamap.get("InvoiceType").toString();
//			if(iType.equalsIgnoreCase("Save")) {
//				int intiCount=getInvoiceCountNext();
//				naviagteCreateInvoicePage();
			//enterClientNameOrNationalID(testdatamap);
			selectSubbiller(EdaatOR.Biller_Invoice_SBilIdList,testdatamap);
			Thread.sleep(1000);
			
			WebClickUsingJS(EdaatOR.Biller_Invoice_TemplateList);
			WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			selectTemplate(EdaatOR.Biller_Invoice_TemplateList,testdatamap);
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			enterInvoiceCaseType(testdatamap);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);

			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				test.log(Status.PASS,"#FUNC- Create Individual Client Invoice" + driver.getTitle() +" *Create Individual Client Invoice  PASS * " );
			}
			else{
				test.log(Status.FAIL,"#FUNC- Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
			}
			this.takeScreenShot();
		

	}
	catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
		this.takeScreenShot();
	}
}
public void ViewIndividualClientInvoice(Map<Object,Object> testdatamap) throws Exception {
	boolean existsNID=false;
	try {
		if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Individual")) {
			WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
		}if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Corporate")) {
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
		}
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"View Invoice");
    	switchTonextwindow();
    	this.takeScreenShot();
    	Thread.sleep(1000);
    	WebClick(EdaatOR.Biller_Invoice_view);
    	switchTonextwindow();
    	this.takeScreenShot();
    	if(ExistsCheck(EdaatOR.Biller_Invoice_form)==true) {
	    	existsNID=true;
	    	test.log(Status.PASS,"#FUNC-View Individual Client Invoice " + driver.getTitle() +" * View Individual Client Invoice PASS * " );
	    }
    	else {
    		test.log(Status.FAIL,"#FUNC-View Individual Client Invoice  " + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
    	}
    	this.takeScreenShot();	    	
    }catch(Exception e){
		test.log(Status.FATAL,"#FUNC-View Individual Client Invoice" + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}
	
}