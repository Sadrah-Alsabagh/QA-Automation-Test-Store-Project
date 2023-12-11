package automationStoreTestCases;
import org.testng.annotations.*;

public class TestCases extends Parameters{
	@BeforeTest
	public void Pre_Test() {
	//1-go to this website https://www.automationteststore.com/
		driver.get(automation_store_url);
	}	
	
	@Test()
	public void Check_Sum(){
	/*2- in the home page there are four sections 
	( FEATURED, LATEST PRODUCTS,BESTSELLERS,SPECIALS)
	find the sum of the prices for each category*/

		//1- FEATURED
		//2- LATEST PRODUCTS
		//3- BESTSELLERS
		//4- SPECIALS
	}
	
	@Test()
	public void Check_Payment(){
	/*3-make one assertion that the payment method in 
		 the footer is displayed ( visa, mastercard, paypal)*/
	}
	
	@Test()
	public void Navigate_To_Linkedin(){
	/*4- Navigate to the linkedin page and then 
		 go back to the website page*/

	//5- do one assertion that the page is went back
	}
	
	@AfterTest
	public void postTest() {
	}
}
