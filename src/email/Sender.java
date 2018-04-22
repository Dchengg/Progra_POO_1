package email;


import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Sender {

    private static String host;
    private static String username;  
    private static String password;

    /**
 *Une las partes del corroe
 */
    
    public static void sendEmail(String pAddress, String pSubject, String pContent) {
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
            message.setSubject(pSubject);
            message.setText(pContent);
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
    
    public static String getHost() {
            return host;
    }

    public static void setHost(String pHost) {
            host = pHost;
    }

    public static String getUsername() {
            return username;
    }

    public static void setUsername(String pUsername) {
            username = pUsername;
    }

    public static String getPassword() {
            return password;
    }

    public static void setPassword(String pPassword) {
            password = pPassword;
    }

	
	

}
