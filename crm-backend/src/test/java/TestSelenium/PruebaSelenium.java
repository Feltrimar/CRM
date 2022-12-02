package TestSelenium;

	import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	/**
	 * Q. How to mark any method as part of test?
	 * @Test:	Marks a class or a method as part of the test.
	 * 
	 * Q. Commonly used assert methods to assert the result?
	 * Assert.assertEquals(actual, expected);
	 * Assert.assertNotEquals(actual, expected);
	 * Assert.assertTrue(condition);
	 * Assert.assertFalse(condition);
	 * Assert.assertNull(object);
	 * Assert.assertNotNull(object);	
	 */
	public class PruebaSelenium {
		
		@Test
		public void loginErrorTest() {
			System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://localhost:3000");
	        
	        //WebElement element = driver.findElement(By.id("lst-ib"));
	        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/form/div[1]/input"));
	        element.sendKeys("user");
	        element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/form/div[2]/input"));
	        element.sendKeys("password");
	        element.submit();
		
		}
		
		
		
		
		
		public void wait(int i) {
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

