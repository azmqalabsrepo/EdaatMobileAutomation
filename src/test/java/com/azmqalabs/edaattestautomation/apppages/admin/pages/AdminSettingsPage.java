package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.io.IOException;
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



public class AdminSettingsPage extends BasePage
{

	public AdminSettingsPage(WebDriver driver,ExtentTest test)
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


	public void AddInvoicetemplate(String TemplateArabic,String TemplateEnglish,String InvoiceType){
		try{
			WebClickUsingJS(EdaatOR.Admin_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Admin_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(1000);
			if(InvoiceType.equalsIgnoreCase("Recurring"))
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype);
		else
			WebClickUsingJS(EdaatOR.Admin_Invoice_Templatetype_One);              	
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);

		boolean Ele=AdminSearchtemplate(TemplateEnglish);
		if(Ele==true)
			test.log(Status.PASS,"#FUNC-Admin Search Invoice Template" + driver.getTitle() +" * Admin Search Invoice Template PASS * " );
		else
			test.log(Status.FAIL,"#FUNC-Admin Search Invoice Template" + driver.getTitle() +" * Admin Search Invoice Template FAIL * " );
		this.takeScreenShot();

		Thread.sleep(1000);
		test.log(Status.PASS,"#FUNC-Admin Add New Template client" + driver.getTitle() +" *Admin Add New Template PASS * " );
	}catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Admin Add New Template client" + driver.getTitle() +" * Admin Add New Template client FAIL * " );
		this.takeScreenShot();
	}
}
	public void UpadateProduct(Map<Object,Object>testdatamap) throws IOException, Exception {
		String priceList;
		try { 
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Product_EditLink);
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_NameArabic);
			WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("UpdateProdArabic").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Invoice_TemplateEng);
			WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("UpdateProdEnglish").toString());  
			Thread.sleep(1000);
			WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Ref);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_Description);
			WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
			Thread.sleep(1000);		
			WebClear(EdaatOR.Admin_Prod_Price);
			WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MinPrice);
			WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_MaxPrice);
			WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Prod_Pricelist);
			Thread.sleep(1000);
			priceList=testdatamap.get("PriceList").toString();
			WebClick("//li[contains(text(),'"+priceList+"')]"); 
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Update);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("UpdateProdEnglish").toString());
			WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Update Product Successful" + driver.getTitle() +" * Update Product Successful PASS * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Update product  is not Successful" + driver.getTitle() +" * Update product  is not Successful FAIL * " );
			this.takeScreenShot();
		}
	}
public boolean AdminSearchtemplate(String InvoiceType){
	boolean existsElement = false;
	try{
		
		WebEdit(EdaatOR.Admin_Individualclient_Name,InvoiceType);
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(1000);
		if(CheckElementExists("//td[text()='"+InvoiceType+"']")==true) {
			existsElement=true;
		}
		this.takeScreenShot();	    	

	}catch(Exception e){
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsElement;
}

public void AddProduct(Map<Object,Object>testdatamap){
	String priceList;
	try{
		WebClickUsingJS(EdaatOR.Admin_Prod_Addbutton);
		Thread.sleep(2000);
		WebEdit(EdaatOR.Admin_Prod_NameArabic,testdatamap.get("ProdArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Invoice_TemplateEng,testdatamap.get("ProdEnglish").toString());  
		Thread.sleep(1000);
		WebSelect1(EdaatOR.Admin_Invoice_Select,testdatamap.get("Category").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("ReferenceCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_Description,testdatamap.get("TestDescription").toString());
		Thread.sleep(1000);		
		WebEdit(EdaatOR.Admin_Prod_Price,testdatamap.get("BasicPrice").toString());  
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_MinPrice,testdatamap.get("MinPriceSAR").toString());  
		Thread.sleep(1000);
		WebEdit(EdaatOR.Admin_Prod_MaxPrice,testdatamap.get("MaxPriceSAR").toString());  
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Pricelist);
		Thread.sleep(1000);
		priceList=testdatamap.get("Price Lists").toString();
		WebClick("//li[contains(text(),'"+priceList+"')]"); 
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Admin_Invoice_Add);
		test.log(Status.PASS,"#FUNC-Add Product Successful" + driver.getTitle() +" * Add Product Successful PASS * " );
	}catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Add Product Not Successful" + driver.getTitle() +" * Add Product Successful FAIL * " );
		this.takeScreenShot();
	}
}


public void navigateTemplate() throws Exception {
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(200);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_template);
	Thread.sleep(2000);

}

public void verifyInvoiceTemplateVariables(Map<Object,Object>testdatamap) throws Exception {
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Invoice_Button);
	Thread.sleep(2000);
	VerifyValue1(getText(EdaatOR.Admin_Tamplate_AddTitleHdr), testdatamap.get("AddTemplateHeadr").toString());
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddTemplNameArbicHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddTemplNameEngHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddRefercodeHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddActDdeacHdr);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_AddBillPaymentyHdr);
	}

public boolean Grid(String view,String table) {
	boolean existsNID = false;
	try {
		this.takeScreenShot();
		WebClickUsingJS(view);
		Thread.sleep(1000);
		this.takeScreenShot();
		if (ExistsCheck(table) == true) {
			existsNID = true;
		}
		
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}

public void GridView(String view,String table) throws Exception {
	try {
		
		boolean Ele = Grid(view,table);
		if (Ele == true)
			test.log(Status.PASS,"#FUNC-Grid View" + driver.getTitle() + " * Grid View PASS * ");
		else
			test.log(Status.FAIL,"#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
	} catch (Exception e) {
		test.log(Status.FATAL, "#FUNC-Grid View" + driver.getTitle() + " * Grid View FAIL * ");
		this.takeScreenShot();
	}
}

public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap) throws Exception {
	try {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_UpdateBtn);
	Thread.sleep(2000);
	ValidateTwoValue(getText(EdaatOR.Admin_Tamplate_UpdateTitleHdr), testdatamap.get("VeiwTempleteHeader").toString());
	verifyElementIsPresent(EdaatOR.Admin_Tamplate_UpdateDesHdr);
	verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateInVTyeHdr);
	this.takeScreenShot();
	test.log(Status.PASS,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
}catch(Exception e){
	test.log(Status.FATAL,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
		this.takeScreenShot();
	}
}



	public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Admin_Tamplate_Table+"[1]"+EdaatOR.Admin_Tamplate_DeleteBtn);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Admin_Tamplate_DeletePop), testdatamap.get("DeleteConfirmMes").toString());
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_DeleteConfBtn);
		verifyElementIsPresent(EdaatOR.Admin_Tamplate_DeleteNoBtn);
		test.log(Status.PASS,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
	}catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
		this.takeScreenShot();
	}
}

public void verifyInvoiceTemplateDetails(Map<Object,Object>testdatamap) throws Exception {
	String TemName=testdatamap.get("ActionTemplate").toString();
	switch(TemName) {

	case "Template":
		verifyInvoiceTemplateVariables(testdatamap);
		break;

	case "View":
		verfiyViewInvoiceTemplate(testdatamap);
		break;

	case "Delete":
		verfiyDeleteInvoiceTemplate(testdatamap);
		break;
	}

}


public void navigateProduct() throws Exception {
	WebClickUsingJS(EdaatOR.Admin_Settings);
	Thread.sleep(2000);
	WebClickUsingJS(EdaatOR.Admin_Add_Product);
	Thread.sleep(2000);
}

public void EnterProductInputBox(String pname) {
	if(!pname.equalsIgnoreCase(""))
		WebEdit(EdaatOR.Biller_Product_NameInput, pname);
}

public void SelectIdProductListBox(String lstname) {
	if(!lstname.equalsIgnoreCase(""))
		WebSelect1(EdaatOR.Biller_Product_SearchIDlist, lstname);
}

public void ClickOnSearchBtn() {
	WebClick(EdaatOR.Biller_Product_SeachBtn);
}


public void verifyActivateProductFunctionality(Map<Object,Object>testdatamap) throws IOException, Exception {
	try {
		AddProduct(testdatamap);
		WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(300);
		verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(500);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		Thread.sleep(2000);
		takeScreenShot();
		test.log(Status.PASS,"#FUNC-Add product and active Template" + driver.getTitle() +" * Product Management PASS * " );	
	}
	catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Add product and active Template" + driver.getTitle() +" * Product Management FAIL * " );
		this.takeScreenShot();
	}
}

public void verifyDeActiveProductFunctionality(Map<Object,Object>testdatamap) throws IOException, Exception {
	try {
		AddProduct(testdatamap);
		WebEdit(EdaatOR.Admin_Individualclient_Name,testdatamap.get("ProdEnglish").toString());
		WebClickUsingJS(EdaatOR.Admin_Invoice_Search);
		Thread.sleep(300);
		verifyElementIsPresent(EdaatOR.Admin_Product_ToggleBtn);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(500);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Active").toString());
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Product_ToggleBtn);
		Thread.sleep(500);
		VerifyValue1(getText(EdaatOR.Admin_Product_ActivePop), testdatamap.get("Deactive").toString());
		WebClickUsingJS(EdaatOR.Admin_Product_ActiveConfbtn);
		test.log(Status.PASS,"#FUNC-Add product and De-active Template" + driver.getTitle() +" * Product Management PASS * " );	
	}


	catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Add product and De-active Template" + driver.getTitle() +" * Product Management FAIL * " );
		this.takeScreenShot();
	}
}

public void verifySearchFunctionality(Map<Object,Object>testdatamap) throws IOException, Exception {
	try {
		String pName=testdatamap.get("SearchProdName").toString();
		String pCate=testdatamap.get("SearchProdCateg").toString();
		EnterProductInputBox(pName);
		SelectIdProductListBox(pCate);
		ClickOnSearchBtn();
		Thread.sleep(2000);
		if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
			AddProduct(testdatamap);
			EnterProductInputBox(pName);
			SelectIdProductListBox(pCate);
			ClickOnSearchBtn();
		}

		List<WebElement> listTable=driver.findElements(By.xpath(EdaatOR.Biller_Product_Table));
		for(int i=0;i<listTable.size();i++) {
			int j=i+1;
			if(!pName.equalsIgnoreCase("")) {
				VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[3]"), pName);
			}else if(!pCate.equalsIgnoreCase("")) {
				VerifyValue1(getText(EdaatOR.Biller_Product_Table+"["+j+"]/td[4]"), pCate);
			}
		}

		test.log(Status.PASS,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management PASS * " );	

	}
	catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Search Product Template" + driver.getTitle() +" * Product Management FAIL * " );
			this.takeScreenShot();
		}
	}
}