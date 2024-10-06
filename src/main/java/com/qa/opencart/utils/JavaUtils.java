package com.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaUtils {

	private WebDriver driver;
	
	
	public JavaUtils (WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void flash(WebElement element) {
		String bgColor = element.getCssValue("backgroudColor").toString();
		for(int i=0;i<=300;i++) {
			chngClr("rgb(0,200,0)",element);
			chngClr(bgColor,element);
		}
		
	}
	
	public void chngClr(String color,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroudcolor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
	}
	
}
