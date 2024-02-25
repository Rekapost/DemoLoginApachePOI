package loginUsingParameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectPassword {
	WebDriver driver;
	@BeforeMethod
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	@Parameters({"username","password"})
	public void loginWithCorrectPassword(String userName,String  passWord) {
		driver.get("https://practice.automationtesting.in/my-account/");
		WebElement UsernameBox=driver.findElement(By.id("username"));
		UsernameBox.sendKeys(userName);
		WebElement passwordBox=driver.findElement(By.id("password"));
		passwordBox.sendKeys(passWord);
		WebElement login=driver.findElement(By.xpath("//*[@id=\'customer_login\']/div[1]/form/p[3]/input[3]"));
		login.click();
	}
	
	@AfterMethod
	public void aftertest() {
		driver.quit();
	}

}
