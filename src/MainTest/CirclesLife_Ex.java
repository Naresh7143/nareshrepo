package MainTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.HomePaje;
import ObjectRepository.LoginPage;
import ObjectRepository.PlansPage;

public class CirclesLife_Ex {
  public WebDriver driver;
  public String email="naresh.gopalkadiyala@gmail.com"; 
  public String password="susu7143";
	@BeforeTest
	public void openbrowser()
		{
			driver =new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://pages.circles.life/");
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		}
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void navigation_to_loginpage() throws InterruptedException
	{
		
		driver.findElement(HomePaje.sign_up).click();
		//Thread.sleep(10000);
		driver.findElement(HomePaje.sign_in).click();
		
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{
	driver.findElement(LoginPage.email).sendKeys(email);	
	driver.findElement(LoginPage.pass).sendKeys(password);
	driver.findElement(LoginPage.login_button).click();
	
	}
	@Test(priority=3)
	public void email_verification() throws InterruptedException
	{
	driver.findElement(PlansPage.my_account).click();
   String element= driver.findElement(PlansPage.verify_mail).getAttribute("value");
    System.out.println("email valus is:"+element);
    Assert.assertEquals(email, element);
	
	}
		

	}


