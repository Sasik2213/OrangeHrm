package org.sasiguides.nopCommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sasiguides.nopCommerce.testcases.pages.UserLoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	
	public WebDriver driver;
	
	@BeforeTest
	public void start() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
	}
	@AfterTest
	public void end() {
		driver.quit();
	}
	
	@Test
	public void addToCart() throws Exception {
	
		UserLoginPage loginPage = new UserLoginPage(driver);
		loginPage.entryValuesForLogin("hell@gmail.com","hello@123");
		driver.findElement(By.xpath("//img[@title='Show products in category Electronics']")).click();
		driver.findElement(By.xpath("//img[@title='Show products in category Cell phones']")).click();	
		driver.findElement(By.xpath("//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
		driver.findElement(By.xpath("//button[@id='updatecart']")).click();
		driver.findElement(By.xpath("//a[@id='open-estimate-shipping-popup']")).click();
		WebElement countrySele = driver.findElement(By.xpath("//select[@id='CountryId']"));
		Select select = new Select(countrySele);
		select.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@id='ZipPostalCode']")).sendKeys("789654");
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='×']")).click();
		driver.findElement(By.xpath("//input[@id='discountcouponcode']")).sendKeys("789456");
		driver.findElement(By.xpath("//button[@id='applydiscountcouponcode']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
		WebElement shipCountry = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
		Select selectShipcountry = new Select(shipCountry);
		selectShipcountry.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Ewiddkd");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("address11");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("654987");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")).click();
		driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
		driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
		driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
		driver.findElement(By.xpath("//span[@class='wishlist-label']")).click();
		driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
	}

}
