package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccoubtRegistration;
import pageObjects.HomePage;




public class AccountRegistrationTest extends BaseClass {

	@Test(groups = {"master","regression"})
	void testingAccReg() {
		try {
		
		logger.info("******AccountRegistrationTest----->JUST_STARTED*****");
		HomePage hp = new HomePage(Driver);
		hp.setaccount();
		hp.setregister();
		
		AccoubtRegistration ar = new AccoubtRegistration(Driver);
		
		logger.info("*****Entering_Details******");
		ar.Setfirstname(randomalphabets().toUpperCase());
		ar.Setlastname(randomalphabets());
		ar.Setemail(randomalphabets() + "@gmail.com");
		ar.Setteliphone(randomnumeric());
	
		String pass = randomNumAlpha();
		ar.Setpassword(pass);
		ar.Setconfirmpass(pass);
		ar.Setcheckboc();
		ar.Setcontinue();
	
		logger.info("****Conformation******");
		String GetConMsg = ar.GetconfirmMsg();
		
		if(GetConMsg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Got Failed.....");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(GetConMsg, "Your Account Has Been Created!!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("*******Test Finished*******");
	}
	
}
