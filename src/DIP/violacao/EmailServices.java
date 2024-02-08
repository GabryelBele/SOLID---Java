package DIP.violacao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServices {

	public static boolean isValid(String email) {
		return email.contains("@");
	}

	public static void enviar(String de, String para, String assunto, String mensagem) {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.google.com");

		Session session = Session.getInstance(properties);

		try {
			Message mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress(de));
			mail.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
			mail.setSubject(assunto);
			mail.setText(mensagem);

			Transport.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
