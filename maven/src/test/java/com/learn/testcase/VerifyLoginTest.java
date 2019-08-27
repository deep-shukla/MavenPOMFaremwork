package com.learn.testcase;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.Dashboard;
import pages.LandingPage;
import pages.LoginPage;


/**
 * 
 * @author:Deep.Shukla
 *
 */

public class VerifyLoginTest extends BaseClass{
	
	//public static WebDriver driver;
		
	@Test (priority=2)
	public void verifyValidLogin() throws Exception{		
				
		logger=report.createTest("Start the Application:verifyValidLogin");		
		LandingPage lpage= new LandingPage(driver);
		lpage.clickSignIn();		
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Starting Application");
		loginpage.loginToSite(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
		logger.info("Credentials entered successfully");
		Dashboard dashboard= new Dashboard(driver);
		dashboard.verifyLogin(driver);
		logger.pass("User LoggedIn successfully");
		dashboard.Logout();		
		System.out.println("test case 2");
	}
	
	
	@Test (priority=1)
	public void verifyInvalidlogin() throws Exception{
		logger=report.createTest("Start the Application:verifyInvalidlogin");		
		LandingPage lpage= new LandingPage(driver);
		lpage.clickSignIn();		
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Starting Application");
		loginpage.loginToSite(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));	
		logger.info("Credentials entered successfully");
		loginpage.verifyLoginwithIncorrectPassword();
		logger.pass("Incorrect Password");
	}
}
