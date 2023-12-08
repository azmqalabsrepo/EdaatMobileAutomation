package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;

import org.openqa.selenium.Alert;
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

public class BillerSystemMangement extends BasePage {

	public BillerSystemMangement(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.Systemmgmt_Menu)
	public WebElement Client;

	public boolean Exists() {
		return super.Exists(Client);
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
public void Gridview(String view,String table) {
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

public void DeactoAct(Map<Object,Object> testdatamap) {
	try {

		boolean Ele = EnterDetails(testdatamap);
		if (Ele == true)
			test.log(Status.PASS,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker PASS * ");
		else
			test.log(Status.FAIL,"#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
	} catch (Exception e) {
		test.log(Status.FATAL, "#FUNC-Valid Activation info for deactivated biller by maker" + driver.getTitle() + " * Activation info for deactivated biller by maker FAIL * ");
		this.takeScreenShot();
	}
}
public void DeactoActInvalid(Map<Object,Object> testdatamap) {
	try {

		boolean Ele = EnterDetails(testdatamap);
		if (Ele == true)
			test.log(Status.PASS,"#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker PASS * ");
		else
			test.log(Status.FAIL,"#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker FAIL * ");
	} catch (Exception e) {
		test.log(Status.FATAL, "#FUNC-Invalid Activation info for deactivated biller by maker" + driver.getTitle() + " * Invalid Activation info for deactivated biller by maker FAIL * ");
		this.takeScreenShot();
	}
}

public void ActivatedbyChecker(Map<Object,Object> testdatamap) {
	try {
		boolean Ele = Approval(testdatamap);
		if (Ele == true)
			test.log(Status.PASS,"#FUNC- Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation PASS * ");
		else
			test.log(Status.FAIL,"#FUNC-Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation FAIL * ");
	} catch (Exception e) {
		test.log(Status.FATAL, "#FUNC-Checker approvroval for account activation" + driver.getTitle() + " * Checker approvroval for account activation FAIL * ");
		this.takeScreenShot();
	}
}

public boolean Grid(String view,String table) {
	boolean existsNID = false;
	try {
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
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

public void SysmgmtMenu() throws InterruptedException {
	WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
	Thread.sleep(1000);
	WebClickUsingJS(EdaatOR.Systemmgmt_NotApproved_Menu);
	Thread.sleep(1000);
	WebClick(EdaatOR.Systemmgmt_NotApproved_Edit);
	Thread.sleep(1000);
}

public boolean EnterDetails(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		WebEdit(EdaatOR.Biller_Systemmgmt_TempBenificaryName,testdatamap.get("TempBenificaryName").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerCode,testdatamap.get("BillerCode").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_TransferDuration,testdatamap.get("TransferDuration").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameAr,testdatamap.get("BillerNameArabic").toString());
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_BillerAliasNameEn,testdatamap.get("BillerNameEnglich").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasEnterpriseSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasIndividualSubBillers);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_IsUrgentBillUploader);
		Thread.sleep(1000);		
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceNumberPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceNumber,testdatamap.get("MaxAllowedDailyInvoices").toString());
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_HasMaximumInvoiceAmountPerDay);
		Thread.sleep(1000);
		WebEdit(EdaatOR.Biller_Systemmgmt_MaximumInvoiceAmount,testdatamap.get("MaximumInvoiceAmount").toString());
		Thread.sleep(1000);
		if(testdatamap.get("Billertype").toString().equalsIgnoreCase("Super Biller")) {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Super);
			Thread.sleep(1000);	
		}else {
			WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Tracker);
			Thread.sleep(1000);	
			selectDropdownValue_PartialText(EdaatOR.Biller_Systemmgmt_NewSuperBiller, testdatamap.get("SuperBiller").toString());
		}		
		WebClick(EdaatOR.Biller_Systemmgmt_Confirm);	
		this.takeScreenShot();
		WebClick(EdaatOR.Biller_Save);
		Thread.sleep(1000);	
		
	}

	catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
}
public boolean Approval(Map<Object,Object>testdatamap) {
	boolean existsNID = false;
	try {
		SysmgmtMenu();
		WebEdit(EdaatOR.Biller_Individualclient_Name,testdatamap.get("BillerName").toString());		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Systemmgmt_Btnapprove);
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClickUsingJS(EdaatOR.Biller_Individualclient_button);
		existsNID=true;
	}catch (Exception e) {
		e.printStackTrace();
		this.takeScreenShot();
	}
	return existsNID;
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
public void UpdateBillerdetails(String Billername,String MonthlyLimits,String TransferDuration,String AzimFee,String sadadFee,String corpName,String Max){
    try{
    		
        	boolean Ele=UpdateBiller(Billername, MonthlyLimits, TransferDuration, AzimFee, sadadFee, corpName, Max);
        	if(Ele==true)
        	test.log(Status.PASS,"#FUNC-Updated  Individual client" + driver.getTitle() +" * Updated Individual client PASS * " );
        	else
    	    	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FATAL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
        this.takeScreenShot();
    }
}
public boolean UpdateBiller(String Billername,String MonthlyLimits,String TransferDuration,String AzimFee,String sadadFee,String corpName,String Max){
	boolean existsNID = false;
	try{
		WebClickUsingJS(EdaatOR.Systemmgmt_Menu);
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Systemmgmt_Approved_Menu);		
		Thread.sleep(500);
		WebEdit(EdaatOR.Biller_Individualclient_Name,Billername);		
		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
		Thread.sleep(500);
		WebClickUsingJS(EdaatOR.Biller_Edit);
    	Thread.sleep(1000);	    	
    	WebClear(EdaatOR.Biller_Maxlimit);
    	WebEdit(EdaatOR.Biller_Maxlimit,MonthlyLimits);
    	WebClear(EdaatOR.Biller_TransferDuration);
    	WebEdit(EdaatOR.Biller_TransferDuration,TransferDuration);
    	WebClear(EdaatOR.Biller_AzimFee);
    	WebEdit(EdaatOR.Biller_AzimFee,AzimFee);
    	WebClear(EdaatOR.Biller_sadadFee);
    	WebEdit(EdaatOR.Biller_sadadFee,sadadFee);
    	WebClear(EdaatOR.Biller_BillerAliasNameEn);
    	WebEdit(EdaatOR.Biller_BillerAliasNameEn,corpName);
    	WebClear(EdaatOR.Biller_MaximumInvoiceAmount);
    	WebEdit(EdaatOR.Biller_MaximumInvoiceAmount,Max);
    	this.takeScreenShot();
    	scrollDowntillend(driver);
    	WebClick(EdaatOR.Biller_Save);
    	existsNID=true;
	}catch (Exception e) {
    	e.printStackTrace();
   	 	this.takeScreenShot();
	}
	return existsNID;
    }

}
