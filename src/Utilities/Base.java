package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base extends ExcelUtilities{
	public static WebDriver dr;
	
	 
	public static void launch_browser() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver_v123.exe");
		dr = new ChromeDriver();
		dr.get("https://automationexercise.com/");
		dr.manage().window().maximize();
		Thread.sleep(4000);
	}
	
	//Common Methods
	
	public static void get_screenshot(String filename) throws IOException
	{
		String path = "C:\\Users\\DELL\\OneDrive\\Desktop\\Testing\\Screenshots", fullpath;
		fullpath = path + filename;
		TakesScreenshot scr = ((TakesScreenshot)dr);
		File scrf = scr.getScreenshotAs(OutputType.FILE);
		File dest = new File(fullpath);
		FileUtils.copyFile(scrf, dest);
	}
	
	protected static void close_browser() 
	{
		dr.close();
	}
	
	public void scrollDown() 
	{
        JavascriptExecutor js = (JavascriptExecutor) dr;
        // Scroll down by 1000 pixels vertically
        js.executeScript("window.scrollBy(0,1000)");
    }
	
	public void scrollDown200() 
	{
        JavascriptExecutor js = (JavascriptExecutor) dr;
        // Scroll down by 1000 pixels vertically
        js.executeScript("window.scrollBy(0,200)");
    }
	
	public void windowHandles() 
	{
		
		String mainWindowHandle = dr.getWindowHandle();
	
		for(String windowHandle : dr.getWindowHandles()) 
		{
			if (!windowHandle.equals(mainWindowHandle)) 
			{
	            dr.switchTo().window(windowHandle);
	            break;
	        }
		
		}
		
	}
	
	
	public void scrollDownC(int pixelsToScroll) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) dr;
	    // Scroll down by specified pixels vertically
	    js.executeScript("window.scrollBy(0," + pixelsToScroll + ")");
	}
	
	
	public void StopAds()
	{
		ChromeOptions co = new ChromeOptions();
		co.addExtensions(new File("./Extensions/Adblock.crx"));
		WebDriver dr = new ChromeDriver(co);
		dr.get("https://automationexercise.com/");
		
	}
	
	
}


