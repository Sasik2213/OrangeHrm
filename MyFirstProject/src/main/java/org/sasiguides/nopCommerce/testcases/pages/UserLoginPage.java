package org.sasiguides.nopCommerce.testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	public WebDriver driver;
	
	public UserLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailBtn;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passBtn;
	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement rememberMe;
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement loginNav;
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement logoutBtn;
	
	public void entryValuesForLogin(String uemail,String passcode) {
		loginNav.click();
		emailBtn.sendKeys(uemail);
		passBtn.sendKeys(passcode);
		loginBtn.click();
	}
	public void performLogout() {
		logoutBtn.click();
	}

}
