package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrder_page {
WebDriver dr;
	
	public PlaceOrder_page(WebDriver dr) 
	{
		this.dr = dr;
	}
	
	//place order
	
	public void click_cart()
	{
		WebElement cart = dr.findElement(By.xpath("//a[normalize-space()='Cart']"));
		cart.click();
	}
	
	public void click_proceed()
	{
		WebElement proceed = dr.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']"));
		proceed.click();
	}
	
	public void click_register()
	{
		WebElement reg = dr.findElement(By.xpath("//u[normalize-space()='Register / Login']"));
		reg.click();
	}
	
	public void enter_msg(String m)
	{
		WebElement msg = dr.findElement(By.xpath("//textarea[@name='message']"));
		msg.sendKeys(m);
	}
	
	public void click_placeorder()
	{
		WebElement placeorder = dr.findElement(By.xpath("//a[normalize-space()='Place Order']"));
		placeorder.click();
	}
	
	public void enter_cardname(String cn)
	{
		WebElement cardname = dr.findElement(By.xpath("//input[@name='name_on_card']"));
		cardname.sendKeys(cn);
	}
	
	public void enter_cardnum(int cno)
	{
		WebElement cardnum = dr.findElement(By.xpath("//input[@name='card_number']"));
		cardnum.sendKeys(Integer.toString(cno));
	}
	
	public void enter_cvv(int cv)
	{
		WebElement cvv = dr.findElement(By.xpath("//input[@placeholder='ex. 311']"));
		cvv.sendKeys(Integer.toString(cv));
	}
	
	public void enter_Month(int m)
	{
		WebElement month = dr.findElement(By.xpath("//input[@placeholder='MM']"));
		month.sendKeys(Integer.toString(m));
	}
	
	public void enter_year(int y)
	{
		WebElement year = dr.findElement(By.xpath("//input[@placeholder='YYYY']"));
		year.sendKeys(Integer.toString(y));
	}
	
	public void click_submit()
	{
		WebElement submit = dr.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
	}
	
	public String order()
	{
		WebElement orderplaced = dr.findElement(By.xpath("//b[normalize-space()='Order Placed!']"));
		return orderplaced.getText();
	}
	
	public String Delivery_Address()
	{
		WebElement Delivery = dr.findElement(By.xpath("//ul[@id='address_delivery']"));
		return Delivery.getText();
	}
	
	public String Billing_Address()
	{
		WebElement Billing = dr.findElement(By.xpath("//ul[@id='address_invoice']"));
		return Billing.getText();
	}
	
	public void invoice()
	{
		WebElement Down_inv = dr.findElement(By.xpath("//a[normalize-space()='Download Invoice']"));
		Down_inv.click();
	}

	
}
