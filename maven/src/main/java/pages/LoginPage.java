package pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.UIUtils;

/**
 * 
 * 
 * @author Deep.Shukla
 * 
 * This class all the locators and methods of Login Page
 *
 */

public class LoginPage {
	
	@FindBy(id="UserName")
	WebElement uname;
	
	@FindBy(how=How.ID,using="Password")
	WebElement upwd;
	
	@FindBy(how=How.ID,using="loginSubmit")
	WebElement loginbtn;
	
	@FindBy(id="LoginError")
	WebElement loginerror;
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void loginToSite(String usname, String pswd) throws IOException, InterruptedException{
		
		UIUtils.Input(uname, usname);
		UIUtils.Input(upwd, pswd);
		UIUtils.click(loginbtn);
	}
	
	
	public void verifyLoginwithIncorrectPassword() throws IOException, InterruptedException{
		String expected="* The password you entered is incorrect. Please try again or use the forgot password link.";
		UIUtils.fn_verifytext(loginerror, expected);
	}
	
}
