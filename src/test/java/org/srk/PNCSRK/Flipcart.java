package org.srk.PNCSRK;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flipcart {
	
	private WebDriver driver;
	
  @Test
  public void login() {
	  
	    driver.findElement(By.linkText("Login & Signup")).click();
		driver.findElement(By.name("firstName")).sendKeys("Saurabh");
		driver.findElement(By.name("lastName")).sendKeys("saurabh");
		driver.findElement(By.name("phone")).sendKeys("987456321");
		driver.findElement(By.id("userName")).sendKeys("srk@gmai.com");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Pune chor gali");
		driver.findElement(By.name("city")).sendKeys("PUNE");
  }
  
  
  @BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdc4-training.pdc4\\Downloads\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
