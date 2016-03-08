package UF3PSP.JavaMail;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;
/**
 * Created by 48089748z on 24/02/16.
 */
public class MailReader
{
    private static Message[] messages;

    private static Properties properties;
    private static String username = "urijavamail@gmail.com";
    private static String password = "ecaibpoblenou";

    public static void main(String[] args)
    {
        configureProperties();
        getMessages();

    }
    public static void configureProperties()
    {
        properties = System.getProperties();
        properties.put("mail.pop.host", "pop.gmail.com");
        properties.put("mail.pop.port", "995");
        properties.put("mail.pop.starttls.enable", "true");
    }

    public static void getMessages()
    {
            try
            {
                Session emailSession = Session.getDefaultInstance(properties);
                Store store = emailSession.getStore("pop3s");
                store.connect("pop.gmail.com", username, password);
                Folder emailFolder = store.getFolder("INBOX");
                emailFolder.open(Folder.READ_ONLY);
                messages = emailFolder.getMessages();
                System.out.println("\nYOU HAVE " + messages.length+" MESSAGES ON "+username);
                printMessages();
                emailFolder.close(false);
                store.close();
            }
            catch (MessagingException one) {}
            catch (IOException two) {}
    }

    public static void printMessages() throws MessagingException, IOException
    {
        for (int i = 0, n = messages.length; i < n; i++)
        {
            System.out.println();
            Message message = messages[i];
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Email Number:       " + (i + 1));
            System.out.println("Subject:            " + message.getSubject());
            System.out.println("From:               " + message.getFrom()[0]);
            System.out.println("Text:               " + message.getContent().toString());
            System.out.println("-------------------------------------------------------------------");
        }
    }
}
