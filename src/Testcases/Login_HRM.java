package Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Weblibrary_functions;

public class Login_HRM extends Weblibrary_functions

{	
	@Test
	public static void loginHRM() 
	{		
		boolean stepstatus;	
		
		//******** step 1 - launch HRM application**********************************************
		stepstatus=launchApplication("http://www.testingmasters.com/hrm/","OrangeHRM");
		if(stepstatus)
			System.out.println("step1 - pass, HRM applciation launched successfully");
		else
			System.out.println("step1 - fail, HRM applciation is not launched successfully");
		
		//***********step2 - Login to application ****************************************
		stepstatus=login("user02","pass1234");
		if(stepstatus)
			System.out.println("step2 - pass, Logged into application successfully");
		else
			System.out.println("step2 - fail, login failed");
	}
		
		
		@AfterTest
		public void execution()
		{
			System.out.println("execution completed");
		}
		

		@BeforeTest
		public void sexecution()
		{
			System.out.println("execution started");
		}
		
		
		
	
}                                
	


	


