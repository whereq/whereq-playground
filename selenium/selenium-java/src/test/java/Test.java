import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.whereq.automation.MeasurableWebElement;
import com.whereq.automation.MeasureResult;
import com.whereq.automation.selenium.ExplicitWait;
import com.whereq.automation.selenium.LoadingMeasurer;
import com.whereq.automation.selenium.webdriver.WebDriverFactory;

/**
 * The main class to work with an angular app to show how to use selenium java APIs 
 */
public class Test {

	public static void main(String[] args) {
		testLoadCountries();
		testLoadCities();
	}
	
	public static void testLoadCountries() {
		MeasurableWebElement measurableWebElement = new MeasurableWebElement();
		measurableWebElement.setUrl("http://localhost:4200/countries");
		measurableWebElement.setElementId("td_239");
		
		ExplicitWait explicitWait = new ExplicitWait();
		explicitWait.setWaitingTime(0);
		explicitWait.setExpectedCondition(ExpectedConditions.visibilityOfElementLocated(By.id(measurableWebElement.getElementId())));
		
		MeasureResult measureResult = LoadingMeasurer.measureLoadingTime(measurableWebElement, explicitWait, WebDriverFactory.createChromeWebDriver());
		
		System.out.println("The Element with text=" + measureResult.getElementText() + " is displayed in " + measureResult.getElapsedMillionSeconds() / 1000 + " seconds");
	}
	
	public static void testLoadCities() {
		MeasurableWebElement measurableWebElement = new MeasurableWebElement();
		measurableWebElement.setUrl("http://localhost:4200/cities");
		measurableWebElement.setElementId("td_128768");
		
		ExplicitWait explicitWait = new ExplicitWait();
		explicitWait.setWaitingTime(1);
		explicitWait.setExpectedCondition(ExpectedConditions.visibilityOfElementLocated(By.id(measurableWebElement.getElementId())));
		
		MeasureResult measureResult = LoadingMeasurer.measureLoadingTime(measurableWebElement, explicitWait, WebDriverFactory.createChromeWebDriver());
		
		System.out.println("The Element with text=" + measureResult.getElementText() + " is displayed in " + measureResult.getElapsedMillionSeconds() / 1000 + " seconds");
	}

}
