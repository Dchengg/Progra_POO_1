package email;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.InternetAddress;

import aplicacion.Cliente;
import email.Fetcher;
import email.Sender;

public class AplEmail {
	
	private static final String POP = "pop.gmail.com";
	private static final String SMTP = "smtp.gmail.com";
	private static final String STORETYPE = "pop3";
	private static final String USERNAME = "PackageNotifier";
	private static final String PASSWORD = "Package123";
	private static int numero = 0;

	public static void init(ArrayList<Cliente> clientes) {
		
		Timer timer = new Timer();
		Fetcher emailFetcher = new Fetcher(POP,STORETYPE,USERNAME,PASSWORD);
		Sender emailSender = new Sender(SMTP,USERNAME,PASSWORD);	
		timer.scheduleAtFixedRate(new TimerTask() { 
			public void run() {
				System.out.println("it ran "+ ++numero + " times");
				ArrayList<String> recipients = emailFetcher.fetchEmail();
				for( int i = 0; i < recipients.size(); i++ ) {
	            	String[]parts = recipients.get(i).split(";");
	            	String nombre = parts[0];
	            	String address = parts[1];
	                Cliente cliente = new Cliente(nombre,address);
	                String contraseña = cliente.generarContraseña();
	                clientes.add(cliente);	
	                emailSender.sendEmail(address,nombre,contraseña);
	                timer.cancel();
	            }
				
			}
		},0,30*1000);
	}		
}
