package pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utility.BrowserUtility;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.UIUtils;


public class BaseClass {
	
	public static WebDriver driver;
	public ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentHtmlReporter extenthtmlreport;
    public static ExtentReports report;
	public static ExtentTest logger;
	
	
	@BeforeSuite
	public void setupsuite() throws IOException{
		Reporter.log("Setting up the report and test is getting ready", true);
		
		excel= new ExcelDataProvider(); ///Instantiate excel objcet
		config = new ConfigDataProvider();
		extenthtmlreport = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/RH_"+UIUtils.currentTimeStamp()+".html"));
		report = new ExtentReports();
		report.attachReporter(extenthtmlreport);		
		Reporter.log("Setting up the report and test can be started", true);
	}
	 
	@BeforeTest
	public void setup(){
		
		Reporter.log("Trying to start he browser and getting application ready", true);
		
		driver=BrowserUtility.startApplication(config.getDataFromConfig("Browser"), config.getDataFromConfig("url"));
		
		Reporter.log("Browser and application are up and running", true);
	}

	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException{
		
		Reporter.log("Test is about to end", true);		
		if (ITestResult.FAILURE==result.getStatus())
		{
			String screenshotpathname=UIUtils.captureScreenshot(driver); 
			logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpathname).build());
			logger.fail(MarkupHelper.createLabel(result.getName() + " Test case failed ", ExtentColor.RED));
			String testresult = "Details of Fail Testcase:" + result.getThrowable();
	        logger.info(testresult);
		}else if (ITestResult.SUCCESS==result.getStatus())
		{
			logger.pass("Test Case Passed");
			logger.pass(MarkupHelper.createLabel(result.getName() + " Test case passed ", ExtentColor.GREEN));
		}else
		{
			logger.skip("Test Case Skipped");
			logger.skip(MarkupHelper.createLabel(result.getName() + " Test case passed ", ExtentColor.YELLOW));
		}
		Reporter.log("Test is end now>>>> Reports Generated", true);
		//report.flush();		
		//BrowserUtility.quit(driver);
	}
	
		
	@AfterClass
	public void teardown(){	
		BrowserUtility.quit(driver);
	}
	
	@AfterSuite
	public void testdown(){
		report.flush();		
	}
}
