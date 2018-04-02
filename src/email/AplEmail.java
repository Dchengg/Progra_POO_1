package email;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import email.Fetcher;
import email.Sender;

public class AplEmail {
	
	private static final String POP = "pop.gmail.com";
	private static final String SMTP = "smtp.gmail.com";
	private static final String STORETYPE = "pop3";
	private static final String USERNAME = "PackageNotifier";
	private static final String PASSWORD = "Package123";

	public AplEmail() {
		
		Timer timer = new Timer();
		Fetcher emailFetcher = new Fetcher(POP,STORETYPE,USERNAME,PASSWORD);
		Sender emailSender = new Sender(SMTP,USERNAME,PASSWORD);	
		timer.scheduleAtFixedRate(new TimerTask() { 
			public void run() {
				System.out.println("It RAN");
				ArrayList<String> recipients = emailFetcher.fetchEmail();
				emailSender.sendEmail(recipients);
			}
		},0,30*1000);
	}
}
