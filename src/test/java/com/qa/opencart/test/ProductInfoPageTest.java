package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTests;

public class ProductInfoPageTest extends BaseTests{

	@BeforeClass
	public void preReq() {
		accpg = lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		sr = accpg.dosearch("macbook");
		ppg = sr.selectproduct("MacBook");
		
	}
	
//	@Test(priority=2)
//	public void productPgTitleTest() {
//		String title = ppg.productpgtitle("MacBook");
//		Assert.assertEquals(title, "MacBook");
//	}
//	@Test(priority=3)
//	public void imgcountTest() {
//		int img = ppg.imgCount();
//		Assert.assertEquals(img, 5);
//	}
//	
//	@Test(priority=1)
//	public void productPageurlTest() {
//		boolean url = ppg.url("macbook", 5);
//		Assert.assertTrue(url);
//	}
	
	
	
	@Test(priority=4)
	public void metadataTest() {
		 Map<String,String> data = ppg.productData();
		 
		 Assert.assertEquals(data.get("Brand"), "Apple");
		 Assert.assertEquals(data.get("Product Code"), "Product 16");
		 Assert.assertEquals(data.get("Reward Points"), "600");
		 Assert.assertEquals(data.get("Availability"), "In Stock");
		 
		
	}
	
	
}
