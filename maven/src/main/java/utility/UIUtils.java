package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class UIUtils {
	
	
	// Handle Screenshots, alerts, frames, windows, java script executor
	
		public static String captureScreenshot(WebDriver driver) throws IOException{

			String screenshotPath=System.getProperty("user.dir")+"/Screenshot/"+ UIUtils.currentTimeStamp()+".png";
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			try{
			FileHandler.copy(source, new File (screenshotPath));
			System.out.println("Screenshot captured");
			}catch(Exception e){
				System.out.println("Unable to take screenshot"+e.getMessage());
			}
			return screenshotPath;
		}
		
		public static String currentTimeStamp(){
			 	
				DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
				Date currentdate = new Date();
				return customformat.format(currentdate);
			 }
		
		public static void Input(WebElement we, String ValueToInput) throws IOException, InterruptedException{
			we.clear();
			we.sendKeys(ValueToInput);
		}
		
		public static void click(WebElement we) throws IOException, InterruptedException{
			System.out.println(we.getText());			
				if(we.isDisplayed()==true){
					we.click();
				}else
				{
					System.out.println("Item not displaying");
				}					
			}
		
		
		 public static void fn_verifytext(WebElement we, String expected) throws IOException, InterruptedException{
				String actual=we.getText();
				if(expected.equalsIgnoreCase(actual)){
				System.out.println("Pass");
				}else{
				Assert.assertEquals(actual, expected);
				System.out.println("Fail");
				}
			}
		 
		 
		 //Overloaded method to assert the text
		 public static void fn_verifytext(String actual, String expected) throws IOException, InterruptedException{
				if(expected.equalsIgnoreCase(actual)){
				System.out.println("Pass");
				}else{
				Assert.assertEquals(actual, expected);
				System.out.println("Fail");
				}
			}
		 
		 public static void fn_getcookie(WebDriver driver, String cookiename){
			 driver.manage().getCookieNamed(cookiename);
		 }
		 
		 public static String fn_getTitle(WebDriver driver){
			return driver.getTitle();			 
		 }
		 
		 public static void fn_ElementDisplayed(WebElement we){
			 we.isDisplayed();
		 }
		
	}

