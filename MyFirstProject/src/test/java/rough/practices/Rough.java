package rough.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {
	
	public WebDriver driver;
	
	@Test
	public void roughSession() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		WebElement textSearch = driver.findElement(By.xpath("//input[@id='yschsp']"));
		textSearch.sendKeys("goo");
		Actions actions = new Actions(driver);
		actions.sendKeys(textSearch,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

}
