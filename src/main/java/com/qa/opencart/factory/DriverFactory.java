package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

public class DriverFactory {

	private static final Logger LOG = Logger.getLogger(DriverFactory.class);

	public WebDriver driver;
	public Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public OptionsManager optManager;

	public WebDriver initDriver(Properties prop) {

		String browsername = prop.getProperty("browser").toLowerCase();
		optManager = new OptionsManager(prop);

		if (browsername.equals("chrome")) {

//			if remote webdriver is used
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			}

//			driver = new ChromeDriver();
			else {
				tlDriver.set(new ChromeDriver(optManager.getChromeOptions()));
			}

		} else if (browsername.equals("firefox")) {
			
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");	
			}
			else {
				driver = new FirefoxDriver();
				tlDriver.set(new FirefoxDriver());
			}


		} else {
			System.out.println("Pass the correct browser");
			LOG.info("Pass the correct browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;

//		String envName = System.getenv("env");  this one doesn't work
		String envName = System.getProperty("env");
		System.out.println("running on Environment " + envName);
		LOG.info("running on Environment " + envName);

		if (envName == null) {
			System.out.println("no environment name hence running in QA");
			try {
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {

			try {
				switch (envName) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/prod.config.properties");
					break;

				default:
					System.out.println("please enter correct Environment name " + envName);
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getScreenshot() {

		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File scrnShot = new File(path);

		try {
			FileUtils.copyFile(srcFile, scrnShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

	private void init_remoteDriver(String browser) {
		if(browser.equals("chrome")) {
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),optManager.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}	
		}
		else if(browser.equals("firefox")) {
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),optManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}	
		}
	}

}
