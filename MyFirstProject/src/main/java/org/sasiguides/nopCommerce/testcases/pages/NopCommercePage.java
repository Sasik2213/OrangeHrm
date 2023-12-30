package org.sasiguides.nopCommerce.testcases.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NopCommercePage {

	public WebDriver driver;
	
	public NopCommercePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement RegisterBtn;
	
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement genderOption;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameBtn;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dobBtn;
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement dobMonthbtn;
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement dobYearbtn;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailBtn;
	@FindBy(xpath ="//input[@id='Company']" )
	WebElement companyBtn;
	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement newsElement;
	@FindBy(xpath = "(//input[@id='Password'])[1]")
	WebElement passwordBtn;
	@FindBy(xpath = "(//input[@id='ConfirmPassword'])[1]")
	WebElement confirmPassword;
	@FindBy(xpath = "//button[@id='register-button']")
	WebElement registerBtn;
	
	public void enterYourDetails(String fname,String lname,String email_id,String company_name,String passcode,String confirm_passcode) {
		genderOption.click();
		firstName.sendKeys(fname);
		lastNameBtn.sendKeys(lname);
		Select birthdayDateSelect = new Select(dobBtn);
		birthdayDateSelect.selectByVisibleText("1");
		Select birthMonth = new Select(dobMonthbtn);
		birthMonth.selectByVisibleText("January");
		Select birthYearSele = new Select(dobYearbtn);
		birthYearSele.selectByVisibleText("2000");
		emailBtn.sendKeys(email_id);
		companyBtn.sendKeys(company_name);
		newsElement.click();
		passwordBtn.sendKeys(passcode);
		confirmPassword.sendKeys(confirm_passcode);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		registerBtn.click();
	}
	
}
