package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import constant.AppUtil;

public class FunctionLibrary extends AppUtil{
	//method for login
	public static boolean verifyLogin(String username,String password)throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjUser"))).sendKeys(username);
		driver.findElement(By.xpath(config.getProperty("ObjPass"))).sendKeys(password);
		driver.findElement(By.xpath(config.getProperty("ObjLoginbtn"))).click();
		Thread.sleep(4000);
		String expected ="adminflow";
		String actual =driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log("Login Success::"+expected+"     "+actual,true);
			return true;
		}
		else
		{
			Reporter.log("Login Success::"+expected+"     "+actual,true);
			return false;
		}
	}
	//method for branches click
	public static void clickBranches()throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjClickBrances"))).click();
		Thread.sleep(4000);
	}
	//method for new branch creation
	public static boolean verifynewBranch(String BranchName,String Address1,String Address2,String Address3,String Area,String Zipcode,
			String country,String state,String city)throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjNewBranch"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.getProperty("ObjBranchName"))).sendKeys(BranchName);
		driver.findElement(By.xpath(config.getProperty("ObjAddress1"))).sendKeys(Address1);
		driver.findElement(By.xpath(config.getProperty("ObjAddress2"))).sendKeys(Address2);
		driver.findElement(By.xpath(config.getProperty("ObjAddress3"))).sendKeys(Address3);
		driver.findElement(By.xpath(config.getProperty("ObjArea"))).sendKeys(Area);
		driver.findElement(By.xpath(config.getProperty("Objzipcode"))).sendKeys(Zipcode);
		new Select(driver.findElement(By.xpath(config.getProperty("ObjCountry")))).selectByVisibleText(country);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objstate")))).selectByVisibleText(state);
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objcity")))).selectByVisibleText(city);
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.getProperty("ObjSubmitbtn"))).click();
		Thread.sleep(3000);
		//capture alert
		String expectedBranchalert =driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String Actualalert ="New Branch with";
		if(expectedBranchalert.toLowerCase().contains(Actualalert.toLowerCase()))
		{
			Reporter.log(expectedBranchalert,true);
			return true;
		}
		else
		{
			Reporter.log("New Branch Creation Fail",true);
			return false;
		}
	}
//mehod for branch updation
	public static boolean verifyBranchUpdate(String BranchName,String Adddress,String zipcode)throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjEdit"))).click();
		Thread.sleep(3000);
		WebElement bname =driver.findElement(By.xpath(config.getProperty("ObjBranch")));
		bname.clear();
		bname.sendKeys(BranchName);
		Thread.sleep(3000);
		WebElement add =driver.findElement(By.xpath(config.getProperty("ObjAddress")));
		add.clear();
		add.sendKeys(Adddress);
		Thread.sleep(3000);
		WebElement zip =driver.findElement(By.xpath(config.getProperty("Objzip")));
		zip.clear();
		zip.sendKeys(zipcode);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("ObjUpdateBtn"))).click();
		Thread.sleep(4000);
		String expectedbrachupdate =driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String actualupdatealert ="Branch updated";
		if(expectedbrachupdate.toLowerCase().contains(actualupdatealert.toLowerCase()))
		{
			Reporter.log(expectedbrachupdate,true);
			return true;
		}
		else
		{
			Reporter.log("Branch update Fail",true);
			return false;
		}
		
	}
	//method for logout
	public static boolean verifyLogout()throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjLogout"))).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(config.getProperty("ObjLoginbtn"))).isDisplayed())
		{
			Reporter.log("Logout success",true);
			return true;
		}
		else
		{
			Reporter.log("Logout success",true);
			return false;
		}
	}
	public static void addition()
	{
		int a=23,b=9,c;
		c=a+b;
		System.out.println(c);
	}
}

















