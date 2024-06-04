package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasePage {
WebDriver dr;
	
	public TestCasePage(WebDriver dr) 
	{
		this.dr = dr;
	}
	//TestCase Page
	
	public void click_TestCases()
	{
		WebElement TestCase = dr.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
		TestCase.click();
	}
	
	public String Verify_TestCase() //TEST CASES
	{
		WebElement text = dr.findElement(By.xpath("//b[normalize-space()='Test Cases']"));
		String aTxt =  text.getText();
		return aTxt;
	}
	

}
