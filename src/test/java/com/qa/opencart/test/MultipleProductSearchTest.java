package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTests;

public class MultipleProductSearchTest extends BaseTests {
	
	
	@BeforeClass
	public void intialStep() {
		accpg = lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void searchdisplayTest() {
		Assert.assertTrue(accpg.searchDisplay());
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
