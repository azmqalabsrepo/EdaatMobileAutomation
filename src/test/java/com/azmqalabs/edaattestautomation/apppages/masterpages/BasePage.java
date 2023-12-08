package com.azmqalabs.edaattestautomation.apppages.masterpages;

import java.util.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.common.Common;

public class BasePage extends Common {

	public void launchApplication() {
		try {
			String MavenCmdLineAppUrl = "";
			MavenCmdLineAppUrl = System.getProperty("appurl");
			System.out.println("Maven externalized parameter: " + MavenCmdLineAppUrl);
			if (MavenCmdLineAppUrl != null)
				driver.get(MavenCmdLineAppUrl);
			else
			System.out.println(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			driver.get(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			test.log(Status.PASS, "Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
	     	System.out.println("Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			this.takeScreenShot();
			Thread.sleep(1000);

		} catch (Exception e) {
			test.log(Status.FAIL, "Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
			driver.navigate().to(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
	     	this.takeScreenShot();
		}
	}

	public void launchApplication(String sURL) {
		try {

			String MavenCmdLineTestType = "";
			MavenCmdLineTestType = System.getProperty("testtype");
			System.out.println("Maven externalized parameter: " + MavenCmdLineTestType);
			driver.get(sURL);
			test.log(Status.INFO, "Test URL: " + sURL);
			System.out.println("Test URL: " + sURL);
			this.takeScreenShot();
		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FATAL, ErrorFontColorPrefix
					+ "launchApplication Page - launchApplication failed - unable to Enter" + e + ErrorFontColorSuffix);
			test.log(Status.FATAL,
					ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
							+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
			throw new NoSuchElementException("launchApplication - URL not launched");
		}
	}

}
