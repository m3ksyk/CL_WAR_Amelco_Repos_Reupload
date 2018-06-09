package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendPointToPointMessage(String queueName, String msg) {
        jmsTemplate.convertAndSend(queueName, msg);
    }

    @Override
    public String receive(String queueName) {
        return String.valueOf(jmsTemplate.receiveAndConvert(queueName));
    }

    @Override
    public void publishMessage(String topicName, String msg) {
        final boolean pubSubDomain = jmsTemplate.isPubSubDomain();
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(topicName, msg);
        jmsTemplate.setPubSubDomain(pubSubDomain);
    }
}
