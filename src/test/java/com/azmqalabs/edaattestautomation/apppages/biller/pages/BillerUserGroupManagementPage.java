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



public class BillerUserGroupManagementPage extends BasePage
{

	public BillerUserGroupManagementPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_GroupMgm_Header)
	public WebElement Header;


	public boolean Exists(){
		return super.Exists(Header); 
	}



	public void naviagteGroupManagement() {
		WebClick(EdaatOR.Biller_UserManagement);
		WebClick(EdaatOR.Biller_GropManagment);
		waitForPageToLoad();
	}




	public void EnterSearchGroupName(String pname) {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchGrpName, pname);
	}

	public void EnterSearchGroupCode(String lstname) {
		WebEdit(EdaatOR.Biller_GroupMgm_SearchCode, lstname);
	}


	public void ClickOnGrouSearchBtn() {
		WebClick(EdaatOR.Biller_GroupMgm_SearchButton);
	}

	public void ClickOnAddBtn() {
		WebClick(EdaatOR.Biller_GroupMgm_AddGrpBtn);
	}

	public void EnterAddGroupArabic(String pname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_ArabicName, pname);
	}

	public void EnterAddGroupEng(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Name, lstname);
	}

	public void EnterAddGroupDescription(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_Description, lstname);
	}

	public void EnterAddGroupCode(String lstname) {
		WebEdit(EdaatOR.Biller_AddGroupMgm_GroupCode, lstname);
	}


	public void ClickOnGroupAddBtn() {
		WebClick(EdaatOR.Biller_AddGroupMgm_AddBtn);
	}



	public void addGroup(Map<Object, Object> testdatamap) throws Exception {
		try {
			ClickOnAddBtn();
			waitForPageToLoad();
			Thread.sleep(1000);
			EnterAddGroupArabic(testdatamap.get("ArabicName").toString());
			EnterAddGroupEng(testdatamap.get("EngName").toString());
			EnterAddGroupDescription(testdatamap.get("Description").toString());
			EnterAddGroupCode(testdatamap.get("GroupCode").toString());
			ClickOnGroupAddBtn();
			Thread.sleep(1000);
			searchGroupByName(testdatamap.get("ArabicName").toString());
			ClickOnGrouSearchBtn();
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_GrpName), testdatamap.get("ArabicName").toString());
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
			test.log(Status.PASS,"#FUNC-addGrop is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}


	public void searchGroupByName(String searchName) throws Exception {
		if(!searchName.equalsIgnoreCase("")) {
			EnterSearchGroupName(searchName);
		}
	}

	public void searchGroupByCode(String GroupCode) throws Exception {
		if(!GroupCode.equalsIgnoreCase("")) {
			EnterSearchGroupCode(GroupCode);
		}
	}

	public void searchGroup(Map<Object, Object> testdatamap) throws Exception {
		try {
			searchGroupByName(testdatamap.get("ArabicName").toString());
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_GrpName), testdatamap.get("ArabicName").toString());
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_Code), testdatamap.get("GroupCode").toString());
			test.log(Status.PASS,"#FUNC-Search Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Search Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}

	public void deleteGroup(Map<Object, Object> testdatamap) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_DeleteBtn);
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_SearchGroupMgm_YesDeleteBtn);
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			verifyElementIsPresent(EdaatOR.Biller_SearchGroupMgm_Nodata, "Record got deleted");
			test.log(Status.PASS,"#FUNC-Delete Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Delete Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}
	

	public void updateAndViewGroupPermission(Map<Object, Object> testdatamap) throws Exception {
		try {
			searchGroupByCode(testdatamap.get("GroupCode").toString());
			ClickOnGrouSearchBtn();
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(500);
			VerifyValue1(getText(EdaatOR.Biller_SearchGroupMgm_PermissuionPOp), "Group Permission");
			WebClick(EdaatOR.Biller_EditGroup_Receivable);
			WebClick(EdaatOR.Biller_EditGroup_UpdateBtn);
			Thread.sleep(500);
			WebClick(EdaatOR.Biller_SearchGroupMgm_EditIcon);
			Thread.sleep(500);
			if(IsSelected(EdaatOR.Biller_EditGroup_Receivable)==true) {
				test.log(Status.PASS,"Receivable Check box is permission selected " );
			}
			else {
				test.log(Status.FAIL,"Receivable Check box is permission not selected " );
			}
			test.log(Status.PASS,"#FUNC-update Group is successful" + driver.getTitle() +" * User Group Management PASS * " );	
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-update Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}


	public void verifyViewGroupUnderUserList(Map<Object, Object> testdatamap) throws Exception {
		boolean listGr=false;
		try {
			List<WebElement> glist=driver.findElements(By.xpath(EdaatOR.Biller_Userlist_groups));
			for(int i=0;i<glist.size();i++) {
				int g=i+1;
				String grList=glist.get(i).getText();
				if(grList.contains(testdatamap.get("ArabicName").toString())) {
					test.log(Status.PASS,"Group Name is available in the userlist " );
					listGr=true;
					break;
				}
			}
			if(listGr==false) {
				test.log(Status.FAIL,"Group Name is not available in the userlist " );
			}
		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-View Group is Failed" + driver.getTitle() +" * User Group Management  FAIL * " );
			this.takeScreenShot();
		}

	}

	
	
}
