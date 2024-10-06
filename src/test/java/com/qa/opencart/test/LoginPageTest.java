package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.base.BaseTests;

public class LoginPageTest extends BaseTests{
	
	
	@Test(priority = 1)
	public void logintitleTest() {
		String title = lp.gettitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)
	public void loginurlTest() {
		Assert.assertTrue(lp.getloginPgUrl());
		
	}
	
	@Test(priority = 3)
	public void forgotPwExistTest() {
		boolean fp = lp.forgotPwExist();
		Assert.assertTrue(fp);
	}
	
	@Test(priority = 4)
	public void dologinTest() {
		accpg = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accpg.logoutDisplayed());
	}
	
	

}
