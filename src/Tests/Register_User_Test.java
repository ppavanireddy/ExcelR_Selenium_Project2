package Tests;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Register_User;
import Utilities.Base;

public class Register_User_Test extends Base{
	Register_User ru;
	
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				ru = new Register_User(dr);
			}
	
	@Test
	public void TC_001() throws InterruptedException
			
			{
		//To verify user can register an account. 
		System.out.println(readExcel(1,0) + " : "+ readExcel(1,1));
		
		ru.goTosignup();
		
		String eSText = "New User Signup!";
		
		Assert.assertEquals(ru.Verify_newsignup(), eSText);
		
		ru.enter_name(readExcel(1,2));
		ru.enter_email(readExcel(1,3));
		
		ru.click_signup();
		
		String eSText1 = "ENTER ACCOUNT INFORMATION";
		
		Assert.assertEquals(ru.Verify_actinfo(), eSText1);
		
		ru.select_title();
		
		ru.enter_pwd(readExcel(1,4));
		ru.select_day();
		ru.select_month();
		ru.select_year();
		
		WebElement checkbox = dr.findElement(By.id("newsletter"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox);
        WebElement checkbox1 = dr.findElement(By.id("optin"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", checkbox1);
		
		ru.enter_fname(readExcel(1,5));
		ru.enter_lname(readExcel(1,6));
		ru.enter_com(readExcel(1,7));
		ru.enter_Address(readExcel(1,8));
		ru.enter_Address2(readExcel(1,9));
		
		ru.Country();
		ru.enter_Street(readExcel(1,10));
		ru.enter_city(readExcel(1,11));
		ru.enter_zip(readExcelInt(1,12));
		ru.enter_mobile(readExcelInt(1,13));
		
		WebElement button = dr.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].click();", button);
		
		String eSText11 = "ACCOUNT CREATED!";
		Assert.assertEquals(ru.Verify_actcreated(), eSText11);
		
		ru.click_co();
		
		Thread.sleep(5000);
		String eSText111 = "Logged in as Pavani";
		Assert.assertEquals(ru.Verify_logged(), eSText111);
		
		ru.click_da();
		
		String eSText1111 = "ACCOUNT DELETED!";
		Assert.assertEquals(ru.Verify_delete(), eSText1111);
		
		ru.con();
		
		close_browser();
			}
	
	@Test
	public void TC_005() throws InterruptedException
			
			{
		//To verify user can register an account. 
		System.out.println(readExcel(5,0) + " : "+ readExcel(5,1));
		
		ru.goTosignup();
		
		String eSText = "New User Signup!";
		Assert.assertEquals(ru.Verify_newsignup(), eSText);
		
		ru.enter_name(readExcel(5,2));
		ru.enter_email(readExcel(5,3));
		
		ru.click_signup();
		
		String eSText1 = "Email Address already exist!";
		Assert.assertEquals(ru.aRegisterFailText(), eSText1);
		
		close_browser();
			}
}
		
