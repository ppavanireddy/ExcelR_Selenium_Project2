package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AddtoCart_Page;
import Pages.ContactUs_Page;
import Pages.LoginUser_page;
import Pages.Products_Page;
import Pages.Register_User;
import Utilities.Base;

public class ProductsPage_Test extends Base {
Products_Page pp;
ContactUs_Page cp;
AddtoCart_Page a;
Register_User ru;
LoginUser_page lu;
	@BeforeMethod
	public void bt() throws InterruptedException
			
			{
				launch_browser();
				pp= new Products_Page(dr);
				cp = new ContactUs_Page(dr);
				a = new AddtoCart_Page(dr);
				ru = new Register_User(dr);
				lu = new LoginUser_page(dr);
			}
	
	@Test
	public void TC_008() throws InterruptedException 
			
			{
		//To Verify All Products and product detail page 
		System.out.println(readExcel(8,0) + " : "+ readExcel(8,1));
		
		cp.verify_home();
		
		pp.click_Products();
		
		Thread.sleep(5000);
		String eSText1 = "ALL PRODUCTS";
		Assert.assertEquals(pp.Verify_allproducts(), eSText1);
		
		pp.verify_products();
		
		WebElement click_viewproduct = dr.findElement(By.xpath("//a[@href='/product_details/1' and contains(text(),'View Product')]"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", click_viewproduct);
		
		pp.currenturl();
		
		pp.productinfo();
		
		close_browser();
		
			}
	
	@Test
	public void TC_009() throws InterruptedException 
			
			{
		//To verify Search Product 
		System.out.println(readExcel(9,0) + " : "+ readExcel(9,1));
		
		cp.verify_home();
		
		pp.click_Products();
		
		Thread.sleep(5000);
		String eSText1 = "ALL PRODUCTS";
		Assert.assertEquals(pp.Verify_allproducts(), eSText1);
		
		pp.search(readExcel(9,16));
		
		pp.click_search();
		
		String eSText2 = "SEARCHED PRODUCTS";
		Assert.assertEquals(pp.verify_searchedproduct(), eSText2);
		
		pp.verify_dress();
		
		close_browser();
			}		
	@Test
	public void TC_0013() throws InterruptedException 
			
			{
		//To verify user can check Product quantity in Cart
		
		System.out.println(readExcel(13,0) + " : "+ readExcel(13,1));
		
		cp.verify_home();
		
		WebElement click_viewproduct = dr.findElement(By.xpath("//a[@href='/product_details/1' and contains(text(),'View Product')]"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", click_viewproduct);
        
        pp.currenturl();
        
        pp.incQuan(readExcelInt(13,17));
        
        pp.click_addtocart();
        
        
        pp.click_viewcart();
        
        Thread.sleep(5000);
        String eSText2 = "4";
		Assert.assertEquals(pp.verify_quan(), eSText2);
		
        close_browser();
			}
		
	@Test
	public void TC_0020() throws InterruptedException 
			
			{
		//To verify Search Product 
		System.out.println(readExcel(20,0) + " : "+ readExcel(20,1));
		
		
		pp.click_Products();
		
		Thread.sleep(5000);
		String eSText1 = "ALL PRODUCTS";
		Assert.assertEquals(pp.Verify_allproducts(), eSText1);
		
		pp.search(readExcel(20,16));
		
		pp.click_search();
		Thread.sleep(5000);
		String eSText2 = "SEARCHED PRODUCTS";
		Assert.assertEquals(pp.verify_searchedproduct(), eSText2);
		
		pp.verify_dress();
		
		Thread.sleep(5000);
		pp.hoverOverFirstProduct();
		pp.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickViewCart();
		
		ru.goTosignup();
		
		
		String eSText = "Login to your account";
		Assert.assertEquals(lu.Verify_login(), eSText);
		
		lu.enter_email(readExcel(20,3));
		lu.enter_password(readExcel(20,4));
		
		lu.click_button();
		
		Thread.sleep(5000);
		a.clickViewCart();
		
		close_browser();
			}		
	
	@Test
	public void TC_0021() throws InterruptedException 
			
			{
		//To verify Search Product 
		System.out.println(readExcel(21,0) + " : "+ readExcel(21,1));
		
		
		pp.click_Products();
		
		Thread.sleep(5000);
		String eSText1 = "ALL PRODUCTS";
		Assert.assertEquals(pp.Verify_allproducts(), eSText1);
		
		pp.view_Product();
		
		pp.name(readExcel(21,2));
		
		pp.email(readExcel(21,3));
		
		pp.review(readExcel(21,24));
		close_browser();
			}		
	
	@Test
	public void TC_0022() throws InterruptedException 
			
			{
		//To verify Search Product 
		System.out.println(readExcel(22,0) + " : "+ readExcel(22,1));
		
		
		pp.scrollToFooter();
		
		pp.addtocart();
		
		pp.viewcart();
		close_browser();
			}		
}
