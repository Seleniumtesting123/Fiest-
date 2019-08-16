package Com.QA.ExtentsReports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import static Com.QA.Base.TestBase.*;

public class Screenshot extends TestListenerAdapter {

	String destDir;
	String destFile;
	File scrFile;
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	public void onTestFailure(ITestResult tr) {
		try {
			scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

		} catch (Exception e) {
			System.out.println("Unable to take screenshot");
			e.printStackTrace();
		}

		try {
			DateFormat dateFormat = new SimpleDateFormat(
					"dd_MMM_yyyy__hh_mm_ssaa");
			destDir = "C:\\Workspace\\PageObjects\\Screenshots2";
			new File(destDir).mkdirs();
			destFile = dateFormat.format(new java.util.Date()) + ".png";
			new File(destDir + "/" + destFile);

			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			System.setProperty(ESCAPE_PROPERTY, "false");
			Reporter.log("<a href='file:///" + destDir + "/" + destFile
					+ "'> <img src='file:///" + destDir + "/" + destFile
					+ "' hight='550' width='649'/> </a>");

		} catch (IOException e) {
			Reporter.log("error generating screenshot for " + destDir + "/"
					+ destFile + ": " + e, true);

		}

	}

}
