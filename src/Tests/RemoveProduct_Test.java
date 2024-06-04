package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AddtoCart_Page;
import Pages.ContactUs_Page;
import Pages.LoginUser_page;
import Pages.PlaceOrder_page;
import Pages.Products_Page;
import Pages.Register_User;
import Pages.RemoveProducts_page;
import Utilities.Base;

public class RemoveProduct_Test extends Base{
	AddtoCart_Page a;
	Products_Page pp;
	ContactUs_Page cp;
	PlaceOrder_page po;
	RemoveProducts_page rp;
	
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				
				
				a = new AddtoCart_Page(dr);
				pp= new Products_Page(dr);
				cp = new ContactUs_Page(dr);
				po = new PlaceOrder_page(dr);
				rp = new RemoveProducts_page(dr);
				
			}
	@Test
	public void TC_0017() throws InterruptedException 
			
			{
		
		//To verify the user can Remove Products From Cart
		System.out.println(readExcel(17,0) + " : "+ readExcel(17,1));
		
		 
		cp.verify_home();

		Thread.sleep(5000);
		pp.click_Products();
		
			
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		rp.remove_product();
		
		close_browser();
			}
}
