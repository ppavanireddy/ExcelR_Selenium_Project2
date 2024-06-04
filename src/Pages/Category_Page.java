package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Category_Page {
WebDriver dr;
	
	public Category_Page(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Category Page
	
	public String Verify_cat() //CATEGORY
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Category']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void women()
	{
		WebElement Women = dr.findElement(By.xpath("//a[normalize-space()='Women']"));
		Women.click();
	}
	
	public void dress()
	{
		WebElement Dress = dr.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]"));
		Dress.click();
	}
	
	public String Verify_msg() //WOMEN - DRESS PRODUCTS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Women - Dress Products']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void men()
	{
		WebElement Men = dr.findElement(By.xpath("//a[normalize-space()='Men']"));
		Men.click();
	}
	
	public void tshirts()
	{
		WebElement Tshirts = dr.findElement(By.xpath("//a[normalize-space()='Tshirts']"));
		Tshirts.click();
	}
	
	public String Verify_txt() //MEN - TSHIRTS PRODUCTS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Men - Tshirts Products']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public String Verify_Bra() //BRANDS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Brands']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void polo()
	{
		WebElement Polo = dr.findElement(By.xpath("//a[@href='/brand_products/Polo']"));
		Polo.click();
	}
	
	public String Verify_Polo()//BRAND - POLO PRODUCTS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Brand - Polo Products']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void hm()
	{
		WebElement HM = dr.findElement(By.xpath("//a[@href='/brand_products/H&M']"));
		HM.click();
	}
	
	
	public String Verify_HM()//BRAND - H&M PRODUCTS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Brand - H&M Products']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	

}
