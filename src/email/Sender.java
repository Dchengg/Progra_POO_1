package email;


import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Sender {

	private String host;
    private String username;  
    private String password;
    
    private String subject = "Welcome to PackageNotifier!!!";

    

    public Sender(String pHost, String pUsername, String pPassword) {
    	setHost(pHost);
    	setUsername(pUsername);
    	setPassword(pPassword);
    }

    public void sendEmail(String pAddress, String pNombre, String pContraseña) {
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", getHost());
	    props.put("mail.smtp.user", getUsername());
	    props.put("mail.smtp.password", getPassword());
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	
	    try {
	        message.setFrom(new InternetAddress(getHost()));
	        InternetAddress toAddress = new InternetAddress(pAddress);
	        message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            String content = "Your id is : " + pNombre +"\n"
					+ " Your password is: " + pContraseña;
            message.setText(content);
	        Transport transport = session.getTransport("smtps");
	        transport.connect(getHost(), getUsername(), getPassword());
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (AddressException ae) {
	        ae.printStackTrace();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();
	    }
    }
    
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
