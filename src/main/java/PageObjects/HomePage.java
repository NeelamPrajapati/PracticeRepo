package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public LoginPage loginPage;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="a[href='/login']")
	WebElement loginButton;
	
	public LoginPage goToLogin()
	{
		driver.get("https://www.automationexercise.com/");
		loginButton.click();
		loginPage= new LoginPage(driver);
		return loginPage;
				
	}
	

}
