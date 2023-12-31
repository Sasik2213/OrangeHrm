package org.sasiguides.nopCommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sasiguides.nopCommerce.testcases.pages.NopCommercePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginNopCommerce {
	
	/* Declare the Webdriver */
	public WebDriver driver;
	public Actions actions;
	
	/*
	 * Here,BeforeTest method refers for every time we run different methods of
	 * TestNG codes every time starts with Before Test code
	 */
	@BeforeTest
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

	/*
	 * Here,AfterTest method refers for every time we run differnt methods of
	 * TestNG codes every time starts with Before Test code and ends with AfterTest
	 */
//	@AfterTest
	public void end() {
		driver.close();
	}
	
	/* Here,We are trying to implement the noPCommerceRegistration */
	@Test
	public void nopCommerceRegister() throws Exception {
		/* Here,We giving Implicit Wait for the Webbrowser */
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		NopCommercePage commercePage = new NopCommercePage(driver);
		commercePage.enterYourDetails("Hell","worl","hell@gmail.com","Hello","hello@123","hello@123");
	}

}
