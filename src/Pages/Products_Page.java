package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Products_Page {
WebDriver dr;
Actions actions;
	@FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]//div[@class='productinfo text-center']")
	private WebElement firstProduct;
	@FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]//a[@class='btn btn-default add-to-cart']")
	private WebElement addToCartButton;
	
	@FindBy(id = "footer")
    WebElement footer;

	
	public Products_Page(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Products Page
	
	public void click_Products()
	{
		WebElement products = dr.findElement(By.xpath("//a[@href='/products']"));
		products.click();
	}
	
	public String Verify_allproducts() //ALL PRODUCTS
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='All Products']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public boolean verify_products()
	{
		WebElement text = dr.findElement(By.xpath("//div[@class='features_items']"));
		return text.isDisplayed();
	}
	
	public void click_viewproduct()
	{
		WebElement view = dr.findElement(By.xpath("//a[@href='/product_details/1' and contains(text(),'View Product')]"));
		view.click();
	}
	
	public void currenturl()
	{
		String currentUrl = dr.getCurrentUrl();
        if (currentUrl.contains("/product_details/")) {
            System.out.println("User is on the product detail page.");
        } else {
            System.out.println("User is not on the product detail page.");
        }
	}
	public boolean productinfo()
	{
		WebElement text = dr.findElement(By.xpath("//div[@class='product-information']"));
		return text.isDisplayed();
	}
	
	public void search(String s)
	{
		WebElement Search = dr.findElement(By.xpath("//input[@id='search_product']"));
		Search.sendKeys(s);
	}
	
	public void click_search()
	{
		WebElement button = dr.findElement(By.xpath("//i[@class='fa fa-search']"));
		button.click();
	}
	
	public String verify_searchedproduct() //SEARCHED PRODUCTS
	{
		WebElement SP = dr.findElement(By.xpath("//h2[normalize-space()='Searched Products']"));
		String aTxt = SP.getText();
		return aTxt;
	}
	
	public boolean verify_dress()
	{
		WebElement text = dr.findElement(By.xpath("//div[@class='features_items']"));
		return text.isDisplayed();
	}
	
	public void incQuan(int q)
	{
		WebElement Quantity = dr.findElement(By.xpath("//input[@id='quantity']"));
		Quantity.clear();
		Quantity.sendKeys(Integer.toString(q));
	}
	
	public void click_addtocart()
	{
		WebElement addtocart = dr.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
		addtocart.click();
	}
	
	public void click_viewcart()
	{
		WebElement viewcart = dr.findElement(By.xpath("//u[normalize-space()='View Cart']"));
		viewcart.click();
	}
	
	public String verify_quan()
	{
		WebElement quan = dr.findElement(By.xpath("//button[normalize-space()='4']"));
		return quan.getText();
	}
	
	
	
	public void hoverOverFirstProduct() 
	{
        actions.moveToElement(firstProduct).perform();
    }
	
	
	
	public void clickAddToCart() {
		addToCartButton.click();
    }
	
	public void view_Product()
	{
		WebElement vp = dr.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]"));
		vp.click();
	}
	
	public void name(String n)
	{
		WebElement Name = dr.findElement(By.xpath("//input[@id='name']"));
		Name.sendKeys(n);
	}
	
	public void email(String e)
	{
		WebElement Email = dr.findElement(By.xpath("//input[@id='email']"));
		Email.sendKeys(e);
	}
	
	public void review(String r)
	{
		WebElement Review = dr.findElement(By.xpath("//textarea[@id='review']"));
		Review.sendKeys(r);
	}
	
	 public void scrollToFooter() {
	        JavascriptExecutor js = (JavascriptExecutor) dr;
	        js.executeScript("arguments[0].scrollIntoView(true);", footer);
	 }
	
	 public void addtocart()
	 {
		 WebElement cart = dr.findElement(By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]"));
		 cart.click();
	 }
	 
	 public void viewcart()
	 {
		 WebElement view = dr.findElement(By.xpath("//u[normalize-space()='View Cart']"));
		 view.click();
	 }
	
		
	

}
