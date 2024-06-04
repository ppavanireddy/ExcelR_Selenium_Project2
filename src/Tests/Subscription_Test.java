package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactUs_Page;
import Pages.Products_Page;
import Pages.Subscription_Page;
import Utilities.Base;

public class Subscription_Test extends Base {
	Subscription_Page p;
	ContactUs_Page cp;
	@BeforeMethod
	public void bt() throws InterruptedException
			
			{
				launch_browser();
				p = new Subscription_Page(dr);
				cp = new ContactUs_Page(dr);
			}
	
	@Test
	public void TC_0010() throws InterruptedException 
			
			{
		//To Verify All Products and product detail page 
		System.out.println(readExcel(10,0) + " : "+ readExcel(10,1));
		
		cp.verify_home();
		
		p.scrollToFooter();
		p.isFooterDisplayed();
		
		Thread.sleep(5000);
		String eSText1 = "SUBSCRIPTION";
		Assert.assertEquals(p.Verify_text(), eSText1);
		
		p.Enter_email(readExcel(10,3));
		
		p.click_arrow();
		
		close_browser();
			}
	
	@Test
	public void TC_0011() throws InterruptedException 
			
			{
		//To Verify All Products and product detail page 
		System.out.println(readExcel(11,0) + " : "+ readExcel(11,1));
		
		cp.verify_home();
		
		p.click_cart();
		
		p.scrollToFooter();
		p.isFooterDisplayed();
		
		Thread.sleep(5000);
		String eSText1 = "SUBSCRIPTION";
		Assert.assertEquals(p.Verify_text(), eSText1);
		
		p.Enter_email(readExcel(11,3));
		
		p.click_arrow();
		
		close_browser();
			}
	
	@Test
	public void TC_0025() throws InterruptedException 
			
			{
		//To Verify All Products and product detail page 
		System.out.println(readExcel(25,0) + " : "+ readExcel(25,1));
		
		cp.verify_home();
		
		p.scrollToFooter();
		p.isFooterDisplayed();
		
		Thread.sleep(5000);
		String eSText1 = "SUBSCRIPTION";
		Assert.assertEquals(p.Verify_text(), eSText1);
		
		Thread.sleep(5000);
		p.click_uparrow();
		
		String eSText2 = "Full-Fledged practice website for Automation Engineers";
		Assert.assertEquals(p.msg(), eSText2);
		
		close_browser();
			}
	
	@Test
	public void TC_0026() throws InterruptedException 
			
			{
		//To Verify All Products and product detail page 
		System.out.println(readExcel(26,0) + " : "+ readExcel(26,1));
		
		cp.verify_home();
		
		p.scrollToFooter();
		p.isFooterDisplayed();
		
		Thread.sleep(5000);
		String eSText1 = "SUBSCRIPTION";
		Assert.assertEquals(p.Verify_text(), eSText1);
		
		p.scrollToHeader();
		
		String eSText2 = "Full-Fledged practice website for Automation Engineers";
		Assert.assertEquals(p.msg(), eSText2);
		
		close_browser();
			}
		
}
