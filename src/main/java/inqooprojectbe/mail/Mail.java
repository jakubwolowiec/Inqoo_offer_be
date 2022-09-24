package inqooprojectbe.mail;

public class Mail {
    private String receiver;
    private String subject;
    private String mailText;

    public Mail(String receiver, String subject, String mailText) {
        this.receiver = receiver;
        this.subject = subject;
        this.mailText = mailText;
    }

    public Mail() {
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }
}