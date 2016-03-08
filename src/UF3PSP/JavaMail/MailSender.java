package UF3PSP.JavaMail;

/**
 * Created by 48089748z on 24/02/16.
 */
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender
{
    private static MimeMessage mimeMessage;
    private static Session session;
    private static Transport transport;
    private static Properties properties;

    private static String reciever = "dremon.iespoblenou@gmail.com";
    private static String senderUsername = "urijavamail@gmail.com";
    private static String senderPassword = "ecaibpoblenou";

    public static void main(String[] args)
    {
        configureProperties();
        configureSession();
        try
        {
            configureMessage();
            sendMessage();
            System.out.println("\nSUCCESFULLY SENT MESSAGE");
        }
        catch (MessagingException e) {System.out.println("\nFAILED TO SEND MESSAGE");}
    }
    public static void configureProperties()
    {
        properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }
    public static void configureSession()
    {
        session = Session.getDefaultInstance(properties, null);
    }
    public static void configureMessage() throws MessagingException
    {
        mimeMessage = new MimeMessage(session);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
        mimeMessage.setSubject("TITLE OF THE MESSAGE ");
        mimeMessage.setContent("Content of the message", "text/html");
    }
    public static void sendMessage() throws MessagingException
    {
        transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", senderUsername, senderPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }
}
