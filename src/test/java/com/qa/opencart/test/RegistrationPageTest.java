package com.qa.opencart.test;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.base.BaseTests;
import com.qa.opencart.utils.ExcelUtils;

public class RegistrationPageTest extends BaseTests{

	@BeforeClass
	public void preReq() {
		rpg = lp.navigateToRegister();
	}
	
	@DataProvider
	public Object[][] getRegData() {
		Object regData [][] = ExcelUtils.getSheet(AppConstants.REGISTRATION_SHEET_NAME);
		return regData;
	}
	
	public String randomMail() {
		Random email = new Random();
		int randomNum = email.nextInt(10000);
		String randomMail = RandomStringUtils.randomAlphabetic(5);
		String randomEmail = "amantesting"+randomMail+randomNum+"@gmail.com";
		System.out.println(randomEmail);
		return randomEmail;
	}
	
	@Test(dataProvider="regData")
	public void registrationTest(String name,String lastName,String telephone,String password,String sub) {
		String reg = rpg.doRegistration(name, lastName, randomMail(), telephone, password, sub);
		
		Assert.assertEquals(reg, AppConstants.REGISTRATION_DONE_MESSAGE);
		
	}
}