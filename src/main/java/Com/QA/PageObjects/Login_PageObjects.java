package Com.QA.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.QA.Base.TestBase2;

public class Login_PageObjects extends TestBase2 {
	
	
	@FindBy(id="email")
	WebElement Username;
	
	@FindBy(id="pass")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LoginButton;
		
	public Login_PageObjects() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePageObjects Login(String UN,String PW)
	{
		Username.sendKeys(UN);
		Password.sendKeys(PW);
		LoginButton.submit();
		
		return new HomePageObjects();
	}
}

