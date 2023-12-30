package org.orangeHrm.UserDashboard.testscenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.orangeHrm.testscenarios.pages.LoginPage;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondScenario {

	public WebDriver driver;
	public LoginPage loginPage;
	public Actions actions;

	@Test
	public void secondScenario() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		loginPage.enterLoginDetails("Admin", "admin123");
		actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath("//li[1]//a[1]//span[1]"))).build().perform();
		actions.click(driver.findElement(By.xpath("//button[normalize-space()='Add']"))).build().perform();
		actions.click(
				driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")))
				.build().perform();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		WebElement hintsText = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		hintsText.sendKeys("a");
		Thread.sleep(3000);
		actions.sendKeys(hintsText, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		actions.click(
				driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")))
				.build().perform();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")), "testings1")
				.build().perform();
		actions.sendKeys(driver.findElement(By.xpath("(//input[@type='password'])[1]")), "test12345").build().perform();
		actions.sendKeys(driver.findElement(By.xpath("(//input[@type='password'])[2]")), "test12345").build().perform();
		actions.click(driver.findElement(By.xpath("//button[normalize-space()='Save']"))).build().perform();
	}

}
