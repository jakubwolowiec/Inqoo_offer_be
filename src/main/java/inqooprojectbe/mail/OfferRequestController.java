package inqooprojectbe.mail;

import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OfferRequestController {

private final MailSender mailSender;

    OfferRequestController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/send")
   void sendMail(){

          MailService mailService = new MailService(mailSender);

        mailService.sendMail("kremufka2005@gmail.com","kubaq001@gmail.com","Test","Liżme jaja");
}

}
