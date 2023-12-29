package org.orangeHrm.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orangeHrm.testscenarios.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstCaseScenario {

	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	public File fs;
	public LoginPage loginPage;
	@BeforeTest
	public void start() throws IOException {
		/* Cross Browser Testing Codes Goes Here*/
		properties = new Properties();
		fs = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config.properties");
		fis = new FileInputStream(fs);
		properties.load(fis);
		/*
		 * Here we're taking information related browser from config.properties file
		 */
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			/*
			 * Here Checks the browserName whether equals to Chrome browser or something else
			 */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			/*
			 * Here Checks the browserName whether equals to Chrome browser or something else
			 */
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	@AfterTest
	public void end() {
		driver.close();
	}
	@Test
	public void firstCaseScenario() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.enterLoginDetails("Admin","admin123");
		loginPage.logoutOperation();
	}
}
