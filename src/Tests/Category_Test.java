package Tests;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AddtoCart_Page;
import Pages.Category_Page;
import Pages.ContactUs_Page;
import Pages.PlaceOrder_page;
import Pages.Products_Page;
import Pages.RemoveProducts_page;
import Utilities.Base;

public class Category_Test extends Base{
	Category_Page c;
	Products_Page pp;
	
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				c = new Category_Page(dr);
				pp= new Products_Page(dr);
			}
	@Test
	public void TC_0018() throws InterruptedException 
			
			{
		
		//To verify user can View Category Products
		System.out.println(readExcel(18,0) + " : "+ readExcel(18,1));
		
		String eSText1 = "CATEGORY";
		Assert.assertEquals(c.Verify_cat(), eSText1);
		scrollDown200();
		c.women();
		
		scrollDown200();
		//Thread.sleep(5000);
		c.dress();
		
		String eSText2 = "WOMEN - DRESS PRODUCTS";
		Assert.assertEquals(c.Verify_msg(), eSText2);
		
		Thread.sleep(5000);
		c.men();
		
		Thread.sleep(5000);
		c.tshirts();
		
		String eSText3 = "MEN - TSHIRTS PRODUCTS";
		Assert.assertEquals(c.Verify_txt(), eSText3);
		
		close_browser();
			}
	
	@Test
	public void TC_0019() throws InterruptedException 
			
			{
		
		//To verify user can View & Cart Brand Products
		System.out.println(readExcel(19,0) + " : "+ readExcel(19,1));
		
		pp.click_Products();
		
		
		
		String eSText1 = "BRANDS";
		Assert.assertEquals(c.Verify_Bra(), eSText1);
		
		c.polo();
		
		String eSText2 = "BRAND - POLO PRODUCTS";
		Assert.assertEquals(c.Verify_Polo(), eSText2);
		
		c.hm();
		
		String eSText3 = "BRAND - H&M PRODUCTS";
		Assert.assertEquals(c.Verify_HM(), eSText3);
		
		close_browser();
			}		
}
