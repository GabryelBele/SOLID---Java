package DIP.solucao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DIP.solucao.interfaces.IEmailServices;

public class EmailServices implements IEmailServices {

	public boolean isValid(String email) {
		return email.contains("@");
	}

	public void enviar(String de, String para, String assunto, String mensagem) {
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
