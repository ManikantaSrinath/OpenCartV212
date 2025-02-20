package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage {
	
	
	public HomePage(WebDriver Driver) {
		super(Driver);
	}
	
	
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']" ) WebElement myaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement rigister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement login;
	
	
	
	
	public void setaccount() {
		myaccount.click();
	}
	
	public void setregister() {
		rigister.click();
	}
	
	public void setlogin() {
		login.click();
	}

}
