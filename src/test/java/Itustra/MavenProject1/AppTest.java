package Itustra.MavenProject1;
/**
 * Unit test for simple App.
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(Itustra.MavenProject1.EventListner.class)

public class AppTest 
{
	WebDriver driver;

	@Test
	public void DoTest()
	{
		assertEquals(false, false);
		Reporter.log("Do test started");
		Reporter.log("Do Test Completed.....");
	}

	@Parameters({"userNameData", "passwordData"})
	@Test
	public void LoginUser(String userName, String Password) {
		//Steps
		Reporter.log("Login User test started");
		Reporter.log("Locating Login Button....");
		driver.findElement(By.id("loginLink")).click();
		Reporter.log("Login Button Clicked");
		
		Reporter.log("Locating user Name TextBox....");
		assertNotEquals("", userName);
		driver.findElement(By.id("UserName")).sendKeys(userName);
		
		Reporter.log("UserName inserted in User text Box...");
		
		Reporter.log("Locating Password TextBox....");
		driver.findElement(By.id("Password")).sendKeys(Password);
		Reporter.log("Password inserted in password text Box...");
		Reporter.log("Locating Login Button in login Page....");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[4]/div/input")).click();
		Reporter.log("Clicked on Login button to log IN...");
		
		List<WebElement> IfLoginSucess = driver.findElements(By.xpath("//*[@id=\"logoutForm\"]/ul/li[2]/a"));
		
		//hard Assertion
		assertEquals(true, (IfLoginSucess.size()>0));
		Reporter.log("Login Test Completed.....");

		//Test SUITE
	}
	
	//Expected = user should register with valid data..
	@Test
	@Parameters({"userNameData", "passwordData", "ConfirmPasswordData", "Email"})
	public void RegisterUser(String UserName, String Password, String confirmPassword, String Email) {
		SoftAssert ObjSoftAssert = new SoftAssert(); 
	  driver.findElement(By.id("registerLink")).click();
	  
	  ObjSoftAssert.assertNotEquals("", UserName, "Username is Blank!!");
	  driver.findElement(By.id("UserName")).sendKeys(UserName);
	  
	  ObjSoftAssert.assertNotEquals("", Password, "Password is Blank!!");
	  driver.findElement(By.id("Password")).sendKeys(Password);
	  
	  ObjSoftAssert.assertNotEquals("", confirmPassword, "Confirm Password is Blank!!!");
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
	  
	  driver.findElement(By.name("Email")).sendKeys(Email);
	  
	  driver.findElement(By.xpath("/html/body/div[2]/form/div[6]/div/input")).click();
	  
	   List<WebElement> IfRegister = driver.findElements(By.xpath("//*[@id=\"logoutForm\"]/ul/li[2]/a"));
		//Expected = user should register with valid data..
	  
	  //Soft Assertion

	  
	  ObjSoftAssert.assertEquals(IfRegister.isEmpty(), false, "Log Off Button is not available!!!");
	  ObjSoftAssert.assertTrue(IfRegister.size()>0, "This Assertion is Fail!!!");
	  //Hard Assertion
/*	  assertTrue(IfRegister.size()>0);
	  assertFalse(IfRegister.size()==0);

	  assertEquals(IfRegister.isEmpty(), false);
	  assertEquals(IfRegister.size()==0, false);
*/
	  //Assertion
	  /*assertTrue(false)
	  assertFalse(false)
	  assertNotEquals(null, null)
	  assertEquals(false, false)
	  assertNotNull(Email)
	  assertNull(Email)
	  */
	  
	  
	  //assertTrue(!IfRegister.isEmpty());
	  
	  if(!IfRegister.isEmpty())
	  {
		  IfRegister.get(0).click();
	  }
	  
	  

	  Reporter.log("This is End of First Test Case");

	  Reporter.log("This message will print to Console and Replrt", true);

	  
	  Reporter.log("This is End of First Test Case", 1);

	  Reporter.log("This message will print to Console and Report with Level 1", 1, true);

	  
	  ObjSoftAssert.assertAll("This Is asserting for all Soft Assertion");

	}
 
	@Parameters({"browser"})
	@BeforeTest()
	public void beforeTest(String browserType) {
		  System.out.println("Type of Browser:=>" + browserType);

		  if(browserType.equalsIgnoreCase("chrome")) {
			  driver = new ChromeDriver();
		  }
		  
		  else if(browserType.equalsIgnoreCase("firefox"))
		  {
			  driver = new FirefoxDriver();
		  }
		  else 
		  {
			  driver = new EdgeDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.get("http://eaapp.somee.com/");
	  }

		@AfterTest
		public void afterTest() {
		  driver.close();//this will close the browser
	  }

}
