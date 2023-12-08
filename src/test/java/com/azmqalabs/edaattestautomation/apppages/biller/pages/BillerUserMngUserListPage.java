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



public class BillerUserMngUserListPage extends BasePage
{

	public BillerUserMngUserListPage(WebDriver driver,ExtentTest test)
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



	public void navigateUserlistPage() throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Menu_UserManagement);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_Menu_UserList);
		Thread.sleep(2000);
	}


	public void ClickOnAddUserBtn() {
		WebClick(EdaatOR.Biller_UserList_AddUserBt);
	}

	public void EnterUserNameBox(String pname) {
		WebEdit(EdaatOR.Biller_UserListAdd_NameInput, pname);
	}

	public void EnterEmailIdBox(String lstname) {
		WebEdit(EdaatOR.Biller_UserListAdd_EmailInput, lstname);
	}

	public void EnterPhoneNmBox(String lstname) {
		WebEdit(EdaatOR.Biller_UserListAdd_PhoneInput, lstname);
	}

	public void ClickOnGrouChekbox() {
		WebClick(EdaatOR.Biller_UserListAdd_GroupCheckBox);
	}

	public void ClickOnUserAddBtn() {
		WebClick(EdaatOR.Biller_UserListAdd_AddUserBtPop);
	}


	public void EnterSearchUserName(String lstname) {
		WebEdit(EdaatOR.Biller_UserListSearch_NameBt, lstname);
	}

	public void EnterSearchEmalID(String lstname) {
		WebEdit(EdaatOR.Biller_UserListSearch_EmailBt, lstname);
	}

	public void ClickOnUselistSearchBtn() {
		WebClick(EdaatOR.Biller_UserListSearch_SaerchBt);
	}

	public void ClickOnDiscountDeleteBtn() {
		WebClick(EdaatOR.Biller_Discount_DeleteBtn);
	}

	public void ClickOnDiscountConfYesBtn() {
		WebClick(EdaatOR.Biller_Discount_YesConfBtn);
	}


	public void AddUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnAddUserBtn();
		Thread.sleep(1500);
		EnterUserNameBox(testdatamap.get("UserName").toString());
		Thread.sleep(500);
		EnterEmailIdBox(testdatamap.get("EmailID").toString());
		Thread.sleep(200);
		EnterPhoneNmBox(testdatamap.get("PhoneNum").toString());
		ClickOnGrouChekbox();

		ClickOnUserAddBtn();
		Thread.sleep(1500);
	}

	public void SearchUser(Map<Object,Object>testdatamap) throws Exception {
		EnterSearchUserName(testdatamap.get("UserName").toString());
		EnterSearchEmalID(testdatamap.get("EmailID").toString());
		ClickOnUselistSearchBtn();
		Thread.sleep(1500);
	}

	public void DeleteUser(Map<Object,Object>testdatamap) throws Exception {
		ClickOnDiscountDeleteBtn();
		Thread.sleep(1500);
		VerifyValue1(getText(EdaatOR.Biller_Tamplate_ConfirmDeletePop), testdatamap.get("DeleteDiscount").toString());
		ClickOnDiscountConfYesBtn();
		Thread.sleep(1500);

	}

	
	public void verifyDeleteUser(Map<Object,Object> testdatamap) throws Exception {
		try {
			AddUser(testdatamap);
			SearchUser(testdatamap);
			DeleteUser(testdatamap);
			SearchUser(testdatamap);
			verifyElementIsPresent(EdaatOR.Biller_Product_NoData);
			WebClick(EdaatOR.Biller_UserList_IsDeletChekckbox);
			SearchUser(testdatamap);
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			test.log(Status.PASS,"#FUNC-Delete User from userlist and IsDelete User check box" + driver.getTitle() +" * User Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Delete User from userlist and IsDelete User check box" + driver.getTitle() +" * User Management  FAIL * " );
			this.takeScreenShot();
		}
	}



	public void verifyAddUser(Map<Object,Object> testdatamap) throws Exception {
		try {
			AddUser(testdatamap);
			SearchUser(testdatamap);
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			test.log(Status.PASS,"#FUNC-Add User from userlist" + driver.getTitle() +" * User Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add User from userlist" + driver.getTitle() +" * User Management  FAIL * " );
			this.takeScreenShot();
		}
	}
	
	
	public void verifySearchUser(Map<Object,Object> testdatamap) throws Exception {
		try {
			SearchUser(testdatamap);
			if(CheckElementExists(EdaatOR.Biller_Product_NoData)==true) {
			AddUser(testdatamap);
			SearchUser(testdatamap);
			}
			VerifyValue1(getText(EdaatOR.Biller_UserList_UserName), testdatamap.get("UserName").toString());
			verifyElementIsNotPresent(EdaatOR.Biller_Product_NoData, "Data is exists");
			WebClick(EdaatOR.Biller_UserList_UserName);
			switchToWindow();
			Thread.sleep(1000);
			VerifyValue1(WebGetTextAttribute(EdaatOR.Biller_UserListAdd_NameInput), testdatamap.get("UserName").toString());
			VerifyValue1(getText(EdaatOR.Biller_UserListAdd_EmailInput), testdatamap.get("EmailID").toString());
			
			test.log(Status.PASS,"#FUNC-Search User from userlist and User is clickable" + driver.getTitle() +" * User list Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Search User from userlist and User is clickable" + driver.getTitle() +" * User List Management  FAIL * " );
			this.takeScreenShot();
		}
	}
}
