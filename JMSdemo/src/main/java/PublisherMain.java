import org.apache.activemq.ActiveMQConnectionFactory;
import pl.coderslab.Book;

import javax.jms.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PublisherMain {

    public static void main(String[] args) {

        final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://10.20.241.99:61616");


        Connection connection = null;

        try {

            connection = connectionFactory.createConnection();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            final Topic topic = session.createTopic("events");

            final MessageProducer producer = session.createProducer(topic);

            final ObjectMessage message = session.createObjectMessage(new Book("KUP PAN ", "OPLA"));

            connection.start();

            final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

            executor.scheduleAtFixedRate(() -> {

                try {

                    System.out.println("Sending a message...");
                    producer.send(message);

                } catch (final JMSException e) {
                    e.printStackTrace();
                }

            }, 0, 1, TimeUnit.SECONDS);
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (final JMSException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (final JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
