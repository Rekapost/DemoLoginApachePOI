package loginUsingDataProvider;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

//String[][] data={	
//		{"rekaharisri@gmail.com","Admi2/888'''"},
//		{"rekaha@gmail.com","Admin123///888'''"},
//		{"rekahari@gmail.com","Admi2/888'''"},
//		{"rekaharisri@gmail.com","Admin123///888'''"}		
//	};

	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() {
		String[][] data = { { "rekaharisri@gmail.com", "Admi2/888'''" }, { "rekaha@gmail.com", "Admin123///888'''" },
							{ "rekahari@gmail.com", "Admi2/888'''" }, { "rekaharisri@gmail.com", "Admin123///888'''" } 
						  };
		// return the test data
		return data;
	}

	@Test(dataProvider = "loginData")
	public void loginWithParameters(String userName, String passWord) {
//          System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();		
//	        WebDriverManager.chromedriver().clearDriverCache();
//	        WebDriverManager.chromedriver().clearResolutionCache();

//	        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().usingAnyFreePort().build();
//          webDriver = new ChromeDriver(chromeDriverService, options);
//          webDriver.manage().window().maximize();
//          ((JavascriptExecutor) webDriver).executeScript("document.body.style.zoom='100%';");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().clearDriverCache();
		WebDriverManager.chromedriver().clearResolutionCache();
		// WebDriverManager.chromedriver().browserVersion("110.0.0").setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(chromeOptions);
		// WebDriver driver=new ChromeDriver();
		driver.get("https://practice.automationtesting.in/my-account/");
		WebElement UsernameBox = driver.findElement(By.id("username"));
		UsernameBox.sendKeys(userName);
		WebElement passwordBox = driver.findElement(By.id("password"));
		passwordBox.sendKeys(passWord);
		WebElement login = driver.findElement(By.xpath("//*[@id=\'customer_login\']/div[1]/form/p[3]/input[3]"));
		login.click();
		driver.quit();
	}

}
