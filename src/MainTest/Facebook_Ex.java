package MainTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectRepository.FacebookHomePage;
import ObjectRepository.FacebookLoginPage;

public class Facebook_Ex {
	public WebDriver driver;
	public String my_comment ="This is my first Comment";
	@BeforeClass
	public void openbrowser()
	{
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
@AfterClass
public void closebrowser()
{
	driver.quit();
}

@Test
public void fb_login()
{
	driver.findElement(FacebookLoginPage.fb_email).sendKeys("usert7091@gmail.com");
	driver.findElement(FacebookLoginPage.fb_pass).sendKeys("Abc@12345");
	driver.findElement(FacebookLoginPage.fb_login).click();
}

@Test(dependsOnMethods= {"fb_login"})
public void fb_comment()
{
	driver.findElement(FacebookHomePage.fb_home).click();
	
	WebElement ele1= driver.findElement(FacebookHomePage.fb_comment);
	/*driver.findElement(FacebookHomePage.fb_comment).click();
	driver.findElement(FacebookHomePage.fb_comment).sendKeys("hai this is my first comment");
	
	String cmt=driver.findElement(FacebookHomePage.fb_comment).getText();
	System.out.println(cmt);*/
	
	JavascriptExecutor je =(JavascriptExecutor)driver;
	je.executeScript("arguments[0].scrollIntoView(true)",ele1 );
	System.out.println(ele1.getText());
	ele1.click();
	ele1.sendKeys("my first test");
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER);
	
	
}

@Test(dependsOnMethods= {"fb_comment"})
public void fb_verify_comment()
{
	String comment=driver.findElement(FacebookHomePage.fb_verify_comment).getText();
	System.out.println("comment is:"+comment);
	Assert.assertEquals(comment, my_comment);
	
}

}
