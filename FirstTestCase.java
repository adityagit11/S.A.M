package automationFramework;

import java.io.*;
import java.nio.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		//Set the path to the geckodriver.exe file 
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium Webdriver\\geckodriver.exe");
		
		//take the input from the text file
		String DummyInstruction = null;
		char EmailSiteOption = '\0';
		String UserName = null;
		String Password = null;
		String REmail = null;
		String Subject = null;
		String EmailBody = null;
		try
		{
			File FileObject = new File("E:/FirstTestCase.txt");
			Scanner input = new Scanner(FileObject);
			DummyInstruction = input.nextLine();
			EmailSiteOption = input.nextLine().charAt(95);
			String[] StringArray = new String[2];
			StringArray = input.nextLine().split(":");
			UserName = StringArray[1];
			StringArray = input.nextLine().split(":");
			Password = StringArray[1];
			StringArray = input.nextLine().split(":");
			REmail = StringArray[1];
			StringArray = input.nextLine().split(":");
			Subject = StringArray[1];
			StringArray = input.nextLine().split(":");
			EmailBody = StringArray[1];
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//Let the Magic begin
		if(EmailSiteOption=='G')
		{
			WebDriver driver = new FirefoxDriver();
			String URLToOpen = "https://www.google.com/gmail/";
			driver.get(URLToOpen);
			
			By UserNameTextInputLocator = By.id("Email");
			WebElement UserNameElement = driver.findElement(UserNameTextInputLocator);
			UserNameElement.sendKeys(UserName);
			
			By NextButtonLocator = By.id("next");
			WebElement NextButtonElement = driver.findElement(NextButtonLocator);
			NextButtonElement.click();
			
			Thread.sleep(2000);
			
			By PasswordTextInputLocator = By.id("Passwd");
			WebElement PasswordElement = driver.findElement(PasswordTextInputLocator);
			PasswordElement.sendKeys(Password);
			
			By SignInButtonLocator = By.id("signIn");
			WebElement SignInButtonElement = driver.findElement(SignInButtonLocator);
			SignInButtonElement.click();
			
			//Wait for 10 seconds for the  UI to load, this is important 
			Thread.sleep(10000);
			
			WebElement ComposeButtonElement = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
			ComposeButtonElement.click();
			
			Thread.sleep(5000);
			
			By ToTextAreaInputLocator = By.name("to");
			WebElement ToTextAreaElement = driver.findElement(ToTextAreaInputLocator);
			ToTextAreaElement.sendKeys(REmail);
			
			By SubjectLocator = By.name("subjectbox");
			WebElement SubjectElement = driver.findElement(SubjectLocator);
			SubjectElement.sendKeys(Subject);
			
			//Yet To locate the element for the body of the email 
			
			WebElement SendButtonElement = driver.findElement(By.xpath("//div[text()='Send']"));
			SendButtonElement.click();
			
			System.out.println("Done Boss!");
		}
		else if(EmailSiteOption=='Y')
		{
			WebDriver driver = new FirefoxDriver();
			String URLToOpen = "https://mail.yahoo.com/";
			driver.get(URLToOpen);
			
			WebElement UserNameElement = driver.findElement(By.xpath("//input[@id='login-username']"));
			UserNameElement.sendKeys(UserName);
			WebElement SubmitButtonElement = driver.findElement(By.xpath("//button[@id='login-signin']"));
			SubmitButtonElement.click();
			
			//2 seconds delay for the password UI TEXTAREA to show up
			//otherwise ElementNotVisible Error will be thrown
			
			Thread.sleep(2000);
			
			WebElement PasswordElement = driver.findElement(By.xpath("//input[@id='login-passwd']"));
			PasswordElement.sendKeys(Password);
			SubmitButtonElement = driver.findElement(By.xpath("//button[@id='login-signin']"));
			SubmitButtonElement.click();
			
			//10 seconds delay for the site to properly load even in the remote connections
			
			Thread.sleep(10000); 
			
			//Now We Are In!
			WebElement ComposeElement = driver.findElement(By.xpath("//button[@title='Compose']"));
			ComposeElement.click();
			
			Thread.sleep(5000);
			
			WebElement ToFieldElement = driver.findElement(By.xpath("//input[@id='to-field']"));
			ToFieldElement.sendKeys(REmail);
			Thread.sleep(2000);
			ToFieldElement.sendKeys(Keys.ENTER);
			WebElement SubjectElement = driver.findElement(By.xpath("//input[@id='subject-field']"));
			SubjectElement.sendKeys(Subject);
			
			//Yet To locate the element for the body of the email 
			
			WebElement SendButtonElement = driver.findElement(By.xpath("//a[@title='Send this email [Ctrl+Enter]']"));
			SendButtonElement.click();
			
			System.out.println("Done Boss!");
		}
		else if(EmailSiteOption=='R')
		{
			WebDriver driver = new FirefoxDriver();
			String URLToOpen = "http://www.rediff.com/";
			driver.get(URLToOpen);
			
			
			WebElement SignInElement = driver.findElement(By.xpath("//a[@title='Already a user? Sign in']"));
			SignInElement.click();
			
			Thread.sleep(5000);
			
			WebElement UserNameInputElement = driver.findElement(By.xpath("//input[@id='login1']"));
			UserNameInputElement.sendKeys(UserName);
			
			WebElement PasswordInputElement = driver.findElement(By.xpath("//input[@id='password']"));
			PasswordInputElement.sendKeys(Password);
			
			Thread.sleep(5000);
			
			WebElement GoButtonElement = driver.findElement(By.xpath("//input[@title='Sign in']"));
			GoButtonElement.click();
			
			Thread.sleep(10000);
			
			//Crash Report Here!
			//now we have entered it's realm
			
			/*WebElement WriteMailElement = driver.findElement(By.xpath("//b[contains(.,'Write mail')]"));
			WriteMailElement.click();*/
		}
	}

}
