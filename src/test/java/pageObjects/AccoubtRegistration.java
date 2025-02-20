package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoubtRegistration extends Basepage {

	public AccoubtRegistration(WebDriver Driver) {
		super(Driver);
		
	}
	
	

	
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement firstname_txt;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement lastname_txt;
	@FindBy(xpath = "//input[@id='input-email']") WebElement email_txt;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement telephone_txt;
	@FindBy(xpath = "//input[@id='input-password']") WebElement password_txt;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement confirm_txt;
	@FindBy(xpath = "//input[@name='agree']") WebElement agree_checkbox;
	@FindBy(xpath = "//input[@value='Continue']") WebElement continue_bttn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmationMSG;
	
	
	
	
	public void Setfirstname(String firstname) 
	{
		firstname_txt.sendKeys(firstname);
	}
	
	public void Setlastname(String lastname) 
	{
		lastname_txt.sendKeys(lastname);
	}
	public void Setemail(String email) 
	{
		email_txt.sendKeys(email);
	}
	public void Setteliphone(String teleNum) {
		telephone_txt.sendKeys(teleNum);
	}
	
	public void Setpassword(String pwd) {
		password_txt.sendKeys(pwd);
	}
	
	public void Setconfirmpass(String cfimpwd) {
		confirm_txt.sendKeys(cfimpwd);
		
	}
	
	public void Setcheckboc() {
		agree_checkbox.click();
	}
	
	public void Setcontinue() {
		continue_bttn.click();
	}
	
	//This is for Conformation WebElements
	public String GetconfirmMsg() {
		try {
			return(confirmationMSG.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	

}
