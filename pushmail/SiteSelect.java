package com.pushmail;

// Class - 2: Selection of email account
public class SiteSelect 
{
	public void run(String senderEmail, String senderPassword, String recieverEmail, String emailSubject, String emailContent)
	{
		if(senderEmail.contains("@gmail.com"))
		{
			// Automate Google mail service.
			
			SiteGoogleMail gmailObject = new SiteGoogleMail();
			//gmailObject.run(senderEmail, senderPassword, recieverEmail, emailSubject, emailContent);
		}
		else if(senderEmail.contains("@yahoo.com") || senderEmail.contains("@yahoo.in"))
		{
			// Automate Yahoo! mail service.			
			try 
			{
				SiteYahooMail.run(senderEmail, senderPassword, recieverEmail, emailSubject, emailContent);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
		else if(senderEmail.contains("@aitpune.edu.in"))
		{
			// Automate Outlook
			
			
		}
	}
}
