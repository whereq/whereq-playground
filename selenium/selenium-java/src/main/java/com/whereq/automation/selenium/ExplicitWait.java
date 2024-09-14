package com.whereq.automation.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * 
 * @author whereq
 *
 */
public class ExplicitWait {

	
	/*
	 * The waiting time is not actually working as expected, the only difference is between 0 and 1,
	 *   0 : no timeout
	 *   1 : the WebDriverWait will wait until meet the ExpectedConditions. 
	 * 
	 */
	private long waitingTime;
	
	
	/*
	 * So far the expected condition will only be ExpectedConditions.visibilityOfElementLocated(By.id(...))
	 */
	private ExpectedCondition<WebElement> expectedCondition;

	public long getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}

	public ExpectedCondition<WebElement> getExpectedCondition() {
		return expectedCondition;
	}

	public void setExpectedCondition(ExpectedCondition<WebElement> expectedCondition) {
		this.expectedCondition = expectedCondition;
	}
	
	
}
