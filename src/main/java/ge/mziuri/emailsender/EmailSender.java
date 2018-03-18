package ge.mziuri.emailsender;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import ge.mziuri.util.PropertiesUtil;
import ge.mziuri.util.random.RandomTextGenerator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import javax.mail.*;
import javax.mail.internet.*;


public class EmailSender {

    public static void sendEmail(String senderEmail, String senderPassword, String receiverEmail,String mailText ,String subject) throws MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

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
