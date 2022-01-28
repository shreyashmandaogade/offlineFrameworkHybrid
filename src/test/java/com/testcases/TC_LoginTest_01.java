package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass;
import com.pages.LoginPage;

public class TC_LoginTest_01 extends BaseClass{

	public LoginPage lp;
	
	@Test
	public void loginTest() throws Exception{
		
		lp = new LoginPage(driver);
		
		lp.setUserName(username);
		Log.info("Entered UserName Successfully>>>");
		
		lp.setPassword(password);
		Log.info("Entered Password Successfully>>>");
		
		lp.clickSubmit();
		Log.info("Login Successfully>>>");
		
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
		{
			Assert.assertTrue(true);
			Log.info("Login Test Passed");
			
		}else {
			Assert.assertTrue(false);
			Log.info("Login Test failed");
		}
	}
}
