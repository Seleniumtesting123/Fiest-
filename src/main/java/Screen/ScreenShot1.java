package Screen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot1 {
	
	WebDriver driver ;
	
	
	@Test
	 public void TestJavaS1() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\selenium-java-3.141.59\\chromedriver.exe");
	
	 WebDriver driver=new ChromeDriver();
	 

	driver.manage().window().maximize();
	 

	driver.get("http://www.google.com");
	 
	
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	 
	//FileUtils.copyFile(src, new File("./Screenshot/google.png"));
	
	FileUtils.copyFile(src, new File("./Screenshot/google.png"));

	
	System.out.println("taken");
	
	}
}
