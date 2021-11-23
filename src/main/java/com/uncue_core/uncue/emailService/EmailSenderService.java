package com.uncue_core.uncue.emailService;


import com.uncue_core.uncue.Security.service.UserInfo;
import com.uncue_core.uncue.constants.DisplayMessage;
import com.uncue_core.uncue.dto.IUDReturningMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@Service
public class EmailSenderService {
    @Autowired
    UserInfo employee;

	/*@Autowired
	OrderNOrderDetailsDataRepository orderRepository;*/

    @Value("${passwordSenderEmailId}")
    private String senderEmailId;

    @Value("${passwordSenderUsername}")
    private String senderUsername;

    @Value("${passwordSenderPassword}")
    private String senderPassword;

    public IUDReturningMessage sendEmail(Map hm)
            throws AddressException, MessagingException, IOException {
        System.out.println("Inside send email");

        IUDReturningMessage iUDReturningMessage = new IUDReturningMessage();
        try {
            String from = senderEmailId;// change accordingly
            final String username = senderUsername;// change accordingly
            final String password = senderPassword;// change accordingly

		/*List<OrderNOrderDetailsData> orderDetailsList = orderRepository
				.getOrderByOrderIdUserId(userInfo.getLoggedInUser().getuserId(), orderId);*/
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });



            Message message = new MimeMessage(session);

            // Set From: header field of the header.

            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse((String) hm.get("To")));



            // Set Subject: header field

            message.setSubject((String) hm.get("Subject"));

            // Now set the actual message
            // message.setText(msg);
            message.setContent(hm.get("Content"), "text/html");

            // Send message
            Transport.send(message);
            iUDReturningMessage.setError(false);
            iUDReturningMessage.setDetails("");
            iUDReturningMessage.setMessage(DisplayMessage.EmailIdTrue);
            return iUDReturningMessage;
        }catch(Exception e) {
            iUDReturningMessage.setError(true);
            iUDReturningMessage.setDetails("");
            iUDReturningMessage.setMessage("Email service not available");
            e.printStackTrace();
            System.out.println("mail sent");
            return iUDReturningMessage;
        }
    }
}
