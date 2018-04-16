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

	public static void init(ArrayList<Cliente> clientes) {	
		Timer timer = new Timer();
		Fetcher emailFetcher = new Fetcher(POP,STORETYPE,USERNAME,PASSWORD);
		Sender emailSender = new Sender(SMTP,USERNAME,PASSWORD);	
		timer.scheduleAtFixedRate(new TimerTask() { 
			public void run() {
				ArrayList<String> recipients = emailFetcher.fetchEmail();
				for( int i = 0; i < recipients.size(); i++ ) {
	            	String[]parts = recipients.get(i).split(";");
	            	String nombre = parts[0];
	            	String address = parts[1];
	            	String content;
	            	String subject;   		
            		if(VerificarCorreo(clientes,address)) {
            			Cliente clienteNuevo = new Cliente(nombre,address);
            			String contraseña = clienteNuevo.generarContraseña();
            			clientes.add(clienteNuevo);	
            			content = "Your id is : " + nombre +"\n"
 		  					+ " Your password is: " + contraseña;
            			subject = "Bienvenido a Package Notifier!!!";
            			emailSender.sendEmail(address,subject,content);
            		}else {
            			System.out.println("Correo esta repetido");
            			content = "Error al crear la cuenta, la cuenta de correo " + address +
            					"ya esta asociada a una cuenta ya creada" + "\n" + 
            					"Por favor verifique si ud ya tiene una cuenta creada a su nombre";
            			subject = "Hubo un error en la creación de su Cuenta";
            			emailSender.sendEmail(address,subject,content);
            		}
	            		
				}
	            //timer.cancel();
	          }
		},0,60000);
	}		
	
	private static boolean VerificarCorreo(ArrayList<Cliente> clientes, String address) {
		for(Cliente cliente:clientes) {
			if(address.equals(cliente.getEmail())) {
				return false;
			}
		}
		return true;
	}
}
