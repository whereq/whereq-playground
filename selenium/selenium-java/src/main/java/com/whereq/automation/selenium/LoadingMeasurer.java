package com.whereq.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.whereq.automation.MeasurableWebElement;
import com.whereq.automation.MeasureResult;

/**
 * Use Selenium Explicit Wait to measure the elapsed time for loading a web page.
 * 
 * @author whereq
 *
 */
public class LoadingMeasurer {
	
	
	public static MeasureResult measureLoadingTime(MeasurableWebElement measurableWebElement,  ExplicitWait explicitWait, WebDriver driver) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, explicitWait.getWaitingTime());
		
		long startTime = System.currentTimeMillis();
		driver.get(measurableWebElement.getUrl());
		
		
		//WebDriverWait.until will block the current thread until meet the ExpectedConditions 
		//The RuntimeException - NoSuchElementException will be thrown out here if the given element can't be found, 
		//so far just ignore it and assume the element will be there because of POC.
		WebElement element = driverWait.until(explicitWait.getExpectedCondition());
		long endTime = System.currentTimeMillis();
		
        MeasureResult measureResult = new MeasureResult();
        measureResult.setElapsedMillionSeconds(endTime - startTime);
        measureResult.setElementText(element.getText());
		
		//close browser
        driver.close();
        
        return measureResult;
	}
}
