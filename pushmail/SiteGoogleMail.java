package com.pushmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Class - 2.1: For Gmail
public class SiteGoogleMail 
{
	private static String baseURL = "https://www.google.com/gmail/";
	
	private static WebDriver driver;
	

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","E:\\BEproject\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get(baseURL);
		
		driver.findElement(By.id("identifierId")).sendKeys("adityasinghwolvieait@gmail.com");
				
		driver.close();
	}
	
	/*
	public void run(String senderEmail, String senderPassword, String recieverEmail, String emailSubject, String emailContent)
	{
		System.setProperty("webdriver.gecko.driver","E:\\BEproject\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get(baseURL);
		
		
		
		driver.close();
	}
	*/
}
