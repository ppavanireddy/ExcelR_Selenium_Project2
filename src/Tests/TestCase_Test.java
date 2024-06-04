package Tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactUs_Page;
import Pages.TestCasePage;
import Utilities.Base;

public class TestCase_Test extends Base{
	ContactUs_Page cp;
	TestCasePage tp;
	
	@BeforeMethod
	public void bt() throws InterruptedException
			
			{
				launch_browser();
				cp = new ContactUs_Page(dr);
				tp= new TestCasePage(dr);
			}
	
	@Test
	public void TC_007() throws InterruptedException 
			
			{
		//To Verify Test Cases Page 
		System.out.println(readExcel(7,0) + " : "+ readExcel(7,1));
		
		cp.verify_home();
		
		tp.click_TestCases();
		
		Thread.sleep(5000);
		String eSText1 = "TEST CASES";
		Assert.assertEquals(tp.Verify_TestCase(), eSText1);
		
		close_browser();
			}
		
	
}
