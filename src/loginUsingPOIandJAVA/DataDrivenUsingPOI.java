package loginUsingPOIandJAVA;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUsingPOI {
	String[][] data=null;
	WebDriver driver;

	@DataProvider(name="loginData")
	public String[][]loginDataProvider() throws IOException
	{		
		//return the test data
		data=getExcelData();
		return data;
	}

	public String[][] getExcelData() throws IOException
	{
		FileInputStream excel=new FileInputStream("C:\\Users\\Reka\\Desktop\\New\\Eclipse\\loginData1.xlsx");
		XSSFWorkbook workBook= new XSSFWorkbook(excel);
		XSSFSheet sheet=workBook.getSheetAt(0);
		int noOfRows = sheet.getLastRowNum()+1;
	    int noOfColumns = sheet.getRow(0).getLastCellNum();
	    String[][] dataTable = new String[noOfRows][noOfColumns];

	    for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum() + 1; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
	            Cell cell = row.getCell(j);
	            dataTable[i][j] = cell.getStringCellValue();
	        }
	    }
	    return dataTable;
	}
		

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reka\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}	
	@Test (dataProvider = "loginData")
	public void loginWithCredential(String userName,String passWord)
	{
		driver.get("https://practice.automationtesting.in/my-account/");
		WebElement UsernameBox=driver.findElement(By.id("username"));
		UsernameBox.sendKeys(userName);
		WebElement passwordBox=driver.findElement(By.id("password"));
		passwordBox.sendKeys(passWord);
		WebElement login=driver.findElement(By.xpath("//*[@id=\'customer_login\']/div[1]/form/p[3]/input[3]"));
		login.click();  
		//driver.get("https://admin-demo.nopcommerce.com");
		//WebElement UsernameBox=driver.findElement(By.xpath("//input[@id='Email']"));
		//UsernameBox.sendKeys(userName);
		//WebElement passwordBox=driver.findElement(By.xpath("//input[@id='Password']"));
		//passwordBox.sendKeys(passWord);
		//WebElement login=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		//login.click(); 
	}
}
