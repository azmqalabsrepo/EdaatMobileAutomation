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



public class BillerSettingsDiscountPage extends BasePage
{

	public BillerSettingsDiscountPage(WebDriver driver,ExtentTest test)
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



	public void navigateDisCountPage() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_Discount);
		Thread.sleep(2000);
	}


	public void ClickOnDiscountBtn() {
		WebClick(EdaatOR.Biller_Discount_AddBtn);
	}

	public void EnterDiscEnglishBox(String pname) {
		WebEdit(EdaatOR.Biller_Discount_EngInp, pname);
	}

	public void EnterDiscArabicBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_AtrabInp, lstname);
	}

	public void EnterDiscPercentBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_Percent, lstname);
	}

	public void ClickOnDiscountAddBtn() {
		WebClick(EdaatOR.Biller_Discount_AddDiscBtn);
	}

	public void EnterDiscNameBox(String lstname) {
		WebEdit(EdaatOR.Biller_Discount_DiscName, lstname);
	}

	public void ClickOnDiscountSearchBtn() {
		WebClick(EdaatOR.Biller_Discount_SearchBtn);
	}

	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}

	public void ClickOnDiscountConfYesBtn() {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}


	public void AddDiscount(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountBtn();
		Thread.sleep(1500);
		EnterDiscEnglishBox(testdatamap.get("DiscountEngName").toString());
		Thread.sleep(500);
		EnterDiscArabicBox(testdatamap.get("DiscountArabicName").toString());
		Thread.sleep(200);
		EnterDiscPercentBox(testdatamap.get("DiscountPercentage").toString());
		ClickOnDiscountAddBtn();
		Thread.sleep(1500);
	}

	public void searchDiscount(Map<Object,Object>testdatamap) throws Exception {
		EnterDiscNameBox(testdatamap.get("DiscountEngName").toString());
		ClickOnDiscountSearchBtn();
		Thread.sleep(1500);
	}

	public void DeleteDiscount(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR.Biller_Tamplate_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}

	public void verifyDeleteDiscount(Map<Object,Object> testdatamap) throws Exception {
		try {
			searchDiscount(testdatamap);
			if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
				AddDiscount(testdatamap);
				searchDiscount(testdatamap);
			}

			DeleteDiscount(testdatamap);
			verifyElementIsPresent(EdaatOR.Biller_Product_NoData);
			test.log(Status.PASS,"#FUNC-Delete Invoice Template" + driver.getTitle() +" * Delete Discount PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Delete Discount" + driver.getTitle() +" * Delete Discount FAIL * " );
			this.takeScreenShot();
		}
	}

}
