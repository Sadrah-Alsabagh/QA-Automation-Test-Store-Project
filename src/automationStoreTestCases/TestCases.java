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
		System.out.println("-------------------->Featured<--------------------");
		System.out.println("Featured New Price ==> " + total_featured_new_prices);

		String featured_old_price_text = featured_container.findElement(By.className("priceold")).getText().replace("$", "");
			System.out.println("Featured old Price ==> " + featured_old_price_text);
		
		
		////////////////////////////////////
		// 2- LATEST PRODUCTS
			WebElement latest_container = driver.findElement(By.id("latest"));
			double total_latest_new_price = 0;

			List<WebElement> latest_price_elements = latest_container.findElements(By.className("oneprice"));
			for (int i = 0; i < latest_price_elements.size(); i++) {
			    // Get the text of the prices
			    String latest_price_text = latest_price_elements.get(i).getText().replace("$", "");
			    double double_latest_prices = Double.parseDouble(latest_price_text);
			    total_latest_new_price += double_latest_prices;
			}


			List<WebElement> latest_new_price = latest_container.findElements(By.className("pricenew"));
			for (int j = 0; j < latest_new_price.size(); j++) {
			    String latest_new_price_text = latest_new_price.get(j).getText().replace("$", "");
			    double double_latest_new_price = Double.parseDouble(latest_new_price_text);
			    total_latest_new_price += double_latest_new_price;
			}

			System.out.println("-------------------->Latest Products<--------------------");
			System.out.println("Latest Products New Price ==> " + total_latest_new_price);
		

			
			double total_latest_old_price = 0;
			List<WebElement> latest_old_price = latest_container.findElements(By.className("priceold"));
			for (int i = 0; i < latest_old_price.size(); i++) {
				String latest_old_price_text = latest_old_price.get(i).getText().replace("$", "");
				double double_latest_old_price = Double.parseDouble(latest_old_price_text);
				total_latest_old_price += double_latest_old_price;
			}
				System.out.println("Latest Products old Price ==> " + total_latest_old_price);
			
		
		////////////////////////////////////
		// 3- BESTSELLERS 
				WebElement bestseller_container = driver.findElement(By.id("bestseller"));
				List<WebElement> bestseller_price_elements = bestseller_container.findElements(By.className("oneprice"));
				double sum_bestseller_prices = 0;
				double total_bestseller_new_prices = 0;

				for (int i = 0; i < bestseller_price_elements.size(); i++) {
					// Get the text of the prices
					String bestseller_price_text = bestseller_price_elements.get(i).getText().replace("$", "");
					String bestseller_new_price =bestseller_container.findElement(By.className("pricenew")).getText().replace("$", "");
					double double_bestseller_new_price = Double.parseDouble(bestseller_new_price);
					double double_bestseller_prices = Double.parseDouble(bestseller_price_text);
					sum_bestseller_prices += double_bestseller_prices;
					total_bestseller_new_prices = sum_bestseller_prices + double_bestseller_new_price;
				}
				System.out.println("-------------------->BestSeller<--------------------");
				System.out.println("BestSeller New Price ==> " + total_bestseller_new_prices);

				String bestseller_old_price_text = bestseller_container.findElement(By.className("priceold")).getText().replace("$", "");
					System.out.println("BestSeller old Price ==> " + bestseller_old_price_text);
		
		////////////////////////////////////
		// 4- SPECIALS 
				WebElement special_container = driver.findElement(By.id("special"));
				double total_special_new_price = 0;

				List<WebElement> special_new_price = special_container.findElements(By.className("pricenew"));
				for (int j = 0; j < special_new_price.size(); j++) {
				    String special_new_price_text = special_new_price.get(j).getText().replace("$", "");
				    double double_special_new_price = Double.parseDouble(special_new_price_text);
				    total_special_new_price += double_special_new_price;
				}

				System.out.println("-------------------->Special<--------------------");
				System.out.println("Special Products New Price ==> " + total_special_new_price);
			
				
				double total_special_old_price = 0;
				List<WebElement> special_old_price = special_container.findElements(By.className("priceold"));
				for (int i = 0; i < special_old_price.size(); i++) {
					String special_old_price_text = special_old_price.get(i).getText().replace("$", "");
					double double_special_old_price = Double.parseDouble(special_old_price_text);
					total_special_old_price += double_special_old_price;
				}
					System.out.println("Special old Price ==> " + total_special_old_price);
					System.out.println();
	}

	@Test()
	public void Check_Payment() {
		/*
		 * 3-make assertion that the payment method in the footer is displayed (visa,
		 * mastercard, paypal)
		 */
		WebElement payment_img = driver.findElement(By.xpath("//img[@alt='payments']"));
		softassert.assertTrue(payment_img.isDisplayed(), "Payment image is not displayed");
		softassert.assertAll();
	}

	@Test()
	public void Navigate_To_Linkedin() {
		/*
		 * 4- Navigate to the linkedin page and then go back to the website page
		 */
		driver.findElement(By.className("linkedin")).click();
		driver.navigate().back();

		// 5- do one assertion that the page is went back
		softassert.assertEquals(driver.getCurrentUrl(), automation_store_url,
				"Validation of the website url after go to linkedin page");
		softassert.assertAll();
	}

	@AfterTest
	public void postTest() {
//		driver.quit();
	}
}
