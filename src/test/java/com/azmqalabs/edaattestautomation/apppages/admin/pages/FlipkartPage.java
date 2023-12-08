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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.Window;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;



public class FlipkartPage extends BasePage {

	public FlipkartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}

	
	public void AddtoCart(Map<Object,Object> testdatamap){
		try {
			   this.getScreen();
     	   	   Thread.sleep(5000);
     	   	   Actions actions = new Actions(driver);
     	       WebElement skip = driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']"));
     	   	   actions.click(skip).build().perform();
			   Thread.sleep(6000);
			   this.getScreen();
			   WebElement searchicon = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[466,305][1158,438]']"));
			   actions.click(searchicon).build().perform();
			   Thread.sleep(2000);
			   this.getScreen();
			   driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("Mobiles");
			   Thread.sleep(6000);
			   WebElement Firstoption = driver.findElement(By.xpath("(//android.widget.TextView[@index='1'])[1]"));
			   actions.click(Firstoption).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
			   WebElement Continue = driver.findElement(By.xpath("//android.widget.Button[@index='2']"));
			   actions.click(Continue).build().perform();
			   Thread.sleep(5000);	
			   this.getScreen();
	           WebElement allow = driver.findElement(By.xpath("//android.widget.Button[@text='Allow']"));
			   actions.click(allow).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
			   Thread.sleep(5000);	
			   this.getScreen();
	           WebElement Continueloc = driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']"));
			   actions.click(Continueloc).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
			   WebElement Allowloc = driver.findElement(By.xpath("//android.widget.Button[@text='While using the app']"));
			   actions.click(Allowloc).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
			   WebElement FirstMobile = driver.findElement(By.xpath("(//android.view.ViewGroup[@bounds='[0,1312][1440,1936]'])[1]"));//(//android.widget.LinearLayout[@index='0'])[3]
			   actions.click(FirstMobile).build().perform();
			   Thread.sleep(5000); 
			   this.getScreen();
			   WebElement carticon = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[42,2830][252,3008]']"));
			   actions.click(carticon).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
			   WebElement ViewCart = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[1286,154][1370,238]']"));
			   actions.click(ViewCart).build().perform();
			   Thread.sleep(5000);
			   this.getScreen();
		  	   driver.quit();
		} 
		catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-Add Product to  Cart" + driver.getTitle() + " * Add Product to Cart FAILED * ");
			this.takeScreenShot();
		}
	}
	public void navigatetochrome(Map<Object,Object> testdatamap) throws Exception{
		   	   	   Thread.sleep(6000);
	   	   Actions actions = new Actions(driver);
	       WebElement skip = driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']"));
	   	   actions.click(skip).build().perform();
		   Thread.sleep(9000);
		   WebElement account = driver.findElement(By.xpath("//android.widget.TextView[@text='Account']"));
	   	   actions.click(account).build().perform();
		   Thread.sleep(9000);
		   WebElement sale = driver.findElement(By.xpath("//android.view.ViewGroup[@bounds='[56,1255][1384,1339]']"));
	   	   actions.click(sale).build().perform();
		   Thread.sleep(9000);
		   WebElement share = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Share']"));
	   	   actions.click(share).build().perform();
		   Thread.sleep(5000);
		   WebElement chrome = driver.findElement(By.xpath("//android.widget.TextView[@text='Chrome']"));
	   	   actions.click(chrome).build().perform();
		   Thread.sleep(9000);
		   waitForPageToLoad();
		   Thread.sleep(9000);
		   driver.findElement(By.xpath("(//android.view.View[@index='1'])[1]")).click();
		   waitForPageToLoad();
		   Thread.sleep(9000);

		 //android.widget.Image[@text='Site Logo']
		
		   
		   

		}
	}
		
