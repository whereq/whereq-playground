

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * 
 * The implicit wait is not working properly or as documented in my test, so just leave it here for future references.
 *   
 * @author whereq
 *
 */
public class TestImplicitWait {

	private String url;
	private long waitingTime;
	private String elementId;

	private WebDriver driver;
	private WebElement element;

	public static void main(String[] args) {
		TestImplicitWait explicitWait = new TestImplicitWait();
//		explicitWait.waitToLoadCountries();
		explicitWait.waitToLoadCities();
	}

	public void waitToLoadCountries() {
//    	System.setProperty("webdriver.ie.driver",".\\selenium\\webdriver\\ie\\iexplore.exe");
//		driver = new InternetExplorerDriver();

		System.setProperty("webdriver.chrome.driver", ".\\selenium\\webdriver\\chrome\\chromedriver.exe");

		url = "http://localhost:4200/countries";
		waitingTime = 1;
		elementId = "td_239";

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.MILLISECONDS);
		
		try {
			
			long startTime = System.currentTimeMillis();
			
			driver.get(url);
			
			long endTime = System.currentTimeMillis();

			element = driver.findElement(By.id(elementId));

			System.out.println("ElementId=" + elementId + ", ElementText=" + element.getText() + " is displayed in "
					+ (endTime - startTime) / 1000 + " seconds");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		driver.close();
	}

	public void waitToLoadCities() {
//    	System.setProperty("webdriver.ie.driver",".\\selenium\\webdriver\\ie\\iexplore.exe");
//		driver = new InternetExplorerDriver();

		System.setProperty("webdriver.chrome.driver", ".\\selenium\\webdriver\\chrome\\chromedriver.exe");

		url = "http://localhost:4200/cities";
		waitingTime = 100;
		elementId = "td_128768";

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.SECONDS);
		
		try {
			long startTime = System.currentTimeMillis();
			driver.get(url);
//			driver.manage().timeouts().implicitlyWait(waitingTime, TimeUnit.SECONDS);
			long endTime = System.currentTimeMillis();
			
			System.out.println("Time elapsed " + (endTime - startTime) / 1000 + " seconds");
			
			element = driver.findElement(By.id(elementId));

			System.out.println("ElementId=" + elementId + ", ElementText=" + element.getText() + " is displayed in " + waitingTime + " seconds");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		driver.close();
	}
}
