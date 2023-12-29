package org.orangeHrm.testscenarios.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmDashboard {

	public WebDriver driver;
	
	public OrangeHrmDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement userDropDown;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logOutBtn;
	
	public void userDropDownOperation() {
		userDropDown.click();
	}
	public void logOutOperation() {
		logOutBtn.click();
	}
}
