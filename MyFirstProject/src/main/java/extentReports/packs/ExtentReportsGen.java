package extentReports.packs;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsGen {
	
	public static ExtentReports getExtentReports() {
		ExtentReports extentReports = new ExtentReports();
		File fs = new File(System.getProperty("user.dir")+"//ExtentReports//OneExtent.html");
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fs);
		extentReports.attachReporter(extentSparkReporter);
		extentReports.flush();
		return extentReports;
	}
	
	public String addtestScreenshot(String testName,WebDriver driver) {
		
		File fileSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destSrc = System.getProperty("user.dir")+"\\Images\\"+testName+".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(fileSrc, new File(destSrc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destSrc;
	}

}
