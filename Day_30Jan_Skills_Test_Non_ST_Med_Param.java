package Day_30Jan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_30Jan_Skills_Test_Non_ST_Med_Param {
	
	
	 static WebDriver driver;
	
	//Gobal varibel
	String URLlink="https://opensource-demo.orangehrmlive.com/";
	String USERname="Admin",Password="admin123";
	String jobtitle="PCB",jobdescrp="course was completed ",jobnote="certifcateds was ready";

	
  @Test
  public void JOBTEST() throws Exception {
	  
	  
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.OpenChromebroswser();
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.openHRM(URLlink);   //step2
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.Login(USERname,Password); //step2
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.adminlook();
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.viewjobs();
	  Day_30Jan_Skills_Test_Non_ST_Med_Param.jobtitle(jobtitle,jobdescrp,jobnote); //step2
		
	
  }
  
  public static void OpenChromebroswser() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
 public static void openHRM(String URLlink) throws Exception {
	 driver.get(URLlink);
  }
  
  
 public static void Login(String USERname,String Password) throws Exception {
	 findElement(By.id("txtUsername")).sendKeys(USERname);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();  
 }
 
 
 public static void adminlook() throws Exception {
	 findElement(By.id("menu_admin_viewAdminModule")).click(); 
 }
	 
	 public static void viewjobs() throws Exception {
		 findElement(By.id("menu_admin_Job")).click();
			findElement(By.id("menu_admin_viewJobTitleList")).click();
			findElement(By.id("btnAdd")).click(); 
	 }
	 
	
 
 public  static void jobtitle(String jobtitle,String jobdescrp,String jobnote ) throws Exception {
	 findElement(By.id("jobTitle_jobTitle")).sendKeys(jobtitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(jobdescrp);  
		findElement(By.id("jobTitle_note")).sendKeys(jobnote);
		findElement(By.id("btnSave")).click();
 }
 
 
 
  
  public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
  
}
