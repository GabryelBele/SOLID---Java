package SRP.solucao.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public String enviarEmail(String destinatario, String assunto, String corpo) {
        String from = "seu_email@gmail.com";
        String senha = "sua_senha";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, senha);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(corpo);

            Transport.send(message);

            return "E-mail enviado com sucesso!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
    }

    public static void main(String[] args) {
    	
        EmailService emailService = new EmailService();
        String destinatario = "destinatario@gmail.com";
        String assunto = "Teste";
        String corpo = "Este é um e-mail de teste.";

        String resultado = emailService.enviarEmail(destinatario, assunto, corpo);
        System.out.println(resultado);
    }
}
