package org.srk.PNCSRK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPageObject;
import utility.WebDriverFactory;

public class Login {

	private WebDriver driver;

	@Test(dataProvider="usernameandpassword", description="This Test case will")
	//@Test(priority=2)
	public void login(String username,String password){
		LoginPageObject.uname.clear();
		LoginPageObject.uname.sendKeys(username);
		LoginPageObject.pass.clear();
		LoginPageObject.pass.sendKeys(password);
		LoginPageObject.login_button.click();
		driver.navigate().back();
	}

	@DataProvider(name="usernameandpassword")
	public String[][] credentials(){
		return new String[][] {
			new String [] {"invalidUN","invalidPW"},
			new String [] {"username1","password1"}
		}; 

	}

	@BeforeTest
	public void beforeTest() {
		//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdc4-training.pdc4\\Downloads\\Driver\\chromedriver.exe");
		//  driver = new ChromeDriver();

		driver = WebDriverFactory.createDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		PageFactory.initElements(driver,LoginPageObject.class);


	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
