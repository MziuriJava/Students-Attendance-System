package ge.mziuri.util;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;


import javax.mail.PasswordAuthentication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {

    //genereting random string
    String genereteRandomString() {
        final String character = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        int length = 7;

        StringBuilder text = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            text.append(character.charAt(random.nextInt(character.length())));
        }
        return (text.toString());
    }

    //////file read
    String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    private final String senderEmail = PropertiesUtil.getProperty("Email");
    private final String senderPassword = PropertiesUtil.getProperty("Password");
    private String receverEmail="students.attendance.system@gmail.com";
    private String smsText=genereteRandomString();

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public void setReceverEmail(String receverEmail) {
        this.receverEmail = receverEmail;
    }

    public void sendEmail() throws MessagingException {



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

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receverEmail));
            message.setSubject("თქვენი პაროლი");
            message.setText(smsText);
            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
