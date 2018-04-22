package email;


import java.util.ArrayList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.search.FlagTerm;

public class Fetcher {
	
	private String host;
	private String storeType;
	private String username;
	private String password;
	private ArrayList<String> from = new ArrayList<String>();
	
	public Fetcher(String pHost, String pStoreType, String pUsername, String pPassword) {
		setHost(pHost);
		setStoreType(pStoreType);
		setUsername(pUsername);
		setPassword(pPassword);
	}
        
        /**
 * Forma el cuerpo del correo
 */
        
	public ArrayList<String> fetchEmail() {
		try {
			from.clear();
			Properties props = new Properties();
			props.put("mail.store.protocol",getStoreType());
			props.put("mail.pop3.host",getHost());
			props.put("mail.pop3.port","995");
			props.put("mail.pop3.starttls.enable","true");
			Session session = Session.getDefaultInstance(props);
			Store store = session.getStore("pop3s");
			store.connect(getHost(),getUsername(),getPassword());
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN),false)); 
		    for (int i = 0, n = messages.length; i < n; i++) {
		        Message indvidualmsg = messages[i];
		        System.out.println("Printing individual messages");
		        System.out.println("No# " + (i + 1));
		        String subject = indvidualmsg.getSubject();
		        subject = subject.toLowerCase();
		        System.out.println("Email Subject: " + subject);
		        String address = indvidualmsg.getFrom()[0].toString();
		        address = getAddress(address);
		        System.out.println("Sender: " + address);
		        String content = getContent(indvidualmsg);
		        if(subject.equals("solicitud de cuenta")) {
		        	String cleanContent = content.replaceAll("\r", "").replaceAll("\n", "");
		        	from.add(cleanContent + ";" + address);
			        System.out.println(content);
		        }
		     }
			emailFolder.close(false);
			store.close();
		} catch(NoSuchProviderException e) {
			e.printStackTrace();
		} catch(MessagingException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return from;
	}
        
      /**
 * Se define el contenido del correo
 */
	public static String getContent(Part p) throws Exception {
		String error = "Unknown content";
	    if (p.isMimeType("multipart/*")) {
	       Multipart mp = (Multipart) p.getContent();
	       int count = mp.getCount();
	       for (int i = 0; i < count;)
	          if(mp.getBodyPart(i).isMimeType("text/plain")) {
	        	  return (String) mp.getBodyPart(i).getContent();
	          } else {
	            return error;
	          }
	    }
	    return error;
	 }
	
	 private String getAddress(String recipient) {
    	String address = recipient.substring(recipient.indexOf("<")+1,recipient.indexOf(">"));
    	return address;
    }
	 
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	private String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<String> getFrom() {
		return from;
	}
	
}
