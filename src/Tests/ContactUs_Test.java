package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactUs_Page;
import Pages.Register_User;
import Utilities.Base;

public class ContactUs_Test extends Base {
ContactUs_Page cp;
	
	@BeforeMethod
	public void bt() throws InterruptedException 
			
			{
				launch_browser();
				cp = new ContactUs_Page(dr);
			}
	
	@Test
	public void TC_006() throws InterruptedException, AWTException
			
			{
		//To verify Contact Us Form. 
		System.out.println(readExcel(6,0) + " : "+ readExcel(6,1));
		
		cp.goToContactus();
		
		String eSText = "GET IN TOUCH";
		Assert.assertEquals(cp.Verify_text(), eSText);
		
		cp.enter_name(readExcel(6,2));
		cp.enter_email(readExcel(6,3));
		cp.enter_subject(readExcel(6,14));
		cp.enter_message(readExcel(6,15));
		
		String filePath = Paths.get("C:\\Users\\DELL\\Downloads\\practice.txt").toAbsolutePath().toString(); // Replace with the actual file path

        cp.uploadFile(filePath);
        
		cp.click_submit();
		
		dr.switchTo().alert().accept();
		
		String eSText1 = "Success! Your details have been submitted successfully.";
		Assert.assertEquals(cp.Success_text(), eSText1);
		
		cp.click_home();
		
		cp.verify_home();
		
		close_browser();
			}
}
