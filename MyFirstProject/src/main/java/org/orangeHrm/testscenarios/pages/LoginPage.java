package org.orangeHrm.testscenarios.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public OrangeHrmDashboard dashboard;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWord;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	
	public void enterLoginDetails(String uname,String pswrd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		userName.sendKeys(uname);
		passWord.sendKeys(pswrd);
		loginBtn.click();
	}
	public void logoutOperation() {
		dashboard = new OrangeHrmDashboard(driver);
		dashboard.userDropDownOperation();
		dashboard.logOutOperation();
	}
	@FindBy(xpath = "(//i[@class='oxd-icon bi-chevron-down'])[2]")
	WebElement JobButton;
	
	public void JobButton() {
		JobButton.click();
	}

}
