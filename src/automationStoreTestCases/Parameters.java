package automationStoreTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String automation_store_url = "https://www.automationteststore.com/";
	SoftAssert softassert = new SoftAssert();
}
