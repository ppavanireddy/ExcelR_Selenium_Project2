package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs_Page {
WebDriver dr;
WebDriverWait wait;

	
	public ContactUs_Page(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Contact Us
	
	public void goToContactus() 
	{
		WebElement ContactUs = dr.findElement(By.xpath("//a[normalize-space()='Contact us']"));
		ContactUs.click();
		}
		
		public String Verify_text() //GET IN TOUCH
		{
			WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
			String aTxt =  text.getText();
			return aTxt;
		}
		
		public void enter_name(String name)
		{
			WebElement Name = dr.findElement(By.xpath("//input[@placeholder='Name']"));
			Name.sendKeys(name);
		}
		
		public void enter_email(String email)
		{
			WebElement Email = dr.findElement(By.xpath("//input[@placeholder='Email']"));
			Email.sendKeys(email);
		}
		
		public void enter_subject(String Subject)
		{
			WebElement sub = dr.findElement(By.xpath("//input[@placeholder='Subject']"));
			sub.sendKeys(Subject);
		}
		
		public void enter_message(String Message)
		{
			WebElement msg = dr.findElement(By.xpath("//textarea[@id='message']"));
			msg.sendKeys(Message);
		}
		
		
        public void uploadFile(String filePath) {
        	WebElement fileUploadInput = dr.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        	this.wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        	WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(fileUploadInput));
            uploadElement.sendKeys(filePath);
        }
      
		public void click_submit()
		{
			WebElement Submit = dr.findElement(By.xpath("//input[@name='submit']"));
			Submit.click();
		}
		
		public String Success_text() //Success! Your details have been submitted successfully.
		{
			WebElement text = dr.findElement(By.xpath("//div[@class='status alert alert-success']"));
			String aTxt =  text.getText();
			return aTxt;
		}
		
		public void click_home()
		{
			WebElement Home = dr.findElement(By.xpath("//span[normalize-space()='Home']"));
			Home.click();
		}
		
		public boolean verify_home()
		{
			WebElement text = dr.findElement(By.xpath("//img[@alt='Website for automation practice']"));
			return text.isDisplayed();
		}
}
