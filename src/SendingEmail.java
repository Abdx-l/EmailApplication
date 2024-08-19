import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendingEmail {

    public static void sendEmail(String recipient, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "emailtestprojectlongerdomainforcheaper.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(/*email*/, /*password*/);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(/*email*/));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Subject Here");
            message.setText(content);

            Transport.send(message);
            System.out.println("Email Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
