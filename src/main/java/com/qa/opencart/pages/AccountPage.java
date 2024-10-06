package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.utils.ElementsUtil;

public class AccountPage {

	private static final Logger LOG = Logger.getLogger(AccountPage.class);
	
	private WebDriver driver;
	private ElementsUtil ele;

	By logout = By.xpath("//a[@class='list-group-item' and text()='Logout']");
	By search = By.xpath("//input[@name='search']");
	By searchbtn = By.cssSelector("button.btn-default");
	By h2tag = By.cssSelector("div#content h2");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementsUtil(driver);
	}

	public boolean accPageUrl() {
		String url = driver.getCurrentUrl();
		if (url.contains(AppConstants.ACCOUNT_PAGE_URL)) {
			return true;
		}
		return false;
	}

	public String accpgTitle() {
		return ele.getTitle();
	}

	public boolean logoutDisplayed() {
		return ele.isDisplayedWithWait(logout, 10);
	}

	public boolean searchDisplay() {
		return ele.isDisplayedWithWait(search, 10);
	}

	public ArrayList<String> contTags() {
		List<WebElement> tags = ele.getElements(h2tag);
		ArrayList<String> contList = new ArrayList<String>();

		for (WebElement a : tags) {
			String text = a.getText();
			contList.add(text);
		}
		return contList;
	}

	public searchResult dosearch(String searchKey) {
		ele.clearBeforeInput(search, searchKey);
		ele.doclick(searchbtn);
		return new searchResult(driver);
	}

}
