package email;


import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Sender {

	private String host;
    private String username;  
    private String password;
    
    private String subject = "Welcome to PackageNotifier!!!";

    private ArrayList<String> recipients = new ArrayList<String>();

    public Sender(String pHost, String pUsername, String pPassword) {
    	setHost(pHost);
    	setUsername(pUsername);
    	setPassword(pPassword);
    }

    public void sendEmail(ArrayList<String> raw) {
    	setRecipients(raw);
    	if(recipients.isEmpty() == false) {
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
	            InternetAddress[] toAddress = new InternetAddress[recipients.size()];
	            String[] toWho = new String[recipients.size()];
	            for( int i = 0; i < recipients.size(); i++ ) {
	            	String[]parts = recipients.get(i).split(";");
	            	String name = parts[0];
	            	String address = parts[1];
	            	System.out.println("address = " + address);
	                toAddress[i] = new InternetAddress(address);
	                toWho[i] = name;
	            }
	
	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	                message.setSubject(subject);
		            String content = "Your id is : " + toWho[i] +"\n"
							+ " Your password is: " + "x123";
		            message.setText(content);
	            }
	            
	            
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
	        recipients.clear();
    	} else {
    		//System.out.println("No email to send");
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

	public ArrayList<String> getRecipients() {
		return recipients;
	}

	private void setRecipients(ArrayList<String> raw) {
		for(int i = 0; i<raw.size();i++) {
			String recipient = raw.get(i);
			//System.out.println(recipient);
			recipients.add(recipient);
		}
	}
	
	

}
