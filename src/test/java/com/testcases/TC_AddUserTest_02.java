package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class TC_AddUserTest_02 extends BaseClass{

	@Test
	public void addNewCustomer() throws Exception{

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Log.info("User name is provided");

		lp.setPassword(password);
		Log.info("Password is provided");
		lp.clickSubmit();

		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		
		dp.clickUser();
		dp.clickAddUser();
		dp.custUserName("Shreyash");
		dp.custMobile("8888989065");
		dp.custEmailId("Shreyash@gmail.com");
		dp.custCourse("Java");
		dp.custgender();

		Thread.sleep(2000);
		dp.custState("Maharashtra");
		dp.custPassword("246sdm");
		dp.custFriendMobile("1020304050");
		Thread.sleep(2000);
		
		dp.clickSubt();
		
		Thread.sleep(4000);
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
			Log.info("Customer added Successfully");
		}
		else {
			Assert.assertTrue(false);
			Log.info("Customer not added");
		}
	}	

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

