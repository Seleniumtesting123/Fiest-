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

public class TestBase2 {
	
	
	public static WebDriver driver;
	public static Properties Pro;
	
	public TestBase2() throws IOException
	{
		Pro = new Properties();
		
		FileInputStream F1 = new FileInputStream("C:\\Users\\Lenovo\\Downloads\\PageObjects\\PageObjects\\src\\main\\java\\Com\\QA\\EnvironmentUtilities\\EnnVar.properties");
		Pro.load(F1);
	}
	
	
	public void Initilization()
	{
		String Browsername =Pro.getProperty("Browser");
		if(Browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(Pro.getProperty("Firefox_Key"), Pro.getProperty("Firefox_Path"));
			
			driver = new FirefoxDriver();
			
		}
		if(Browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(Pro.getProperty("Chrome_Key"), Pro.getProperty("Chrome_Path"));
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Pro.getProperty("AppUrl"));
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PageLoadTime, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtils.ImplicityTime, TimeUnit.SECONDS)
	}
	
	
}
