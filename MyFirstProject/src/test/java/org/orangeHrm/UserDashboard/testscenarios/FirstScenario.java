package org.orangeHrm.UserDashboard.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;
import org.orangeHrm.UserDashboard.testscenarios.pages.AdminPage;
import org.orangeHrm.testscenarios.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScenario {

	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	public File fs;
	public LoginPage loginPage;
	public AdminPage adminPage;

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
	public void userDashboardScenario1() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		loginPage.enterLoginDetails("Admin", "admin123");
		WebElement dashboard = driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.getElementsByTagName('span')[0].click()");
		driver.findElement(By.xpath(
				"//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"))
				.sendKeys("Admin");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")))
				.build().perform();
		actions.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();

		WebElement textHolder = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		textHolder.sendKeys("Paul");
		Thread.sleep(3000);
		actions.sendKeys(textHolder, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		actions.click(driver.findElement(By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"))).build()
				.perform();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		actions.click(driver.findElement(By.xpath("//button[normalize-space()='Search']"))).build().perform();

	}

}
