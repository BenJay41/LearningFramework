package com.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testppn {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		JavaUtils ju = new JavaUtils(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		
		
		ju.flash(ele);
	}

}
