package Screen;

import java.io.File;
import java.io.IOException;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Taken {

	
	WebDriver driver ;
	
	@Test
	
	public void login() throws Exception
	{
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\selenium-java-3.141.59\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Rohit");
		
		driver.findElement(By.id("txtPassword")).sendKeys("Rohit@123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshot/orange.png"));
		
		
	}
	
}
