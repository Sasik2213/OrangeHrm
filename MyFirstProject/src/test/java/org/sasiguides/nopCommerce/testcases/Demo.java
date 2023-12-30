package org.sasiguides.nopCommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("several");
		WebElement dob = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		Select dobSelect = new Select(dob);
		dobSelect.selectByVisibleText("1");
		WebElement dobMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		Select dobMonthSelect = new Select(dobMonth);
		dobMonthSelect.selectByVisibleText("January");
		WebElement dobYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		Select dobYearSelect = new Select(dobYear);
		dobYearSelect.selectByVisibleText("2000");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("testingstel@gmail.com");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("testingComp");
		driver.findElement(By.xpath("//input[@id='Newsletter']")).click();
		driver.findElement(By.xpath("(//input[@id='Password'])[1]")).sendKeys("hello@12345");
		driver.findElement(By.xpath("(//input[@id='ConfirmPassword'])[1]")).sendKeys("hello@12345");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
	}

}
