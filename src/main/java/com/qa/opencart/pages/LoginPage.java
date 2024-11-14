package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.utils.ElementsUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementsUtil ele;

	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.cssSelector("input[type='submit']");
//	private By logo = By.cssSelector("img[title='naveenopencart']");
	private By forgotpw = By.xpath("//div[@class='form-group']/a");
	private By registration = By.xpath("//aside[@id='column-right']//a[text()='Register']");
	
	// 2. page const . . .

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementsUtil(driver);
	}
	// 3. page actions

	public String gettitle() {
		String title = ele.getTitle();
		System.out.println("Title of the page : "+title);
		return title;
	}

	public boolean getloginPgUrl() {
		String url = ele.geturl();
		System.out.println("login page url : " + url);
		if(url.contains(AppConstants.LOGIN_PAGE_URL)) {
			return true;
		}
		else{return false;}
	}

	public boolean forgotPwExist() {
		boolean Fpw = ele.isDisplayedWithWait(forgotpw, 10);
		if(Fpw) {
			System.out.println("forgot password link exist");
		}else {
			System.out.println("forgot password link doesn't exist");
		}
		return Fpw;
		
	}

	public AccountPage doLogin(String un, String pw) {
		ele.doSendKeys(username, un);
		ele.doSendKeys(password,pw);
		ele.doclick(loginbtn);
		return new AccountPage(driver);
		
	}
	
	public RegistratioPage navigateToRegister() {
		System.out.println("navigating to Reg. page . . .");
		ele.doclick(registration);
		return new RegistratioPage(driver);
		
		
	}

}
