package com.pushmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Class - 2.3: For yahoomail
public class SiteYahooMail 
{
private static String baseURL = "https://login.yahoo.com/";
	
	private static WebDriver driver;
	
	public static void run(String senderEmail, String senderPassword, String recieverEmail, String emailSubject, String emailContent) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","E:\\BEproject\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get(baseURL);
		
		driver.findElement(By.id("login-username")).sendKeys(senderEmail);
		
		driver.findElement(By.id("login-signin")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.id("login-passwd")).sendKeys(senderPassword);
		
		Thread.sleep(10000);
		
		driver.findElement(By.id("login-signin")).click();

		Thread.sleep(10000);
		
		driver.get("http://compose.mail.yahoo.com/");

		Thread.sleep(10000);
		
		driver.findElement(By.id("message-to-field")).sendKeys(recieverEmail);

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(emailSubject);

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys(emailContent);

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']")).click();

		Thread.sleep(10000);

		driver.get("https://login.yahoo.com/account/logout");

		Thread.sleep(10000);
		
		driver.close();
	}
}
