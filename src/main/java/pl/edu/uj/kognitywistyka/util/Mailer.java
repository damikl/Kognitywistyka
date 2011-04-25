package pl.edu.uj.kognitywistyka.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	//TODO: Przenieść do config.properties projektu
	private static final String SMTP_HOST_NAME = "sv12.vipserv.org";
	private static final String SMTP_AUTH_USER = "test@mstanek.vipserv.org";
	private static final String SMTP_AUTH_PASS = "Warsztaty!@";

	private static class SMTPAuthenticator extends Authenticator {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			String user = SMTP_AUTH_USER;
			String pass = SMTP_AUTH_PASS;
			return new PasswordAuthentication(user, pass);
		}
	}

	private String subject;
	private String content;
	private String sentFrom;
	private List<String> recipients;

	private Message message;

	public Mailer(String subject, String content, String sentFrom,
			String... recipients) {
		this.subject = subject;
		this.content = content;
		this.sentFrom = sentFrom;
		this.recipients = Arrays.asList(recipients);

		init();
	}

	public static void sendTestMail(String testRecipient, boolean showDebugInfos) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		
		Authenticator authenticator = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, authenticator);
		session.setDebug(showDebugInfos);
		
		Message message = new MimeMessage(session);
		
		InternetAddress addressFrom = new InternetAddress("Mailer Test <mailer@kognitywistyka.uj.pl>");
		InternetAddress addressTo = new InternetAddress(testRecipient);

		message.setFrom(addressFrom);
		message.setRecipient(Message.RecipientType.BCC, addressTo);

		message.setSubject("Test message");
		message.setContent("This is test message, sent from Mailer class", "text/plain");

		Transport.send(message);
	}
	
	private void init() {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");

		Authenticator authenticator = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, authenticator);

		message = new MimeMessage(session);
	}

	public void sendWithAdditionalInfos(String addSubject, String beforeContent, String afterContent)
			throws MessagingException {
		subject = addSubject + " " + subject;
		content = beforeContent + " " + content + " " + afterContent;

		send();
	}

	public void send() throws MessagingException {
		InternetAddress addressFrom = new InternetAddress(sentFrom);
		InternetAddress[] addressesTo = getAddresses();

		message.setFrom(addressFrom);
		message.setRecipients(Message.RecipientType.BCC, addressesTo);

		message.setSubject(subject);
		message.setContent(content, "text/html; charset=UTF-8");

		Transport.send(message);
	}

	private InternetAddress[] getAddresses() throws AddressException {
		List<InternetAddress> addresses = new ArrayList<InternetAddress>();
		for (String recipient : recipients) {
			addresses.add(new InternetAddress(recipient));
		}
		
		return addresses.toArray(new InternetAddress[addresses.size()]);
	}
}
