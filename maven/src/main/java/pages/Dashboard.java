package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.UIUtils;

public class Dashboard {
	
	@FindBy(how=How.XPATH,using="//ul[@id='ddlMyAccount']/li[2]/a[text()='Log Out']")
	WebElement logout;
	@FindBy(id="lnkMyAccount")
	WebElement myaccount;
	@FindBy(xpath="//div[@class='rh-logo']")
	WebElement logo;
	
	
	public Dashboard(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void verifyLogin(WebDriver driver) throws IOException, InterruptedException{
		String actual=UIUtils.fn_getTitle(driver);
		String expected = "Dashboard | ResumeHelp";
		UIUtils.fn_verifytext(actual, expected);		
	}
	

	public void Logout() throws IOException, InterruptedException{
		UIUtils.click(myaccount);
		UIUtils.click(logout);
		UIUtils.click(logo);
	}

}
