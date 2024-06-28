package headlessBrowserTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessBrowser 
{
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		//options.setHeadless(true);
		
		driver = new ChromeDriver(options);
		System.out.println("Working on Headless Mode......");
	}
	@Test
	public void dragAndDrop()
	{
		
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		System.out.println("The title of the page is " +driver.getTitle());
		
		
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.manage().window().maximize();
	     
	     WebElement eleSource = driver.findElement(By.id("column-a"));
	     WebElement eleTarget= driver.findElement(By.id("column-b"));
		
	     
	     Actions builder = new Actions(driver);
	   
	     builder.dragAndDrop(eleSource, eleTarget).perform();
	     
	     String textTo = eleTarget.getText();
	     if(textTo.equals("A")) {
	     System.out.println("PASS: File is dropped to target as expected");
	     }else {
	     System.out.println("FAIL: File couldn't be dropped to target as expected");
	     }
	}
	@Test
	public void anaajApp()
	{
		driver.get("https://anaaj.net/my-account");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	     
	    System.out.println("Title : " +driver.getTitle());
	    System.out.println("Page url : " +driver.getCurrentUrl());
	    System.out.println("\n"); 
	    
	   driver.findElement(By.id("email-2")).sendKeys("8555079032");
	   WebElement password = driver.findElement(By.name("password"));
	   password.sendKeys("Moksha@111");
	   
	   WebElement btn = driver.findElement(By.id("login_id"));
	   btn.click();
	   
	   String actualurl= "https://anaaj.net/search-products";
	   String expectedurl = driver.getCurrentUrl();
	   if(actualurl.equals(expectedurl))
	   {
		   System.out.println("Successful login");  
	   }
	   else
	   {
		   System.out.println("Login Failed"); 
	   }
	}
	@AfterClass
	public void teardown()
	{
	     driver.close();
		  
	}
}
