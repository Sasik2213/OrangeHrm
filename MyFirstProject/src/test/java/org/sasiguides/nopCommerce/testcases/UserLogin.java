package org.sasiguides.nopCommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sasiguides.nopCommerce.testcases.pages.UserLoginPage;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {
	
	public WebDriver driver;
	
	
	@Test
	public void login() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		UserLoginPage loginPage = new UserLoginPage(driver);
		loginPage.entryValuesForLogin("hell@gmail.com","hello@123");
		loginPage.performLogout();
		
		
		
	}
	
}
