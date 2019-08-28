package utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtility {

	
		public static void sendEmail() throws EmailException{
			
			System.out.println("============Email test report initiated============");
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("deep.tbsl@gmail.com", "Moodle@123"));
			email.setSSLOnConnect(true);
			email.setFrom("deep.tbsl@gmail.com");
			email.setSubject("Test Report");
			email.setMsg("This is a test mail from Selenium:-)");
			email.addTo("dshukla2005@gmail.com");
			email.send();
			System.out.println("============Email test report sent============");
		}
}
