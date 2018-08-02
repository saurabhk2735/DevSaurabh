package org.srk.PNCSRK;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.WebDriverFactory;

public class register {

	private WebDriver driver;

	@Test(priority=1)
	public void Register() {
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Saurabh");
		driver.findElement(By.name("lastName")).sendKeys("saurabh");
		driver.findElement(By.name("phone")).sendKeys("987456321");
		driver.findElement(By.id("userName")).sendKeys("srk@gmai.com");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Pune chor gali");
		driver.findElement(By.name("city")).sendKeys("PUNE");

		Select country = new Select (driver.findElement(By.name("country")));  // clt+Shift+O
		country.selectByVisibleText("INDIA");

		driver.findElement(By.id("email")).sendKeys("SRK");	  
		driver.findElement(By.name("password")).sendKeys("srk@123");
		driver.findElement(By.name("confirmPassword")).sendKeys("srk@123");

		driver.findElement(By.name("register")).click();

	}

	@Test(priority=2)
	public void login() {
		driver.findElement(By.linkText("sign-in")).click();		  
		driver.findElement(By.name("userName")).sendKeys("SRK");
		driver.findElement(By.name("password")).sendKeys("srk@123");
		driver.findElement(By.name("login")).click();

	}  
	
	
	@BeforeTest
	public void beforeTest() {
	//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdc4-training.pdc4\\Downloads\\Driver\\chromedriver.exe");
			//  driver = new ChromeDriver();

			driver = WebDriverFactory.createDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");

	}

//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}

}
