package com.maveric.scuba.utils;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.maveric.scuba.pageobjects.demoqa.Demoqa_Objects;

public class Scubautils {
	
	public static WebDriver driver;
	public static WebElement loc;
	public static WebElement ele;
//	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	public static void driverinit(String browser)
	{
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			driver = new ChromeDriver();
//			WebDriverWait wait = new WebDriverWait(driver, 60);
			break;
		case "ff":
			System.setProperty("webdriver.firefox.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;	
		default:
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static void urllaunch(String url)
	{
		driver.get(url);
	}
	
	public static void send(By loc, String value )
	{
		try
		{
//			wait.until(ExpectedConditions.visibilityOf((WebElement) loc ));
			WebElement ele = driver.findElement(loc);
			ele.clear();
			ele.sendKeys(value);
		}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	
	public static void Btnclick(By loc)
	{
		try
		{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
			WebElement ele = driver.findElement(loc);
			ele.click();
		}
		catch (Exception e) {
	// TODO: handle exception
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("arguments[0].click();",ele );
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public static void linkclick(By loc)
	{
		try
		{
//			wait.until(ExpectedConditions.elementToBeSelected(loc));
			WebElement ele = driver.findElement(loc);
			if (!ele.isSelected()) {
				ele.click();
			}
		}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public static void dropdownselectval(By loc, String value)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByValue(value);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public static void dropdownselectind(By loc, int index)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByIndex(index);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public static void dropdownselecttxt(By loc, String value)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByVisibleText(value);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public static void datePicker(By objlocator, int Index, By Date, String Year )
	{
		driver.findElement(objlocator).click();
		Select Month_dropdown = new Select(driver.findElement(Demoqa_Objects.Month));
		Month_dropdown.selectByIndex(Index);
		Select Year_dropdown = new Select(driver.findElement(Demoqa_Objects.Year));
		Year_dropdown.selectByValue(Year);
		driver.findElement(Date).click();
	}
	
	public static void sendDate(By loc, String message)
	{
		Actions action = new Actions(driver);
		WebElement textbox = driver.findElement(loc);
		textbox.clear();
		action.moveToElement(textbox).click(textbox).sendKeys(message).build().perform();		
	}
	
	public static void autofill(By loc, String text)
	{
		WebElement autoOptions= driver.findElement(loc);
	    autoOptions.sendKeys("En");

	    List<WebElement> optionsToSelect = driver.findElements(By.tagName("li"));

	    for(WebElement option : optionsToSelect){
	        System.out.println(option);
	        if(option.getText().equals(text)) {
	            System.out.println("Trying to select: "+text);
	            option.click();
	            break;
	        }
	}
} 
	
	public static void UploadFile(By loc)
	{
		
		String path = System.getProperty("user.dir");
        System.out.println(path);
		driver.findElement(loc).sendKeys(path+"\\UploadaFile\\Thamarai.png");
		// click the "UploadFile" button
		//driver.findElement(By.name("send")).click();
	}
	
	public static void pgdwn()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
	}
	
	public static void tabkey()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
	}
	
	public static void alertok()
	{
		driver.switchTo().alert().accept();
	}
}
