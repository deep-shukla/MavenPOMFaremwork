package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * 
 * @author Deep.Shukla
 * 
 * This class all the locators and methods of Login Pge
 *
 */

public class LoginPage2 {
	WebDriver driver;
	
	By username = By.id("UserName");
	By password = By.xpath("//*[@id='Password']");
	By loginbtn = By.xpath("//*[@id='loginSubmit']");
	
	public LoginPage2(WebDriver driver){
		this.driver=driver;		
	}
	
	public void loginToSite(String usname, String pswd){
		driver.findElement(username).sendKeys(usname);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(loginbtn).click();
	}
	
	
	public void typeUserName(String uname){
		driver.findElement(username).sendKeys(uname);
		
		}
	
	public void typeUserPassword(String pwd){
		driver.findElement(password).sendKeys(pwd);
		}
	
	public void clickLoginButton(){
		driver.findElement(loginbtn).click();
		
		}
}
