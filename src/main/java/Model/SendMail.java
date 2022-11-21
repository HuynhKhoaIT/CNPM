package Model;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SendMail {
    public boolean sendMail(String email, int veri, String name) {
        boolean test = false;


        final String fromEmail = "nhomcongnghephanmem1@gmail.com";
        final String passEmail = "gkzeixfkhdwtqdvl";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, passEmail);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nhomcongnghephanmem1@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Account Verification");
            message.setText("Dear " + name + ","
                    + "\n\n Your code to verify your account is: " + veri);

            Transport.send(message);

            //System.out.println("Done");

            test = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return test;
    }
}