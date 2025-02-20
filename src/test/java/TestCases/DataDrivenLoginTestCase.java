package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class DataDrivenLoginTestCase extends BaseClass {
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class )
	public void datadriventest(String email,String pwd,String exp) {
	logger.info("***********Starting the case************");

	//Homepage
	HomePage pg = new HomePage(Driver);
	
	pg.setaccount();
	pg.setlogin();
	
	logger.info("**********loginpage**********");
	//LoginPage
	Loginpage lp = new Loginpage(Driver);
	
	lp.Setemail(email);
	lp.Setpwd(pwd);
	lp.Setclick();
	
	logger.info("**********AccountPage**********");
	//MyAccountPage
	
	MyAccount ma = new MyAccount(Driver); 
    boolean acc = ma.checkmyacc();
    
    
   /* 
    Data is valid - loginsucess-testpass-logout
    Data is valid - loginfail-testfail
    
    
    Data is invalid - loginsucess-testfail-logout
    Data is invalid - loginfail - testpass
    
    */
    
    if(exp.equalsIgnoreCase("Valid")) {
    	
    	if(acc==true) {
    		
    		ma.Clicklogout();
    		Assert.assertTrue(true);
    	}
    	
    	else {
    		Assert.fail();
    	}
    }
    
    if(exp.equalsIgnoreCase("Invalid")) {
    	if(acc==true) {
    		
    		ma.Clicklogout();
    		Assert.assertTrue(false);
    		
    	}
    	else {
    		
    		Assert.assertTrue(true);
    		
    	}
    }
    
    logger.info("**********TestFineshed**********");
    
	}
	
}

