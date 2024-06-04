package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveProducts_page {
WebDriver dr;
	
	public RemoveProducts_page(WebDriver dr) 
	{
		this.dr = dr;
	}
	
	//remove product
	
	public void remove_product()
	{
		WebElement remove = dr.findElement(By.xpath("//i[@class='fa fa-times']"));
		remove.click();
	}
	
	public String msg()
	{
		WebElement Message = dr.findElement(By.xpath("//p[contains(text(),'Click')]"));
		return Message.getText();
	}

}
