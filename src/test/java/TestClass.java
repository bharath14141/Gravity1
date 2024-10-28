import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BaseMethod;
import pomPackage.POMClass;

public class TestClass extends BaseMethod {

	public static WebDriver driver;
	public static POMClass pageObjectClass;
	public static SoftAssert assertSoft = new SoftAssert();
	

	@Test(priority = 1)
	public static void TestCase1() throws IOException {
		driver = launchBrowserMethod(readPropertyFile("Browser"));
		pageObjectClass = new POMClass(driver);
		staticWaitMethod(2000);
		maximizeWindowMethod();
		deleteAllCookiesMethod();
		staticWaitMethod(2000);
		getBrowserMethod(readPropertyFile("URLSauceDemo"));
		staticWaitMethod(2000);
		takesScreenShotMethod("Home_Page");
		assertSoft.assertEquals(driver.getTitle(), readPropertyFile("ExpectedHomePageTitle"));
	}
	
	@Test(priority = 2)
	public static void TestCase2() throws Exception{
		clickMethod(pageObjectClass.getLoginButton());
		takesScreenShotMethod("Error_Message_1");
		staticWaitMethod(2000);
		assertSoft.assertEquals(getTextMethod(pageObjectClass.getErrorMessage())
				, readPropertyFile("ExpectedErrorMessage1"));
		navigationMethod('l');
	}
	@Test(priority = 3)
	public static void TestCase3() throws Exception{
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getUserName(), readPropertyFile("InvalidUserName"));
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getPassword(), readPropertyFile("InvalidPassword"));
		staticWaitMethod(2000);
		clickMethod(pageObjectClass.getLoginButton());
		takesScreenShotMethod("Error_Message_2");
		staticWaitMethod(2000);
		assertSoft.assertEquals(getTextMethod(pageObjectClass.getErrorMessage())
				, readPropertyFile("ExpectedErrorMessage2"));
		navigationMethod('l');
		
	}
	@Test(priority = 4)
	public static void TestCase4() throws Exception{
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getUserName(), readPropertyFile("ValidUserName"));
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getPassword(), readPropertyFile("InvalidPassword"));
		staticWaitMethod(2000);
		clickMethod(pageObjectClass.getLoginButton());
		takesScreenShotMethod("Error_Message_3");
		staticWaitMethod(2000);
		assertSoft.assertEquals(getTextMethod(pageObjectClass.getErrorMessage())
				, readPropertyFile("ExpectedErrorMessage2"));
		navigationMethod('l');
		
		
	}
	@Test(priority = 5)
	public static void TestCase5() throws Exception{
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getUserName(), readPropertyFile("ValidUserName"));
		staticWaitMethod(2000);
		sendKeysMethod(pageObjectClass.getPassword(), readPropertyFile("ValidPassword"));
		staticWaitMethod(2000);
		clickMethod(pageObjectClass.getLoginButton());
		takesScreenShotMethod("Main_Page");
		staticWaitMethod(2000);
		browserQuitMethod();
		assertSoft.assertAll();
	}

	
	

}
