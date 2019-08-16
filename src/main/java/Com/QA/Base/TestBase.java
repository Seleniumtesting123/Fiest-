package Com.QA.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.QA.TestUtils.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties Pro;
	
	public TestBase() throws IOException
	{
		Pro = new Properties();
		FileInputStream FI = new FileInputStream("C:\\Users\\Lenovo\\Downloads\\PageObjects\\PageObjects\\src\\main\\java\\Com\\QA\\EnvironmentUtilities\\EnnVar.properties");
		 Pro.load(FI);
		
	}
	
	public static void Initialize()
	{
		String Browsername = Pro.getProperty("Browser");
		
		if(Browsername.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(Pro.getProperty("Chrome_Key"),Pro.getProperty("Chrome_Path"));
			driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty(Pro.getProperty("IE_Key"),Pro.getProperty("IEDriver_Path"));
			driver = new InternetExplorerDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Pro.getProperty("AppUrl"));
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PageLoadTime, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtils.ImplicityTime, TimeUnit.SECONDS);
		
	}

	
}
