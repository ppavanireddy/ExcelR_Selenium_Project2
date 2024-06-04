package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginUser_page;
import Pages.Register_User;
import Utilities.Base;

public class Loginuser_Test extends Base {
	Register_User ru;
	LoginUser_page lu;
	
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				ru = new Register_User(dr);
				lu = new LoginUser_page(dr);
			}
	@Test
	public void TC_002() throws InterruptedException
			
			{
		//To verify Login User with correct email and password
		System.out.println(readExcel(2,0) + " : "+ readExcel(2,1));
		
		ru.goTosignup();
		
		
		String eSText = "Login to your account";
		Assert.assertEquals(lu.Verify_login(), eSText);
		
		lu.enter_email(readExcel(2,3));
		lu.enter_password(readExcel(2,4));
		
		lu.click_button();
		
		Thread.sleep(5000);
		String eSText1 = "Logged in as Pavani";
		Assert.assertEquals(ru.Verify_logged(), eSText1);
		
		ru.click_da();
		
		Thread.sleep(5000);
		String eSText11 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText11);
		
		close_browser();
			}
	@Test
	public void TC_003() throws InterruptedException
			
			{
		//To verify Login User with incorrect email and password
		System.out.println(readExcel(3,0) + " : "+ readExcel(3,1));
		
		ru.goTosignup();
		
		
		String eSText = "Login to your account";
		Assert.assertEquals(lu.Verify_login(), eSText);
		
		lu.enter_email(readExcel(3,3));
		lu.enter_password(readExcel(3,4));
		
		lu.click_button();
		
		Thread.sleep(5000);
		String eSText11 = "Your email or password is incorrect!";
		Assert.assertEquals(lu.aLoginFailText(), eSText11);
		
		close_browser();
			}
	
	@Test
	public void TC_004() throws InterruptedException
			
			{
		//To verify user can logout from an account. 
		System.out.println(readExcel(4,0) + " : "+ readExcel(4,1));
		
		ru.goTosignup();
		
		
		String eSText = "Login to your account";
		Assert.assertEquals(lu.Verify_login(), eSText);
		
		lu.enter_email(readExcel(4,3));
		lu.enter_password(readExcel(4,4));
		
		lu.click_button();
		
		Thread.sleep(5000);
		String eSText1 = "Logged in as manogna";
		Assert.assertEquals(lu.verify(), eSText1);
		
		lu.click_logout();
		
		String eSText11 = "Login to your account";
		Assert.assertEquals(lu.Verify_login(), eSText11);
		
		close_browser();
			}
}
