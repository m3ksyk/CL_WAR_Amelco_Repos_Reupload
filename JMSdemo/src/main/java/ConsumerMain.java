import org.apache.activemq.ActiveMQConnectionFactory;
import pl.coderslab.Book;

import javax.jms.*;
import java.io.Serializable;
import java.util.Arrays;

public class ConsumerMain {

    public static void main(String[] args) {
        final ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://10.20.241.99:61616");
        ((ActiveMQConnectionFactory) connectionFactory).setTrustedPackages(Arrays.asList("pl.coderslab"));

        Connection connection = null;

        try{

            connection = connectionFactory.createConnection();
            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            final Queue queue = session.createQueue("events");

            final MessageConsumer consumer = session.createConsumer(queue);

            connection.start();


            while(true) {

                final Message message = consumer.receive();

                if (message instanceof ObjectMessage) {

                    final Serializable rawMessage = ((ObjectMessage) message).getObject();

                    if (rawMessage instanceof Book) {

                        final Book readMessage = (Book) rawMessage;

                        System.out.println(
                                String.format("Thread %s received message %s", Thread.currentThread().getName(), readMessage));
                    }
                }

//                if (message instanceof TextMessage) {
//                    final String messageStr = ((TextMessage) message).getText();
//                    System.out.println("Thread : " + Thread.currentThread().getName() + " | message : " + messageStr);
//
//                }
            }
        }catch (JMSException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
