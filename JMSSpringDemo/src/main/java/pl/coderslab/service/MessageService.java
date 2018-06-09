package pl.coderslab.service;

import javax.jms.Queue;

public interface MessageService {
    void sendPointToPointMessage(String queueName, String msg);
    String receive(String queueName);

    void publishMessage(String topicName, String msg);
}
