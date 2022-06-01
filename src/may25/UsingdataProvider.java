package may25;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class UsingdataProvider {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		
	}
	@Test(dataProvider = "supplyData")
	public void verifyLogin(String user,String password) {
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		String expected ="dashboard";
		String actual =driver.getCurrentUrl();
		if(actual.contains(expected))
		{
			Reporter.log("Login success::"+expected+"      "+actual,true);
		}
		else
		{
			Reporter.log("Login Fail::"+expected+"      "+actual,true);
		}
	}

	@DataProvider
	public Object[][] supplyData() {
		Object login [][]= new Object[4][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin";
		login[1][1]="Qedge123!@#";
		login[2][0]="Admin";
		login[2][1]="Qedge123!@#";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@#";
		return login;
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
