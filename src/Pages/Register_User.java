package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register_User {
WebDriver dr;
	
	public Register_User(WebDriver dr) 
	{
		this.dr = dr;
	}
	//Register user
			public void goTosignup() 
			{
				WebElement Signup = dr.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
				Signup.click();
				
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
			public String Verify_newsignup()
			{
				WebElement text = dr.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
				String aTxt =  text.getText();
				return aTxt;
			}
			
			public void enter_name(String Name)
			{
				WebElement name = dr.findElement(By.xpath("//input[@placeholder='Name']"));
				name.sendKeys(Name);
			}
			
			public void enter_email(String Email)
			{
				WebElement email = dr.findElement(By.xpath("//input[@data-qa='signup-email']"));
				email.sendKeys(Email);
			}
			
			public void click_signup()
			{
				WebElement signup_button = dr.findElement(By.xpath("//button[normalize-space()='Signup']"));
				signup_button.click();
			}
			
			public String Verify_actinfo()
			{
				WebElement text = dr.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
				String aTxt = text.getText();
				return aTxt;
			}
			
			public void select_title()
			{
				WebElement title = dr.findElement(By.xpath("//input[@value = 'Mrs']"));
				title.click();
			}
			
			public void enter_pwd(String Pass)
			{
				WebElement pwd = dr.findElement(By.xpath("//input[@id='password']"));
				pwd.sendKeys(Pass);
			}
			
			public void select_day()
			{
				WebElement day = dr.findElement(By.xpath("//select[@id='days']"));
				Select sel2 = new Select(day);
				sel2.selectByVisibleText("2");
			}
			
			public void select_month()
			{
				WebElement month = dr.findElement(By.xpath("//select[@id='months']"));
				Select sel2 = new Select(month);
				sel2.selectByVisibleText("February");
			}
			
			public void select_year()
			{
				WebElement year = dr.findElement(By.xpath("//select[@id='years']"));
				Select sel2 = new Select(year);
				sel2.selectByVisibleText("1998");
			}
			
			
			  public void checkbox() {
			  
			  WebElement button = dr.findElement(By.xpath("//input[@id='newsletter']"));
			  button.click(); }
			 
			
			public void offers()
			{
				WebElement Button = dr.findElement(By.xpath("//input[@id='optin']"));
				Button.click();
			}
			
			public void enter_fname(String fname)
			{
				WebElement firstname = dr.findElement(By.xpath("//input[@id='first_name']"));
				firstname.sendKeys(fname);
			}
			
			public void enter_lname(String lname)
			{
				WebElement lastname = dr.findElement(By.xpath("//input[@id='last_name']"));
				lastname.sendKeys(lname);
			}
			
			public void enter_com(String company)
			{
				WebElement Company = dr.findElement(By.xpath("//input[@id='company']"));
				Company.sendKeys(company);
			}
			
			public void enter_Address(String add1)
			{
				WebElement Address1 = dr.findElement(By.xpath("//input[@name='address1']"));
				Address1.sendKeys(add1);
			}
			
			public void enter_Address2(String add2)
			{
				WebElement Address2 = dr.findElement(By.xpath("//input[@name='address2']"));
				Address2.sendKeys(add2);
			}
			public void Country()
			{
			WebElement country = dr.findElement(By.xpath("//select[@name='country']"));
			Select sel2 = new Select(country);
			
			
			sel2.selectByVisibleText("India"); 
			}
			
			public void enter_Street(String str)
			{
				WebElement street = dr.findElement(By.xpath("//input[@id='state']"));
				street.sendKeys(str);
			}
			
			public void enter_city(String cit)
			{
				WebElement city = dr.findElement(By.xpath("//input[@id='city']"));
				city.sendKeys(cit);
			}
			
			public void enter_zip(int i)
			{
				WebElement ZipCode = dr.findElement(By.xpath("//input[@id='zipcode']"));
				ZipCode.sendKeys(Integer.toString(i));
			}

			public void enter_mobile(int Mobile)
			{
				WebElement MobileNumber = dr.findElement(By.xpath("//input[@id='mobile_number']"));
				MobileNumber.sendKeys(Integer.toString(Mobile));
			}
			
			public void click_ca()
			{
				WebElement createAccount = dr.findElement(By.xpath("//button[normalize-space()='Create Account']"));
				createAccount.click();
			}
			
			public String Verify_actcreated()
			{
				WebElement text = dr.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
				String aTxt = text.getText();
				return aTxt;
			}
			
			public void click_co() 
			{
				WebElement con = dr.findElement(By.xpath("//a[normalize-space()='Continue']"));
				con.click();
			}
			
			public String Verify_logged()
			{
				WebElement text = dr.findElement(By.xpath("//a[i[@class='fa fa-user'] and text()[contains(., 'Logged in as ')] and b[text()='Pavani']]"));
				String aTxt = text.getText();
				return aTxt;
			}
			
			public void click_da()
			{
				WebElement DeleteAccount = dr.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
				DeleteAccount.click();
			}
			
			public String Verify_delete()
			{
				WebElement text = dr.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
				String aTxt= text.getText();
				return aTxt;
			}
			
			public void con()
			{
				WebElement Continue = dr.findElement(By.xpath("//a[normalize-space()='Continue']"));
				Continue.click();
			}
			
			public String aRegisterFailText() //Email Address already exist!
			{
				WebElement Text= dr.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));
				return Text.getText();
			}
}
