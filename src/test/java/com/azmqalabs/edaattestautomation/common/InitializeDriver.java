package com.azmqalabs.edaattestautomation.common;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codoid.products.fillo.Recordset;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

public class InitializeDriver {

	private WebDriver driver;
	
	public WebDriver initDriver(String browser, Map<Object, Object> testdatamap) throws Exception
	{



		String sDriverType=Config.Get("DRIVER.TYPE");
		if (sDriverType.equalsIgnoreCase("remotedriver"))
			driver=initRemoteWebDriver(browser);
		else if (sDriverType.equalsIgnoreCase("webdriver"))
			driver=initWebDriver(browser);
		else if(sDriverType.equalsIgnoreCase("APPIUMDRIVER"))
			driver=initAppiumDriver(browser,testdatamap);
		return(driver);
		
		
		
		
		
	}

	public WebDriver initAppiumDriver(String browser, Map<Object, Object> testdatamap) throws Exception {

		Recordset mobSet= ReadData.readTestDataBySpecifiedValue("MobileConfiguration", "DeviceType;PlatformName", testdatamap.get("DeviceType").toString()+";"+testdatamap.get("PlatformName").toString());
		mobSet.next();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(testdatamap.get("DeviceType").toString().equalsIgnoreCase("Emulator")){

			//Emulator:
			if(testdatamap.get("PlatformName").toString().equalsIgnoreCase("Android")){

				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobSet.getField("MobPlatformName").toString());
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobSet.getField("MobPlatformVersion").toString());
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobSet.getField("MobDeviceName").toString());
				capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
				capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,mobSet.getField("MobAppiumVersion").toString());
				if(browser.equalsIgnoreCase("Chrome")) {
					ChromeOptions options=new ChromeOptions();
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					
					FirefoxOptions options=new FirefoxOptions();
					capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
					}
			}
			if(testdatamap.get("PlatformName").toString().equalsIgnoreCase("AndroidApp")){
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobSet.getField("MobPlatformName").toString());
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobSet.getField("MobPlatformVersion").toString());
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobSet.getField("MobDeviceName").toString());
				capabilities.setCapability("appPackage", mobSet.getField("appPackage").toString());
				capabilities.setCapability("appActivity", mobSet.getField("appActivity").toString());





			}
		}
		if(testdatamap.get("DeviceType").toString().equalsIgnoreCase("MOBILE")){
			if(testdatamap.get("PlatformName").toString().equalsIgnoreCase("Android")){
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,mobSet.getField("MobPlatformName").toString());
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobSet.getField("MobPlatformVersion").toString());
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobSet.getField("MobDeviceName").toString());
				capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); 
			}
			if(testdatamap.get("PlatformName").toString().equalsIgnoreCase("AndroidApp")){
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mobSet.getField("MobPlatformName").toString());
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobSet.getField("MobPlatformVersion").toString());
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mobSet.getField("MobDeviceName").toString());
				capabilities.setCapability("appPackage", mobSet.getField("appPackage").toString());
				capabilities.setCapability("appActivity", mobSet.getField("appActivity").toString());
			}
			if(Config.Get("MOB.platformName").equalsIgnoreCase("iOS")){

			}
			if(Config.Get("MOB.platformName").equalsIgnoreCase("iOSApp")){
			}
		}
	//	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	 //   AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		Thread.sleep(5000);
		return (driver);

	}

	public WebDriver initRemoteWebDriver(String browser) throws Exception
	{
		DesiredCapabilities cap = null;
		int objSyncTime=Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));
		String testMachine=Config.Get("TEST.MACHINE");
		if (browser.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		} else if (browser.equals("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}  else if (browser.equals("ieedge")){
			cap=DesiredCapabilities.edge();
			cap.setBrowserName("MicrosoftEdge");
		}
		else if (browser.equals("ie")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("ie.ensureCleanSession", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		}
		RemoteWebDriver driver = new RemoteWebDriver(new URL(testMachine), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
		return(driver);
	}



	public WebDriver initWebDriver(String browser) throws Exception
	{
		int objSyncTime=Integer.parseInt(Config.Get("DRIVER.OBJ.SYNCTIME"));

		if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setPlatform(Platform.WINDOWS);
			caps.setCapability("marionette", true);
			driver = new FirefoxDriver(caps);
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("chrome")){

			if (Config.Get("CHROME.RESPONSIVE").equalsIgnoreCase("yes"))
			{
				WebDriverManager.chromedriver().setup();

				HashMap<String, String> mobileEmulation = new HashMap<String, String>(); 
				mobileEmulation.put("deviceName", "iPad Pro");    //Galaxy S5, Pixel 2, Pixel 2 XL, iPhone 5/SE, iPhone 6/7/8. iPhone 6, iPhone X, iPad, iPad Pro
				HashMap<String, Object> chromeOptions = new HashMap<String, Object>(); 
				chromeOptions.put("mobileEmulation", mobileEmulation); 
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 

				if (Config.Get("CHROME.HEADLESS").equalsIgnoreCase("yes")){
					chromeOptions.put("args", Arrays.asList("headless",
							"--no-sandbox", "--window-size=1325,744", "ignore-certificate-errors"));

					caps.setCapability("acceptInsecureCerts", true);
					caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				}

				driver = new ChromeDriver(caps);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
			}
			else if (Config.Get("CHROME.NETWORK.TRAFFIC").equalsIgnoreCase("yes"))
			{

				BrowserMobProxyServer server;
				server = new BrowserMobProxyServer();
				server.setTrustAllServers(true);
				server.start(0);
				server.newHar("Edaat");

				int port = server.getPort();
				Proxy proxy = ClientUtil.createSeleniumProxy(server);
				WebDriverManager.chromedriver().setup();
				DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
				seleniumCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);


				this.driver = new ChromeDriver(seleniumCapabilities);

				System.out.println("Port started:" + port);

				server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
				server.newHar("Edaat");

				driver.get("http://www.Edaat.com/");


				server.stop();


			}
			else
			{
				/*
				 * File classpathRoot = new File(System.getProperty("user.dir")); File app = new
				 * File(classpathRoot, "SeleniumGrid//chromedriver.exe"); String PROP_FILE =
				 * app.getAbsolutePath(); System.setProperty("webdriver.chrome.driver",
				 * PROP_FILE);
				 */
				WebDriverManager.chromedriver().setup();
				DesiredCapabilities caps = DesiredCapabilities.chrome();

				String MavenCmdLineheadless="";
				MavenCmdLineheadless=System.getProperty("headlesstest");
				System.out.println("Maven externalized parameter: "+MavenCmdLineheadless);	
				if (MavenCmdLineheadless==null)
					MavenCmdLineheadless=Config.Get("CHROME.HEADLESS");
				else
				{
					if (MavenCmdLineheadless.equalsIgnoreCase("yes"))
						MavenCmdLineheadless="yes";
					else if(MavenCmdLineheadless.equalsIgnoreCase("no"))
						MavenCmdLineheadless="no";
				}

				ChromeOptions options=new ChromeOptions();
				if (MavenCmdLineheadless.equalsIgnoreCase("yes")){
					options.addArguments("headless");
					options.addArguments("--no-sandbox");
					options.addArguments("--window-size=1325,744");
					options.merge(caps);
					caps.setCapability(ChromeOptions.CAPABILITY, options);
					caps.setCapability("acceptInsecureCerts", true);	
				}

				this.driver = new ChromeDriver(caps);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);

			}
		}
		else if (browser.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			DesiredCapabilities dcie = DesiredCapabilities.internetExplorer();
			dcie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);							
			driver = new InternetExplorerDriver(dcie);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("ieedge")){
			WebDriverManager.edgedriver().setup();         
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(objSyncTime, TimeUnit.SECONDS);
		}

		return(driver);
	}


//	public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
//		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
//		try {
//			String hostIp = Inet4Address.getLocalHost().getHostAddress();
//			seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
//			seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//			Assert.fail("invalid Host Address");
//		}
//		return seleniumProxy;
//	}
	public BrowserMobProxy getProxyServer() {
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);
		proxy.start();
		return proxy;
	}  

}



