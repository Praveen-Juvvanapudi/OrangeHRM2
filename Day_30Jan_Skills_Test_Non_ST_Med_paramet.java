package Day_30Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_30Jan_Skills_Test_Non_ST_Med_paramet {
	
	
	WebDriver driver;
	
	//Gobal variabels
		String URLlink="https://opensource-demo.orangehrmlive.com/";
	    String UserName="Admin",Password="admin123";
		String JOBtitle="management",JOBDescep="course was cpleted",JOBNote="passed with 77%";
		
		
  @Test
  public void JOBTEST() throws Exception {
	  
	  Day_30Jan_Skills_Test_Non_ST_Med_paramet J1= new Day_30Jan_Skills_Test_Non_ST_Med_paramet();
	  	
		J1.OpenChromebroswser();
		J1.openHRM(URLlink);
		J1.Login(UserName,Password);
		J1.adminlook();
		J1.viewjobs();
		J1.jobtitle(JOBtitle,JOBDescep,JOBNote);
		
	
  }
  
  public void OpenChromebroswser() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
 public void openHRM(String URLlink) throws Exception {
	 driver.get(URLlink);
  }
  
  
 public void Login(String UserName,String Password) throws Exception {
	 findElement(By.id("txtUsername")).sendKeys(UserName);
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
	 
	
 
 public void jobtitle(String JOBtitle,String JOBDescep,String JOBNote) throws Exception {
	 findElement(By.id("jobTitle_jobTitle")).sendKeys(JOBtitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JOBDescep);  
		findElement(By.id("jobTitle_note")).sendKeys(JOBNote);
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
