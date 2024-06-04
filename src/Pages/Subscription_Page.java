package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Subscription_Page {
WebDriver dr;
WebDriverWait wait;

@FindBy(id = "header")
WebElement header;
	public Subscription_Page(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Subscription Page
	
	public void scrollToFooter() {
		By footer = By.xpath("//footer");
		this.wait = new WebDriverWait(dr, Duration.ofSeconds(10),Duration.ofMillis(500));
        WebElement footerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(footer));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", footerElement);
    }
	
	public boolean isFooterDisplayed() {
		By footer = By.xpath("//footer");
        WebElement footerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(footer));
        return footerElement.isDisplayed();
    }
	
	public String Verify_text() //SUBSCRIPTION
	{
		WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	
	public void Enter_email(String e)
	{
		WebElement Email = dr.findElement(By.xpath("//input[@id='susbscribe_email']"));
		Email.sendKeys(e);
	}
	
	public void click_arrow()
	{
		WebElement button = dr.findElement(By.xpath("//button[@id='subscribe']"));
		button.click();
	}
	
	public boolean isSuccessMessageDisplayed() 
	{
		By successMessage = By.xpath("//div[@class='alert-success' and contains(text(), 'You have been successfully subscribed!')]");
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successMsg.isDisplayed();
	}
	
	public void takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void click_cart()
	{
		WebElement cart = dr.findElement(By.xpath("//a[normalize-space()='Cart']"));
		cart.click();
	}
	
	public void click_uparrow()
	{
		WebElement arrow = dr.findElement(By.xpath("//*[@id=\"scrollUp\"]/i"));
		arrow.click();
	}
	
	public String msg()
	{
		WebElement Txt = dr.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]"));
		return Txt.getText();
	}
	
	public void scrollToHeader() {
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("arguments[0].scrollIntoView(true);", header);
    }
}

