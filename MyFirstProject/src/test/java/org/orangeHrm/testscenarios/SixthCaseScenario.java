package org.orangeHrm.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.orangeHrm.testscenarios.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SixthCaseScenario {

	public Properties properties;
	public File fs;
	public FileInputStream fis;
	public WebDriver driver;

	@BeforeTest
	public void start() throws IOException {
		/* Cross Browser Testing Codes Goes Here */
		properties = new Properties();
		fs = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config.properties");
		fis = new FileInputStream(fs);
		properties.load(fis);
		/*
		 * Here we're taking information related browser from config.properties file
		 */
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			/*
			 * Here Checks the browserName whether equals to Chrome browser or something
			 * else
			 */
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			/*
			 * Here Checks the browserName whether equals to Chrome browser or something
			 * else
			 */
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

//	@AfterTest
	public void end() {
		driver.close();
	}

	@Test
	public void testName() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginDetails("Admin", "admin123");
		WebElement menu = driver.findElement(By.xpath("//ul[@class='oxd-main-menu']"));
		menu.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM'])[1]")).click();
		Actions actions = new Actions(driver);
		WebElement empName = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		actions.sendKeys(empName, "Aa").build().perform();
		Thread.sleep(3000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("0256");
		actions.click(driver.findElement(By.xpath("(//i)[8]"))).build().perform();
	}

}
