package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtil {
	private WebDriver driver;

	public ElementsUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String dogettext(By locator) {
		System.out.println(getElement(locator).getText());
		return getElement(locator).getText();
	}

	public void dogettext(String locator, String checkVal) {
		if (locator.equalsIgnoreCase(checkVal)) {
			System.out.println("correct header");
		} else {
			System.out.println("wrong header");
		}
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		
	}

	public void doclick(By locator) {
		getElement(locator).click();
	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public int getElementscount(By locator) {

		return getElements(locator).size();

	}

	public ArrayList<String> alltext(By locator) {

		List<WebElement> linktext = getElements(locator);
		ArrayList<String> list = new ArrayList<String>();

		for (WebElement a : linktext) {
			String text = a.getText();
//		String hrefT = a.getAttribute("href");

			if (text.length() != 0) {
				list.add(text);
			}
		}
		return list;

	}

	public void countList(By locator) {

		List<WebElement> linktext = getElements(locator);
		int i = 0;
		for (WebElement a : linktext) {
			String texties = a.getText();
			if (texties.length() != 0) {

				System.out.println(texties + ": " + (i + 1));
				i++;
			}

		}
	}

	public List<String> dropdownWithoutSelect(By locator, String select) {
		List<WebElement> t1 = getElements(locator);
		List<String> t2 = new ArrayList<>();
		for (WebElement a : t1) {
			String text = a.getText();
			t2.add(text);

			if (text.equals(select)) {
				a.click();
				break;
			}
		}
		return t2;
	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public void doSearch(String tag, String value) {
		By search = By.xpath("//" + tag + "[text()='" + value + "']");
		getElement(search).click();
	}

	public void doSearch(By searchBoxLocator, By optionsList, String searchKey, String clickOptn)
			throws InterruptedException {

		getElement(searchBoxLocator).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> list = getElements(optionsList);

		for (WebElement a : list) {
			String text = a.getText();
			System.out.println(text);
			if (text.equals(clickOptn)) {
				a.click();
				break;
			}

		}
		Thread.sleep(3000);

	}
	
	public void clearBeforeInput(By locator, String inputValue) {
		WebElement input = driver.findElement(locator);
		input.clear();
		input.sendKeys(inputValue);
		}
	

	public void actions(By hover, By clickLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement content = getElement(hover);
		act.moveToElement(content).build().perform();
		Thread.sleep(3000);

		// in html is says Courses but we made it UPPER case why??
		// because we always go for how it is visible in the website
		driver.findElement(clickLocator).click();
	}

	public void actions(By hover) throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement content = getElement(hover);
		act.moveToElement(content).build().perform();
		Thread.sleep(3000);

	}

	// dynamcic wait

	public WebElement wait(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return ele;
	}

	/**
	 * 
	 * Alert Handle with Timeout
	 * 
	 */

	public Alert WaitForAlert(int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public String WaitForAlertGetText(int timeout, String value) {

		return WaitForAlert(timeout).getText();

	}

	public void WaitForAlertSendkeys(int timeout, String value) {

		WaitForAlert(timeout).sendKeys(value);

	}

	public void WaitForAlertDismiss(int timeout) {
		WaitForAlert(timeout).dismiss();

	}

	public void WaitForAlertAccept(int timeout) {
		WaitForAlert(timeout).accept();

	}

	/**
	 * 
	 * Wait for Title
	 * 
	 */

	public String waitForTitleContains(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleContains(title))) {
			return driver.getTitle();
		} else {
			return null;
		}
	}

	public String waitForTitleEquals(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * Wait for URL
	 * 
	 */
	
	public String waitForURLContains(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlContains(title))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}
	}

	public String waitForURLEquals(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if (wait.until(ExpectedConditions.urlToBe(title))) {
			return driver.getTitle();
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * wait for visibleEle
	 * 
	 */
	
	public WebElement waitForVisibleEle (By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public boolean isDisplayedWithWait(By locator, int timeout) {
		return waitForVisibleEle(locator, timeout).isDisplayed();
	}
	
	public String geturl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
