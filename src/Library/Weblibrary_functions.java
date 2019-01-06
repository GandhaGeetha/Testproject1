package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Weblibrary_functions {
	
	public static WebDriver driver;
	
	//******************* launch application function*****************************************************
	
public static boolean launchApplication(String url, String title)
{                      
	
	boolean status=true;	
	
	try
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-2.53.1\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		String pagetitle=driver.getTitle();
		if(!(pagetitle.equals(title)))
			status=false;		

	}
	
	catch(Exception e)
	{
		status=false;
	}
	
	return status;
	
}

//************************ end - launch Application function********************************



//******************* login function****************************************************************

public static boolean login(String username, String password)
{                      

boolean status=true;	

try
{
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
	if(!(driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"))).isDisplayed())
	status=false;
}

catch(Exception e)
{
	status=false;
}

return status;

}
	
//******************* End - login function****************************************************************


//***********************************************************************************

public static boolean navigateToLeaveMenu()
{                      

boolean status=true;	

try
{
	WebElement leavemenu=driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
	Actions leaveobj=new Actions(driver);
	leaveobj.moveToElement(leavemenu).build().perform();	
	//driver.findElement(By.xpath("//a[@id='menu_leave_applyLeave']")).click();
	
}

catch(Exception e)
{
	status=false;
}

return status;

}
	
//***********************************************************************************


//apply leave function***********************************************************************************

public static boolean applyLeave(String leavetype)
{                      

boolean status=true;	

try
{
		
	driver.findElement(By.xpath("//a[@id='menu_leave_applyLeave']")).click();
	driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']/option[text()='"+leavetype+"']")).click();
	
		
	Thread.sleep(5000);
	String leavebalance=driver.findElement(By.xpath("//div[@id='applyleave_leaveBalance']")).getText();
	leavebalance=leavebalance.replaceAll("[a-z]", "");
	//float balance=Float.parseFloat(leavebalance);	
	//System.out.println(balance);
	
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/div/select[2]/option[text()='2018']")).click();
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/div/select[1]/option[text()='Nov']")).click();	
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]]")).click();	
}

catch(Exception e)
{
	status=false;
}	

return status;

}
	
//***********************************************************************************
}
	
	
	

