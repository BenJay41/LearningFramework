package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtil;

public class RegistratioPage {

	
	private WebDriver driver;
	private ElementsUtil ele;
	
	public RegistratioPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementsUtil(driver);
	}
	
	private By registration = By.xpath("//aside[@id='column-right']//a[text()='Register']");
	private By firstName = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By passowrd = By.id("input-password");
	private By confirmpassowrd = By.id("input-confirm");
	private By subYes = By.xpath("//label[@class='radio-inline']/input[@value='1']");
	private By subNo = By.xpath("//label[@class='radio-inline']/input[@value='0']");
	private By termsandc = By.xpath("//div[@class='pull-right']//input[@value='1']");
	private By continueBtn = By.xpath("//div[@class='pull-right']//input[@value='Continue']");
	private By confrmMSG = By.cssSelector("div#common-success div#content h1");
	private By logout = By.xpath("//aside[@id='column-right']//a[text()='Logout']");
	
	
	
	
	public String doRegistration(String firstname, String lastname,String email,String telephone,String password,String sub) {
		ele.doSendKeys(this.firstName, firstname);
		ele.doSendKeys(this.lastname, lastname);
		ele.doSendKeys(this.email, email);
		ele.doSendKeys(this.telephone, telephone);
		ele.doSendKeys(this.passowrd, password);
		ele.doSendKeys(this.confirmpassowrd, password);
		
		if(sub.equalsIgnoreCase("yes")) {
			ele.doclick(subYes);
		}else if(sub.equalsIgnoreCase("no")) {
			ele.doclick(subNo);
		}
		
		ele.doclick(this.termsandc);
		ele.doclick(this.continueBtn);
		
		
		
		String sucMsg = ele.getElement(this.confrmMSG).getText();
		System.out.println("Final Message: "+sucMsg);
		
		ele.doclick(logout);
		ele.doclick(registration);
		return sucMsg;
	
		
		
		
	}
	
	
	
	
}
