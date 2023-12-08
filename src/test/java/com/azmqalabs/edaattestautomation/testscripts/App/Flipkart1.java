package com.azmqalabs.edaattestautomation.testscripts.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.collectionofpages.Pages;
import com.azmqalabs.edaattestautomation.common.DBUtil;
import com.azmqalabs.edaattestautomation.common.ExtentManager;
import com.azmqalabs.edaattestautomation.common.InitializeDriver;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.webDriverEventListener;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;
import com.github.dockerjava.api.model.Capability;
import com.mysql.cj.x.protobuf.MysqlxConnection.Capabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

// TEST LISTENER
@Listeners(com.azmqalabs.edaattestautomation.common.TestListener.class)
public class Flipkart1 {
	
	// DECLARATION SECTION
	  static String TestDataTab="AdminLogin";  
	  
	  public WebDriver driver;
	  private InitializeDriver initializeDriver;
	  private EventFiringWebDriver driverEvent;
	  private webDriverEventListener eventListener;
	  Map<Object, Object> testdatamap;
	  Map<Object, Object> testresultsmap;
	  private String TestScriptID="";
	  static Recordset recTestData;
	  static ArrayList<String> arrListTestDataColumnNames;
	  String sBrowserTestData="";
	  String browserFromXML="";
	  String Username="";
	  String FullName="";
	  String SecondName="";
	  String ThirdName="";
	  String LastName="";
	  String NationalID="";
	  String Year="";
	  String Month="";
	  String Date="";
	  String Password="";
	  String MobileNo="";
	  String Email="";
	  ExtentReports extent;
	  ExtentTest test;
	  Pages Pages;
	  Log Log;
	  DBUtil DBUtil;
	  
		// FACTORY - DATA PROVIDER
	    @Factory (dataProvider="TestDataProvider")
	    public Flipkart1(Map<Object, Object> testdatamap){
	    	this.testdatamap=testdatamap;
	        this.TestScriptID=testdatamap.get("TestScriptID").toString();
	        this.sBrowserTestData=testdatamap.get("Browser").toString();
	  	    
	    }
	    @Override
	    public String toString(){
	    	return String.format("%S", TestScriptID);
	    }
	    
	    
		// DATA PROVIDER - FOR TEST DATA
	    @DataProvider
	    public static Object[][] TestDataProvider() throws Exception {
	    	Map<String, String> TestDataColNames;
	      	ReadData.retrieveLoginEnvDetails();
	      	arrListTestDataColumnNames=ReadData.readDataTableColumns(TestDataTab);
		  	TestDataColNames=ReadData.mapTestDataTableColumns(arrListTestDataColumnNames);
	      	recTestData=ReadData.readTestData(TestDataTab);
	        int lastRowOfTestData=recTestData.getCount();
	        Object[][] testdataobj = new Object[lastRowOfTestData][1];
	        testdataobj=ReadData.mapTestData(TestDataColNames,recTestData);
	      	return testdataobj;
	    }

	    
	    
	    
	    
		// TEST METHOD
//	    @Parameters({ "username", "password" })
	    @Test
	    public void myTest() throws InterruptedException, Exception{
	        try{
	               	
	        	   Thread.sleep(5000);
			       Actions actions = new Actions(driver);
	        	   WebElement skip = driver.findElement(By.id("com.flipkart.android:id/custom_back_icon"));
	        	   actions.click(skip).build().perform();
				   Thread.sleep(5000);
				   WebElement searchicon = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[355,257][857,362]']"));
				   actions.click(searchicon).build().perform();
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("Mobiles");
				   Thread.sleep(6000);
				   WebElement Firstoption = driver.findElement(By.xpath("(//android.widget.TextView[@index='1'])[1]"));
				   actions.click(Firstoption).build().perform();
				   Thread.sleep(5000);
				   WebElement Continue = driver.findElement(By.xpath("//android.widget.Button[@index='2']"));
				   actions.click(Continue).build().perform();
				   Thread.sleep(5000);	
		           WebElement allow = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
				   actions.click(allow).build().perform();
				   Thread.sleep(5000);	
				   WebElement FirstMobile = driver.findElement(By.xpath("(//android.view.ViewGroup[@index='0'])[11]"));
				   actions.click(FirstMobile).build().perform();
				   Thread.sleep(5000);   
				   WebElement carticon = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[33,1986][198,2126]']"));
				   actions.click(carticon).build().perform();
				   Thread.sleep(1000);   
				   WebElement ViewCart = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[959,138][1025,204]']"));
				   actions.click(ViewCart).build().perform();
				   Thread.sleep(5000);  
				   driver.quit();
	        		
	        		
	        	
	     
	        	 
	        		
	        	}
	        	
	        catch (Exception e)
			  {
				  Log.takeScreenShot();
				  Log.PostTestStatus(TestScriptID);
				  Log.ReportEvent("INFO", "TEST EXECUTION INCOMPLETE"+e);
				  DBUtil.UpdateTestResultExceptionInDB(testresultsmap);
				  Log.ReportEvent("FATAL", "<< !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
				  System.out.println("<< FATAL - !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
				  throw new NullPointerException("********FATAL EXCEPTION TRIGGERED********");
			  }
	    }
	    
		// BEFORE CLASS METHOD - BROWSER INITIALIZATION
		   @BeforeClass
		    public void beforeClass() throws Exception {
		        browserFromXML=sBrowserTestData;
		        // EXTENT REPORT
		        extent=ExtentManager.CreateExtentReportExtent();
		  	  	test=ExtentManager.CreateExtentReportTest(extent,browserFromXML,TestScriptID);
		  	  	// INITIALIZE DRIVER
		  	  	initializeDriver=new InitializeDriver();
		  		driver=initializeDriver.initDriver(browserFromXML, testdatamap);
		  		driverEvent = new EventFiringWebDriver(driver);
				eventListener = new webDriverEventListener(test);
				driverEvent.register(eventListener);
				this.driver=driverEvent;
				// INITIALIZE PAGE FACTORY OBJECT
				Pages=new Pages(driver,test);
			    Log=new Log(driver,test);
				DBUtil=new DBUtil(driver,test);
				// LOG TEST MACHINE/USER DETAILS
				Log.QAMachineInfo();
		    }
		// AFTER CLASS
	    @AfterClass
	    public void afterClass() {
	        extent.flush();
	    }
	    
		// AFTER TEST - NEED TO USE FOR LOGIN/LOGOUT HANDLING PURPOSE
	    @AfterTest
	    public void afterTest() {
	        System.out.println("After test");
	    }
	    
	    	  
	    
}
