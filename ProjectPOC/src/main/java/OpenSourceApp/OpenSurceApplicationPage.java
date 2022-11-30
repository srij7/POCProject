package OpenSourceApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenSurceApplicationPage {
	
	WebDriver driver;
	
	public OpenSurceApplicationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement UserName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'][@name='username']"));

	@FindBy (xpath="//input[@class='oxd-input oxd-input--active'][@name='username']")
	WebElement UserName;
	
	@FindBy (xpath="//input[@class='oxd-input oxd-input--active'][@name='password']")
	WebElement PassWord;
	
	@FindBy (xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement LoginButton;
	
	@FindBy (xpath="//img[@alt='client brand banner']")
	WebElement orangeHRMlogo;
	
	@FindBy (xpath="//a[contains(@href,'/web/index.php/pim/viewPimModule')]")
	WebElement PIMLeftNav;
	
	@FindBy (xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement AddEmployee;
	
	@FindBy (xpath="//a[contains(text(),'Add Employee')]")
	WebElement AddEmployeeHeader;
	
	@FindBy (xpath="//label[contains(text(),'Employee Full Name')]")
	WebElement AddEmployeePage;
	
	@FindBy (xpath="//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
	WebElement Firstname;
	
	@FindBy (xpath="//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
	WebElement Lastname;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement Submit;
	
	@FindBy (xpath="//a[contains(@href,'web/index.php/leave/viewLeaveModule')]")
	WebElement LeaveLeftnav;
	
	@FindBy (xpath="//a[contains(text(),'Apply')]")
	WebElement LeaveHeader;
	
	@FindBy (xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement SelectLeaveDropdown;
	
	@FindBy (css="div.oxd-select-option span")
	WebElement SelectionofLeave;
	
	@FindBy (xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input")
	WebElement fromDate;
	
	@FindBy (xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input")
	WebElement toDate;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement SubmitLeave;
	
	
	public void ApplicationUrl(){
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void LoginToApplication(String username, String password){
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		LoginButton.click();
		
	}
	
	public void EmployeeCreation() throws Throwable{
		Assert.assertEquals(true, orangeHRMlogo.isDisplayed());
		System.out.println("orangeHRM logo is displayed – Assert passed");
		Thread.sleep(2000);
		PIMLeftNav.click();
		Thread.sleep(2000);
		AddEmployee.click();
		
	}
	
	public void AddingEmployee(String firstname, String lastname) throws Throwable{
		Assert.assertEquals(true, AddEmployeeHeader.isDisplayed());
		System.out.println("AddEmployeeHeader is displayed – Assert passed");
		AddEmployeeHeader.click();
		Thread.sleep(2000);
		Assert.assertEquals(true, AddEmployeePage.isDisplayed());
		System.out.println("AddEmployeePage is displayed – Assert passed");
		Thread.sleep(2000);
		Firstname.click();
		Firstname.sendKeys(firstname);
		Thread.sleep(2000);
		Lastname.click();
		Lastname.sendKeys(lastname);
		Submit.click();	
		Thread.sleep(2000);
	}
	
	public void ApplyLeave(String fromdate, String todate) throws Throwable  {
		
		LeaveLeftnav.click();
		Thread.sleep(2000);
		Assert.assertEquals(true, LeaveHeader.isDisplayed());
		System.out.println("Apply header is displayed – Assert passed");
		LeaveHeader.click();
		Thread.sleep(2000);
		SelectLeaveDropdown.click();
		SelectionofLeave.click();
		Thread.sleep(2000);
		fromDate.click();
		fromDate.sendKeys(fromdate);
		Thread.sleep(2000);
		toDate.click();
	    toDate.sendKeys(todate);
	    SubmitLeave.click();
		
	}
		
	
	
}
