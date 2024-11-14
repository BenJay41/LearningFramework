package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistratioPage;
import com.qa.opencart.pages.productPage;
import com.qa.opencart.pages.searchResult;

public class BaseTests {
	WebDriver driver;
	DriverFactory df;
	public LoginPage lp;
	public Properties prop;
	public AccountPage accpg;
	public searchResult sr;
	public productPage ppg;
	public RegistratioPage rpg;
	
	@Parameters({"browser"})
	@BeforeTest
	public void initBrowser(@Optional("firefox")String browser) throws InterruptedException {
		df = new DriverFactory();
		prop = df.initProp();
		
		if(browser!=null) {
			prop.setProperty("browser", browser);
		}
		
		
		driver = df.initDriver(prop);
		lp = new LoginPage(driver);
		
		
		Thread.sleep(2000);	
	}

	@AfterTest
	public void finalSteps() {

		driver.quit();
	}

}
