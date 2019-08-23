package com.learn.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LandingPage;

public class VerifyLandingPageTest extends BaseClass {
	
	
	@Test
	public void verifyPageTitle() throws IOException, InterruptedException{
		logger=report.createTest("Start the Application:verifyValidLogin");		
		LandingPage lpage= new LandingPage(driver);
		logger.info("Landing Page Launched");
		lpage.verifyTitle(driver);
		logger.pass("Correct Page Title");
		System.out.println("test case 1");
	}

}
