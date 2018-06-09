package pl.coderslab.beans;

public class EmailService implements MessageService {
    MessageService messageService;
    String Message;

    public EmailService(MessageService messageService, String message) {
        this.messageService = messageService;
        Message = message;
    }

    public EmailService() {

    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending email");
    }

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
