package inqooprojectbe.mail;

import inqooprojectbe.model.SubcategoryDTO;
import inqooprojectbe.model.SubcategoryMapper;
import inqooprojectbe.model.Workshop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OfferRequestController {

    private final MailSender mailSender;
    private final SubcategoryMapper subcategoryMapper;

    @Autowired
    public OfferRequestController(MailSender mailSender, SubcategoryMapper subcategoryMapper) {
        this.mailSender = mailSender;
        this.subcategoryMapper = subcategoryMapper;
    }

    @GetMapping("/send")
    public void sendMail(@RequestBody Request request) {
        MailService mailService = new MailService(mailSender);
        for (SubcategoryDTO sub : request.getSubcategoryDTOList()) {
            for (Workshop workshop : sub.getWorkshops()) {
                Message messageToSend = new Message(workshop, workshop.getTrainer(), subcategoryMapper.fromDTO(sub), workshop.getTrainer().getSchedule());
                mailService.sendMail("kremufka2005@gmail.com", request.getReceiver(), "Oferta szkolenia", messageToSend.setMessage());
            }
        }


    }

}
