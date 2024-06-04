package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUser_page {
WebDriver dr;
	
	public LoginUser_page(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Login user
	public String Verify_login() //Login to your account
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void enter_email(String email)
	{
		WebElement Email = dr.findElement(By.xpath("//input[@data-qa='login-email']"));
		Email.sendKeys(email);
	}
	
	public void enter_password(String pass)
	{
		WebElement pwd = dr.findElement(By.xpath("//input[@placeholder='Password']"));
		pwd.sendKeys(pass);
	}
	
	public void click_button()
	{
		WebElement login = dr.findElement(By.xpath("//button[normalize-space()='Login']"));
		login.click();
	}
	
	public String aLoginFailText() 
	{
		WebElement Text= dr.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
		return Text.getText();
	}
	
	public String verify()
	{
		WebElement text = dr.findElement(By.xpath("//a[i[@class='fa fa-user'] and text()[contains(., 'Logged in as ')] and b[text()='manogna']]"));
		String aTxt = text.getText();
		return aTxt;
	}
	
	public void click_logout()
	{
		WebElement logout = dr.findElement(By.xpath("//a[normalize-space()='Logout']"));
		logout.click();
	}
	
	

}
