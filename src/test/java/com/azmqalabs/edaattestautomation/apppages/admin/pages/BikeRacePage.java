package com.azmqalabs.edaattestautomation.apppages.admin.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class BikeRacePage extends BasePage {

	public BikeRacePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}

	
	public void Play(Map<Object,Object> testdatamap){
		try {
			//  driver.manage().timeouts().implicitlyWait(, TimeUnit.MINUTES);
			   this.getScreen();
     	   	   Actions actions = new Actions(driver);
     	       WebElement Closepopup = driver.findElement(By.xpath("//android.widget.ImageView[@index='3']"));
     	   	   actions.click(Closepopup).build().perform();
			   this.getScreen();
     	   	   WebElement play = driver.findElement(By.xpath("(//android.widget.ImageView[@index='1'])[3]"));
     	   	   actions.click(play).build().perform();
			   this.getScreen();
			   WebElement Desert = driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]"));
     	   	   actions.click(Desert).build().perform();
			   this.getScreen();
			   WebElement level1 = driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[4]"));
     	   	   actions.click(level1).build().perform();
			   this.getScreen();
			   Thread.sleep(10000);
			   WebElement click = driver.findElement(By.xpath("//android.widget.TextView[@text='Touch to start']"));
     	   	   actions.click(click).build().perform();
			   this.getScreen();
			   driver.quit();
		} 
		catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-Add Product to  Cart" + driver.getTitle() + " * Add Product to Cart FAILED * ");
			this.takeScreenShot();
		}
	}
}
