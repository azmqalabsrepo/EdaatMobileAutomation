package com.azmqalabs.edaattestautomation.apppages.biller.pages;

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



public class BillerSubbillerPage extends BasePage
{

	public BillerSubbillerPage(WebDriver driver,ExtentTest test)
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

	
	public boolean SubbillerSearch(String BillerName,String NationalID){
		boolean existsElement = false;
		try{
				WebClickUsingJS(EdaatOR.Biller_Sub_Individualclient);
	        	Thread.sleep(2000);
	        	WebClickUsingJS(EdaatOR.Biller_Sub_IndividualsubBiller);
	        	Thread.sleep(2000);
	        	WebEdit(EdaatOR.Biller_Individualclient_Name,BillerName);
				Thread.sleep(1000);
				WebEdit(EdaatOR.Biller_Subbiller_NId,NationalID);
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_Subbiller_Search);
				this.takeScreenShot();
            	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
				Thread.sleep(1000);
				
           	
        }catch(Exception e){
//       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
            this.takeScreenShot();
        }
        return existsElement;
    }
  }
	
	
    

