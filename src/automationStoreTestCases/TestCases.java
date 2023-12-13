package automationStoreTestCases;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCases extends Parameters {
	@BeforeTest
	public void Pre_Test() {
		// 1- go to this website https://www.automationteststore.com/
		driver.get(automation_store_url);
		driver.manage().window().maximize();
	}

	@Test()
	public void Check_Sum() {
		/*
		 * 2- in the home page there are four sections ( FEATURED, LATEST
		 * PRODUCTS,BESTSELLERS,SPECIALS) find the sum of the prices for each category
		 */

		// 1- FEATURED

		WebElement featured_container = driver.findElement(By.id("featured"));
		List<WebElement> featured_price_elements = featured_container.findElements(By.className("oneprice"));
		List<WebElement> featured_old_price_elements = featured_container.findElements(By.className("priceold"));
		double sum_featured_prices = 0;
		double total_featured_new_prices = 0;

		for (int i = 0; i < featured_price_elements.size(); i++) {
			// Get the text of the prices
			String featured_price_text = featured_price_elements.get(i).getText().replace("$", "");
			String featured_new_price = driver
					.findElement(By.cssSelector("div[id='block_frame_featured_1769'] div[class='pricenew']")).getText()
					.replace("$", "");
			double double_featured_new_price = Double.parseDouble(featured_new_price);
			double double_featured_prices = Double.parseDouble(featured_price_text);
			sum_featured_prices += double_featured_prices;
			total_featured_new_prices = sum_featured_prices + double_featured_new_price;
		}
		System.out.println("Featured New Price ==> " + total_featured_new_prices);

		String featured_old_price_text = featured_old_price_elements.get(0).getText().replace("$", "");
		System.out.println("Featured old Price ==> " + featured_old_price_text);
		////////////////////////////////////
		// 2- LATEST PRODUCTS
		// 3- BESTSELLERS
		// 4- SPECIALS
	}

	@Test()
	public void Check_Payment() {
		/*
		 * 3-make assertion that the payment method in the footer is displayed (visa,
		 * mastercard, paypal)
		 */
		WebElement paymentImage = driver.findElement(By.xpath("//img[@alt='payments']"));
		softassert.assertTrue(paymentImage.isDisplayed(), "Payment image is not displayed");
		softassert.assertAll();
}

	@Test()
	public void Navigate_To_Linkedin() {
		/*
		 * 4- Navigate to the linkedin page and then 
		 * go back to the website page
		 */
		driver.findElement(By.className("linkedin")).click();
		driver.navigate().back();
		
		// 5- do one assertion that the page is went back
		softassert.assertEquals(driver.getCurrentUrl(), automation_store_url,"Validation of the website url after go to linkedin page");
		softassert.assertAll();
	}

	@AfterTest
	public void postTest() {
	}
}
