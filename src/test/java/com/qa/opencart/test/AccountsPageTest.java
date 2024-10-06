package com.qa.opencart.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.base.BaseTests;

public class AccountsPageTest extends BaseTests{
	
	
	@BeforeClass
	public void intialStep() {
		accpg = lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void accpgurlTest() {
		Assert.assertTrue(accpg.accPageUrl());
	}
	
	@Test
	public void accpgTitleTest() {
		String title = accpg.accpgTitle();
		Assert.assertEquals(title,AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void searchdisplayTest() {
		Assert.assertTrue(accpg.searchDisplay());
	}
	
	@Test
	public void logoutdisplayTest() {
		Assert.assertTrue(accpg.logoutDisplayed());
	}
	
	@Test
	public void pgContainer() {
		ArrayList <String> list = accpg.contTags(); 
		System.out.println(list);
		Assert.assertEquals(list, AppConstants.ACCPG_CONTENT_TAGS);
		
	}
	
	
	@Test(priority = 1)
	public void searchTest() {
		sr = accpg.dosearch("macbook");
		Assert.assertTrue(sr.isSearchCompleted());
	}
	
	@DataProvider
	public Object [][] getProductData(){
		return new Object [][] {
				 
				{"MacBook","MacBook"},
				{"MacBook","MacBook Pro"},
				{"MacBook","MacBook Air"},
				{"Samsung","Samsung Galaxy Tab 10.1"},
				{"Samsung","Samsung SyncMaster 941BW"},
				{"imac","iMac"}};
				
	}
	
	@Test(priority = 2,dataProvider = "getProductData")
	public void productpgTest(String searchKey, String productName) {
		sr = accpg.dosearch(searchKey);
		ppg = sr.selectproduct(productName);
		Assert.assertTrue(ppg.productPgSuccessfull(productName));
	}
	
	
	
	
	
	
}
