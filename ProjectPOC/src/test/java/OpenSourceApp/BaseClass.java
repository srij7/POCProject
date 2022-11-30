package OpenSourceApp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testproperties.BaseTestClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends BaseTestClass{

	@Test
		
	public void applicationPage() throws Throwable {
		
		OpenSurceApplicationPage OpenSurceLoginPage = OpenSurceApplicationPage();
		OpenSurceLoginPage.ApplicationUrl();	
		OpenSurceLoginPage.LoginToApplication("Admin", "admin123");
		OpenSurceLoginPage.EmployeeCreation();
		OpenSurceLoginPage.AddingEmployee("Andrew", "Flintoff");
		OpenSurceLoginPage.ApplyLeave("2022-12-07", "2022-12-14");
	    
	    System.out.println("perfect");
		
		
		

	}

}
