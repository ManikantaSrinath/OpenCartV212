package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	
	WebDriver Driver;
	
	public Basepage(WebDriver Driver){
		
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}

}
