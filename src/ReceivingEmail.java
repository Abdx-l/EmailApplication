import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;

public class ReceivingEmail {

    public static List<String> receiveEmails() {
        List<String> emails = new ArrayList<>();
        Properties props = new Properties();
        props.put("mail.pop3.host", /*domain*/);
        props.put("mail.pop3.port", "110"); 
        props.put("mail.pop3.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props);

        try {
            Store store = session.getStore("pop3");
            store.connect(/*domain*/, /*email*/, /*password*/);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            for (Message message : messages) {
                String emailDetails = "From: " + message.getFrom()[0] + "\n" +
                                      "Content: " + message.getContent().toString() + "\n";
                emails.add(emailDetails);
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emails;
    }
}
