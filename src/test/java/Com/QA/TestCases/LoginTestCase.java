package Com.QA.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.QA.Base.TestBase;
import Com.QA.PageObjects.HomePageObjects;
import Com.QA.PageObjects.LoginPageObjects;

public class LoginTestCase extends TestBase{
	LoginPageObjects loginpage;
	HomePageObjects  homepage;

	public LoginTestCase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		Initialize();
		loginpage = new LoginPageObjects();
	}
	
	@Test(priority=1)
	public void VerifyPageTitleTest()
	{
		String PageTitle=loginpage.VerifyPageTitle();
		Assert.assertEquals(PageTitle,"Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void LoginTest()
	{
		homepage = loginpage.Login(Pro.getProperty("UN"), Pro.getProperty("PW"));
	}
	
	@AfterMethod
	public void CloseMethod() throws IOException
	{
		driver.close();
	}
	

}
