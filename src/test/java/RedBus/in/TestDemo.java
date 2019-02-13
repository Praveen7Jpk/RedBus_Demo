package RedBus.in;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelData.ReadExcel;
import PageObject.Login_Page;
import PageObject.Redbus_Home;

public class TestDemo {

	public WebDriver driver;
	public Redbus_Home rh;
	public Login_Page lp;
	public ReadExcel ex;
	
	@BeforeTest
	public void setup() throws Throwable {
		
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--disable-notifications");
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\EMP1\\Documents\\Chrome_Driver\\chromedriver.exe");
		driver =new ChromeDriver(ops);
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		rh=new Redbus_Home(driver);
		lp=new Login_Page(driver);	
		
		//Excel Functions
		ex=new ReadExcel();
		ex.excelfile();
	}
	
	
	@Test(priority=1)
	public void RedBus_Homepage() throws InterruptedException {	
		rh.Home_page();	
	}
	
	@Test(priority=2)
	public void Sign() throws InterruptedException {	
		lp.sign_function();
	}
	
	
}
