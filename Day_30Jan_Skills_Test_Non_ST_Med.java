package Day_30Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_30Jan_Skills_Test_Non_ST_Med {
	
	
	WebDriver driver;
		
	
  @Test
  public void JOBTEST() throws Exception {
	  
	  Day_30Jan_Skills_Test_Non_ST_Med J1= new Day_30Jan_Skills_Test_Non_ST_Med();
	  	
		J1.OpenChromebroswser();
		J1.openHRM();
		J1.Login();
		J1.adminlook();
		J1.viewjobs();
		J1.jobtitle();
		
	
  }
  
  public void OpenChromebroswser() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
 public void openHRM() throws Exception {
	 driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  
 public void Login() throws Exception {
	 findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();  
 }
 
 
 public void adminlook() throws Exception {
	 findElement(By.id("menu_admin_viewAdminModule")).click(); 
 }
	 
	 public void viewjobs() throws Exception {
		 findElement(By.id("menu_admin_Job")).click();
			findElement(By.id("menu_admin_viewJobTitleList")).click();
			findElement(By.id("btnAdd")).click(); 
	 }
	 
	
 
 public void jobtitle() throws Exception {
	 findElement(By.id("jobTitle_jobTitle")).sendKeys("seleniumtesting");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("course wascompleted");  
		findElement(By.id("jobTitle_note")).sendKeys("passed");
		findElement(By.id("btnSave")).click();
 }
 
 
 
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
  
}
