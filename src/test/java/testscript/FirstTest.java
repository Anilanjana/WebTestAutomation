package testscript;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericlibrary.BrowserUtilities;
import genericlibrary.LogUtilities;
import genericlibrary.ScreenshotUtilities;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class FirstTest extends BrowserUtilities{

	LoginPage lpobj;
	HomePage hpobj;
	Logger log;
	
	public FirstTest() {
		super();
	}
	
	@BeforeTest
	public void launch() throws IOException, InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		BrowserUtilities.getBrowser();
		LogUtilities.info("Browser launched with url Successfully");
	}

	@BeforeMethod
	public void initializePage() {
		lpobj = new LoginPage(BrowserUtilities.driver);
		hpobj=new HomePage(BrowserUtilities.driver);
	}

	@Test
	public void firstTest() throws IOException {
		try { 
			
			lpobj.loginUser();
			String actualmsg=lpobj.Invalid_email_address_msg.getText();
			System.out.println(actualmsg);
			Assert.assertEquals(actualmsg, "Invalid email address");
			
		} catch (Exception e) {
			System.out.println("Test failed");
		}
	}

	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtilities.captureScreenShot();
		}
	}

	@AfterTest
	public void crash() {
		//BrowserUtilities.closeBrowser();
		LogUtilities.info("Browser closed Successfully");
	}
	
}
