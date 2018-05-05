package ge.mziuri.util.emailsender;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    private static final String SMTP_AUTH = "true";

    private static final String STARTLES_ENABLE = " true";

    private static final String SMTP_HOST = "smtp.gmail.com";

    private static final String SMTP_PORT = "587";

    public static void sendEmail(String senderEmail, String senderPassword, String receiverEmail,String mailText ,String subject) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", SMTP_AUTH);
        properties.put("mail.smtp.starttls.enable", STARTLES_ENABLE);
        properties.put("mail.smtp.host",SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            message.setSubject(subject);
            message.setText(mailText);
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
