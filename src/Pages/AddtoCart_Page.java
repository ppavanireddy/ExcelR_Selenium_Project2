package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart_Page {
		WebDriver dr;
		Actions actions;
		@FindBy(xpath = "//div[@class='productinfo text-center'][1]")
		
	    private WebElement firstProduct;
		
		@FindBy(xpath = "//div[3]//div[1]//div[1]//div[2]//div[1]//a[1]")
	    private WebElement secondProduct;
		
		@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]//a[@class='btn btn-default add-to-cart']")
		private WebElement addToCartButton;
		
		@FindBy(xpath = "(//div[@class='productinfo text-center'])[2]//a[@class='btn btn-default add-to-cart']")
		private WebElement addToCartButton1;
			
		public AddtoCart_Page(WebDriver dr) 
			{
				this.dr = dr;
				this.actions = new Actions(dr);
				PageFactory.initElements(dr, this);
			}
			//AddtoCart page
			
			public void hoverOverFirstProduct() 
			{
		        actions.moveToElement(firstProduct).perform();
		    }
			
			public void clickAddToCart() {
				addToCartButton.click();
		    }
			
			public void clickContinueShopping()
			{
				WebElement continueShopping = dr.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
				continueShopping.click();
			}
			
			
			public void hoverOverSecondProduct() 
			{
		        actions.moveToElement(secondProduct).perform();
		    }
			
			public void clickAddToCart2() {
		        
				addToCartButton.click();
		    }
			
			public void clickViewCart()
			{
				WebElement viewCart = dr.findElement(By.xpath("//u[normalize-space()='View Cart']"));
				viewCart.click();
			}
			
			public void verifyitems()
			{
				WebElement items = dr.findElement(By.xpath("//*[@id=\"cart_info_table\"]/tbody"));
				items.isDisplayed();
			}
			
			public String Price1()//Rs. 500
			{
					WebElement text = dr.findElement(By.xpath("//p[normalize-space()='Rs. 500']"));
					String aTxt =  text.getText();
					return aTxt;
				}
			
			public String Quantity1()//5
			{
					WebElement text = dr.findElement(By.xpath("//tr[@id='product-1']//button[@class='disabled']"));
					String aTxt =  text.getText();
					return aTxt;
				}
			
			public String Total1()//Rs. 2500
			{
					WebElement text = dr.findElement(By.xpath("//p[normalize-space()='Rs. 1000']"));
					String aTxt =  text.getText();
					return aTxt;
				}
			
		
			
			

}
