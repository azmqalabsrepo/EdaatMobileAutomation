package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

public class BillerLoginPage extends BasePage {

	public BillerLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = EdaatOR.LoginPage_Username)
	public WebElement Username;

	public boolean Exists() {
		return super.Exists(Username);
	}

	public void ExistsCheckElement(String Main) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		boolean Header;
		try {
			Header = ExistsCheck(Main);
			
			if (Header) {
				test.log(Status.PASS, "#FUNC-Element Exists" + driver.getTitle() + " * Element Exists * ");

			} else {
				test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
			}
		} catch (Exception e) {
			test.log(Status.FATAL,
					ErrorFontColorPrefix + "launchApplication Page - loginToApplication failed - unable to Enter" + e
							+ ErrorFontColorSuffix);
			test.log(Status.FATAL,
					ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
			throw new NoSuchElementException("Biller Home Page - Not Loaded");
		}
	}

	//LOGIN TO APPLICATION WITH GLOBAL LOGIN USER ID FROM LOGIN PAGE
	public void LoginToApplication(){
		try {
			
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	public void LoginToApplication(Map<Object,Object> testdatamap){
		try {
			Recordset login=ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
			login.next();
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username,  login.getField("LoginUserName"));
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password,  login.getField("LoginPassword"));
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
				Thread.sleep(2000);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, login.getField("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	//LOGIN TO APPLICATION WITH INDIVIDUAL TESTDATA SHEET(SAME SHEET - CALL THIS METHOD IF USER WANTS PASS USER ID FROM THE SAME SHEET)
	public void LoginToApplication(String username, String password) {
		try {
			this.Exists();
			if (IsDispalyed(EdaatOR.LoginPage_Username)) {
				WebEdit(EdaatOR.LoginPage_Username, username);
				Thread.sleep(2000);
				WebEdit(EdaatOR.LoginPage_Password, password);
				Thread.sleep(2000);
				this.takeScreenShot();
				WebClick(EdaatOR.LoginPage_LogIn);
			} else {
				WebEdit(EdaatOR.LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(EdaatOR.LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application PASS * ");

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}
	public void loginToApplication(String Username) {
		try {
			if (Username.equalsIgnoreCase("")) {
				Username = GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName").toString();
			}

			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebEdit(EdaatOR.LoginPage_Password, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword").toString());
			WebClick(EdaatOR.LoginPage_LogIn);

		} catch (Exception e) {
			test.log(Status.FATAL,
					ErrorFontColorPrefix + "launchApplication Page - loginToApplication failed - unable to Enter" + e
							+ ErrorFontColorSuffix);
			test.log(Status.FATAL,
					ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
			throw new NoSuchElementException("loginToApplication - Login Failed");
		}

	}

	public void Wait() throws Exception {
		int i = 0;
		while (i < 10) {
			SetExecutionDelay();
			i = i + 1;
		}
	}

	public void Logout(String logout) {
		try {
			WebClickUsingJS(logout);
			test.log(Status.PASS, "#FUNC-Logout Successful" + driver.getTitle() + " * Logout * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
	
	public void ForgetPassword(String forGet,String Username) {
		try {
			WebClickUsingJS(forGet);
			WebEdit(EdaatOR.LoginPage_Username, Username);
			WebClickUsingJS(EdaatOR.LoginPage_send);
			test.log(Status.PASS, "#FUNC-ForgetPassword functionality Successful" + driver.getTitle() + " * Forget Password * ");
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-ForgetPassword functionality Not Successful" + driver.getTitle() + " * Forget Password * ");
			throw new NoSuchElementException("ForgetPassword - ForgetPassword Failed");

		}
	}
	public void Calcu() throws InterruptedException {
		try {
//	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	WebClickUsingActions("//android.widget.ImageButton[@content-desc='5']");

	WebClickUsingActions("//android.widget.ImageButton[@content-desc='plus']");

	WebClickUsingActions("//android.widget.ImageButton[@content-desc='5']");

	WebClickUsingActions("//android.widget.ImageButton[@content-desc='equals']");
	this.takeScreenShot();
	driver.quit();
		}
		catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC-Addition operation is done functionality Not Successful" + driver.getTitle() + " * Forget Password * ");

		}
	}
}
