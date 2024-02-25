package loginUsingParameterization;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BothCorrect {
	WebDriver driver;
	
	@BeforeMethod
	public void beforetest() {
//		WebDriverManager.chromedriver().setup();
//	    WebDriverManager.chromedriver().clearDriverCache();
//	    WebDriverManager.chromedriver().clearResolutionCache();
//      WebDriverManager.chromedriver().browserVersion("120.0.0").setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();	
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));			
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
		chromeOptions.addArguments("--remote-allow-origins=*");	
		
		driver=new ChromeDriver(chromeOptions);
	}
	
	@Test
	@Parameters({"username","password"})
	public void loginWithBothCorrect(String userName,String  passWord) {
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
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
