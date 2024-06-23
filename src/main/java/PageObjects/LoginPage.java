package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class LoginPage  extends AbstractComponent{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"login-form\"] //input[@name='email']")
	WebElement email;
	
	@FindBy(css="input[name='password']")
	WebElement password;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement loginButton;
	
	@FindBy(css="ul[class='nav navbar-nav'] li a b")
	WebElement welcomeMessage;
	
	public void loginMethod(String userName,String password)
	{
		waitForElementToAppear(email);
		email.sendKeys(userName);
		this.password.sendKeys(password);
		loginButton.click();
		Assert.assertEquals(welcomeMessage.getText(), "Neelam Prajapati");
		
	}

}
