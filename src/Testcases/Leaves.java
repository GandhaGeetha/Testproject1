package Testcases;

import Library.Weblibrary_functions;

public class Leaves extends Weblibrary_functions {
	
	public static void applyLeaveHRM()
	{
		
		boolean stepstatus=true;
		
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
		
		//***** step3 - go to leave menu*************************************************8
		stepstatus=navigateToLeaveMenu();
		if(stepstatus)
			System.out.println("step1 pass, navigated to leave menu successfully");
		else
			System.out.println("step1 fail, unable to navigate to leave menu ");
		
		//*** step4 - click on Apply and apply leave
		//pass leave type parameter as "Annual Leave" or "Personal Leave"
		stepstatus=applyLeave("Annual Leave");
	}
	

}
