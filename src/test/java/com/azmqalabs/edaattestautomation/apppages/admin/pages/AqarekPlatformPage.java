package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.Window;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;



public class AqarekPlatformPage extends BasePage {

	public AqarekPlatformPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}

	
	public void Signin(Map<Object,Object> testdatamap){
		try {
			  
     	   	   Thread.sleep(10000);
     	   	   Actions actions = new Actions(driver);
     	   	   WebElement click = driver.findElement(By.xpath(EdaatOR.Aquarek_Myrequestmenu.toString()));
     	   	   Thread.sleep(2000);
     	   	   this.getScreen();
		   	   actions.click(click).build().perform();
			   Thread.sleep(3000);	
			   this.getScreen();
			   driver.findElement(By.xpath(EdaatOR.Aquarek_MobileNotextfield.toString())).sendKeys(testdatamap.get("MobileNo").toString());
			   Thread.sleep(5000);
			   this.getScreen();
			   WebElement signin = driver.findElement(By.xpath(EdaatOR.Aquarek_SigninBtn.toString()));
		   	   actions.click(signin).build().perform();
		   	   Thread.sleep(2000);
		   	   WebElement tostmsg = driver.findElement(By.xpath(EdaatOR.Aquarek_Signin_ErrorMessage.toString()));
		       VerifyValue1(tostmsg.getText(),testdatamap.get("ErrorMessage").toString());
		       this.getScreen();
		       Thread.sleep(3000);	
		   	   test.log(Status.PASS, "* Signin Error Message PASSED * ");
			} 
		catch (Exception e) {
			test.log(Status.FAIL, "* Signin Error Message FAILED * ");
			this.takeScreenShot();
		}
	}
}
		 
