package com.atual.covid.web.util;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailService {
	public static final String EMAIL_REMETENTE = "informasenadourt@gmail.com";
    public static final String EMAIL_REMETENTE_SENHA = "InformaSenado123";

    public void sendEmail(String emailDestino, String assunto, String corpoDoEmail) {
        try {
            final Properties props = criarPropriedades();
            final Session session = criarSessao(props);
            final Message message = criarMensagem(session, assunto, emailDestino, corpoDoEmail);

            Transport.send(message);
        } catch (MessagingException e) {
            System.err.println(e);
        }
    }
    private Properties criarPropriedades() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.trust", "*");

        return props;
    }
    private Session criarSessao(Properties props) {
        return Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_REMETENTE, EMAIL_REMETENTE_SENHA);
            }
        });
    }
    
    private Message criarMensagem(Session session, String assunto, String emailDestino, String corpoDoEmail) {
        final MimeMessage message = new MimeMessage(session);

        try {
            final Address[] toUser = InternetAddress.parse(emailDestino);
            message.setFrom(new InternetAddress(EMAIL_REMETENTE));
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
            message.setText(corpoDoEmail);
        } catch (Exception e) {
            System.err.println(e);
        }

        return message;
}
}
