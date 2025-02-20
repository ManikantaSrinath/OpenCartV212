package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends Basepage {

	public MyAccount(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//h2[normalize-space()='My Account']
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement account_logo;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutbtn;	
	
	
	
	public boolean checkmyacc() {
		try {
		return(account_logo.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	
	}
	public void Clicklogout() {
		logoutbtn.click();
	}

}
