package Com.QA.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.QA.Base.TestBase2;
import Com.QA.PageObjects.HomePageObjects;
import Com.QA.PageObjects.LoginPageObjects;
import Com.QA.PageObjects.Login_PageObjects;

public class Login_TestCases extends TestBase2 {
	
	
	
	Login_PageObjects login;
	HomePageObjects HomePage;
	
	
	public Login_TestCases() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		Initilization();
		login = new Login_PageObjects();
	}
	
	@Test(priority=1)
	public void VerifyPageTitleTest()
	{
		String PageTitle=login.VerifyPageTitle();
		Assert.assertEquals(PageTitle,"Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void LoginTest()
	{
		HomePage = login.Login(Pro.getProperty("UN"), Pro.getProperty("PW"));
	}
	
	@AfterMethod
	public void CloseMethod() throws IOException
	{
		driver.close();
	}
	
	
	

}
