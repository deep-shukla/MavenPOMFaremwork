package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UIUtils;

public class LandingPage {
	
	//WebDriver ldriver;
	
	
	@FindBy(xpath="//a[text()='Sign in']") 
	WebElement signIn;
	
	/*@FindBy(how=How.XPATH,using="//a[text()='Sign in']") 
	WebElement signIn;*/
	
	
	public LandingPage(WebDriver driver){		
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() throws Exception{
		UIUtils.click(signIn);
	}
	
	public void verifyTitle(WebDriver driver) throws IOException, InterruptedException{
		UIUtils.fn_verifytext(UIUtils.fn_getTitle(driver), "Resume Help: Instantly Create Your Resume Online");
	}

}
