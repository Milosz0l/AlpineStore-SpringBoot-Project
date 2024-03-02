package pl.coderslab.services;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private final String sendgridApiKey;


    public EmailService(@Value("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") String sendgridApiKey) {
        this.sendgridApiKey = sendgridApiKey;
    }

    public void sendWelcomeEmail(String userEmail) {
        sendEmail(userEmail, "Welcome to Alpine Store!!", "<html><body><h1>Welcome to Alpine Store!</h1><p>We're glad to have you on board.</p></body></html>");
    }

    //    public static void sendSetPassword(String userEmail){
//        sendEmail(userEmail,"Reset yor password","<html><body><h1>Welcome to Alpine Store!</h1><p>We're glad to have you on board.</p></body></html>");
//    }
    public void sendEmail(String userEmail, String subject, String htmlContent) {
        Email from = new Email("milosz.oles@onet.pl");
        Email to = new Email(userEmail);
        Content content = new Content("text/html", htmlContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendgridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {

            ex.printStackTrace();

        }
    }

}