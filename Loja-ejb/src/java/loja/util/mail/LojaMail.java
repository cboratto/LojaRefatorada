package loja.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author cbsantos
 */
public class LojaMail {

    public LojaMail() {
    }

    ;
    public void sendLojaMail(Integer idPedido, String nomeCliente, String desEmail, String descricao) throws UnsupportedEncodingException {

        final String username = "lojaapd3@gmail.com";
        final String password = "1234mudar_";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        String msgBody = "Prezado " + nomeCliente + "\n"
                + "Seu pedido de número " + idPedido + " foi efetivado com sucesso."
                + "\n"
                + descricao +"\n"
                + "Estamos aguardando efetivação do pagamento para encaminhar a mercadoria."
                + "\n"
                + "Obrigado."
                + "\n"
                + "Att.,\n"
                + "Loja";

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lojaapd3@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(desEmail));
            message.setSubject("Loja - Compra efetivada");
            message.setText(msgBody);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
