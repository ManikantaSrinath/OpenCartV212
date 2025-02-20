package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver Driver) {
		super(Driver);
		
	}
	
	
	
	

	
	@FindBy(xpath = "//input[@id='input-email']") WebElement email_txt;
	@FindBy(xpath = "//input[@id='input-password']") WebElement password_txt;
	@FindBy(xpath= "//input[@value='Login']") WebElement click_btn;
	
	
	
	public void Setemail(String mail) {
		email_txt.sendKeys(mail);
	}
	
	public void Setpwd(String pwd) {
		password_txt.sendKeys(pwd);
	}
	
	public void Setclick() {
		click_btn.click();
	}
	
	
	
	
	
	
	

}
