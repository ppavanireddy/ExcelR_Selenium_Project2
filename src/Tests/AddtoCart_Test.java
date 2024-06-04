package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AddtoCart_Page;
import Pages.ContactUs_Page;
import Pages.Products_Page;
import Utilities.Base;

public class AddtoCart_Test extends Base {
	Products_Page pp;
	AddtoCart_Page a;
	ContactUs_Page cp;
		
	@BeforeMethod
		public void bt() throws InterruptedException 
				
				{
					launch_browser();
					pp= new Products_Page(dr);
					a = new AddtoCart_Page(dr);
					cp = new ContactUs_Page(dr);
				}
		
		@Test
		public void TC_0012() throws InterruptedException 
				
				{
			//To verify user can add Products in Cart
			System.out.println(readExcel(12,0) + " : "+ readExcel(12,1));
			
			cp.verify_home();
			
			pp.click_Products();
			
			Thread.sleep(5000);
			a.hoverOverFirstProduct();
			a.clickAddToCart();
			
			Thread.sleep(5000);
			a.clickContinueShopping();
			
			
			try {
			a.hoverOverSecondProduct();
			}catch (Exception e) {
			}
			a.clickAddToCart2();
			
			Thread.sleep(5000);
			a.clickViewCart();
			
			a.verifyitems();
			
			String eSText1 = "Rs. 500";
			Assert.assertEquals(a.Price1(), eSText1);
			
			String eSText11 = "2";
			Assert.assertEquals(a.Quantity1(), eSText11);
			
			String eSText111 = "Rs. 1000";
			Assert.assertEquals(a.Total1(), eSText111);
			
		
			 
			close_browser();
				}
			
			
			
}
