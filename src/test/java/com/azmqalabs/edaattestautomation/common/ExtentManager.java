package com.azmqalabs.edaattestautomation.common;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;

public class ExtentManager {
	private static ExtentReports extent;
	private static String extentReportLocation = "ReportsConfig.xml";
	private static String filePath;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentTest test;

	public static ExtentReports GetExtent() {
		if (extent != null)
			return extent;
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {
		String sProjectName = "";
		sProjectName = System.getProperty("projectname");
		if (sProjectName == null) {
			sProjectName = Config.Get("PROJECT.NAME");
		}
		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot.getAbsolutePath() + "//src//test//resources//testConfig//extentreport//",
				extentReportLocation);
		File app1 = new File(classpathRoot.getPath() + "//",
				"src//test//resources//testReport//" + sProjectName);
		
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss");
		String formatDateTime = now.format(format);  
		
		filePath = app1.toString() + "//" + Config.Get("TESTCYCLE.NAME")+"_"+formatDateTime+".html";
		System.out.println(filePath);
		htmlReporter = new ExtentHtmlReporter(filePath.toString());
		htmlReporter.loadXMLConfig(app.toString());
		return htmlReporter;
	}

	public static ExtentReports CreateExtentReportExtent() {
		String sModuleName = "";
		extent = ExtentManager.GetExtent();
		return (extent);
	}

	public static ExtentTest CreateExtentReportTest(ExtentReports extent, String browserName, String sTestID) {
		String sModuleName = "";
		test = ExtentManager.createTestNew(sModuleName, "TEST RESULTS", "_" + sTestID + "_" + browserName);
		return (test);
	}

	public static ExtentTest createTestNew(String name, String description, String sTestIDBrowserName) {
		name = "Test" + sTestIDBrowserName;
		test = extent.createTest(name, description);
		return test;
	}
	public static ExtentTest CreateExtentReportTest(ExtentReports extent, String cName, String scName, String browserName, String sTestID) {
        String sModuleName = "";
        test = ExtentManager.createTestNew(sModuleName, cName+" : "+scName, "_" + sTestID + "_" + browserName);
        return (test);
    }

}
