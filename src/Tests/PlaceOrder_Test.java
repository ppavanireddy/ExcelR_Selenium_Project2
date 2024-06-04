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
import Pages.PlaceOrder_page;
import Pages.Products_Page;
import Pages.Register_User;
import Utilities.Base;

public class PlaceOrder_Test extends Base {
	AddtoCart_Page a;
	Products_Page pp;
	ContactUs_Page cp;
	PlaceOrder_page po;
	Register_User ru;
	LoginUser_page lu;
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				a = new AddtoCart_Page(dr);
				pp= new Products_Page(dr);
				cp = new ContactUs_Page(dr);
				po = new PlaceOrder_page(dr);
				ru = new Register_User(dr);
				lu = new LoginUser_page(dr);
			}
	@Test
	public void TC_0014() throws InterruptedException 
			
			{
		//To verify Place Order: Register while Checkout
		System.out.println(readExcel(14,0) + " : "+ readExcel(14,1));
		
		cp.verify_home();
		
		Thread.sleep(5000);
		pp.click_Products();
		
			
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		po.click_proceed();
		
		po.click_register();
		
		String eSText = "New User Signup!";
		Assert.assertEquals(ru.Verify_newsignup(), eSText);
		
		ru.enter_name(readExcel(14,2));
		ru.enter_email(readExcel(14,3));
		
		ru.click_signup();
		
		String eSText1 = "ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(ru.Verify_actinfo(), eSText1);
		ru.select_title();
		
		ru.enter_pwd(readExcel(14,4));
		ru.select_day();
		ru.select_month();
		ru.select_year();
		
		WebElement checkbox = dr.findElement(By.id("newsletter"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox);
        WebElement checkbox1 = dr.findElement(By.id("optin"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox1);
		
		ru.enter_fname(readExcel(14,5));
		ru.enter_lname(readExcel(14,6));
		ru.enter_com(readExcel(14,7));
		ru.enter_Address(readExcel(14,8));
		ru.enter_Address2(readExcel(14,9));
		
		ru.Country();
		ru.enter_Street(readExcel(14,10));
		ru.enter_city(readExcel(14,11));
		ru.enter_zip(readExcelInt(14,12));
		ru.enter_mobile(readExcelInt(14,13));
		
		WebElement button = dr.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", button);
		
		String eSText11 = "ACCOUNT CREATED!";
		Assert.assertEquals(ru.Verify_actcreated(), eSText11);
		
		ru.click_co();
		
		po.click_cart();
		
		po.click_proceed();
		
		po.enter_msg(readExcel(14,18));
		
		po.click_placeorder();
		
		po.enter_cardname(readExcel(14,19));
		
		po.enter_cardnum(readExcelInt(14,20));
		
		po.enter_cvv(readExcelInt(14,21));
		
		po.enter_Month(readExcelInt(14,22));
		
		po.enter_year(readExcelInt(14,23));
		
		po.click_submit();
		
		String eSText2 = "ORDER PLACED!";
		Assert.assertEquals(po.order(), eSText2);
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
			}
	
	@Test
	public void TC_0015() throws InterruptedException 
	
	{
		//To verify Place Order: Register before Checkout
		System.out.println(readExcel(15,0) + " : "+ readExcel(15,1));

		cp.verify_home();
		
		ru.goTosignup();
		
		ru.enter_name(readExcel(15,2));
		ru.enter_email(readExcel(15,3));
		
		ru.click_signup();
		
		String eSText1 = "ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(ru.Verify_actinfo(), eSText1);
		ru.select_title();
		
		ru.enter_pwd(readExcel(15,4));
		ru.select_day();
		ru.select_month();
		ru.select_year();
		
		WebElement checkbox = dr.findElement(By.id("newsletter"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox);
        WebElement checkbox1 = dr.findElement(By.id("optin"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox1);
		
		ru.enter_fname(readExcel(15,5));
		ru.enter_lname(readExcel(15,6));
		ru.enter_com(readExcel(15,7));
		ru.enter_Address(readExcel(15,8));
		ru.enter_Address2(readExcel(15,9));
		
		ru.Country();
		ru.enter_Street(readExcel(15,10));
		ru.enter_city(readExcel(15,11));
		ru.enter_zip(readExcelInt(15,12));
		ru.enter_mobile(readExcelInt(15,13));
		
		WebElement button = dr.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", button);
		
		String eSText11 = "ACCOUNT CREATED!";
		Assert.assertEquals(ru.Verify_actcreated(), eSText11);
		
		ru.click_co();
		
		Thread.sleep(5000);
		pp.click_Products();
		
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		po.click_proceed();
		
		po.enter_msg(readExcel(15,18));
		
		po.click_placeorder();
		
		po.enter_cardname(readExcel(15,19));
		
		po.enter_cardnum(readExcelInt(15,20));
		
		po.enter_cvv(readExcelInt(15,21));
		
		po.enter_Month(readExcelInt(15,22));
		
		po.enter_year(readExcelInt(15,23));
		
		po.click_submit();
		
		String eSText2 = "ORDER PLACED!";
		Assert.assertEquals(po.order(), eSText2);
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
	}
	
	@Test
	public void TC_0016() throws InterruptedException 
	
	{
		//To verify Place Order: Login before Checkout
		System.out.println(readExcel(16,0) + " : "+ readExcel(16,1));

		cp.verify_home();
		
		ru.goTosignup();
		
		lu.enter_email(readExcel(16,3));
		lu.enter_password(readExcel(16,4));
		
		lu.click_button();
		
		Thread.sleep(5000);
		String eSText1 = "Logged in as manogna";
		Assert.assertEquals(lu.verify(), eSText1);
		
		Thread.sleep(5000);
		pp.click_Products();
		
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		po.click_proceed();
		
		po.enter_msg(readExcel(16,18));
		
		po.click_placeorder();
		
		po.enter_cardname(readExcel(16,19));
		
		po.enter_cardnum(readExcelInt(16,20));
		
		po.enter_cvv(readExcelInt(16,21));
		
		po.enter_Month(readExcelInt(16,22));
		
		po.enter_year(readExcelInt(16,23));
		
		po.click_submit();
		
		String eSText2 = "ORDER PLACED!";
		Assert.assertEquals(po.order(), eSText2);
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
	}
	
	@Test
	public void TC_0023() throws InterruptedException 
	
	{
		//To verify Place Order: Login before Checkout
		System.out.println(readExcel(23,0) + " : "+ readExcel(23,1));

		cp.verify_home();
		
		ru.goTosignup();
		
		ru.enter_name(readExcel(23,2));
		ru.enter_email(readExcel(23,3));
		
		ru.click_signup();
		
		String eSText1 = "ENTER ACCOUNT INFORMATION";
		
		Assert.assertEquals(ru.Verify_actinfo(), eSText1);
		
		ru.select_title();
		
		ru.enter_pwd(readExcel(23,4));
		ru.select_day();
		ru.select_month();
		ru.select_year();
		
		WebElement checkbox = dr.findElement(By.id("newsletter"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox);
        WebElement checkbox1 = dr.findElement(By.id("optin"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox1);
		
		ru.enter_fname(readExcel(23,5));
		ru.enter_lname(readExcel(23,6));
		ru.enter_com(readExcel(23,7));
		ru.enter_Address(readExcel(23,8));
		ru.enter_Address2(readExcel(23,9));
		
		ru.Country();
		ru.enter_Street(readExcel(23,10));
		ru.enter_city(readExcel(23,11));
		ru.enter_zip(readExcelInt(23,12));
		ru.enter_mobile(readExcelInt(23,13));
		
		WebElement button = dr.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", button);
		
		String eSText11 = "ACCOUNT CREATED!";
		Assert.assertEquals(ru.Verify_actcreated(), eSText11);
		
		ru.click_co();
		
		Thread.sleep(5000);
		pp.click_Products();
		
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		po.click_proceed();
		
		String eSText2 = "YOUR DELIVERY ADDRESS\n"
				+ "Mrs. Panasala Pavani\n"
				+ "Wipro\n"
				+ "KKR Nagar\n"
				+ "Kovur\n"
				+ "Nellore Andhra Pradesh 524137\n"
				+ "India\n"
				+ "9874561230";
		Assert.assertEquals(po.Delivery_Address(), eSText2);
		
		String eSText3 = "YOUR BILLING ADDRESS\n"
				+ "Mrs. Panasala Pavani\n"
				+ "Wipro\n"
				+ "KKR Nagar\n"
				+ "Kovur\n"
				+ "Nellore Andhra Pradesh 524137\n"
				+ "India\n"
				+ "9874561230";
		Assert.assertEquals(po.Billing_Address(), eSText3);
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
	}
	
	@Test
	public void TC_0024() throws InterruptedException 
	
	{
		//To verify Place Order: Login before Checkout
		System.out.println(readExcel(24,0) + " : "+ readExcel(24,1));

		cp.verify_home();
		
		pp.click_Products();
		
		Thread.sleep(5000);
		a.hoverOverFirstProduct();
		a.clickAddToCart();
		
		Thread.sleep(5000);
		a.clickContinueShopping();
		
		po.click_cart();
		
		po.click_proceed();
		
		ru.goTosignup();
		
		ru.enter_name(readExcel(24,2));
		ru.enter_email(readExcel(24,3));
		
		ru.click_signup();
		
		String eSText1 = "ENTER ACCOUNT INFORMATION";
		
		Assert.assertEquals(ru.Verify_actinfo(), eSText1);
		
		ru.select_title();
		
		ru.enter_pwd(readExcel(24,4));
		ru.select_day();
		ru.select_month();
		ru.select_year();
		
		WebElement checkbox = dr.findElement(By.id("newsletter"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox);
        WebElement checkbox1 = dr.findElement(By.id("optin"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox1);
		
		ru.enter_fname(readExcel(24,5));
		ru.enter_lname(readExcel(24,6));
		ru.enter_com(readExcel(24,7));
		ru.enter_Address(readExcel(24,8));
		ru.enter_Address2(readExcel(24,9));
		
		ru.Country();
		ru.enter_Street(readExcel(24,10));
		ru.enter_city(readExcel(24,11));
		ru.enter_zip(readExcelInt(24,12));
		ru.enter_mobile(readExcelInt(24,13));
		
		WebElement button = dr.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", button);
		
		String eSText11 = "ACCOUNT CREATED!";
		Assert.assertEquals(ru.Verify_actcreated(), eSText11);
		
		ru.click_co();
		
		po.click_cart();
		
		po.click_proceed();
		
		po.enter_msg(readExcel(24,18));
		
		po.click_placeorder();
		
		po.enter_cardname(readExcel(24,19));
		
		po.enter_cardnum(readExcelInt(24,20));
		
		po.enter_cvv(readExcelInt(24,21));
		
		po.enter_Month(readExcelInt(24,22));
		
		po.enter_year(readExcelInt(24,23));
		
		po.click_submit();
		
		String eSText2 = "ORDER PLACED!";
		Assert.assertEquals(po.order(), eSText2);
		
		po.invoice();
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
	}
		
	
		
		
}
