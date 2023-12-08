package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
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

public class AdminSystemMangement extends BasePage {

	public AdminSystemMangement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
	}
	
	public void TableGridviewTax(String Category){
	     try{
	     	if(CheckElementExists(EdaatOR.Admin_taxTable)==true) {
	 			Thread.sleep(2000);
	 			WebClear(EdaatOR.Admin_TaxSearch);
	 			WebEdit(EdaatOR.Admin_TaxSearch,Category);        			
	 			WebClick(EdaatOR.Admin_SearchCat);
	 			this.takeScreenShot();
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

	public void navigateSystemMangementCategory() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Category);
		Thread.sleep(2000);
	}

	public void navigateSystemMangement() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Prod_Category);
		Thread.sleep(2000);
	}
	public void navigateSystemMangementTax() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_Tax_Mgmt);
		Thread.sleep(2000);
	}
	public void ActivateDactivate(Map<Object, Object>testdatamap){
		String searchstr=testdatamap.get("TaxEnglish").toString();
		try{
			if(CheckElementClickable(EdaatOR.Biller_Subbiller_Search)==true) {
				WebEdit(EdaatOR.Admin_TaxEng,searchstr);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
	        	ExistsCheck("//td[text()='"+searchstr+"']");
				Thread.sleep(1000);
				verifyElementIsPresent(EdaatOR.Admin_Tax_ToggleBtn);
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				Thread.sleep(500);
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("Active").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClickUsingJS(EdaatOR.Admin_Tax_ToggleBtn);
				VerifyValue1(getText(EdaatOR.Admin_Compan_ActivePop), testdatamap.get("InActive").toString());
				WebClickUsingJS(EdaatOR.Admin_Compan_ActiveConfbtn);
				Thread.sleep(2000);		
				test.log(Status.PASS,"#FUNC-Tax Deactivate/Activate Done" + driver.getTitle() +" * Tax Deactivate/Activate Done PASS * " );
			}	   		
			else {
				test.log(Status.FAIL,"#FUNC-Tax Deactivate/Activate Not Done" + driver.getTitle() +" * Tax Deactivate/Activate Not Done FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Tax Deactivate/Activate Not Done" + driver.getTitle() +" * Tax Corporate client Not Done * " );
			this.takeScreenShot();
		}
	}

	public void Toggle(String view,String tog) {
		try {

			boolean Ele = Toggleview(view,tog);
			if (Ele == true)
				test.log(Status.PASS,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click  PASS * ");
			else
				test.log(Status.FAIL,"#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
		} catch (Exception e) {
			test.log(Status.FATAL, "#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
			this.takeScreenShot();
		}
	}
	public void TableGridview(String Category){
		try{
			if(CheckElementExists(EdaatOR.Admin_CatTable)==true) {
				Thread.sleep(2000);
				WebClear(EdaatOR.Admin_UpdateSearch);
				WebEdit(EdaatOR.Admin_UpdateSearch,Category);        			
				WebClick(EdaatOR.Admin_SearchCat);
				this.takeScreenShot();
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




	public boolean Toggleview(String view,String tog) {
		boolean existsNID = false;
		try {
			WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
			Thread.sleep(1000);
			WebClickUsingJS(view);
			Thread.sleep(1000);
			this.takeScreenShot();
			if (ExistsCheck(tog) == true) {
				WebClickUsingJS(tog);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(1000);
				this.takeScreenShot();
				WebClickUsingJS(tog);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_button);
				existsNID = true;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	public void UpdateCategoryDetails(Map<Object,Object> testdatamap){
		try{

			boolean Ele=UpdateCategory(testdatamap);
			if(Ele==true)
				test.log(Status.PASS,"#FUNC-Updated  Category Passed " + driver.getTitle() +" * Updated Category PASS * " );
			else
				test.log(Status.FAIL,"#FUNC-Updated Category Failed" + driver.getTitle() +" * Updated Category FAIL * " );
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Updated Category Failed" + driver.getTitle() +" * Updated Category FAIL * " );
			this.takeScreenShot();
		}
	}
	public boolean UpdateCategory(Map<Object,Object> testdatamap){
		boolean existsNID = false;
		try{
			Addcat(testdatamap);
			WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("ProdEnglish").toString());
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Search);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Admin_Updatebtn);	
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_CatEng);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("UpdateProdEnglish").toString());
			Thread.sleep(1000);
			WebClear(EdaatOR.Admin_Prod_CatArabic);
			WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("UpdateProdArabic").toString());
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_UpdateCat);
			WebEdit(EdaatOR.Admin_UpdateSearch,testdatamap.get("UpdateProdEnglish").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Search);
			existsNID=true;
		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}

	public void addCategoryDetails() throws Exception {
		ClickOnProductBtn();
		Thread.sleep(500);
	}

	public void ClickOnProductBtn() {
		WebClickUsingJS(EdaatOR.Admin_Cat_Addbtn);
		waitForPageToLoad();
	}

	public void addTaxdeatails() throws Exception {
		ClickOnTaxBtn();
		Thread.sleep(500);
	}
	public void ClickOnTaxBtn() {
		WebClickUsingJS(EdaatOR.Admin_Tax_Addbtn);
		waitForPageToLoad();
	}

	public boolean Addcat(Map<Object,Object> testdatamap){
		boolean existsNID = false;
		try{
			addCategoryDetails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("ProdEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatArabic,testdatamap.get("ProdArabic").toString());
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Add_Cat);
			existsNID=true;
		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	public boolean AddTax(Map<Object,Object> testdatamap){
		boolean existsNID = false;
		try{
			addTaxdeatails();
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_CatEng,testdatamap.get("TaxEnglish").toString());  
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_taxArabic,testdatamap.get("TaxArabic").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_Prod_Ref,testdatamap.get("RefCode").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Admin_PercentageValue,testdatamap.get("Percentage").toString());
			Thread.sleep(1000);
			if(testdatamap.get("Activate").toString().equalsIgnoreCase("yes")) {
				WebClickUsingJS(EdaatOR.Admin_Status);
			}
			this.takeScreenShot();
			WebClickUsingJS(EdaatOR.Admin_Add_tax);
			existsNID=true;
		}catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
		}
		return existsNID;
	}
	public void AddCategory(Map<Object,Object> testdatamap){
		boolean cat=false;
		try{
			if(Addcat(testdatamap)==true) {
				test.log(Status.PASS,"#FUNC-Add Category is Successful" + driver.getTitle() +" * Add Category is Successful PASS * " );
			}else {
				test.log(Status.FATAL,"#FUNC-Add Category is not Successful" + driver.getTitle() +" * Add Category is not Successful FAIL * " );
			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Category is not Successful" + driver.getTitle() +" * Add Category is not Successful FAIL * " );
			this.takeScreenShot();
		}
	}

	public boolean SearchCategory(Map<Object,Object> testdatamap){
		boolean existsElement = false;
		String searchstr=testdatamap.get("ProdEnglish").toString();
		try{
			WebEdit(EdaatOR.Admin_Prod_CatEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
			this.takeScreenShot();
			existsElement=ExistsCheck("//td[text()='"+searchstr+"']");
			Thread.sleep(1000);
			if(existsElement==true) {
				test.log(Status.PASS,"#FUNC-Searched Category is Found" + driver.getTitle() +" * Searched Category is Found PASS * " );
			}else {
				test.log(Status.FAIL,"#FUNC-Searched Category is Not Found" + driver.getTitle() +" * Searched Category is Not Found  FAIL* " );

			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Searched Category is not Successful" + driver.getTitle() +" * Searched Category is not Successful FATAL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}


	public void navigateNotApprovedBillerManagement() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_NoAppBillerMangm);
		Thread.sleep(2000);
	}




	public void navigateApprovedBillerManagement() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_ApproveBillerMangm);
		Thread.sleep(2000);
	}

	public void navigateTrackerBillerManagement() throws Exception {
		WebClickUsingJS(EdaatOR.Admin_Sytemmanagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Admin_TrackerBillerMangm);
		Thread.sleep(2000);
	}
	
	public boolean SearchTaxes(Map<Object,Object> testdatamap){
		boolean existsElement = false;
		String searchstr=testdatamap.get("TaxEnglish").toString();
		try{
			WebEdit(EdaatOR.Admin_TaxEng,searchstr);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
			this.takeScreenShot();
			existsElement=ExistsCheck("//td[text()='"+searchstr+"']");
			Thread.sleep(1000);
			if(existsElement==true) {
				test.log(Status.PASS,"#FUNC-Searched Tax is Found" + driver.getTitle()+ " * Searched Tax is Found PASS * " );
			}else {
				test.log(Status.FAIL,"#FUNC-Searched Tax is Not Found" + driver.getTitle() +" * Searched Tax is Not Found  FAIL* " );

			}
		}catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Searched Tax is not Successful" + driver.getTitle() +" * Searched Tax is not Successful FATAL * " );
			this.takeScreenShot();
		}
		return existsElement;
	}
}
