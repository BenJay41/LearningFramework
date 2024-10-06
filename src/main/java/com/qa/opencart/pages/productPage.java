package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtil;

public class productPage {

	private WebDriver driver;
	private ElementsUtil ele;
	private Map<String,String> productmetaData;
	
	
	public productPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementsUtil(driver);
	}
	
	public boolean productPgSuccessfull(String productName) {
		String productTag = ele.getElement(By.cssSelector("#content h1")).getText();
		
		if(productTag.equals(productName)) {
			System.out.println("opened "+productTag+" page successfully...");
			return true;
		}return false;
	}
	
	public String productpgtitle(String title) {
		return ele.waitForTitleContains(title, 5);
	}
	
	
	public int imgCount() {
		By img = By.cssSelector("#content img");
		int totalimages = ele.getElements(img).size();
		System.out.println("No. of images : "+totalimages);
		return totalimages;
	}
	
	public boolean url(String title,int timeOut) {
		String url = ele.waitForURLContains(title, timeOut);
		if(url.contains(title)) {
			return true;
		}return false;
		
	}
	
	public Map<String, String> productData() {
		By metadata = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
		List <WebElement> data = ele.getElements(metadata);
		productmetaData = new HashMap<String,String>();
		
		for(WebElement a : data) {
			String text = a.getText();
			String textdata[] = text.split(":");
			String metadataKey = textdata[0].trim();
			String metadataValue = textdata[1].trim();
			
			 productmetaData.put(metadataKey, metadataValue);
			 
		}
		productmetaData.forEach((k,v) -> System.out.println(k+" : "+v));
		return productmetaData;
		
	}
	

}
