package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtil;

public class searchResult {

	private WebDriver driver;
	private ElementsUtil ele;

	By productList = By.cssSelector("div.product-layout");
	By productsName = By.xpath("//div//h4/a");
	

	public searchResult(WebDriver driver) {
		this.driver = driver;
		ele = new ElementsUtil(driver);

	}
//	public String getTitle() {
//		return ele.getTitle();
//	}

	public List<String> searchResults() {
		List<WebElement> results = ele.getElements(productsName);
		List<String> itemsList = new ArrayList<String>();
		for (WebElement a : results) {
			String text = a.getText();
			itemsList.add(text);
		}
		return itemsList;
	}

	public boolean isSearchCompleted() {
		List<WebElement> itemResults = ele.getElements(productList);
		if (itemResults.size() > 0) {
			System.out.println("Search is successfull. . . ");
			return true;
		}
		return false;
	}
	
	public productPage selectproduct(String productName) {
		By product = By.linkText(productName);
		String pdN = ele.getElement(product).getText();
		System.out.println("selected product : "+pdN);
		ele.doclick(product);
		return new productPage(driver);
	}
	

}
