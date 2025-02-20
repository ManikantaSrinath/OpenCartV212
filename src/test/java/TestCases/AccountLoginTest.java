package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccount;

public class AccountLoginTest extends BaseClass {
	
	@Test(groups = {"master","sanity"})
	public void logintest() {
		
		logger.info("***********Starting the case************");
		try {
		//Homepage
		HomePage pg = new HomePage(Driver);
		
		pg.setaccount();
		pg.setlogin();
		
		logger.info("**********loginpage**********");
		//LoginPage
		Loginpage lp = new Loginpage(Driver);
		
		lp.Setemail(p.getProperty("email"));
		lp.Setpwd(p.getProperty("password"));
		lp.Setclick();
		
		logger.info("**********AccountPage**********");
		//MyAccountPage
		
		MyAccount ma = new MyAccount(Driver); 
	    boolean acc = ma.checkmyacc();
	    
	    Assert.assertTrue(acc);
		}
		
		catch(Exception e) {
			
			logger.error("****Test Fail*****");
			Assert.fail();

		}
		
		logger.info("******TestCompleted********");
		
	}
	
}
