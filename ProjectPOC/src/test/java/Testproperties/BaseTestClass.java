package Testproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import OpenSourceApp.OpenSurceApplicationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	
	public WebDriver driver;
	public OpenSurceApplicationPage OpenSurceLoginPage;
	
	public WebDriver initializeDiver() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/workspace/ProjectPOC/src/main/java/Resources/GlobalData.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else if (browsername.equalsIgnoreCase("firefox")){
			//firefox
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeMethod

	public  OpenSourceApp.OpenSurceApplicationPage OpenSurceApplicationPage() throws IOException{
		
		driver = initializeDiver();
		OpenSurceLoginPage = new OpenSurceApplicationPage(driver);
		return OpenSurceLoginPage;
		
	}
	
	@AfterMethod
	public  void TurnOffExecution(){
		
		driver.close();
	}
	}

