package at.edersteiner.backend.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final AppMailProperties props;

    public EmailService(JavaMailSender mailSender, AppMailProperties props) {
        this.mailSender = mailSender;
        this.props = props;
    }

    public void sendContactMail(String subject, String body, String replyTo) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(props.to());
        msg.setFrom(props.from());
        msg.setSubject(subject);
        msg.setText(body);

        if (replyTo != null && !replyTo.isBlank()) {
            msg.setReplyTo(replyTo);
        }

        mailSender.send(msg);
    }
}