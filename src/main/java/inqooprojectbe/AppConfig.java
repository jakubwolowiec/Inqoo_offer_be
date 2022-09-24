package inqooprojectbe;

import inqooprojectbe.services.DummyMailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration

public class AppConfig {

    @Bean
    @Profile("prod")
    public MailSender realMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("kremufka2005@gmail.com");
        mailSender.setPassword("faovcjyqnptlosxz");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    @Profile("!prod")
    public MailSender testMailSender() {
        DummyMailService dummyMailService = new DummyMailService();

        return dummyMailService;
    }
}