package loginUsingDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
String[][] data={	
		{"rekaharisri@gmail.com","Admi2/888'''"},
		{"rekaha@gmail.com","Admin123///888'''"},
		{"rekahari@gmail.com","Admi2/888'''"},
		{"rekaharisri@gmail.com","Admin123///888'''"}		
	};
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider()
	{	
		//return the test data
		return data;
	}
	
	@Test(dataProvider ="loginData" )
		public void loginWithBothCorrect(String userName,String  passWord) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://practice.automationtesting.in/my-account/");
			WebElement UsernameBox=driver.findElement(By.id("username"));
			UsernameBox.sendKeys(userName);
			WebElement passwordBox=driver.findElement(By.id("password"));
			passwordBox.sendKeys(passWord);
			WebElement login=driver.findElement(By.xpath("//*[@id=\'customer_login\']/div[1]/form/p[3]/input[3]"));
			login.click();
			driver.quit();
		}

	}

