package com.whereq.automation.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * A simple factory class to create the specific web driver instances.
 * 
 * @author whereq
 *
 */
public class WebDriverFactory {

	public static WebDriver createChromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\selenium\\webdriver\\chrome\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	public static WebDriver createIEWebDriver() {
		System.setProperty("webdriver.ie.driver",".\\selenium\\webdriver\\ie\\iexplore.exe");
		return new InternetExplorerDriver();
	}
}
