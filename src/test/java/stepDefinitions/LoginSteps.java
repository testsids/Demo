package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.auto.base.BasePage;
import com.auto.base.ILogLevel;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
public class LoginSteps extends BasePage {
	
	@Before
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//driver_windows//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://staging.1click2deliver.com/");
	 }
	
	@Given("^I am on home page$")
	public void user_is_on_Home_Page(){
		Assert.assertEquals(driver.getTitle(),"OneClick Delivery Services");
	}
	
	@When("^I enter user name$")
	public void i_enter_Mobile_Number() {
		driver.findElement(By.xpath("//input[@title='Enter login']")).sendKeys("Sachin");
		log("Enter user name",ILogLevel.METHOD);
	}
	
	@And("^I enter password$")
	public void i_enter_Password() {
		driver.findElement(By.id("passwordInput")).sendKeys("Testing@123");
		log("Enter password",ILogLevel.METHOD);
	}
	
	@And("^I click login button$")
	public void i_click_loginButton() {
		driver.findElement(By.cssSelector(".dx-button-text")).click();
		log("click on login button",ILogLevel.METHOD);
	}
	
	@After
	public void setStatus() {
	driver.quit();
	}
}
