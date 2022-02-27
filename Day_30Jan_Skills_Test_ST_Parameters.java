package Day_30Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_30Jan_Skills_Test_ST_Parameters {
	
	
	WebDriver driver;
	
	String JOBURL="https://opensource-demo.orangehrmlive.com";
	String Username="Admin",Password="admin123";
	String JobTitle="java",JobDescr="John was passed",JobNote="Certified was Printed";
		
	
  @Test
  public void JOBTEST() throws Exception {
	  
	  Day_30Jan_Skills_Test_ST_Parameters J1= new Day_30Jan_Skills_Test_ST_Parameters();
	  	
		J1.OpenChromebroswser();
		J1.openHRM(JOBURL);
		J1.Login(Username,Password);
		J1.adminlook();
		J1.viewjobs();
		J1.jobtitle(JobTitle,JobDescr,JobNote);
		
	
  }
  
  public void OpenChromebroswser() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
 public void openHRM(String JOBURL) throws Exception {
	 driver.get(JOBURL);
  }
  
  
 public void Login(String Username, String Password) throws Exception {
	 findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
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
	 
	
 
 public void jobtitle(String JobTitle,String JobDescr, String JobNote) throws Exception {
	 findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);  
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
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
