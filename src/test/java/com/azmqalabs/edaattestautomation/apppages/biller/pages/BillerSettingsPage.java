package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerSettingsPage extends BasePage
{

	public BillerSettingsPage(WebDriver driver,ExtentTest test)
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
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Invoice_template);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateArabic,TemplateArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,TemplateEnglish);  
			Thread.sleep(1000);
			if(InvoiceType.equalsIgnoreCase("Recurring"))
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype);
			else
				WebClickUsingJS(EdaatOR.Biller_Invoice_Templatetype_One);              	
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Invoice_Add);

			boolean Ele=BillerSearchtemplate(TemplateEnglish);
			if(Ele==true)
				test.log(Status.PASS,"#FUNC-Search Template" + driver.getTitle() +" * Search Template PASS * " );
			else
				test.log(Status.FAIL,"#FUNC-Search Template" + driver.getTitle() +" * Search Template FAIL * " );
			this.takeScreenShot();

			Thread.sleep(1000);
			test.log(Status.PASS,"#FUNC-Add New Template client" + driver.getTitle() +" *Add New Template PASS * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add New Template client" + driver.getTitle() +" * Add New Template client FAIL * " );
			this.takeScreenShot();
		}
	}

	public boolean BillerSearchtemplate(String InvoiceType){
		boolean existsElement = false;
		try{

			WebEdit(EdaatOR.Biller_Individualclient_Name,InvoiceType);
			WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
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

	public void AddProduct(String ProdArabic,String ProdEnglish,String Category,String BasicPrice){
		try{
			WebClickUsingJS(EdaatOR.Biller_Settings);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Add_Product);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Prod_Addbutton);
			Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Prod_NameArabic,ProdArabic);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Invoice_TemplateEng,ProdEnglish);  
			Thread.sleep(1000);
			WebSelect1(EdaatOR.Biller_Invoice_Select,Category);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Prod_Price,BasicPrice);  
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Biller_Invoice_Add);
			test.log(Status.PASS,"#FUNC-Add Product Successful" + driver.getTitle() +" * Add Product Successful PASS * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Product Not Successful" + driver.getTitle() +" * Add Product Successful FAIL * " );
			this.takeScreenShot();
		}
	}


	public void navigateTemplate() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(200);
		WebClickUsingJS(EdaatOR.Biller_Add_Invoice_template);
		Thread.sleep(2000);

	}

	public void verfiyInvoiceTemplateVariables(Map<Object,Object>testdatamap) throws Exception {
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Add_Invoice_Button);
		Thread.sleep(2000);
		VerifyValue1(getText(EdaatOR.Biller_Tamplate_AddTitleHdr), testdatamap.get("AddTemplateHeadr").toString());
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameArbicHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddTemplNameEngHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddRefercodeHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddActDdeacHdr);
		verifyElementIsPresent(EdaatOR.Biller_Tamplate_AddBillPaymentyHdr);
	}


	public void verfiyViewInvoiceTemplate(Map<Object,Object>testdatamap) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_UpdateBtn);
			Thread.sleep(2000);
			ValidateTwoValue(getText(EdaatOR.Biller_Tamplate_UpdateTitleHdr), testdatamap.get("VeiwTempleteHeader").toString());
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateDesHdr);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_UpdateInVTyeHdr);
			test.log(Status.PASS,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client PASS * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-View Invoice Template" + driver.getTitle() +" * Add Individual client FAIL * " );
			this.takeScreenShot();
		}
	}



	public void verfiyDeleteInvoiceTemplate(Map<Object,Object>testdatamap) throws Exception {
		try {
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Tamplate_Table+"[1]"+EdaatOR.Biller_Tamplate_DeleteBtn);
			Thread.sleep(2000);
			VerifyValue1(getText(EdaatOR.Biller_Tamplate_DeletePop), testdatamap.get("DeleteConfirmMes").toString());
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_DeleteConfBtn);
			verifyElementIsPresent(EdaatOR.Biller_Tamplate_DeleteNoBtn);
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
			verfiyInvoiceTemplateVariables(testdatamap);
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
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Add_Product);
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


	public void verifyActiveProductFunctionality(Map<Object,Object>testdatamap) throws IOException, Exception {
		try {
			AddProduct(testdatamap.get("ProdArabic").toString(),testdatamap.get("ProdEnglish").toString(),testdatamap.get("Category").toString(),testdatamap.get("BasicPrice").toString());
			verifyElementIsPresent(EdaatOR.Biller_Product_ToggleBtn);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Active").toString());
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
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
			AddProduct(testdatamap.get("ProdArabic").toString(),testdatamap.get("ProdEnglish").toString(),testdatamap.get("Category").toString(),testdatamap.get("BasicPrice").toString());
			verifyElementIsPresent(EdaatOR.Biller_Product_ToggleBtn);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Active").toString());
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
			Thread.sleep(2000);
			WebClickUsingJS(EdaatOR.Biller_Product_ToggleBtn);
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Biller_Product_ActivePop), testdatamap.get("Deactive").toString());
			WebClickUsingJS(EdaatOR.Biller_Product_ActiveConfbtn);
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
				AddProduct(testdatamap.get("ProdArabic").toString(),pName,pCate,testdatamap.get("BasicPrice").toString());
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